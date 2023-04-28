package com.tailor.Shop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tailor.Shop.Payload.UserDto;
import com.tailor.Shop.Services.Implementation.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService _userService;

    // CRUD
    @PostMapping()
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        UserDto savedUser = this._userService.create(userDto);
        return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}/address/{addressId}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto,
            @PathVariable Integer userId,
            @PathVariable Integer addressId) {
        UserDto updatedUser = this._userService.update(userDto, userId, addressId);
        return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable Integer userId) {
        this._userService.delete(userId);
        return new ResponseEntity<String>("User deleted successfully with ID: " + userId, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getByID(@PathVariable Integer userId) {
        UserDto userById = this._userService.getUserById(userId);
        return new ResponseEntity<UserDto>(userById, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> users = this._userService.getAll();
        return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
    }
}
