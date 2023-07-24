package com.kuang.controller;

import com.kuang.Service.*;
import com.kuang.pojo.DocInfo;
import com.kuang.pojo.DocRate;
import com.kuang.pojo.EldInfo;
import com.kuang.pojo.EldStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class LoginDocController {

    @Autowired
    private DocInfoService docInfoService;
    @Resource
    private DocRateService docRateService;

    @RequestMapping("/user/index_doc")
    public String index(@RequestParam("username") String username, @RequestParam("password")String password, Model model, HttpSession session){
        //具体业务
        //UserDTO user = userService.selectPasswordByName(username, password);
        DocInfo user = docInfoService.selectByPrimaryKey(username,password);

        if (user != null){
            session.setAttribute("loginDoc",user.getPhone());
            /**根据电话查询所有docrate中信息*/

            return "redirect:/index_doc.html";

        }else {
            //告诉用户，登录失败
            model.addAttribute("msg","用户名或者密码错误！");
            return "login_doc";
        }

    }

    @RequestMapping("/index_doc.html")
    public String Doc_table(Model model,HttpSession session){
        String phone = (String) session.getAttribute("loginDoc");
        List<DocRate> list = docRateService.selectByPhone(phone);
        if(list.isEmpty()) {
            DocRate docRate = new DocRate();
            docRate.setId(0000L);
            docRate.setPhone(phone);
            docRate.setRate("您当前还未收到任何评语");
            docRate.setScore(00000F);
            model.addAttribute("listrate",docRate);
        }else {
            model.addAttribute("listrate",list);
        }
        return "index_doc.html";
    }
   @RequestMapping("/register_doc.html")
    public String logout(HttpSession session){
        session.invalidate();
       System.out.println("==============");
        return "register_doc.html";
    }


/*
    @RequestMapping("/login_doc.html")
    public String logout1(HttpSession session){
        session.invalidate();
        return "/login_doc.html";
    }
 @RequestMapping("/index_doc.html")
    public String Doc_table(){
        System.out.println("=============");
        return "/index_doc.html";
    }
    @RequestMapping("/login.html")
    public String logout3(HttpSession session){
        session.invalidate();
        return "/login.html";
    }

    @RequestMapping("/login_manage.html")
    public String logout2(HttpSession session){
        session.invalidate();
        return "/login_manage.html";
    }


*/
    @RequestMapping("/register_doc")
    public String reg(DocInfo docInfo,Model model){
        //model.addAttribute("docs", docInfo);
        //userinfoService.add(user);
        //eldStatusService.insert(eldStatus);
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        docInfo.setAccNum(uuid);
        docInfo.setProStatus(0);
        docInfo.setAllScore(0.00F);
        docInfo.setOnline(0);
        docInfoService.insert(docInfo);
        return "redirect:login_doc.html";
    }
}
