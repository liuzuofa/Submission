/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : submission

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

<<<<<<< HEAD
Date: 2018-03-08 09:41:29
=======
Date: 2018-03-07 22:38:37
>>>>>>> 54b9fd655b41e65ccf234d0d3f5482ed8bd6024d
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for magazine
-- ----------------------------
DROP TABLE IF EXISTS `magazine`;
CREATE TABLE `magazine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `summary` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL DEFAULT '待审',
  `address` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `submission_time` varchar(255) NOT NULL,
  `review_time` varchar(255) DEFAULT NULL,
  `reject_time` varchar(255) DEFAULT NULL,
  `publish_time` varchar(255) DEFAULT NULL,
  `editor` varchar(255) DEFAULT NULL,
  `expert` varchar(255) DEFAULT NULL,
  `editor_advise` varchar(255) DEFAULT NULL,
  `expert_advise` varchar(255) DEFAULT NULL,
  `periodical_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of magazine
-- ----------------------------
INSERT INTO `magazine` VALUES ('22', '基于javaweb的在线投稿系统', '使用javaweb技术实现在线投稿审稿', '张三', '已发表', '/submission/pdf/基于javaweb的在线投稿系统.pdf', '计算机技术', '2017-12-30 13:53:07', '2018-03-01 21:46:49', null, '2018-03-07 22:08:26', '李四', '本', '同意送审', null, '1');
INSERT INTO `magazine` VALUES ('23', '基于PHP的在线投稿系统', '使用PHP技术实现在线投稿审稿', '张三', '编辑待审', '/submission/pdf/基于javaweb的在线投稿系统.pdf', '计算机技术', '2017-12-30 14:10:44', '2018-03-07 20:19:59', null, null, '李四', '王老五', '同意', '拒绝', '0');
INSERT INTO `magazine` VALUES ('24', '基于.NET的在线投稿系统', '使用.NET技术实现在线投稿审稿', '张三', '作者修改', '/submission/pdf/张三/基于Android平台课堂点名系统的设计与实现.pdf', '计算机技术', '2017-12-30 14:12:17', '2018-03-07 19:39:55', null, null, '李四', '王老五', '同意送审', '修改', '0');
INSERT INTO `magazine` VALUES ('25', 'javaweb', 'javaweb', '张三', '已录用', '/submission/pdf/基于javaweb的在线投稿系统.pdf', '计算机技术', '2017-12-30 20:46:07', '2018-03-07 21:49:39', '2018-03-01 21:46:49', null, '李四', '王老五', '同意送审', '同意', '2');
<<<<<<< HEAD
INSERT INTO `magazine` VALUES ('27', 'web开发', 'web开发技术', '张三', '编辑待审', '/submission/pdf/张三/OpenCV入门教程.pdf', '计算机技术', '2018-03-08 09:20:44', null, null, null, null, null, null, null, '0');
=======
>>>>>>> 54b9fd655b41e65ccf234d0d3f5482ed8bd6024d

