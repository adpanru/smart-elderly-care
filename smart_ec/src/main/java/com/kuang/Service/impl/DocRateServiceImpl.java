package com.kuang.Service.impl;

import com.kuang.Service.DocRateService;
import com.kuang.dao.DocRateMapper;
import com.kuang.dto.DocRateDTO;
import com.kuang.pojo.DocRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DocRateServiceImpl implements DocRateService {
    @Resource
    DocRateMapper docRateMapper;


    @Override
    public int insert(DocRate record) {
        return this.docRateMapper.insert(record);
    }

    @Override
    public List<DocRateDTO> selectAllSc() {
        return this.docRateMapper.selectAllSc();
    }

    @Override
    public List<DocRate> selectByPhone(String phone) {
        return this.docRateMapper.selectByPhone(phone);
    }

    @Override
    public List<DocRate> selectByPrimaryKey(Long id) {
        return this.docRateMapper.selectByPrimaryKey(id);
    }
}
