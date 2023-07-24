package com.kuang.Service.impl;

import com.kuang.Service.UserService;
import com.kuang.dao.UserMapper;
import com.kuang.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDTO selectPasswordByName(String userName,String password) {
        return userMapper.selectPasswordByName(userName,password);
    }
}
