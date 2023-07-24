package com.kuang.Service;

import com.kuang.dto.DocRateDTO;
import com.kuang.pojo.DocRate;

import java.util.List;

public interface DocRateService {
    int insert(DocRate record);
    List<DocRateDTO> selectAllSc();
    List<DocRate> selectByPhone(String phone);
    List<DocRate> selectByPrimaryKey(Long id);
}
