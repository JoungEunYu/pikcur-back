package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.mapper.SigninMapper;
import com.pikcurchu.pikcur.vo.Member;
import org.springframework.stereotype.Service;

@Service
public class SigninService {
    private final SigninMapper signinMapper;

    public SigninService(SigninMapper signinMapper) {
        this.signinMapper = signinMapper;
    }

    public Member authenticate(String id, String rawPassword) {

        Member member = signinMapper.findById(id);

        if(member != null && member.getPassword().equals(rawPassword)) {
            return member;
        }
        return null;
    }
}
