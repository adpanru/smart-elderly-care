package com.kuang.Service;

import com.kuang.dto.DocRateDTO;
import com.kuang.pojo.DocInfo;
import com.kuang.pojo.DocRate;
import com.kuang.pojo.EldInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DocInfoService {

    DocInfo selectByPrimaryKey(String accNum, String password);
    int insert(DocInfo record);
    List<DocInfo> selectAllDoc();
    int updateByPrimaryKey(DocInfo record);
    DocInfo selectDocByPhone(String phone);
    int upAllScoreByPhone(DocRateDTO docRateDTO);
    DocInfo selectDocByid(Long id);
    int updateByPrimaryKeySelective(DocInfo record);
    int upProById(DocInfo docInfo);
    List<DocInfo> selectByProStats (Integer proStatus);
    int deleteByPrimaryKey(Long id);
}
