package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.request.ReqAccountDto;
import com.pikcurchu.pikcur.mapper.AccountMapper;
import com.pikcurchu.pikcur.mapper.AddressMapper;
import com.pikcurchu.pikcur.vo.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    private final AccountMapper accountMapper;

    public AccountService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public Integer insertAccount(ReqAccountDto req, Integer memberNo) {
        int response = selectAccountIsDefault(memberNo);

        if(response > 0) {
            return accountMapper.insertAccount(req, memberNo, "N");
        } else {
            return accountMapper.insertAccount(req, memberNo, "Y");
        }
    }

    public Integer selectAccountIsDefault(Integer memberNo) {
        return accountMapper.selectAccountIsDefault(memberNo);
    }

    public List<Account> selectAccountList(Integer memberNo) {
        return accountMapper.selectAccountList(memberNo);
    }

    public Integer updateAccount(ReqAccountDto req, Integer memberNo) {
        return accountMapper.updateAccount(req, memberNo);
    }

    public Integer deleteAccount(Integer accountId, Integer memberNo) {
        return accountMapper.deleteAccount(accountId, memberNo);
    }

    @Transactional
    public Integer updateDefaultAccount(int accountId, int memberNo) {
        int response = 0;

        response += accountMapper.updateDefaultAccountN(memberNo);

        response += accountMapper.updateDefaultAccountY(accountId, memberNo);

        return response;
    }

}
