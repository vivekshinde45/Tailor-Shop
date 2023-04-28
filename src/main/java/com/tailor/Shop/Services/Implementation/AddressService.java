package com.tailor.Shop.Services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailor.Shop.Entities.Address;
import com.tailor.Shop.Exceptions.ResourceNotFoundException;
import com.tailor.Shop.Mappings.AddressMapping;
import com.tailor.Shop.Payload.AddressDto;
import com.tailor.Shop.Repositories.AddressRepository;
import com.tailor.Shop.Services.Interface.IAddressService;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private AddressRepository _addressRepository;

    @Autowired
    private AddressMapping _addressMapping;

    @Override
    public AddressDto create(AddressDto addressDto) {
        Address address = this._addressMapping.dtoToAddress(addressDto);
        address = this._addressRepository.save(address);
        return this._addressMapping.addressToDto(address);
    }

    @Override
    public AddressDto getById(Integer addressId) {
        Address address = this._addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Address",
                        "ID",
                        addressId + ""));
        return this._addressMapping.addressToDto(address);
    }

}
