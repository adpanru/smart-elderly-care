package com.kuang.controller;

import com.kuang.Service.DocInfoService;
import com.kuang.Service.EldInfoService;
import com.kuang.Service.EldStatusService;
import com.kuang.dto.EldFenYeDto;
import com.kuang.pojo.Department;
import com.kuang.pojo.DocInfo;
import com.kuang.pojo.EldInfo;
import com.kuang.pojo.EldStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.Collection;
import java.util.List;

@Controller
public class EldInfoController {
    @Resource
    private EldInfoService eldInfoService;
    @Resource
    private EldStatusService eldStatusService;
    @Resource
    private DocInfoService docInfoService;


    @RequestMapping("/tables_doc")
    public String list(Model model, HttpSession session,
                       @RequestParam(defaultValue = "0") int pageNo,
                       @RequestParam(defaultValue = "3") int pageSize) {
        String phone1 = (String) session.getAttribute("loginDoc");
        /**统计页数*/
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<EldInfo> page1 = eldInfoService.selectALL(phone1,pageable);
        List<EldInfo> myDataList = page1.getContent();
        long totalCount = eldInfoService.SelectCount();
        long totalPages=0L;
        if(totalCount%3==0){
            totalPages = totalCount/3;
        }else {
            totalPages=totalCount/3+1;
        }
        /**展示分页*/

        EldFenYeDto eldFenYeDto = new EldFenYeDto();
        eldFenYeDto.setPageNo(pageNo*pageSize);
        eldFenYeDto.setPageSize(pageSize);
        eldFenYeDto.setRes_doctor(phone1);
        List<EldInfo> fenyeList = eldInfoService.selectALLByFenYe(eldFenYeDto);

            model.addAttribute("list",fenyeList);
            model.addAttribute("myDataList", myDataList);
            model.addAttribute("currentPage", pageNo);
            model.addAttribute("totalPages", totalPages);

        /** 用于展示当前医生负责的老人联系方式*/
        List<String> name = eldInfoService.selectByDoc(phone1);
        if (name != null && !name.isEmpty()) {
            //list不为空
            List<EldStatus> employees1 = eldStatusService.selectByNames(name);
            model.addAttribute("emps2", employees1);
        } else {
            //list为空
            EldStatus eldStatus1 = new EldStatus();
            eldStatus1.setEName("暂无");
            eldStatus1.setPhone("--");
            eldStatus1.setAddress("--");
            model.addAttribute("emps2",eldStatus1);
        }

        return "emp/tables_doc";
    }

    @RequestMapping("/tables_doindex")
    public String list1(Model model, HttpSession session,
                       @RequestParam(defaultValue = "0") int pageNo,
                       @RequestParam(defaultValue = "3") int pageSize) {
        String phone1 = (String) session.getAttribute("loginDoc");
        /**统计页数*/
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<EldInfo> page1 = eldInfoService.selectALLInfo(pageable);
        List<EldInfo> myDataList = page1.getContent();
        long totalCount = eldInfoService.SelectCount();
        long totalPages=0L;
        if(totalCount%3==0){
            totalPages = totalCount/3;
        }else {
            totalPages=totalCount/3+1;
        }
        /**展示分页*/

        List<EldInfo> fenyeList = eldInfoService.selectALLByFenYeInfo(pageNo*pageSize,pageSize);

        model.addAttribute("list",fenyeList);
        model.addAttribute("myDataList", myDataList);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", totalPages);

        /** 用于展示当前医生负责的老人联系方式*/

       /* List<String> name = eldInfoService.selectByDoc(phone1);
        if (name != null && !name.isEmpty()) {
            //list不为空
            List<EldStatus> employees1 = eldStatusService.selectByNames(name);
            model.addAttribute("emps2", employees1);
        } else {
            //list为空
            EldStatus eldStatus1 = new EldStatus();
            eldStatus1.setEName("暂无");
            eldStatus1.setPhone("--");
            eldStatus1.setAddress("--");
            model.addAttribute("emps2",eldStatus1);
        }*/

        return "emp/tables_doindex";
    }

    //删除员工
    @GetMapping("/del_eld/{id}")
    public String toDeleteEmp(@PathVariable("id")Integer id){
        eldInfoService.deleteByPrimaryKey(Long.valueOf(id));
        return "redirect:tables_doindex";
    }

    @RequestMapping("/tables_ocindex")
    public String list2(Model model) {

     List<DocInfo> listDoc = docInfoService.selectAllDoc();
     model.addAttribute("lists",listDoc);

        return "emp/tables_ocindex";
    }

    @RequestMapping("/tables_Po")
    public String list3(Model model) {

        List<DocInfo> listDoc = docInfoService.selectByProStats(0);
        model.addAttribute("lists",listDoc);

        return "emp/tables_Po";
    }

    //同意申请
    @GetMapping("/tables_Po/{id}")
    public String toUpdate(@PathVariable("id")Long id){
        DocInfo docInfo = new DocInfo();
        docInfo.setId(id);
        docInfo.setProStatus(1);
        docInfoService.upProById(docInfo);
        return "redirect:tables_Po";
    }

    //驳回申请
    @GetMapping("/del_Po/{id}")
    public String toDeleteEmp1(@PathVariable("id")Long id){
        docInfoService.deleteByPrimaryKey(id);
        return "redirect:tables_Po";
    }

}
