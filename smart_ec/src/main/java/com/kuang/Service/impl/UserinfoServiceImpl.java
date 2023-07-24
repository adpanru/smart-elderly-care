package com.kuang.Service.impl;

import com.kuang.Service.UserinfoService;
import com.kuang.dao.UserinfoMapper;
import com.kuang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    UserinfoMapper userinfoMapper;
    @Override
    public int add(User user) {
        return userinfoMapper.add(user);
    }
}
