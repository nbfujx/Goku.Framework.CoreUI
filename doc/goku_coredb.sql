/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50715
Source Host           : 192.168.1.107:3306
Source Database       : goku_coredb

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-01-09 21:00:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `ids` varchar(32) COLLATE utf8_bin NOT NULL,
  `version` bigint(20) DEFAULT NULL,
  `allchildnodeids` varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  `departmentlevel` bigint(20) DEFAULT NULL,
  `depttype` char(1) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `images` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `isparent` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `names` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `orderids` bigint(20) DEFAULT NULL,
  `url` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `parentdepartmentids` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `principaluserids` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for sys_friend
-- ----------------------------
DROP TABLE IF EXISTS `sys_friend`;
CREATE TABLE `sys_friend` (
  `id` varchar(32) NOT NULL,
  `friend_id` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `module_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `parent_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `isparent` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `sort` int(20) DEFAULT NULL,
  `icon` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '图标',
  `description` varchar(500) COLLATE utf8_bin DEFAULT '',
  `if_show` varchar(1) COLLATE utf8_bin DEFAULT 'Y' COMMENT '是否显示。N：不显示。Y：显示。',
  `is_leaf` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `permission` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '权限key',
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for sys_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `description` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `index_page` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `if_show` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `sort` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` varchar(32) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_operate
-- ----------------------------
DROP TABLE IF EXISTS `sys_operate`;
CREATE TABLE `sys_operate` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `version` bigint(20) DEFAULT NULL,
  `permission` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `one_many` char(1) COLLATE utf8_bin DEFAULT NULL,
  `return_url` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `row_filter` char(1) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `module_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `form_token` char(1) COLLATE utf8_bin DEFAULT '0',
  `ip_black` char(1) COLLATE utf8_bin DEFAULT '0',
  `privilegess` char(1) COLLATE utf8_bin DEFAULT '1',
  `module_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sort` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `onemanyindex` (`one_many`) USING BTREE,
  KEY `returnurlindex` (`return_url`) USING BTREE,
  KEY `rowfilterindex` (`row_filter`) USING BTREE,
  KEY `urlindex` (`url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `version` bigint(20) DEFAULT NULL,
  `level` bigint(20) DEFAULT NULL,
  `type` char(1) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `isparent` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `sort` bigint(20) DEFAULT '0',
  `url` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `parent_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `operate` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `version` bigint(20) DEFAULT NULL,
  `key` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for sys_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_auth`;
CREATE TABLE `sys_role_auth` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '??',
  `role_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '??ids',
  `menu_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '??ids',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='????';

-- ----------------------------
-- Table structure for sys_role_operator
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_operator`;
CREATE TABLE `sys_role_operator` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `role_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `operator_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='????';

-- ----------------------------
-- Table structure for sys_schedule
-- ----------------------------
DROP TABLE IF EXISTS `sys_schedule`;
CREATE TABLE `sys_schedule` (
  `id` varchar(32) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `participate_id` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) COLLATE utf8_bin DEFAULT '1' COMMENT '0:女',
  `status` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '0:禁用',
  `orgid` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '部门ID',
  `stationid` text COLLATE utf8_bin COMMENT '岗位ID',
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `idcard` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号',
  `is_admin` varchar(1) COLLATE utf8_bin DEFAULT '0' COMMENT '是否是管理员',
  `sort` bigint(99) DEFAULT NULL,
  `mobile` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usernameindex` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for sys_user_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_auth`;
CREATE TABLE `sys_user_auth` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `menu_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `user_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `head_portrait` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭住址',
  `post_code` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '邮编',
  `height` varchar(5) COLLATE utf8_bin DEFAULT NULL COMMENT '身高',
  `weight` varchar(5) COLLATE utf8_bin DEFAULT NULL COMMENT '体重',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `blood` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '血型',
  `culture` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '文化程度',
  `finish_school_date` date DEFAULT NULL,
  `folk` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '民族',
  `government` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT '党员关系',
  `homepage` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '个人主页',
  `householder` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '户主',
  `marriage` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '婚否',
  `msn` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'MSN',
  `nativity_address` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '出生地',
  `qq` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'QQ',
  `speciality` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '特长',
  `description` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '描述信息',
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bloodgroupindex` (`blood`) USING BTREE,
  KEY `msnindex` (`msn`) USING BTREE,
  KEY `nativityaddressindex` (`nativity_address`) USING BTREE,
  KEY `postboyindex` (`post_code`) USING BTREE,
  KEY `specialityindex` (`speciality`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for sys_user_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_notice`;
CREATE TABLE `sys_user_notice` (
  `id` varchar(32) NOT NULL,
  `userid` varchar(32) DEFAULT NULL,
  `noticeid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
