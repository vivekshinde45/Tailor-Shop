package com.tailor.Shop.Mappings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tailor.Shop.Entities.User;
import com.tailor.Shop.Payload.UserDto;

@Component
public class UserMapping {

    @Autowired
    private AddressMapping _addressMapping;

    public User dtoToUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setAddress(this._addressMapping.dtoToAddress(userDto.getAddressDto()));
        return user;
    }

    public UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        userDto.setAddressDto(this._addressMapping.addressToDto(user.getAddress()));
        return userDto;
    }
}
