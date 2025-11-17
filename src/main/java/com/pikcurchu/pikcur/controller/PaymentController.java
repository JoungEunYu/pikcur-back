package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.request.ReqVerifyPaymentDto;
import com.pikcurchu.pikcur.dto.response.ResVerifyPaymentDto;
import com.pikcurchu.pikcur.service.PaymentService;
// ... (다른 import)
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="payment api", description = "결제 관련 api")
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @Operation(summary = "결제 검증 요청", description = "결제 검증 로직")
    @PostMapping("/verify")
    public ResponseEntity<ResVerifyPaymentDto> verifyPayment(@RequestBody ReqVerifyPaymentDto dto){
        Integer memberNo = 6;
        try {
            // 1. 서비스 호출을 try 블록으로 감쌉니다.
            boolean isValid = paymentService.verifyPayment(dto, memberNo);

            if (isValid) {
                // 2. 100% 성공
                ResVerifyPaymentDto responseDto = new ResVerifyPaymentDto("success", "결제 검증 성공");
                return ResponseEntity.ok().body(responseDto);
            } else {
                // 3. 'false' 반환 (금액 위/변조 검증 실패)
                // (DB 에러가 아니므로 'Bad Request'가 맞습니다)
                ResVerifyPaymentDto responseDto = new ResVerifyPaymentDto("fail", "결제 검증 실패 (금액 불일치)");
                return ResponseEntity.badRequest().body(responseDto);
            }

        } catch (RuntimeException e) {
            // 4. 서비스가 던진 '롤백용 폭탄(RuntimeException)'을 여기서 잡습니다.
            // (이건 DB 에러, 즉 'Server Error'입니다)
            ResVerifyPaymentDto responseDto = new ResVerifyPaymentDto("error", "결제 처리 중 서버 오류 발생");

            // 5. 400 대신 500 Internal Server Error를 JSON으로 반환
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
        }
    }
}