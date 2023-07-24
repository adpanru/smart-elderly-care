package com.kuang.dto;

import lombok.Data;

@Data
public class DocRateDTO {
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 综合评分
     */
    private Float allScore;
}
