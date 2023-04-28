package com.tailor.Shop.Services.Interface;

import com.tailor.Shop.Payload.AddressDto;

public interface IAddressService {
    AddressDto create(AddressDto addressDto);

    AddressDto getById(Integer addressId);
}
