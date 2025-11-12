package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.enums.Gender;
import com.pikcurchu.pikcur.mapper.AuthMapper;
import com.pikcurchu.pikcur.util.PasswordUtil;
import com.pikcurchu.pikcur.vo.Member;
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
    public int insertMember(String id, String password, String email, String name, String phone, Gender gender, LocalDate birth) {
        Member member = new Member();
        member.setId(id);
        member.setPassword(PasswordUtil.encode(password));;
        member.setEmail(email);
        member.setName(name);
        member.setPhone(phone);
        member.setGender(gender);
        member.setBirth(birth);

        int result = authMapper.insertMember(member);

        if (result > 0 && member.getMemberNo() != null) {
            String storeName = name + "님의 상점";
            result += authMapper.insertStore(member.getMemberNo(), storeName);
        }

        return result;
    }

    public String findIdByEmail(String email) {
        return authMapper.findIdByEmail(email);
    }

    public boolean updateMemberToWithdrawal(Integer memberNo) {
        int updated = authMapper.updateMemberToWithdrawal(memberNo); // 01 = 상세 코드
        return updated > 0;
    }

    public Integer countById(String id) {
        return authMapper.countById(id);
    }

    public Integer updatePassword(Integer memberNo, String password) {
        String encodedPassword = PasswordUtil.encode(password);

        return authMapper.updatePassword(memberNo, encodedPassword);
    }

    public int insertStore(Integer memberNo, String storeName) {
        return authMapper.insertStore(memberNo, storeName);
    }
}
