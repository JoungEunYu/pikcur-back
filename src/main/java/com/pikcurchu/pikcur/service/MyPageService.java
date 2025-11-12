package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.response.MyPageInfoDto;
import com.pikcurchu.pikcur.dto.response.ResMyStoreDto;
import com.pikcurchu.pikcur.mapper.MyPageMapper;
import com.pikcurchu.pikcur.vo.Member;
import com.pikcurchu.pikcur.vo.Store;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MyPageService {
    private final MyPageMapper myPageMapper;

    public MyPageService(MyPageMapper myPageMapper) {
        this.myPageMapper = myPageMapper;
    }

    public MyPageInfoDto selectMyInfoById(Integer memberNo) {

        return myPageMapper.selectMyInfoById(memberNo);
    }

    public int updateMyInfo(Member member) {
        return myPageMapper.updateMyInfo(member);
    }

    public ResMyStoreDto selectMyStore(Integer memberNo) {
        return myPageMapper.selectMyStore(memberNo);
    }

    public int updateMyStore(Store store) {
        return myPageMapper.updateMyStore(store);
    }
}
