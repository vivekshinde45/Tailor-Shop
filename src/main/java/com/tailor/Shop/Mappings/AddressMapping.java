package com.tailor.Shop.Mappings;

import org.springframework.stereotype.Component;

import com.tailor.Shop.Entities.Address;
import com.tailor.Shop.Payload.AddressDto;

@Component
public class AddressMapping {
    public Address dtoToAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setStreet(addressDto.getStreet());
        address.setArea(addressDto.getArea());
        address.setCity(addressDto.getCity());
        address.setDistrict(addressDto.getDistrict());
        address.setPincode(addressDto.getPincode());
        return address;
    }

    public AddressDto addressToDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setArea(address.getArea());
        addressDto.setCity(address.getCity());
        addressDto.setDistrict(address.getDistrict());
        addressDto.setPincode(address.getPincode());
        return addressDto;
    }
}
