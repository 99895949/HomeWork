/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : park_sys

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-02-10 18:39:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理者id',
  `admin_name` varchar(128) NOT NULL,
  `admin_password` varchar(128) NOT NULL,
  `admin_gender` varchar(128) DEFAULT NULL COMMENT '管理者性别',
  `admin_phone` varchar(128) DEFAULT NULL COMMENT '管理者电话',
  `admin_email` varchar(128) DEFAULT NULL COMMENT '管理者邮箱',
  `admin_address` varchar(128) DEFAULT NULL,
  `admin_type` int(11) NOT NULL COMMENT '管理者类型，',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '刘备', 'liubei', '男', '15832654555', 'liubei@163.com', '四川', '0');
INSERT INTO `admin` VALUES ('2', '关羽', 'guanyu', '男', '15332654555', 'guanyu@163.com', '四川', '1');
INSERT INTO `admin` VALUES ('3', '曹操', 'caocao', '男', '15332354555', 'caocao@163.com', '河南', '1');
INSERT INTO `admin` VALUES ('4', 'root', 'root', '男', '15332354555', 'root@163.com', '河南', '2');
INSERT INTO `admin` VALUES ('5', 'admin', 'admin', '男', '15332354555', 'admin@163.com', '河南', '1');
INSERT INTO `admin` VALUES ('6', '张飞', 'zhangfei', '男', '15532136587', 'zhangfei@163.com', '河北', '0');
INSERT INTO `admin` VALUES ('7', '许褚', 'xuchu', '男', '14432546987', 'xuchu@163.com', '山东', '0');
INSERT INTO `admin` VALUES ('8', '孙权', 'sunquan', '男', '13325469878', 'sunquan@163.com', '云南', '0');
INSERT INTO `admin` VALUES ('9', '小乔', 'xiaoqiao', '女', '15465879566', 'xiaoqiao@163.com', '江西', '0');
INSERT INTO `admin` VALUES ('10', '诸葛亮', 'zhugeliang', '女', '17765894655', 'zhugeliang@163.com', '广东', '1');
INSERT INTO `admin` VALUES ('11', '貂蝉', 'diaochan', '女', '15565884666', 'diaochan@163.com', '上海', '1');
INSERT INTO `admin` VALUES ('12', '西施', 'xishi', '女', '19954668665', 'xishi@163.com', '广西', '1');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `car_id` varchar(255) NOT NULL COMMENT '车牌号',
  `car_type` varchar(255) DEFAULT NULL COMMENT '车型号',
  `card_id` varchar(255) DEFAULT NULL COMMENT '所属停车卡号',
  PRIMARY KEY (`car_id`),
  KEY `card_id` (`card_id`),
  CONSTRAINT `car_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `card` (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('京A10001', '', '00c1c');
INSERT INTO `car` VALUES ('京A10002', '', '00c1c');
INSERT INTO `car` VALUES ('冀020A7', '宝马', '4b53b');
INSERT INTO `car` VALUES ('冀02892', '宝马', '48c09');
INSERT INTO `car` VALUES ('冀0C751', '宝马', '575aa');
INSERT INTO `car` VALUES ('冀0ED5F', '宝马', '7f878');
INSERT INTO `car` VALUES ('冀17D6F', '宝马', '30ed1');
INSERT INTO `car` VALUES ('冀267D1', '宝马', '0b2d9');
INSERT INTO `car` VALUES ('冀346C7', '宝马', 'ffae3');
INSERT INTO `car` VALUES ('冀34AAA6C7', '', '测试');
INSERT INTO `car` VALUES ('冀37A3C', '宝马', '5a2fb');
INSERT INTO `car` VALUES ('冀3B6E4', '宝马', '3f7dc');
INSERT INTO `car` VALUES ('冀5BBC7', '宝马', '1b68a');
INSERT INTO `car` VALUES ('冀5EB7B', '宝马', '5bdcf');
INSERT INTO `car` VALUES ('冀67046', '宝马', '364a5');
INSERT INTO `car` VALUES ('冀6B817', '宝马', 'e7740');
INSERT INTO `car` VALUES ('冀72D9A', '宝马', 'dc68c');
INSERT INTO `car` VALUES ('冀7627C', '宝马', '3afae');
INSERT INTO `car` VALUES ('冀7A59B', '宝马', '21f5e');
INSERT INTO `car` VALUES ('冀813E2', '宝马', '543e4');
INSERT INTO `car` VALUES ('冀86AC0', '宝马', 'e4a44');
INSERT INTO `car` VALUES ('冀8C0FE', '宝马', 'a0dcf');
INSERT INTO `car` VALUES ('冀93ACD', '宝马', '1c933');
INSERT INTO `car` VALUES ('冀98908', '', '0e42e');
INSERT INTO `car` VALUES ('冀9C890', '宝马', 'bc340');
INSERT INTO `car` VALUES ('冀9FE92', '宝马', '41b18');
INSERT INTO `car` VALUES ('冀A5262', '宝马', 'f4313');
INSERT INTO `car` VALUES ('冀AC541', '宝马', '93c2c');
INSERT INTO `car` VALUES ('冀ADABD', '宝马', '2cbbf');
INSERT INTO `car` VALUES ('冀AE5A3', '宝马', '1b81c');
INSERT INTO `car` VALUES ('冀AF81A', '宝马', '4c9f7');
INSERT INTO `car` VALUES ('冀B5D91', '宝马', '496ae');
INSERT INTO `car` VALUES ('冀B62C7', '宝马', 'b2586');
INSERT INTO `car` VALUES ('冀BD1A3', '宝马', 'e2911');
INSERT INTO `car` VALUES ('冀BF6C2', '宝马', '38902');
INSERT INTO `car` VALUES ('冀BFDA5', '宝马', '9bd7f');
INSERT INTO `car` VALUES ('冀CCF83', '宝马', 'ba24f');
INSERT INTO `car` VALUES ('冀D163B', '宝马', '813bb');
INSERT INTO `car` VALUES ('冀D2421', '宝马', '58e49');
INSERT INTO `car` VALUES ('冀D9F77', '宝马', '81808');
INSERT INTO `car` VALUES ('冀E0A22', '宝马', '5efa6');
INSERT INTO `car` VALUES ('冀E0C46', '宝马', '2271a');
INSERT INTO `car` VALUES ('冀E6C65', '宝马', 'e262a');
INSERT INTO `car` VALUES ('冀EAB93', '宝马', '87ceb');
INSERT INTO `car` VALUES ('冀F3F1B', '宝马', 'd58af');
INSERT INTO `car` VALUES ('冀F64EF', '宝马', '304bc');
INSERT INTO `car` VALUES ('冀F6DB7', '宝马', 'ef649');
INSERT INTO `car` VALUES ('冀F9C19', '宝马', '3bab2');
INSERT INTO `car` VALUES ('冀FF4F4', '宝马', 'f25c4');
INSERT INTO `car` VALUES ('冀冀34AAA6C722', '', '测试');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `card_id` varchar(255) NOT NULL COMMENT '停车卡号',
  `user_name` varchar(255) NOT NULL COMMENT '用户姓名',
  `user_password` varchar(255) NOT NULL COMMENT '用户密码',
  `user_phone` varchar(255) NOT NULL COMMENT '用户电话',
  `card_type` int(11) NOT NULL COMMENT '停车卡类型，0普通卡，1VIP',
  `card_balance` double(8,2) NOT NULL COMMENT '卡内余额',
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('00c1c', '黄版秋', '00c1c', '15919571588', '1', '140.00');
INSERT INTO `card` VALUES ('0b2d9', '鲜于言窍', '0b2d9', '13373954276', '0', '100.00');
INSERT INTO `card` VALUES ('0e42e', '韦踞垫', '0e42e', '15229447265', '0', '100.00');
INSERT INTO `card` VALUES ('1b68a', '梁龄欣', '1b68a', '14540251641', '0', '100.00');
INSERT INTO `card` VALUES ('1b81c', '夏缉拎', '1b81c', '13061627990', '0', '100.00');
INSERT INTO `card` VALUES ('1c933', '白避斌', '1c933', '18850546955', '0', '100.00');
INSERT INTO `card` VALUES ('21f5e', '杨易句', '21f5e', '18337379108', '0', '100.00');
INSERT INTO `card` VALUES ('2271a', '谢捣写', '2271a', '13899334450', '0', '100.00');
INSERT INTO `card` VALUES ('2cbbf', '叶唉', '2cbbf', '17701162778', '0', '100.00');
INSERT INTO `card` VALUES ('304bc', '郑邀淤', '304bc', '15819043884', '0', '100.00');
INSERT INTO `card` VALUES ('30ed1', '东方孺', '30ed1', '17759499102', '0', '100.00');
INSERT INTO `card` VALUES ('364a5', '宋胺', '364a5', '18699858635', '0', '100.00');
INSERT INTO `card` VALUES ('38902', '施辕袍', '38902', '15600125056', '0', '100.00');
INSERT INTO `card` VALUES ('3afae', '司马靠炭', '3afae', '18663442815', '0', '100.00');
INSERT INTO `card` VALUES ('3bab2', '施钾', '3bab2', '18589635073', '0', '100.00');
INSERT INTO `card` VALUES ('3f7dc', '牛墓华', '3f7dc', '18127051119', '0', '100.00');
INSERT INTO `card` VALUES ('41b18', '夏侯场', '41b18', '13741652192', '0', '100.00');
INSERT INTO `card` VALUES ('48c09', '邹辩际', '48c09', '18184227114', '0', '100.00');
INSERT INTO `card` VALUES ('496ae', '郑簿', '496ae', '13330698735', '0', '100.00');
INSERT INTO `card` VALUES ('4b53b', '独孤赃熬', '4b53b', '18244241987', '0', '60.00');
INSERT INTO `card` VALUES ('4c9f7', '卢瞧', '4c9f7', '13264639117', '0', '100.00');
INSERT INTO `card` VALUES ('543e4', '吕豫', '543e4', '13661390205', '0', '100.00');
INSERT INTO `card` VALUES ('575aa', '沈唬套', '575aa', '13827529406', '0', '100.00');
INSERT INTO `card` VALUES ('58e49', '徐帅', '58e49', '18899272385', '0', '100.00');
INSERT INTO `card` VALUES ('5a2fb', '令狐唐经', '5a2fb', '13150493263', '0', '100.00');
INSERT INTO `card` VALUES ('5bdcf', '钟薄地', '5bdcf', '18265482441', '0', '100.00');
INSERT INTO `card` VALUES ('5efa6', '马摈贞', '5efa6', '15248758865', '0', '100.00');
INSERT INTO `card` VALUES ('7f878', '谢禹', '7f878', '14509586094', '0', '100.00');
INSERT INTO `card` VALUES ('813bb', '范滦涝', '813bb', '18584675976', '0', '100.00');
INSERT INTO `card` VALUES ('81808', '姚升棺', '81808', '14559094953', '0', '100.00');
INSERT INTO `card` VALUES ('87ceb', '牛硝钥', '87ceb', '13576407912', '0', '100.00');
INSERT INTO `card` VALUES ('93c2c', '秦牡', '93c2c', '13791602200', '0', '100.00');
INSERT INTO `card` VALUES ('9bd7f', '熊鸭', '9bd7f', '13760311474', '0', '100.00');
INSERT INTO `card` VALUES ('a0dcf', '唐郸孰', 'a0dcf', '14533665523', '0', '100.00');
INSERT INTO `card` VALUES ('b2586', '石盘慷', 'b2586', '13549525093', '0', '100.00');
INSERT INTO `card` VALUES ('ba24f', '施喝', 'ba24f', '14712862830', '0', '100.00');
INSERT INTO `card` VALUES ('bc340', '戴合踏', 'bc340', '15590163059', '0', '100.00');
INSERT INTO `card` VALUES ('d58af', '谢秆', 'd58af', '15877991086', '0', '100.00');
INSERT INTO `card` VALUES ('dc68c', '江粤怜', 'dc68c', '13142681117', '0', '100.00');
INSERT INTO `card` VALUES ('e262a', '闾丘廓', 'e262a', '13476735795', '0', '100.00');
INSERT INTO `card` VALUES ('e2911', '顾仰', 'e2911', '15520643976', '0', '100.00');
INSERT INTO `card` VALUES ('e4a44', '许葡该', 'e4a44', '17692495168', '0', '100.00');
INSERT INTO `card` VALUES ('e7740', '宇文母券', 'e7740', '13854126826', '0', '100.00');
INSERT INTO `card` VALUES ('ef649', '常者费', 'ef649', '18840512610', '0', '100.00');
INSERT INTO `card` VALUES ('f25c4', '西门冗', 'f25c4', '15330036333', '0', '100.00');
INSERT INTO `card` VALUES ('f4313', '卢踞钠', 'f4313', '15593347552', '0', '100.00');
INSERT INTO `card` VALUES ('ffae3', '丁甸', 'ffae3', '17004807211', '0', '100.00');
INSERT INTO `card` VALUES ('测试', '丁甸', 'ffae3', '17004807211', '0', '100.00');

-- ----------------------------
-- Table structure for charge
-- ----------------------------
DROP TABLE IF EXISTS `charge`;
CREATE TABLE `charge` (
  `charge_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_type` int(11) NOT NULL COMMENT '停车卡类型',
  `price` decimal(10,2) DEFAULT NULL COMMENT '一小时的费用',
  `station_type` int(11) NOT NULL COMMENT '停车位类型',
  PRIMARY KEY (`charge_id`),
  UNIQUE KEY `card_type` (`card_type`,`station_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge
