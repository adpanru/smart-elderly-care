package com.kuang.Service.impl;

import com.kuang.Service.DepartmentService;
import com.kuang.dao.DepartmentMapper;
import com.kuang.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }
}
