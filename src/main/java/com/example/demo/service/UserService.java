package com.example.demo.service;

import com.example.demo.dto.UserDto;

public interface UserService {
    UserDto findById(Long id);

    String saveUser(UserDto userDto);

}