-- ----------------------------
INSERT INTO `charge` VALUES ('1', '0', '5.00', '0');
INSERT INTO `charge` VALUES ('2', '0', '10.00', '1');
INSERT INTO `charge` VALUES ('3', '0', '15.00', '2');
INSERT INTO `charge` VALUES ('4', '1', '8.00', '2');
INSERT INTO `charge` VALUES ('5', '1', '5.00', '1');
INSERT INTO `charge` VALUES ('6', '1', '2.00', '0');
INSERT INTO `charge` VALUES ('7', '-1', '15.00', '0');
INSERT INTO `charge` VALUES ('8', '-1', '25.00', '1');
INSERT INTO `charge` VALUES ('9', '-1', '30.00', '2');

-- ----------------------------
-- Table structure for park_info
-- ----------------------------
DROP TABLE IF EXISTS `park_info`;
CREATE TABLE `park_info` (
  `info_id` varchar(255) NOT NULL,
  `card_id` varchar(255) DEFAULT NULL COMMENT '停车卡号',
  `user_name` varchar(255) DEFAULT NULL COMMENT '车主姓名',
  `car_id` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `station_location` varchar(255) DEFAULT NULL COMMENT '车位位置',
  `begin_time` timestamp NULL DEFAULT NULL COMMENT '驶入时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '驶出时间',
  `pay_type` int(11) DEFAULT NULL,
  `pay_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of park_info
-- ----------------------------
INSERT INTO `park_info` VALUES ('12323-1581324517533', '', '', '12323', 'C19', '2020-02-10 16:48:37', '2020-02-10 16:49:15', '1', '1');
INSERT INTO `park_info` VALUES ('2222222222-1581305506208', '', '', '2222222222', 'A15', '2020-02-10 11:31:46', '2020-02-10 16:23:09', '1', '1');
INSERT INTO `park_info` VALUES ('456-1581324639514', '00c1c', '黄版秋', '456', 'A01', '2020-02-03 16:50:39', '2020-02-10 16:51:32', '1', '1');
INSERT INTO `park_info` VALUES ('5454454-1581305520866', '', '', '5454454', 'D18', '2020-02-10 11:32:00', '2020-02-10 16:28:53', '1', '1');
INSERT INTO `park_info` VALUES ('京A10001-1581325353011', '00c1c', '黄版秋', '京A10001', 'A01', '2020-02-10 17:02:33', '2020-02-10 17:24:14', '0', '1');
INSERT INTO `park_info` VALUES ('冀020A7-1581300413300', '4b53b', '独孤赃熬', '冀020A7', 'A01', '2020-02-10 02:06:53', '2020-02-10 10:08:10', '0', '1');
INSERT INTO `park_info` VALUES ('冀020A7-1581323150965', '4b53b', '独孤赃熬', '冀020A7', 'A01', '2020-02-10 16:25:50', '2020-02-10 16:25:57', '0', '1');
INSERT INTO `park_info` VALUES ('冀020A7-1581324371787', '4b53b', '独孤赃熬', '冀020A7', 'A01', '2020-02-10 16:46:11', '2020-02-10 16:46:27', '0', '1');
INSERT INTO `park_info` VALUES ('冀020A7-1581326625824', '4b53b', '独孤赃熬', '冀020A7', 'A02', '2020-02-10 17:23:45', '2020-02-10 17:24:11', '0', '1');
INSERT INTO `park_info` VALUES ('冀0210A7-1581300810078', '', '', '冀A00002', 'C11', '2020-02-10 10:13:30', '2020-02-10 16:22:33', '1', '1');
INSERT INTO `park_info` VALUES ('冀67046-1581324304615', '364a5', '宋胺', '冀67046', 'A01', '2020-02-10 16:45:04', '2020-02-10 16:45:56', '0', '1');
INSERT INTO `park_info` VALUES ('冀98908-1581330789357', '0e42e', '韦踞垫', '冀98908', 'A01', '2020-02-10 18:33:09', null, '0', '0');
INSERT INTO `park_info` VALUES ('冀9890S-1581330799014', '', '', '冀9890S', 'C03', '2020-02-10 18:33:19', null, '1', '0');
INSERT INTO `park_info` VALUES ('惹我热二无-1581324313322', '', '', '惹我热二无', 'D17', '2020-02-10 16:45:13', '2020-02-10 16:45:39', '1', '1');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` int(11) NOT NULL,
  `permission_type` int(11) DEFAULT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '0', 'operator');
