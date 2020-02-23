/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : employee

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-02-23 09:24:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `admin_name` varchar(11) NOT NULL,
  `admin_password` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`admin_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('root', '111');

-- ----------------------------
-- Table structure for tb_attend
-- ----------------------------
DROP TABLE IF EXISTS `tb_attend`;
CREATE TABLE `tb_attend` (
  `attend_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_no` varchar(11) NOT NULL COMMENT '员工编号',
  `emp_name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `attend_begin_time` timestamp NULL DEFAULT NULL COMMENT '上班打卡时间',
  `attend_end_time` timestamp NULL DEFAULT NULL COMMENT '下班打卡时间',
  PRIMARY KEY (`attend_id`),
  KEY `emp_no` (`emp_no`),
  CONSTRAINT `tb_attend_ibfk_1` FOREIGN KEY (`emp_no`) REFERENCES `tb_emp` (`emp_no`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_attend
-- ----------------------------
INSERT INTO `tb_attend` VALUES ('2', '00002', '后羿', '2020-02-22 20:38:39', '2020-02-22 23:00:00');
INSERT INTO `tb_attend` VALUES ('6', '00005', '诸葛亮', '2020-02-22 20:41:07', null);
INSERT INTO `tb_attend` VALUES ('7', '00006', '刘备', '2020-02-22 20:41:13', null);
INSERT INTO `tb_attend` VALUES ('8', '00010', '孙悟空', '2020-02-22 20:41:19', null);
INSERT INTO `tb_attend` VALUES ('9', '00003', '孙尚香', '2020-02-22 00:00:00', null);
INSERT INTO `tb_attend` VALUES ('12', '00009', '公孙离', '2020-02-22 22:05:27', '2020-02-22 22:05:43');
INSERT INTO `tb_attend` VALUES ('13', '00009', '公孙离', '2020-02-23 08:56:28', '2020-02-23 08:56:59');
INSERT INTO `tb_attend` VALUES ('14', '00002', '后羿', '2020-02-23 09:21:50', '2020-02-23 09:22:04');

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `dept_id` varchar(10) NOT NULL COMMENT '部门编号',
  `dept_name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `dept_create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '部门创建时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES ('01', '开发部', '2020-02-22 13:43:15');
INSERT INTO `tb_dept` VALUES ('02', '产品部', '2020-02-22 13:43:20');
INSERT INTO `tb_dept` VALUES ('03', '销售部', '2020-02-22 13:43:23');
INSERT INTO `tb_dept` VALUES ('04', '测试部', '2020-02-22 13:43:26');
INSERT INTO `tb_dept` VALUES ('05', '行政部', '2020-02-22 13:43:31');
INSERT INTO `tb_dept` VALUES ('06', '后勤部', '2020-02-22 13:43:37');
INSERT INTO `tb_dept` VALUES ('07', '党政机关部', '2020-02-22 13:43:46');
INSERT INTO `tb_dept` VALUES ('08', '机电部', '2020-02-22 13:43:52');

-- ----------------------------
-- Table structure for tb_emp
-- ----------------------------
DROP TABLE IF EXISTS `tb_emp`;
CREATE TABLE `tb_emp` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工主键',
  `emp_name` varchar(255) NOT NULL COMMENT '员工姓名',
  `emp_gender` varchar(255) DEFAULT NULL COMMENT '员工性别',
  `emp_email` varchar(255) DEFAULT NULL COMMENT '员工邮箱',
  `emp_status` int(11) DEFAULT NULL COMMENT '员工状态，1表示已转正，0表示没转正',
  `dept_id` varchar(10) DEFAULT NULL COMMENT '部门编号',
  `emp_no` varchar(11) DEFAULT NULL COMMENT '员工工号，唯一',
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_no` (`emp_no`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `tb_emp_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `tb_dept` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_emp
-- ----------------------------
INSERT INTO `tb_emp` VALUES ('155', '鲁班七号', '男', 'lubanqihao@163.com', null, '07', '00001');
INSERT INTO `tb_emp` VALUES ('156', '后羿', '男', 'houyi@163.com', null, '02', '00002');
INSERT INTO `tb_emp` VALUES ('157', '孙尚香', '女', 'sunshangxiang@163.com', null, '03', '00003');
INSERT INTO `tb_emp` VALUES ('158', '张飞', '男', 'zhangfei@163.com', null, '04', '00004');
INSERT INTO `tb_emp` VALUES ('159', '诸葛亮', '男', 'zhugeliang@163.com', null, '01', '00005');
INSERT INTO `tb_emp` VALUES ('160', '刘备', '男', 'liubei@163.com', null, '01', '00006');
INSERT INTO `tb_emp` VALUES ('161', '关羽', '男', 'guanyu@163.com', null, '05', '00007');
INSERT INTO `tb_emp` VALUES ('162', '钟馗', '男', 'zhongkui@163.com', null, '02', '00008');
INSERT INTO `tb_emp` VALUES ('163', '公孙离', '女', 'gongsunli@163.com', null, '03', '00009');
INSERT INTO `tb_emp` VALUES ('164', '孙悟空', '男', 'sunwukong@163.com', null, '01', '00010');
INSERT INTO `tb_emp` VALUES ('165', '猪八戒', '男', 'zhubajie@163.com', null, '02', '00011');
INSERT INTO `tb_emp` VALUES ('166', '上官婉儿', '女', 'shangguanwaner@163.com', null, '02', '00012');
INSERT INTO `tb_emp` VALUES ('167', '武则天', '女', 'wuzetian@163.com', null, '03', '00013');
INSERT INTO `tb_emp` VALUES ('168', '王昭君', '女', 'wangzhaojun@163.com', null, '04', '00014');
