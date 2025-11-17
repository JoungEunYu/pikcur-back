package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.request.ReqAccountDto;
import com.pikcurchu.pikcur.vo.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {

    Integer insertAccount(@Param("req") ReqAccountDto req, @Param("memberNo") Integer memberNo, @Param("isDefault") String isDefault);

    Integer selectAccountIsDefault(Integer memberNo);

    List<Account> selectAccountList(Integer memberNo);

    Integer updateAccount(@Param("req") ReqAccountDto req, @Param("memberNo")Integer memberNo);

    Integer deleteAccount(Integer accountId, Integer memberNo);

    Integer updateDefaultAccountN(Integer memberNo);
    Integer updateDefaultAccountY(Integer accountId, Integer memberNo);
}
