/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : library_sys_

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-10-13 10:00:09
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `t_book`
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `roomid` int(10) unsigned DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `roomname` varchar(45) DEFAULT NULL,
  `userid` int(10) unsigned DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('26', '7', '2016-04-25 03:26:00', '2016-04-25 04:27:00', null, '5', '1');
INSERT INTO `t_book` VALUES ('29', '6', '2016-04-25 06:48:00', '2016-04-25 07:48:00', null, '5', '1');
INSERT INTO `t_book` VALUES ('31', '7', '2016-05-08 09:28:00', '2016-05-08 10:29:00', null, '7', '1');
INSERT INTO `t_book` VALUES ('32', '6', '2016-05-08 11:29:00', '2016-05-08 14:29:00', null, '7', '1');
INSERT INTO `t_book` VALUES ('35', '6', '2017-02-24 03:22:00', '2017-02-25 03:22:00', null, '8', '1');
INSERT INTO `t_book` VALUES ('36', '6', '2017-04-01 09:37:00', '2017-04-02 09:37:00', null, '6', '1');
INSERT INTO `t_book` VALUES ('38', '7', '2017-04-01 04:53:00', '2017-04-01 07:53:00', null, '10', '1');
INSERT INTO `t_book` VALUES ('39', '7', '2017-10-13 09:35:00', '2017-10-13 09:35:00', null, '9', '0');

-- ----------------------------
-- Table structure for `t_borrow`
-- ----------------------------
DROP TABLE IF EXISTS `t_borrow`;
CREATE TABLE `t_borrow` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `endtime` datetime DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `roomid` int(10) unsigned DEFAULT NULL,
  `userid` int(10) unsigned DEFAULT NULL,
  `roomname` varchar(45) DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_borrow
-- ----------------------------
INSERT INTO `t_borrow` VALUES ('3', '2016-05-09 09:29:00', '2016-05-08 09:29:00', '6', '7', null, '0');
INSERT INTO `t_borrow` VALUES ('7', '2017-02-26 03:23:00', '2017-02-24 03:23:00', '7', '8', null, '0');
INSERT INTO `t_borrow` VALUES ('10', '2017-04-02 01:54:00', '2017-04-01 01:54:00', '10', '10', null, '0');

