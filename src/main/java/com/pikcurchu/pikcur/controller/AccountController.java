package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.request.ReqAccountDto;
import com.pikcurchu.pikcur.service.AccountService;
import com.pikcurchu.pikcur.vo.Account;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="account api", description = "계좌 API")
@RestController
@RequestMapping("/mypage")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "계좌 추가", description = "계좌 추가 API")
    @PostMapping("/account")
    public ResponseEntity<Integer> insertAccount(@RequestBody ReqAccountDto req, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        Integer response = accountService.insertAccount(req, memberNo);

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "계좌 조회", description = "계좌 조회 API")
    @GetMapping("/account")
    public ResponseEntity<List<Account>> selectAccountList(HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        List<Account> response = accountService.selectAccountList(memberNo);

        return new ResponseEntity<List<Account>>(response, HttpStatus.OK);
    }

    @Operation(summary = "계좌 수정", description = "계좌 수정 API")
    @PutMapping("/account")
    public ResponseEntity<Integer> updateAccount(@RequestBody ReqAccountDto req, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        Integer response = accountService.updateAccount(req, memberNo);

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "계좌 삭제", description = "계좌 삭제 API")
    @DeleteMapping("/account/{accountId}")
    public ResponseEntity<Integer> deleteAccount(@PathVariable Integer accountId, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        Integer response = accountService.deleteAccount(accountId, memberNo);

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "주 계좌 변경", description = "주 계좌 변경 API")
    @PutMapping("/account/{accountId}/set-default")
    public ResponseEntity<Integer> updateDefaultAccount(@PathVariable Integer accountId, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        Integer response = accountService.updateDefaultAccount(accountId, memberNo);

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }
}
