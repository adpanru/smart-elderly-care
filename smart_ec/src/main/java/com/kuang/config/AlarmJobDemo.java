package com.kuang.config;

import com.kuang.Service.EldStatusService;
import com.xxl.job.core.context.XxlJobHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AlarmJobDemo {

    @Resource
    private EldStatusService eldStatusService;

    private  final Integer DEFAULT_THRESHDLD = 90;

    public void alarm(){
        String param = XxlJobHelper.getJobParam();

        Integer threshold = DEFAULT_THRESHDLD ;
        try{
            threshold = Integer.valueOf(param);

        }catch (Exception e){
            XxlJobHelper.log("定时任务的参数有误"+param);
        }
    }
}
