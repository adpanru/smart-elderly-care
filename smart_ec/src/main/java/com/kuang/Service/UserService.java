package com.kuang.Service;

import com.kuang.dto.UserDTO;

public interface UserService {
     UserDTO selectPasswordByName(String userName,String password);
}
