package com.kuang.Service;

import com.kuang.dto.EldFenYeDto;
import com.kuang.pojo.EldInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EldInfoService {

    Page<EldInfo> selectALL(String res_doctor,Pageable pageable);
    List<String> selectByDoc(String res_doctor);
    List<EldInfo> selectByName(String name);
    String selectByPhone(String name);
    EldInfo selectById(Long id);
    List<EldInfo> selectALLByFenYe(EldFenYeDto eldFenYeDto);
    int updateByPrimaryKey(EldInfo record);
    int updateProByName(String eName,String docPropose);
    int deleteByPrimaryKey(Long id);

    Page<EldInfo> selectALLInfo(Pageable pageable);
    List<EldInfo> selectALLByFenYeInfo(Integer pageNo,Integer pageSize);
    long SelectCount();
    int insert(EldInfo record);
    int insertSelective(EldInfo record);
}
