/*
Navicat MySQL Data Transfer

Source Server         : remote
Source Server Version : 50022
Source Host           : 101.201.70.216:3306
Source Database       : chen

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-01-06 09:36:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `film`
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  `number` int(11) default NULL,
  `url` varchar(30) default NULL,
  `desc` varchar(300) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES ('1', 'End Game', '296', 'images/end-game.jpg', '《End Game》是由小古巴·戈丁、詹姆斯·伍兹主演的一部美国动作电影。');
INSERT INTO `film` VALUES ('2', 'Sorority Wars', '0', 'images/Sorority_Wars.jpg', '讲述的是 Katie和Sara从孩提时起便是好朋友，她们一起进入大学。这所大学里的Delta女生联谊会是由Katie的母亲在数十年前创立的，Katie也成为了该联谊会的重要候选成员之一。然而，宣誓周那');
INSERT INTO `film` VALUES ('3', 'Twilight New Moon', '0', 'images/New-Moon.jpg', null);
INSERT INTO `film` VALUES ('4', 'Avatar', '0', 'images/avatar_movie.jpg', null);
INSERT INTO `film` VALUES ('5', 'Black Swan', '0', 'images/black-swan.jpg', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(10) default NULL,
  `password` varchar(15) default NULL,
  `mail` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'chen', '1994', '1047810633@qq.com');
INSERT INTO `user` VALUES ('2', '123', '123', '1047810633@qq.com');
INSERT INTO `user` VALUES ('3', '33', '33', '123@qq.com');
INSERT INTO `user` VALUES ('4', 'ABC', '123', '1312122005@qq.com');

-- ----------------------------
-- Table structure for `user2ticket`
-- ----------------------------
DROP TABLE IF EXISTS `user2ticket`;
CREATE TABLE `user2ticket` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `ticket_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user2ticket
-- ----------------------------
