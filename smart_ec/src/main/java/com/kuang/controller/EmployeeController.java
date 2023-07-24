package com.kuang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuang.Service.*;
import com.kuang.dto.DocRateDTO;
import io.netty.util.internal.ObjectUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.kuang.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EldInfoService eldInfoService;
    @Autowired
    EldStatusService eldStatusService;
    @Autowired
    DocInfoService docInfoService;
    @Autowired
    DocRateService docRateService;



    @RequestMapping("/tables")
    public String list(Model model, HttpSession session,
                       @RequestParam(defaultValue = "0") int pageNo,
                       @RequestParam(defaultValue = "3") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        String name = eldStatusService.selectByPhone((String) session.getAttribute("loginUser"));
        //Collection<EmployeeDTO> employees = employeeService.selectAllEmployeeDTO();
        List<EldInfo> employees = eldInfoService.selectByName(name);
        if (employees == null || employees.isEmpty()) {
            EldInfo eldInfo = new EldInfo();
            eldInfo.seteName(name);
            eldInfo.setTemperature(0.0);
            eldInfo.setPulse(0);
            eldInfo.setBreathe(0);
            eldInfo.setBloodPre(0);
            eldInfo.setWeight(0.0);
            eldInfo.setBloodSugar(0.0);
            eldInfo.setSleep(0.0);
            eldInfo.setMedHistory(" ");
            eldInfo.setMentalStatus(" ");
            eldInfo.setTime(new Date());
            eldInfo.setResDoctor("-");
            eldInfo.setResDoctor(" ");
            eldInfo.setDocPropose(" ");
            eldInfo.setOnline(1);
            eldInfoService.insert(eldInfo);
            List<EldInfo> employees1 = eldInfoService.selectByName(name);
            model.addAttribute("page", employees1);
        }else {
            model.addAttribute("page", employees);
        }
        return "emp/tables";
    }


    @RequestMapping("/toadd")
    public String toAddpage(Model model,HttpSession session){
        //查出所有部门的信息
        //Collection<Department> departments = departmentService.selectAllDepartment();
        String phone = (String) session.getAttribute("username");
        String name = eldStatusService.selectByPhone(phone);
        //拿到医生的电话
        String docphone = eldInfoService.selectByPhone(name);
        //根据医生电话查出医生的信息
        DocInfo docInfo = docInfoService.selectDocByPhone(docphone);
        model.addAttribute("departments",docInfo);
        return "emp/add";
    }
    @RequestMapping("/add")
    public String Addpage(DocRate docRate,HttpSession session){
        String phone = (String) session.getAttribute("username");
        String name = eldStatusService.selectByPhone(phone);
        //拿到医生的电话
        String docphone = eldInfoService.selectByPhone(name);
        //根据医生电话查出医生的信息
        DocInfo docInfo = docInfoService.selectDocByPhone(docphone);
        //添加
        docRate.setDName(docInfo.getDName());
        docRate.setPhone(docInfo.getPhone());

        if(docRate.getScore() != null){
           //插入数据
            docRateService.insert(docRate);
        }
        return "redirect:tables";
    }

    @GetMapping("/tables/{id}")
    public String toUpdate(@PathVariable("id")Integer id,Model model){
        Long id1 = id.longValue();
        //查出原来的数据

        EldInfo employee = eldInfoService.selectById(id1);

        model.addAttribute("emp",employee);
        //查出所有已经审批通过的医生信息
        Collection<Department> departments = departmentService.selectAllDepartment();
        Collection<DocInfo> docs = docInfoService.selectByProStats(1);
        //System.out.println(docs);
        model.addAttribute("docs",docs);
        return "emp/update";
    }

    @PostMapping("/update")
    public String updateEmp(EldInfo eldInfo){
        Date date = new Date();
        eldInfo.setTime(date);
        eldInfo.setOnline(1);
        eldInfo.setDocPropose("");
        eldInfoService.updateByPrimaryKey(eldInfo);
        return "redirect:tables";
    }
    //删除员工
    @GetMapping("/delemp/{id}")
    public String toDeleteEmp(@PathVariable("id")Integer id){
        System.out.println("======================");
        //employeeService.deleteEmployee(id);
        return "redirect:tables_";
    }


  /*  @RequestMapping("/tables_doc")
    public String list2(Model model) {
        Collection<EmployeeDTO> employees = employeeService.selectAllEmployeeDTO();
        model.addAttribute("emps", employees);
        System.out.println("======================");
        return "emp/tables_doc";
    }*/

    @GetMapping("/tables_doc/{id}")
    public String toUpdateDoc(@PathVariable("id")Integer id,Model model,HttpSession session){
        Long id1 = id.longValue();
        //查出原来的数据

        EldInfo employee = eldInfoService.selectById(id1);

        model.addAttribute("emp",employee);
        session.setAttribute("eldName",employee.geteName());
        return "emp/update_doc";
    }

    @PostMapping("/update_doc")
    public String updateDocPro(String docPropose,HttpSession session){

        String eName = (String) session.getAttribute("eldName");
        System.out.println("======"+eName);
        //根据名字修改医生建议
        eldInfoService.updateProByName(eName,docPropose);

        return "redirect:tables_doc";
    }

    @RequestMapping("/toadd_doc")
    public String toAddDoc(Model model,HttpSession session){
        //拿到医生的电话
        String phone = (String) session.getAttribute("loginDoc");
        //根据医生电话查出医生的信息
        DocInfo docAllSc = docInfoService.selectDocByPhone(phone);
        //拿到评分
        model.addAttribute("docAllSc",docAllSc);
        //admin评价
        Float allScore = docAllSc.getAllScore();
        String adminPro = null;
        if(allScore>=6){
            adminPro="我代表老年人，真心感谢您在医疗护理中给予的无私帮助和支持。您的专业技能和关怀，让我们感受到了医者仁心的真谛。在您的呵护下，老年人得到了更好的照顾和治疗，我们深感欣慰和感激。\n" +
                    "\n" +
                    "再次衷心感谢您对老年人的关注和支持。祝愿您身体健康、工作顺利！";
        }else if(allScore>=3.5){
            adminPro="我们非常感谢您的工作，以及您日复一日辛勤劳作给患者带来的帮助。尽管收到的评价只是一般，但我们知道这不代表您付出的努力不够。我们相信您是尽心尽力的医护人员，您的工作和努力为患者带来了真正的帮助。\n" +
                    "\n" +
                    "根据我们的观察，您的工作表现有所提高。因此，我们希望鼓励您继续保持优秀的工作态度，并尽您所能提高工作质量。无论您面临什么困难和挑战，我们相信您有信心和能力更好地完成您的工作。如果您需要一些帮助和支持，请不要犹豫，随时与我们联系。\n" +
                    "\n" +
                    "再次感谢您的工作和付出。我们期待着看到您在未来的工作中继续成就辉煌，为患者提供最好的服务。祝愿您健康、快乐和成功！";
        }else {
            adminPro="我们对您的工作进行了评估，非常遗憾地，您收到的评价远低于期望得分。如果您的评价持续如此将意味着着我们被迫注销您的账号。我们理解这对您来说可能是一个沉重的打击，但同时，我们也希望您知道意见反馈的目的在于帮助您了解自己的工作表现，并鼓励您提高工作质量。\n" +
                    "\n" +
                    "我们仍然相信您是尽职尽责的医生，拥有足够的能力和技能来提供优质的医疗服务。因此，我们希望鼓励您继续努力，并寻找改进的机会。我们建议您与同事和患者沟通，听取他们的反馈，以及参加进一步的培训和学习，以提高专业技能并进一步提高工作表现。\n" +
                    "\n"+
                    "如果您对我们的评价有任何疑问或需要任何帮助，请随时与我们联系。我们会尽全力为您提供支持和帮助，以确保您能够恢复并取得有益的经验和成果。\n" +
                    "\n" +
                    "再次感谢您为患者做出的贡献，并祝福您在未来的工作中获得更大的成就。";
        }
        //插入数据
        model.addAttribute("docAdmin",adminPro);

        return "emp/add_doc";
    }

    @RequestMapping("/add_doc")
    public String AddSocre(){

        return "redirect:tables_doc";
    }

    @GetMapping("/tables_doindex/{id}")
    public String toUpdate1(@PathVariable("id")Integer id,Model model){
        Long id1 = id.longValue();
        //查出原来的数据

        EldInfo employee = eldInfoService.selectById(id1);

        model.addAttribute("emp",employee);
        //查出所有部门的信息
        Collection<Department> departments = departmentService.selectAllDepartment();
        Collection<DocInfo> docs = docInfoService.selectAllDoc();
        //System.out.println(docs);
        model.addAttribute("docs",docs);
        return "emp/update_doindex";
    }

    @PostMapping("/update_doindex")
    public String updateEmp1(EldInfo eldInfo){
        Date date = new Date();
        eldInfo.setTime(date);
        eldInfo.setOnline(1);
        eldInfo.setDocPropose("");
        eldInfoService.updateByPrimaryKey(eldInfo);
        return "redirect:/tables_doindex";
    }
    @GetMapping("/tables_ocindex/{id}")
    public String toUpdate2(@PathVariable("id")Integer id,Model model){
        Long id1 = id.longValue();
        //查出原来的数据
        DocInfo docInfo = docInfoService.selectDocByid(id1);
        System.out.println("----------------"+docInfo);
        model.addAttribute("emp",docInfo);
        return "emp/update_oc";
    }
    @PostMapping("/update_oc")
    public String updateEmp2(DocInfo docInfo){
        System.out.println(docInfo);
        docInfoService.updateByPrimaryKeySelective(docInfo);
        return "redirect:tables_ocindex";
    }

    /**管理员查看医生评分*/
    @RequestMapping("/tables_oc")
    public String listad(Model model) {
        List<DocInfo> listDoc = docInfoService.selectAllDoc();
        model.addAttribute("lists",listDoc);
        return "emp/tables_oc";
    }
    @GetMapping("/tables_oc/{phone}")
    public String toUpdate3(@PathVariable("phone")String phone,Model model){

        //查出原来的数据
        List<DocRate> list = docRateService.selectByPhone(phone);
        if(list.isEmpty()) {
            DocRate docRate = new DocRate();
            docRate.setId(0000L);
            docRate.setPhone("---");
            docRate.setRate("当前还未收到任何评语");
            docRate.setScore(00000F);
            model.addAttribute("lists",docRate);
        }else {
            model.addAttribute("lists",list);
        }
        return "index_docAd";
    }
    @PostMapping("/index_docAd")
    public String updateEmp3(){
        return "redirect:tables_oc";
    }
}