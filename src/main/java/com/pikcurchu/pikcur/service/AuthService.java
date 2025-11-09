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

        if (member != null && PasswordUtil.matches(password, member.getPassword())) {
            return member;
        }
        return null;
    }

    public boolean selectEmail(String email) {
        return authMapper.countByEmail(email) > 0;
    }

    public int insertMember(String id, String password, String email, String name, String phone, Gender gender, LocalDate birth) {
        if (selectEmail(email)) {
            return -999;
        }

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
}
