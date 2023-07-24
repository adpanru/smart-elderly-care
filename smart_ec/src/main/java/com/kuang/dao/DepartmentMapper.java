package com.kuang.dao;


import com.kuang.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DepartmentMapper {
    List<Department> selectAllDepartment();
}
