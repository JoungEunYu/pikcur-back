package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.vo.Member;

public interface AuthMapper {
    Member authById (String id);

    String findStatusNo (String id);

    int insertMember(Member member);

    String findIdByEmail(String email);

    int updateMemberToWithdrawal(String id);

    int countById(String id);

    int updatePassword(String id, String password);
}
