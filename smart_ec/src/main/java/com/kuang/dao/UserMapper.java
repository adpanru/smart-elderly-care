package com.kuang.dao;

import com.kuang.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    UserDTO selectPasswordByName(@Param("userName") String userName, @Param("password") String password);
}
