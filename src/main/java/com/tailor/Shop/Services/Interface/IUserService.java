package com.tailor.Shop.Services.Interface;

import java.util.List;

import com.tailor.Shop.Payload.UserDto;

public interface IUserService {
    // CRUD
    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto, Integer userId);

    void delete(Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAll();
}
