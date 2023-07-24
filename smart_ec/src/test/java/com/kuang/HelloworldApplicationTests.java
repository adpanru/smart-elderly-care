package com.kuang;

import com.kuang.Service.UserinfoService;
import com.kuang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class HelloworldApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
   private UserinfoService userinfoService;
    @Test
    void contextLoads() {
        User user = new User();
        user.setId(3);
       user.setUserName("root");
       user.setPassword("123456");
       user.setAge(18);
       user.setAddress("河南开封");
       user.setEmail("157739315@qq.com");
       user.setGender("男");
       user.setMobile("13781130581");
        int ad = userinfoService.add(user);
        System.out.println(ad);


    }

}
