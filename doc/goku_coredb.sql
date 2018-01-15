/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50715
Source Host           : 192.168.1.107:3306
Source Database       : goku_coredb

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-01-15 14:16:44
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
-- Records of sys_department
-- ----------------------------

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
-- Records of sys_friend
-- ----------------------------

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
-- Records of sys_log
-- ----------------------------

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
  `if_show` varchar(1) COLLATE utf8_bin DEFAULT '1' COMMENT '是否显示。0：不显示。1：显示。',
  `is_leaf` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `permission` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '权限key',
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('06fd8633f5f211e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', '菜单修改', 'f287d403efb111e7a2360a0027000038', '0', '11', '', '菜单修改', '0', '1', 'sys:menu:edit', 'sys/menu/editPage');
INSERT INTO `sys_menu` VALUES ('26831a69efb211e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '用户管理', '28c3ef4eefb111e7a2360a0027000038', '0', '4', 'icon-puzzle', '用户管理', '1', '0', 'sys:user:query', 'sys/user/getListPage');
INSERT INTO `sys_menu` VALUES ('28c3ef4eefb111e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '系统管理', '-1', '1', '1', 'icon-puzzle', '系统管理', '1', '0', '', '');
INSERT INTO `sys_menu` VALUES ('32c15082f5f211e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', '菜单删除', 'f287d403efb111e7a2360a0027000038', '0', '12', '', '菜单删除', '0', '1', 'sys:menu:delete', ' ');
INSERT INTO `sys_menu` VALUES ('357ff499f07c11e7a2360a0027000030', '28c3ef4eefb111e7a2360a0027000038', '用户删除', '26831a69efb211e7a2360a0027000038', '0', '9', '', '用户删除', '0', '1', 'sys:user:delete', ' ');
INSERT INTO `sys_menu` VALUES ('357ff499f07c11e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '用户新增', '26831a69efb211e7a2360a0027000038', '0', '7', '', '用户新增', '0', '1', 'sys:user:add', 'sys/user/addPage');
INSERT INTO `sys_menu` VALUES ('35f6df58f07e11e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '首页', '-1', '1', '0', '', '首页', '0', '1', 'sys:index:*', 'sys/index');
INSERT INTO `sys_menu` VALUES ('514ab49ef75911e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', '模块修改', 'cab4c933f6d411e78abf0a002700001d', '0', '14', '', '模块修改', '0', '0', 'sys:module:edit', 'sys/module/editPage');
INSERT INTO `sys_menu` VALUES ('5ea59df3f07f11e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '用户修改', '26831a69efb211e7a2360a0027000038', '0', '8', '', '用户修改', '0', '1', 'sys:user:edit', 'sys/user/editPage');
INSERT INTO `sys_menu` VALUES ('70119b90f75911e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', '模块删除', 'cab4c933f6d411e78abf0a002700001d', '0', '15', '', '模块删除', '0', '0', 'sys:module:delete', '');
INSERT INTO `sys_menu` VALUES ('7cfa8d7defb211e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '资源管理', '-1', '1', '4', 'icon-calculator', '资源管理', '1', '0', '', '');
INSERT INTO `sys_menu` VALUES ('90324954030a447ca6c0decd19fa3d43', '6ad537e2327f421eb90964e1148ededb', '测试菜单', '-1', '0', '1', '', '测试菜单，功能测试', '0', '1', '', '');
INSERT INTO `sys_menu` VALUES ('9fd0374b890d43bdb1630fcaeb591243', '63b2cf7eefb111e7a2360a0027000038', '合同管理', '-1', '1', '2', '', '合同管理', '1', '0', '', '');
INSERT INTO `sys_menu` VALUES ('b7ce7896f5f111e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', '菜单新增', 'f287d403efb111e7a2360a0027000038', '0', '10', '', '菜单新增', '0', '1', 'sys:menu:add', 'sys/menu/addPage');
INSERT INTO `sys_menu` VALUES ('be7187ceefb211e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '字典管理', '7cfa8d7defb211e7a2360a0027000038', '0', '5', 'icon-calculator', '字典管理', '1', '1', 'sys:config:query', 'sys/config/getListPage');
INSERT INTO `sys_menu` VALUES ('c1923372efc311e7a2360a0027000038', '63b2cf7eefb111e7a2360a0027000038', '客户管理', '-1', '1', '6', 'icon-clock', '客户管理', '1', '0', '', ' ');
INSERT INTO `sys_menu` VALUES ('cab4c933f6d411e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', '模块管理', '28c3ef4eefb111e7a2360a0027000038', '0', '2', 'icon-clock', '模块管理', '1', '0', 'sys:module:query', 'sys/module/getListPage');
INSERT INTO `sys_menu` VALUES ('e60ef4d2f75811e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', '模块新增', 'cab4c933f6d411e78abf0a002700001d', '0', '13', '', '模块新增', '0', '0', 'sys:module:add', 'sys/module/addPage');
INSERT INTO `sys_menu` VALUES ('f287d403efb111e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '菜单管理', '28c3ef4eefb111e7a2360a0027000038', '0', '3', 'icon-puzzle', '菜单管理', '1', '0', 'sys:menu:query', 'sys/menu/getListPage');

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
  `if_show` varchar(1) COLLATE utf8_bin DEFAULT '1',
  `sort` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_module
-- ----------------------------
INSERT INTO `sys_module` VALUES ('28c3ef4eefb111e7a2360a0027000038', '1', '系统模块', null, '系统模块', 'sys/index', '1', '1');
INSERT INTO `sys_module` VALUES ('63b2cf7eefb111e7a2360a0027000038', '1', 'CRM模块', null, 'CRM模块', 'crm/index', '1', '2');
INSERT INTO `sys_module` VALUES ('6ad537e2327f421eb90964e1148ededb', null, '测试模块，功能测试', null, '测试模块', 'erp/index', '1', '3');

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
-- Records of sys_notice
-- ----------------------------

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
-- Records of sys_operate
-- ----------------------------

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
-- Records of sys_org
-- ----------------------------

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
  `parent_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('28c3ef4eefb111e7a2360a0027000038', '1', 'admin', '管理员', null, '-1');

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
-- Records of sys_role_auth
-- ----------------------------
INSERT INTO `sys_role_auth` VALUES ('06fd8633f5f211e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', '06fd8633f5f211e78abf0a002700001d');
INSERT INTO `sys_role_auth` VALUES ('32c15082f5f211e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', '32c15082f5f211e78abf0a002700001d');
INSERT INTO `sys_role_auth` VALUES ('514ab49ef75911e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', '514ab49ef75911e78abf0a002700001d');
INSERT INTO `sys_role_auth` VALUES ('5ea59df3f07f11e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '5ea59df3f07f11e7a2360a0027000038');
INSERT INTO `sys_role_auth` VALUES ('70119b90f75911e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', '70119b90f75911e78abf0a002700001d');
INSERT INTO `sys_role_auth` VALUES ('ac145b7defb311e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '26831a69efb211e7a2360a0027000038');
INSERT INTO `sys_role_auth` VALUES ('ac16085eefb311e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038');
INSERT INTO `sys_role_auth` VALUES ('ac160952efb311e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', '7cfa8d7defb211e7a2360a0027000038');
INSERT INTO `sys_role_auth` VALUES ('ac1609f5efb311e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', 'be7187ceefb211e7a2360a0027000038');
INSERT INTO `sys_role_auth` VALUES ('ac160a2aefb311e7a2360a0027000038', '28c3ef4eefb111e7a2360a0027000038', 'f287d403efb111e7a2360a0027000038');
INSERT INTO `sys_role_auth` VALUES ('b7ce7896f5f111e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', 'b7ce7896f5f111e78abf0a002700001d');
INSERT INTO `sys_role_auth` VALUES ('cab4c933f6d411e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', 'cab4c933f6d411e78abf0a002700001d');
INSERT INTO `sys_role_auth` VALUES ('e60ef4d2f75811e78abf0a002700001d', '28c3ef4eefb111e7a2360a0027000038', 'e60ef4d2f75811e78abf0a002700001d');

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
-- Records of sys_role_operator
-- ----------------------------

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
-- Records of sys_schedule
-- ----------------------------

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
  `deptid` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '岗位ID',
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `idcard` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号',
  `is_admin` varchar(1) COLLATE utf8_bin DEFAULT '0' COMMENT '是否是管理员',
  `sort` bigint(99) DEFAULT NULL,
  `mobile` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usernameindex` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('0', 'lll', null, '小慕', '1', '1', null, null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('2', 'lxh', null, '小K', '1', '1', null, null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('3', 'lkj', null, '大河', '0', '1', null, null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('33', 'fjk', null, '二娃', '1', '1', null, null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('4', 'ghj', null, '小小年纪', '1', '1', null, null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('5', 'gnim', null, '小谢谢', '1', '1', null, null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('6', 'cqy', null, '销毁', '1', '1', null, null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('7', 'ccc', null, '等等', '1', '1', null, null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('9', 'dfg', null, '定点', '1', '1', null, null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('99', 'ff', null, '带刀的', '1', '1', null, null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('995', 'fl', null, '你妹', '1', '1', null, null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('999', 'admin', 'fa87f7f90e58ee02504d60e3e431e039', 'nbfujx', '1', '1', null, null, 'nbfujx@qq.com', '222222222222222222', '1', null, '12455555555');

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
-- Records of sys_user_auth
-- ----------------------------
INSERT INTO `sys_user_auth` VALUES ('0c70c9c7efb411e7a2360a0027000038', '999', '7cfa8d7defb211e7a2360a0027000038');
INSERT INTO `sys_user_auth` VALUES ('29294f18efb411e7a2360a0027000038', '999', 'be7187ceefb211e7a2360a0027000038');
INSERT INTO `sys_user_auth` VALUES ('33f6df58f07e11e7a2360a0027000038', '999', '35f6df58f07e11e7a2360a0027000038');
INSERT INTO `sys_user_auth` VALUES ('357ff499f07c11e7a2360a0027000030', '999', '357ff499f07c11e7a2360a0027000030');
INSERT INTO `sys_user_auth` VALUES ('fd88a31cefc311e7a2360a0027000038', '999', 'c1923372efc311e7a2360a0027000038');
INSERT INTO `sys_user_auth` VALUES ('fd89a31cefc311e7a2360a0027000038', '999', '357ff499f07c11e7a2360a0027000038');

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
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('28c3ef4eefb111e7a2360a0027000038', '999', null, null, null, null, null, null, null, null, null, null, null, '28c3ef4eefb111e7a2360a0027000038', '', null, null, null, null, null, null, null);

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
-- Records of sys_user_notice
-- ----------------------------

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

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('f3f9cdc7efb311e7a2360a0027000038', '999', '28c3ef4eefb111e7a2360a0027000038');
