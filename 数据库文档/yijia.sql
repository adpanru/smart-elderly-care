/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : yijia

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 25/03/2023 21:42:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(10) NOT NULL,
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '市场部');
INSERT INTO `department` VALUES (2, '技术部');
INSERT INTO `department` VALUES (3, '销售部');
INSERT INTO `department` VALUES (4, '客服部');
INSERT INTO `department` VALUES (5, '公关部');

-- ----------------------------
-- Table structure for doc_info
-- ----------------------------
DROP TABLE IF EXISTS `doc_info`;
CREATE TABLE `doc_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '医生id',
  `d_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '医生姓名',
  `d_sex` int(2) NOT NULL COMMENT '医生性别 0女 1男',
  `address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '居住地',
  `work_unit` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '工作单位',
  `work_sector` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '工作部门',
  `person_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号码',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系方式',
  `nvq_num` int(10) NOT NULL COMMENT '医师编号',
  `acc_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录账号',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录密码',
  `pro_status` int(2) NOT NULL DEFAULT 0 COMMENT '0审批未通过 1通过',
  `all_score` float(10, 2) NOT NULL COMMENT '综合评分',
  `online` int(2) NOT NULL COMMENT '在线状态 0不在线 1在线',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of doc_info
-- ----------------------------

-- ----------------------------
-- Table structure for doc_rate
-- ----------------------------
DROP TABLE IF EXISTS `doc_rate`;
CREATE TABLE `doc_rate`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `acc_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录账号',
  `d_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '医生姓名',
  `rate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '医生收到的评价',
  `score` float(10, 2) NOT NULL DEFAULT 8888.00 COMMENT '对医生的评分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of doc_rate
-- ----------------------------

-- ----------------------------
-- Table structure for eld_info
-- ----------------------------
DROP TABLE IF EXISTS `eld_info`;
CREATE TABLE `eld_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `e_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '老人姓名',
  `temperature` double(5, 2) NOT NULL COMMENT '体温',
  `pulse` int(5) NOT NULL COMMENT '每分钟心跳次数',
  `breathe` int(5) NOT NULL COMMENT '每分钟呼吸次数',
  `blood_pre` int(5) NOT NULL COMMENT '血压',
  `weight` double(5, 2) NOT NULL COMMENT '体重',
  `blood_sugar` double(5, 2) NOT NULL COMMENT '血糖',
  `sleep` double(5, 2) NOT NULL COMMENT '睡眠时间',
  `med_history` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '病史',
  `mental_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '精神状况',
  `time` date NOT NULL COMMENT '测量时间',
  `res_doctor` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '负责医生',
  `doc_propose` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '医生建议',
  `online` int(2) NOT NULL COMMENT '是否在线 0否1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of eld_info
-- ----------------------------

-- ----------------------------
-- Table structure for eld_status
-- ----------------------------
DROP TABLE IF EXISTS `eld_status`;
CREATE TABLE `eld_status`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `e_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '老人姓名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录密码',
  `e_sex` int(2) NOT NULL COMMENT '性别 0女 1男',
  `e_age` int(3) NOT NULL COMMENT '年龄',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系方式—账号',
  `address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '住址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of eld_status
-- ----------------------------
INSERT INTO `eld_status` VALUES (1, '提莫', '1234', 1, 66, '19833951890', '河北');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工邮箱',
  `gender` int(2) NOT NULL COMMENT '员工性别',
  `department_id` int(10) NOT NULL COMMENT '部门编号',
  `date` date NOT NULL COMMENT '入职日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (2, '李四', 'lisi@qq.com', 1, 2, '2020-02-05');
INSERT INTO `employee` VALUES (3, '王五', 'wangwu@126.com', 0, 3, '2020-02-15');
INSERT INTO `employee` VALUES (4, '赵六', 'zhaoliu@163.com', 1, 4, '2020-02-21');
INSERT INTO `employee` VALUES (5, '田七', 'tianqi@foxmail.com', 0, 3, '2020-02-14');
INSERT INTO `employee` VALUES (10, '王伟', 'wangwei@gmail.com', 1, 3, '2020-02-08');
INSERT INTO `employee` VALUES (11, '张伟', 'zhangwei@gmail.com', 1, 2, '2020-02-11');
INSERT INTO `employee` VALUES (12, '李伟', 'liwei@gmail.com', 1, 3, '2020-02-18');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456');

SET FOREIGN_KEY_CHECKS = 1;