-- ----------------------------
-- Table structure for `t_comments`
-- ----------------------------
DROP TABLE IF EXISTS `t_comments`;
CREATE TABLE `t_comments` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `commitdate` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `bioid` varchar(45) DEFAULT NULL,
  `userid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comments
-- ----------------------------
INSERT INTO `t_comments` VALUES ('1', '2016-04-25 15:23:17', '哈哈', null, '8', '5');
INSERT INTO `t_comments` VALUES ('2', '2016-04-25 15:23:34', '哈哈', null, '9', '5');
INSERT INTO `t_comments` VALUES ('3', '2016-04-25 15:25:23', '呵呵', null, '7', '5');
INSERT INTO `t_comments` VALUES ('4', '2016-04-25 15:47:19', '老师超好哈哈哈', null, '6', '6');
INSERT INTO `t_comments` VALUES ('5', '2016-04-25 15:48:49', '老师很好', null, '7', '5');
INSERT INTO `t_comments` VALUES ('6', '2016-04-25 15:49:03', '感谢老师', null, '7', '5');
INSERT INTO `t_comments` VALUES ('7', '2016-05-08 21:32:41', '111', null, '6', '7');
INSERT INTO `t_comments` VALUES ('8', '2017-04-01 13:52:27', 'good', null, '7', '10');

-- ----------------------------
-- Table structure for `t_employee`
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `dept` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('7', '杨卫民', '13365665545', '895631155@qq.com', '馆长', '55');
INSERT INTO `t_employee` VALUES ('8', '范冬梅', '13365665545', '895631155@qq.com', '秘书', '55');
INSERT INTO `t_employee` VALUES ('9', '马金亭', '13365665545', '895631155@qq.com', '保洁', '55');
INSERT INTO `t_employee` VALUES ('10', '刘方', '13365665545', '895631155@qq.com', '职工', '55');
INSERT INTO `t_employee` VALUES ('11', '田海玲', '13365665545', '895631155@qq.com', '职工', '55');
INSERT INTO `t_employee` VALUES ('12', '吕勇兵', '13365665545', '895631155@qq.com', '职工', '55');
INSERT INTO `t_employee` VALUES ('13', '王里平', '13365665545', '895631155@qq.com', '职工', '55');
INSERT INTO `t_employee` VALUES ('14', '高文莲', '13365665545', '895631155@qq.com', '职工', '55');
INSERT INTO `t_employee` VALUES ('15', '白小红', '13365665545', '895631155@qq.com', '职工', '55');
INSERT INTO `t_employee` VALUES ('16', '冯克明', '13365665545', '895631155@qq.com', '职工', '55');
INSERT INTO `t_employee` VALUES ('17', '薛金莲', '13365665545', '895631155@qq.com', '职工', '55');
INSERT INTO `t_employee` VALUES ('18', '郝志峰', '13365665545', '895631155@qq.com', '职工', '55');
INSERT INTO `t_employee` VALUES ('19', '建筑系', '13365665545', '895631155@qq.com', '职工', '55');
INSERT INTO `t_employee` VALUES ('20', '李震', '13365665545', '895631155@qq.com', '职工', '55');

-- ----------------------------
-- Table structure for `t_meetroom`
-- ----------------------------
DROP TABLE IF EXISTS `t_meetroom`;
CREATE TABLE `t_meetroom` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `device` varchar(45) DEFAULT NULL,
  `capability` varchar(45) DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_meetroom
-- ----------------------------
INSERT INTO `t_meetroom` VALUES ('7', '分析化学', '范冬梅', 'DSN1665645', '化学', '0');
INSERT INTO `t_meetroom` VALUES ('8', '高等数学', '马金亭', 'DSN1665646', '数学', '0');
INSERT INTO `t_meetroom` VALUES ('9', '高等代数', '刘方', 'DSN1665647', '数学', '0');
INSERT INTO `t_meetroom` VALUES ('10', '化工原理', '田海玲', 'DSN1665648', '化学化工', '0');
INSERT INTO `t_meetroom` VALUES ('11', '大学语文', '吕勇兵', 'DSN1665649', '中文', '0');
INSERT INTO `t_meetroom` VALUES ('12', 'C程序设计', '王里平', 'DSN1665650', '计算机', '0');
INSERT INTO `t_meetroom` VALUES ('13', '计算机基础', '高文莲', 'DSN1665651', '计算机', '0');
INSERT INTO `t_meetroom` VALUES ('14', '大学英语', '白小红', 'DSN1665652', '外语', '0');
INSERT INTO `t_meetroom` VALUES ('15', '综合英语', '冯克明', 'DSN1665653', '外语', '0');
INSERT INTO `t_meetroom` VALUES ('16', '思想道德修养与法律基础', '薛金莲', 'DSN1665654', '思政', '0');
INSERT INTO `t_meetroom` VALUES ('17', '建筑工程测量', '郝志峰', 'DSN1665655', '建筑', '0');
INSERT INTO `t_meetroom` VALUES ('18', '运动生理学', '阴乃应', 'DSN1665656', '体育', '1');
INSERT INTO `t_meetroom` VALUES ('19', '大学体育', '李震', 'DSN1665657', '体育', '0');

-- ----------------------------
-- Table structure for `t_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `uptime` datetime DEFAULT NULL,
  `userid` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('2', '睡觉', '2016-02-25 22:58:00', null);
INSERT INTO `t_message` VALUES ('3', '开会', '2016-02-25 13:57:00', null);
INSERT INTO `t_message` VALUES ('4', '买菜', '2016-02-25 03:02:00', null);
INSERT INTO `t_message` VALUES ('5', '开会', '2016-02-26 10:32:00', '2');
INSERT INTO `t_message` VALUES ('6', '吃饭', '2016-02-26 12:32:00', '2');
INSERT INTO `t_message` VALUES ('7', '开会', '2016-02-26 16:33:00', '2');
INSERT INTO `t_message` VALUES ('9', '吃饭', '2016-02-26 12:44:00', '4');
INSERT INTO `t_message` VALUES ('10', '客户开会', '2016-02-26 16:44:00', '4');
INSERT INTO `t_message` VALUES ('11', '下班', '2016-02-26 17:00:00', '4');
INSERT INTO `t_message` VALUES ('12', '呵呵吃饭', '2016-04-25 03:49:00', '5');
INSERT INTO `t_message` VALUES ('13', '额呵睡觉', '2016-04-25 12:49:00', '5');
INSERT INTO `t_message` VALUES ('14', 'OK', '2017-02-24 03:24:00', '8');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `qqnum` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('5', 'john', '111111', '20160232', '计算机', '普通用户');
INSERT INTO `t_user` VALUES ('6', 'jack', '111111', '2016556', '通信工程', '普通用户');
INSERT INTO `t_user` VALUES ('7', 'tom', '111111', '204330000', '机电工程', '普通用户');
INSERT INTO `t_user` VALUES ('8', 'zhang', '111111', '20156666', '物理', '普通用户');
INSERT INTO `t_user` VALUES ('9', 'admin', 'admin', '20170001', '通信', '管理员');
INSERT INTO `t_user` VALUES ('10', 'wang', '111111', '20170023', '数学', '普通用户');
