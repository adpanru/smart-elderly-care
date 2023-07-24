package com.kuang.pojo;

import lombok.Data;
/**
 * <p>
 *
 * </p>
 *
 * @author www.javacoder.top
 * @since 2023-03-31
 */
@Data
public class DocInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 医生id
     */

    private Long id;

    /**
     * 医生姓名
     */
    private String dName;

    /**
     * 医生性别
     */
    private String dSex;

    /**
     * 居住地
     */
    private String address;

    /**
     * 工作单位
     */
    private String workUnit;

    /**
     * 工作部门
     */
    private String workSector;

    /**
     * 身份证号码
     */
    private String personId;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 医师编号
     */
    private Integer nvqNum;

    /**
     * 登录账号
     */
    private String accNum;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 0审批未通过 1通过
     */
    private Integer proStatus;

    /**
     * 综合评分
     */
    private Float allScore;

    /**
     * 在线状态 0不在线 1在线
     */
    private Integer online;

}
