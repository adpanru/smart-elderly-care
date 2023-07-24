package com.kuang.Service.impl;

import com.kuang.Service.EldStatusService;
import com.kuang.dao.EldStatusMapper;
import com.kuang.pojo.EldStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EldStatusServiceImpl implements EldStatusService {
    @Autowired
    private EldStatusMapper eldStatusMapper;
    @Override
    public EldStatus selectByPrimaryKey(String phone, String password) {
        return eldStatusMapper.selectByPrimaryKey(phone,password);
    }

    @Override
    public int insert(EldStatus record) {
        return this.eldStatusMapper.insert(record);
    }

    @Override
    public List<EldStatus> selectByNames(List<String> name) {
        return this.eldStatusMapper.selectByNames(name);
    }

    @Override
    public String selectByPhone(String phone) {
        return this.eldStatusMapper.selectByPhone(phone);
    }
}
