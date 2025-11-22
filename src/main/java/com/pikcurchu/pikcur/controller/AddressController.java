package com.pikcurchu.pikcur.controller;


import com.pikcurchu.pikcur.anotation.Alarm;
import com.pikcurchu.pikcur.dto.request.ReqAddressDto;
import com.pikcurchu.pikcur.service.AddressService;
import com.pikcurchu.pikcur.vo.Address;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="address api", description = "배송지 API")
@RestController
@RequestMapping("/mypage")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @Alarm(alarmTitle = "배송지 추가 완료", alarmContent = "새 배송지가 등록되었습니다.")
    @Operation(summary = "배송지 추가", description = "배송지 추가 API")
    @PostMapping("/address")
    public ResponseEntity<Integer> insertAddress(@RequestBody ReqAddressDto req, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        Integer response = addressService.insertAddress(req, memberNo);

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "배송지 조회", description = "배송지 조회 API")
    @GetMapping("/address")
    public ResponseEntity<List<Address>> selectAddressList(HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        List<Address> response = addressService.selectAddressList(memberNo);

        return new ResponseEntity<List<Address>>(response, HttpStatus.OK);
    }

    @Operation(summary = "배송지 수정", description = "배송지 수정 API")
    @PutMapping("/address")
    public ResponseEntity<Integer> updateAddress(@RequestBody ReqAddressDto req, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        Integer response = addressService.updateAddress(req, memberNo);

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "배송지 삭제", description = "배송지 삭제 API")
    @DeleteMapping("/address/{addressId}")
    public ResponseEntity<Integer> deleteAddress(@PathVariable Integer addressId, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        Integer response = addressService.deleteAddress(addressId, memberNo);

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "주 배송지 변경", description = "주 배송지 변경 API")
    @PutMapping("/address/{addressId}/set-default")
    public ResponseEntity<Integer> updateDefaultAddress(@PathVariable Integer addressId, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        Integer response = addressService.updateDefaultAddress(addressId, memberNo);

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

}
