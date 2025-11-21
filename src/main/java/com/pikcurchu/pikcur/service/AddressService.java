package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.request.ReqAddressDto;
import com.pikcurchu.pikcur.mapper.AddressMapper;
import com.pikcurchu.pikcur.vo.Address;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {

    private final AddressMapper addressMapper;

    public AddressService(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Integer insertAddress(ReqAddressDto req, int memberNo) {

        int response = selectAddressIsDefault(memberNo);

        if(response > 0) {
            return addressMapper.insertAddress(req, memberNo, "N");
        } else {
            return addressMapper.insertAddress(req, memberNo, "Y");
        }
    }

    public Integer selectAddressIsDefault(int memberNo) {
        return addressMapper.selectAddressIsDefault(memberNo);
    }

    public List<Address> selectAddressList(int memberNo) {
        return addressMapper.selectAddressList(memberNo);
    }

    public Integer updateAddress(ReqAddressDto req, int memberNo) {
        return addressMapper.updateAddress(req, memberNo);
    }

    public Integer deleteAddress(int addressId, int memberNo) {
        int response = 0;

        response += addressMapper.deleteAddress(addressId, memberNo);

        response += addressMapper.updateDefaultAddressAfterDelete(addressId, memberNo);

        return response;
    }

    @Transactional
    public Integer updateDefaultAddress(int addressId, int memberNo) {
        int response = 0;

        response += addressMapper.updateDefaultAddressN(memberNo);

        response += addressMapper.updateDefaultAddressY(addressId, memberNo);

        return response;
    }
}
