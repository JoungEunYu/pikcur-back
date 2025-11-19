package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.vo.Member;

public interface AuthMapper {
    Member authById (String id);

    String findStatusNo (String id);

    int insertMember(Member member);

    String findIdByEmail(String email);

    int updateMemberToWithdrawal(Integer memberNo);

    int countById(String id);

    int updatePasswordStatusLogin(Integer memberNo, String password);

    int updatePasswordStatusUnLogin(String id, String password);

    int insertStore(Integer memberNo, String storeName);
}
