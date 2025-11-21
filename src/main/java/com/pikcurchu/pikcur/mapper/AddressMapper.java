package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.request.ReqAddressDto;
import com.pikcurchu.pikcur.vo.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {

    Integer insertAddress (@Param("req") ReqAddressDto req,
                       @Param("memberNo") Integer memberNo,
                       @Param("isDefault") String isDefault);

    Integer selectAddressIsDefault(Integer memberNo);

    List<Address> selectAddressList(Integer memberNo);

    Integer updateAddress(@Param("req") ReqAddressDto req, @Param("memberNo")Integer memberNo);

    Integer deleteAddress(Integer addressId, Integer memberNo);

    Integer updateDefaultAddressAfterDelete(Integer addressId, Integer memberNo);

    Integer updateDefaultAddressN(Integer memberNo);

    Integer updateDefaultAddressY(Integer addressId, Integer memberNo);
}