-- ----------------------------
-- Table structure for operate
-- ----------------------------
DROP TABLE IF EXISTS `operate`;
CREATE TABLE `operate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NOT NULL,
  `operator` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `executor` varchar(255) DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `advise` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operate
-- ----------------------------
INSERT INTO `operate` VALUES ('40', '22', '张三', '2017-12-30 13:53:08', '编辑', '投稿', '');
INSERT INTO `operate` VALUES ('41', '23', '张三', '2017-12-30 14:10:44', '编辑', '投稿', '');
INSERT INTO `operate` VALUES ('42', '24', '张三', '2017-12-30 14:12:18', '编辑', '投稿', '');
INSERT INTO `operate` VALUES ('43', '22', '李四', '2017-12-30 14:12:58', '王老五', '分配稿件', '');
INSERT INTO `operate` VALUES ('44', '23', '李四', '2017-12-30 15:02:55', '本', '分配稿件', '');
INSERT INTO `operate` VALUES ('45', '22', '王老五', '2017-12-30 15:03:45', '李四', '专家拒审', '');
INSERT INTO `operate` VALUES ('46', '25', '张三', '2017-12-30 20:46:08', '编辑', '投稿', '');
INSERT INTO `operate` VALUES ('47', '22', '李四', '2017-12-30 21:34:30', '本', '分配稿件', '');

-- ----------------------------
-- Table structure for periodical
-- ----------------------------
DROP TABLE IF EXISTS `periodical`;
CREATE TABLE `periodical` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of periodical
-- ----------------------------
INSERT INTO `periodical` VALUES ('1', '2018', '1', '已发表');
INSERT INTO `periodical` VALUES ('2', '2018', '2', '未发表');
INSERT INTO `periodical` VALUES ('3', '2018', '3', '未发表');
INSERT INTO `periodical` VALUES ('4', '2018', '4', '未发表');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '我要投稿', 'authorsubmission.jsp');
INSERT INTO `permission` VALUES ('2', '我的稿件', 'AuthorServlet?method=all');
INSERT INTO `permission` VALUES ('3', '修改稿件', 'AuthorServlet?method=modify');
INSERT INTO `permission` VALUES ('4', '退回稿件', 'AuthorServlet?method=back');
INSERT INTO `permission` VALUES ('5', '编辑待审', 'EditorServlet?method=waitcheck');
INSERT INTO `permission` VALUES ('6', '编辑已审', 'EditorServlet?method=checked');
INSERT INTO `permission` VALUES ('7', '编辑录用', 'EditorServlet?method=employ');
INSERT INTO `permission` VALUES ('8', '专家待审', 'ExpertServlet?method=waitcheck');
INSERT INTO `permission` VALUES ('9', '专家已审', 'ExpertServlet?method=checked');
INSERT INTO `permission` VALUES ('10', '录用稿件', 'MajorEditorServlet?method=employ');
INSERT INTO `permission` VALUES ('11', '新建期刊', 'majoreditornewperiodical.jsp');
INSERT INTO `permission` VALUES ('12', '期刊管理', 'MajorEditorServlet?method=periodicalManager');
INSERT INTO `permission` VALUES ('13', '个人中心', 'personal.jsp');
<<<<<<< HEAD
INSERT INTO `permission` VALUES ('14', '用户管理', 'UserServlet?method=getAllUsers');
INSERT INTO `permission` VALUES ('15', '授权管理', 'UserServlet?method=getGrantUsers');
=======
INSERT INTO `permission` VALUES ('14', '用户中心', 'user.jsp');
>>>>>>> 54b9fd655b41e65ccf234d0d3f5482ed8bd6024d

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '作者');
INSERT INTO `role` VALUES ('2', '编辑');
INSERT INTO `role` VALUES ('3', '专家');
INSERT INTO `role` VALUES ('4', '主编');
INSERT INTO `role` VALUES ('5', '管理员');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '1', '2');
INSERT INTO `role_permission` VALUES ('3', '1', '3');
INSERT INTO `role_permission` VALUES ('4', '1', '4');
INSERT INTO `role_permission` VALUES ('5', '1', '13');
INSERT INTO `role_permission` VALUES ('6', '2', '5');
INSERT INTO `role_permission` VALUES ('8', '2', '6');
INSERT INTO `role_permission` VALUES ('9', '2', '7');
INSERT INTO `role_permission` VALUES ('10', '2', '13');
INSERT INTO `role_permission` VALUES ('12', '3', '8');
INSERT INTO `role_permission` VALUES ('13', '3', '9');
INSERT INTO `role_permission` VALUES ('15', '3', '13');
INSERT INTO `role_permission` VALUES ('16', '4', '10');
INSERT INTO `role_permission` VALUES ('17', '4', '11');
INSERT INTO `role_permission` VALUES ('18', '4', '12');
INSERT INTO `role_permission` VALUES ('19', '4', '13');
<<<<<<< HEAD
INSERT INTO `role_permission` VALUES ('20', '5', '14');
=======
>>>>>>> 54b9fd655b41e65ccf234d0d3f5482ed8bd6024d

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `education` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'summer', '1234', '读者', '张三', '本科', '123', '广州', '1');
INSERT INTO `user` VALUES ('2', 'tom', '123', '编辑', '李四', '研究生', '123', '深圳', '1');
INSERT INTO `user` VALUES ('3', 'jack', '123', '专家', '王老五', '博士', '123', '上海', '1');
INSERT INTO `user` VALUES ('4', 'ben', '123', '主编', '本', '研究生', '123', '北京', '1');
<<<<<<< HEAD
INSERT INTO `user` VALUES ('5', 'tomcat', '123', '管理员', '汤姆', '本科', '123', '广州', '1');
=======
INSERT INTO `user` VALUES ('5', 'cat', '123', '读者', '小红', '本科', '123', '南昌', '1');
INSERT INTO `user` VALUES ('7', 'tomcat', '123', '读者', '汤姆', '本科', '123', '广州', '1');
>>>>>>> 54b9fd655b41e65ccf234d0d3f5482ed8bd6024d

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
INSERT INTO `user_role` VALUES ('3', '3', '3');
INSERT INTO `user_role` VALUES ('4', '4', '4');
INSERT INTO `user_role` VALUES ('5', '5', '5');
