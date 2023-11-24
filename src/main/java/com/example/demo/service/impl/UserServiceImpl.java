package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserDto findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return userMapper.toDto(user.orElseThrow());
    }

    @Override
    public String saveUser(UserDto userDto) {
        return null;
    }
}
