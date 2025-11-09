package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.enums.Gender;
import com.pikcurchu.pikcur.mapper.AuthMapper;
import com.pikcurchu.pikcur.util.PasswordUtil;
import com.pikcurchu.pikcur.vo.Member;
import org.springframework.stereotype.Service;

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

    public int insertMember(String id, String password, String email, String name, String phone, Gender gender, LocalDate birth) {
        Member member = new Member();
        member.setId(id);
        member.setPassword(PasswordUtil.encode(password));;
        member.setEmail(email);
        member.setName(name);
        member.setPhone(phone);
        member.setGender(gender);
        member.setBirth(birth);

        return authMapper.insertMember(member);
    }

    public String findIdByEmail(String email) {
        return authMapper.findIdByEmail(email);
    }

    public boolean updateMemberToWithdrawal(String id) {
        int updated = authMapper.updateMemberToWithdrawal(id); // 01 = 상세 코드
        return updated > 0;
    }

    public Integer countById(String id) {
        return authMapper.countById(id);
    }

    public Integer updatePassword(String id, String password) {
        String encodedPassword = PasswordUtil.encode(password);

        return authMapper.updatePassword(id, encodedPassword);
    }
}
