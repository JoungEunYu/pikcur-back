package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.response.MyPageInfoDto;
import com.pikcurchu.pikcur.vo.Member;

import java.time.LocalDate;

public interface MyPageMapper {

    MyPageInfoDto selectMyInfoById (Integer memberNo);

    int updateMyInfo(Member member);
}
