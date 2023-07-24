package com.kuang.Service.impl;

import com.github.pagehelper.PageHelper;
import com.kuang.Service.DocInfoService;

import com.kuang.dao.DocInfoMapper;
import com.kuang.dto.DocRateDTO;
import com.kuang.pojo.DocInfo;
import com.kuang.pojo.DocRate;
import com.kuang.pojo.EldInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DocInfoServiceImpl implements DocInfoService {

    @Resource
    private DocInfoMapper docInfoMapper;

    @Override
    public DocInfo selectByPrimaryKey(String accNum, String password) {

        return this.docInfoMapper.selectByPrimaryKey(accNum,password);
    }

    @Override
    public int insert(DocInfo record) {
        return this.docInfoMapper.insert(record);
    }

    @Override
    public List<DocInfo> selectAllDoc() {
        return this.docInfoMapper.selectAllDoc();
    }

    @Override
    public int updateByPrimaryKey(DocInfo record) {
        return this.docInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public DocInfo selectDocByPhone(String phone) {
        return this.docInfoMapper.selectDocByPhone(phone);
    }

    @Override
    public int upAllScoreByPhone(DocRateDTO docRateDTO) {
        return this.docInfoMapper.upAllScoreByPhone(docRateDTO);
    }

    @Override
    public DocInfo selectDocByid(Long id) {
        return this.docInfoMapper.selectDocByid(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DocInfo record) {
        return this.docInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int upProById(DocInfo docInfo) {
        return this.docInfoMapper.upProById(docInfo);
    }

    @Override
    public List<DocInfo> selectByProStats(Integer proStatus) {
        return this.docInfoMapper.selectByProStats(proStatus);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return this.docInfoMapper.deleteByPrimaryKey(id);
    }
}
