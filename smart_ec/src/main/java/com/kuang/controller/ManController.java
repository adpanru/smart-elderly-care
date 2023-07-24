package com.kuang.controller;

import com.kuang.Service.UserService;
import com.kuang.common.R;
import com.kuang.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/Man")
public class ManController {
    @Autowired
    UserService userService;

    @PostMapping("/manlogin")
    public R log(UserDTO userDto){
        UserDTO userDTO = userService.selectPasswordByName(userDto.getUserName(),userDto.getPassword());
        if(userDTO != null){
            return R.success("success");
        }else {
            return R.error("err");
        }
    }

}
