package com.kuang.Service.impl;

import com.github.pagehelper.PageHelper;
import com.kuang.Service.EldInfoService;
import com.kuang.dao.EldInfoMapper;
import com.kuang.dto.EldFenYeDto;
import com.kuang.pojo.EldInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EldInfoServiceImpl implements EldInfoService {
    @Resource
    private EldInfoMapper eldInfoMapper;

    @Override
    public Page<EldInfo> selectALL(String res_doctor, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<EldInfo> list = eldInfoMapper.selectALL(res_doctor,pageable);
        Page<EldInfo> page = new PageImpl<>(list, pageable,list.size());
        return page;
    }

    @Override
    public List<String> selectByDoc(String res_doctor) {
        return this.eldInfoMapper.selectByDoc(res_doctor);
    }

    @Override
    public List<EldInfo> selectByName(String phone) {
        return this.eldInfoMapper.selectByName(phone);
    }

    @Override
    public String selectByPhone(String name) {
        return this.eldInfoMapper.selectByPhone(name);
    }

    @Override
    public EldInfo selectById(Long id) {
        return this.eldInfoMapper.selectById(id);
    }

    @Override
    public List<EldInfo> selectALLByFenYe(EldFenYeDto eldFenYeDto) {
        return this.eldInfoMapper.selectALLByFenYe(eldFenYeDto);
    }

    @Override
    public int updateByPrimaryKey(EldInfo eldInfo) {
        return this.eldInfoMapper.updateByPrimaryKey(eldInfo);
    }

    @Override
    public int updateProByName(String eName,String docPropose) {
        return this.eldInfoMapper.updateProByName(eName,docPropose);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return this.eldInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<EldInfo> selectALLInfo(Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<EldInfo> list = eldInfoMapper.selectALLInfo(pageable);
        Page<EldInfo> page = new PageImpl<>(list, pageable,list.size());
        return page;
    }

    @Override
    public List<EldInfo> selectALLByFenYeInfo(Integer pageNo, Integer pageSize) {
        return this.eldInfoMapper.selectALLByFenYeInfo(pageNo,pageSize);
    }

    @Override
    public long SelectCount() {
        return this.eldInfoMapper.SelectCount();
    }

    @Override
    public int insert(EldInfo record) {
        return this.eldInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(EldInfo record) {
        return this.eldInfoMapper.insertSelective(record);
    }
}
