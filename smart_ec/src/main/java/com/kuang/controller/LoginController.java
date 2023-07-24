package com.kuang.controller;

import com.kuang.Service.EldInfoService;
import com.kuang.Service.EldStatusService;
import com.kuang.Service.UserService;
import com.kuang.Service.UserinfoService;
import com.kuang.common.R;
import com.kuang.dto.UserDTO;
import com.kuang.pojo.EldInfo;
import com.kuang.pojo.EldStatus;
import com.kuang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserinfoService userinfoService;
    @Autowired
    private EldStatusService eldStatusService;
    @Autowired
    private EldInfoService eldInfoService;

    @RequestMapping("/user/index")
    public String index(@RequestParam("username") String username, @RequestParam("password")String password, Model model, HttpSession session){
        //具体业务
        //UserDTO user = userService.selectPasswordByName(username, password);
        EldStatus user = eldStatusService.selectByPrimaryKey(username,password);

        if (user != null){
            session.setAttribute("loginUser",user.getPhone());
            session.setAttribute("username",username);
            return "redirect:/index.html";

        }else {
            //告诉用户，登录失败
            model.addAttribute("msg","用户名或者密码错误！");
            return "login";
        }

    }

    @RequestMapping("/index.html")
    public String index(Model model,HttpSession session){
        String username = (String) session.getAttribute("username");
        String name = eldStatusService.selectByPhone(username);
        List<EldInfo> einfo = eldInfoService.selectByName(name);
        model.addAttribute("einfo", einfo);
        return "index.html";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login.html";
    }



    @RequestMapping("/login_doc.html")
    public String logout1(HttpSession session){
        session.invalidate();
        return "login_doc.html";
    }

    @RequestMapping("/login.html")
    public String logout2(HttpSession session){
        session.invalidate();
        return "login.html";
    }

    @RequestMapping("/login_manage.html")
    public String logout3(HttpSession session){
        session.invalidate();
        return "login_manage.html";
    }


    @RequestMapping("/register")
    public String reg(EldStatus eldStatus){

        //userinfoService.add(user);
        eldStatusService.insert(eldStatus);

        return "redirect:login.html";
    }

    @RequestMapping("/forms.html")
    public String Form(){

        return "forms.html";
    }

    @RequestMapping("/charts.html")
    public String Charts(){

        return "charts.html";
    }

    @RequestMapping("/forms_doc.html")
    public String FormDoc(){

        return "forms_doc.html";
    }
    @RequestMapping("/forms_admin.html")
    public String FormAdmin(){

        return "forms_admin.html";
    }

    @RequestMapping("/charts_doc.html")
    public String ChartsDoc(){

        return "charts_doc.html";
    }
    @RequestMapping("/emp/tables_doc.html")
    public String TablesDoc(){

        return "emp/tables_doc.html";
    }
    //todo 跳转
    @RequestMapping("/emp/tables.html")
    public String Tables(){

        return "emp/tables";
    }

    @RequestMapping("/shouye.html")
    public String logout(){
        return "shouye/shouye.html";
    }
}
