package com.kuang.Service;

import com.kuang.pojo.EldStatus;

import java.util.List;

public interface EldStatusService {
    EldStatus selectByPrimaryKey(String phone, String password);
    int insert(EldStatus record);
    List<EldStatus> selectByNames(List<String> name);
    String selectByPhone(String phone);
}
