package com.tailor.Shop.Services.Implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailor.Shop.Entities.User;
import com.tailor.Shop.Exceptions.ResourceNotFoundException;
import com.tailor.Shop.Mappings.UserMapping;
import com.tailor.Shop.Payload.UserDto;
import com.tailor.Shop.Repositories.UserRepository;
import com.tailor.Shop.Services.Interface.IUserService;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private UserMapping _userMapping;

    @Override
    public UserDto create(UserDto userDto) {
        User user = this._userMapping.dtoToUser(userDto);
        User savedUser = this._userRepository.save(user);
        return this._userMapping.userToDto(savedUser);
    }

    @Override
    public UserDto update(UserDto userDto, Integer userId) {
        User user = this._userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User",
                        "User Id",
                        userId + ""));
        user = this._userMapping.dtoToUser(userDto);
        return this._userMapping.userToDto(user);
    }

    @Override
    public void delete(Integer userId) {
        User user = this._userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User",
                        "User Id",
                        userId + ""));
        this._userRepository.delete(user);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this._userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User",
                        "User Id",
                        userId + ""));
        return this._userMapping.userToDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> users = this._userRepository.findAll().stream().map(
                user -> this._userMapping.userToDto(user)).collect(Collectors.toList());
        return users;
    }

}
