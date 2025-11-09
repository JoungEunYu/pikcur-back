package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.vo.Member;

public interface AuthMapper {
    Member authById (String id);

    int insertMember(Member member);

    int countByEmail(String email);
}
