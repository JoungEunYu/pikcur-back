package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.common.ApiResponse;
import com.pikcurchu.pikcur.common.ResponseCode;
import com.pikcurchu.pikcur.enums.Gender;
import com.pikcurchu.pikcur.mapper.AuthMapper;
import com.pikcurchu.pikcur.util.PasswordUtil;
import com.pikcurchu.pikcur.vo.Member;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class AuthService {
    private final AuthMapper authMapper;

    public AuthService(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    public Member authenticate(String id, String password) {

        Member member = authMapper.authById(id);

        String statusNo = authMapper.findStatusNo(id);
        if(!"01".equals(statusNo)) {
            return null;
        }

        if (member != null && PasswordUtil.matches(password, member.getPassword())) {
            return member;
        }
        return null;
    }

    @Transactional
    public int insertMember(Member member) {

        member.setPassword(PasswordUtil.encode(member.getPassword()));

        int result = authMapper.insertMember(member);

        if (result > 0 && member.getMemberNo() != null) {
            String storeName = member.getName() + "님의 상점";
            result += authMapper.insertStore(member.getMemberNo(), storeName);
        }

        return result;
    }

    public ApiResponse<String> findIdByEmail(String email) {
        String id = authMapper.findIdByEmail(email);

        if (id == null || id.isEmpty()) {
            return ApiResponse.fail(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND.getMessage(),
                    HttpServletResponse.SC_NOT_FOUND
            );
        }

        return ApiResponse.success(id);
    }

    public boolean updateMemberToWithdrawal(Integer memberNo) {
        int updated = authMapper.updateMemberToWithdrawal(memberNo); // 01 = 상세 코드
        return updated > 0;
    }

    public Integer countById(String id) {
        return authMapper.countById(id);
    }

    public Integer updatePasswordStatusLogin(Integer memberNo, String password) {
        String encodedPassword = PasswordUtil.encode(password);

        return authMapper.updatePasswordStatusLogin(memberNo, encodedPassword);
    }

    public Integer updatePasswordStatusUnLogin(String id, String password) {
        String encodedPassword = PasswordUtil.encode(password);

        return authMapper.updatePasswordStatusUnLogin(id, encodedPassword);
    }

    public int insertStore(Integer memberNo, String storeName) {
        return authMapper.insertStore(memberNo, storeName);
    }
}