INSERT INTO `permission` VALUES ('2', '1', 'admin');
INSERT INTO `permission` VALUES ('3', '1', 'operator');
INSERT INTO `permission` VALUES ('4', '2', 'admin');
INSERT INTO `permission` VALUES ('5', '2', 'operator');
INSERT INTO `permission` VALUES ('6', '2', 'root');

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `station_id` int(11) NOT NULL AUTO_INCREMENT,
  `station_type` int(11) NOT NULL COMMENT '车位类型号，0小型车，1中型车，2大型车',
  `station_location` varchar(255) NOT NULL COMMENT '车位位置',
  `station_status` int(11) NOT NULL COMMENT '0空闲，1已占用',
  PRIMARY KEY (`station_id`),
  UNIQUE KEY `station_location` (`station_location`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES ('23', '0', 'A01', '1');
INSERT INTO `station` VALUES ('24', '0', 'A02', '0');
INSERT INTO `station` VALUES ('25', '0', 'A03', '0');
INSERT INTO `station` VALUES ('26', '0', 'A04', '0');
INSERT INTO `station` VALUES ('27', '0', 'A05', '0');
INSERT INTO `station` VALUES ('28', '0', 'A06', '0');
INSERT INTO `station` VALUES ('29', '0', 'A07', '0');
INSERT INTO `station` VALUES ('30', '0', 'A08', '0');
INSERT INTO `station` VALUES ('31', '0', 'A09', '0');
INSERT INTO `station` VALUES ('32', '0', 'A10', '0');
INSERT INTO `station` VALUES ('33', '0', 'A11', '0');
INSERT INTO `station` VALUES ('34', '0', 'A12', '0');
INSERT INTO `station` VALUES ('35', '0', 'A13', '0');
INSERT INTO `station` VALUES ('36', '0', 'A14', '0');
INSERT INTO `station` VALUES ('37', '0', 'A15', '0');
INSERT INTO `station` VALUES ('38', '0', 'A16', '0');
INSERT INTO `station` VALUES ('39', '0', 'A17', '0');
INSERT INTO `station` VALUES ('40', '0', 'A18', '0');
INSERT INTO `station` VALUES ('41', '0', 'A19', '0');
INSERT INTO `station` VALUES ('42', '0', 'A20', '0');
INSERT INTO `station` VALUES ('43', '0', 'B01', '0');
INSERT INTO `station` VALUES ('44', '0', 'B02', '0');
INSERT INTO `station` VALUES ('45', '0', 'B03', '0');
INSERT INTO `station` VALUES ('46', '0', 'B04', '0');
INSERT INTO `station` VALUES ('47', '0', 'B05', '0');
INSERT INTO `station` VALUES ('48', '0', 'B06', '0');
INSERT INTO `station` VALUES ('49', '0', 'B07', '0');
INSERT INTO `station` VALUES ('50', '0', 'B08', '0');
INSERT INTO `station` VALUES ('51', '0', 'B09', '0');
INSERT INTO `station` VALUES ('52', '0', 'B10', '0');
INSERT INTO `station` VALUES ('53', '0', 'B11', '0');
INSERT INTO `station` VALUES ('54', '0', 'B12', '0');
INSERT INTO `station` VALUES ('55', '0', 'B13', '0');
INSERT INTO `station` VALUES ('56', '0', 'B14', '0');
INSERT INTO `station` VALUES ('57', '0', 'B15', '0');
INSERT INTO `station` VALUES ('58', '0', 'B16', '0');
INSERT INTO `station` VALUES ('59', '0', 'B17', '0');
INSERT INTO `station` VALUES ('60', '0', 'B18', '0');
INSERT INTO `station` VALUES ('61', '0', 'B19', '0');
INSERT INTO `station` VALUES ('62', '0', 'B20', '0');
INSERT INTO `station` VALUES ('63', '2', 'C01', '0');
INSERT INTO `station` VALUES ('64', '2', 'C02', '0');
INSERT INTO `station` VALUES ('65', '2', 'C03', '1');
INSERT INTO `station` VALUES ('66', '2', 'C04', '0');
INSERT INTO `station` VALUES ('67', '2', 'C05', '0');
INSERT INTO `station` VALUES ('68', '2', 'C06', '0');
INSERT INTO `station` VALUES ('69', '2', 'C07', '0');
INSERT INTO `station` VALUES ('70', '2', 'C08', '0');
INSERT INTO `station` VALUES ('71', '2', 'C09', '0');
INSERT INTO `station` VALUES ('72', '2', 'C10', '0');
INSERT INTO `station` VALUES ('73', '2', 'C11', '0');
INSERT INTO `station` VALUES ('74', '2', 'C12', '0');
INSERT INTO `station` VALUES ('75', '2', 'C13', '0');
INSERT INTO `station` VALUES ('76', '2', 'C14', '0');
INSERT INTO `station` VALUES ('77', '2', 'C15', '0');
INSERT INTO `station` VALUES ('78', '2', 'C16', '0');
INSERT INTO `station` VALUES ('79', '2', 'C17', '0');
INSERT INTO `station` VALUES ('80', '2', 'C18', '0');
INSERT INTO `station` VALUES ('81', '2', 'C19', '0');
INSERT INTO `station` VALUES ('82', '2', 'C20', '0');
INSERT INTO `station` VALUES ('83', '1', 'D01', '0');
INSERT INTO `station` VALUES ('84', '1', 'D02', '0');
INSERT INTO `station` VALUES ('85', '1', 'D03', '0');
INSERT INTO `station` VALUES ('86', '1', 'D04', '0');
INSERT INTO `station` VALUES ('87', '1', 'D05', '0');
INSERT INTO `station` VALUES ('88', '1', 'D06', '0');
INSERT INTO `station` VALUES ('89', '1', 'D07', '0');
INSERT INTO `station` VALUES ('90', '1', 'D08', '0');
INSERT INTO `station` VALUES ('91', '1', 'D09', '0');
INSERT INTO `station` VALUES ('92', '1', 'D10', '0');
INSERT INTO `station` VALUES ('93', '1', 'D11', '0');
INSERT INTO `station` VALUES ('94', '1', 'D12', '0');
INSERT INTO `station` VALUES ('95', '1', 'D13', '0');
INSERT INTO `station` VALUES ('96', '1', 'D14', '0');
INSERT INTO `station` VALUES ('97', '1', 'D15', '0');
INSERT INTO `station` VALUES ('98', '1', 'D16', '0');
INSERT INTO `station` VALUES ('99', '1', 'D17', '0');
INSERT INTO `station` VALUES ('100', '1', 'D18', '0');
INSERT INTO `station` VALUES ('101', '1', 'D19', '0');
INSERT INTO `station` VALUES ('102', '1', 'D20', '0');
