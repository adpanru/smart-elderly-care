package com.kuang.config;


import com.kuang.Service.DocInfoService;
import com.kuang.Service.DocRateService;
import com.kuang.Service.UserService;
import com.kuang.dto.DocRateDTO;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
@Slf4j
public class JobTimeDemo {

    @Autowired
    private UserService userService;
    @Autowired
    private DocRateService docRateService;
    @Autowired
    private DocInfoService docInfoService;

    //每天的0点和十二点执行操作:更新医生的综合评分
    /*
    当并发量少的时候可以采用此方法进行定时任务
    @Scheduled(cron = " 0 0 12 1/1 1/1 ?")
    public void run(){
        System.out.println(userService.selectPasswordByName("admin","123456"));
        System.out.println("我执行了");
    }*/

    /**
     * 高并发的时候采用Xxjob作为定时任务
     */
    @XxlJob("aaaaaa")
    public void demo(){
        XxlJobHelper.log("输出日志");
        //参数
        System.out.println(XxlJobHelper.getJobParam());

        //我一共有多少台机器
        System.out.println(XxlJobHelper.getShardTotal());

        //现在是第几台机器
        System.out.println(XxlJobHelper.getShardIndex());

        List<DocRateDTO> Avglists = docRateService.selectAllSc();
        for(DocRateDTO avglists:Avglists){
            docInfoService.upAllScoreByPhone(avglists);
        }
        System.out.println("我执行了");

    }
}
