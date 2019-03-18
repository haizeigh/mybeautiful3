CREATE TABLE socical_user (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
`username` varchar(32) BINARY CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
`password` varchar(100) NOT NULL COMMENT '密码',
`salt` varchar(50) NOT NULL COMMENT '加密盐',
`create_time` datetime  COMMENT '创建时间',
`locked` int(2) NOT NULL DEFAULT '0' COMMENT '是否锁定 0:未锁定 1：锁定',
PRIMARY key (`id`),
UNIQUE key `unique_username` (`username`)
)ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

DROP TABLE social_dynamic

CREATE TABLE social_dynamic (
id int NOT NULL AUTO_INCREMENT COMMENT '标识Id',
username varchar(32) NOT NULL COMMENT '发表人',
content varchar(200) NOT NULL COMMENT '动态内容',
picture varchar(100)  COMMENT '动态图片地址',
multi_media varchar(100)  COMMENT '音视频等地址',
time datetime NOT NULL COMMENT '发表时间',
commented varchar(200) DEFAULT NULL COMMENT '评论内容',
  PRIMARY KEY (id)
)ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

ALTER TABLE social_dynamic MODIFY COLUMN username  varchar(32) BINARY

INSERT INTO `social_dynamic` VALUES ('23', 'zxl', '喜欢身边有朋友的感觉，那样不会是自己一个人',NULL,NULL, '2013-07-10 00:20:13', null);
INSERT INTO `social_dynamic` VALUES ('21', 'chenwenping', '今天很开心~O(∩_∩)O~',NULL,NULL,  '2013-07-09 22:31:54', null);
INSERT INTO `social_dynamic` VALUES ('22', 'zxl', '被感动~', NULL,NULL, '2013-07-10 00:19:36', null);
INSERT INTO `social_dynamic` VALUES ('24', 'lqh', '下雨了，心情很好~', NULL,NULL, '2013-07-10 00:23:04', null);
INSERT INTO `social_dynamic` VALUES ('25', 'lqh', '北京很久没有这样的天，安静祥和，让人觉得幸福',NULL,NULL,  '2013-07-10 00:23:23', null);

CREATE TABLE social_friendship(
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识id',
  `username` varchar(32) BINARY NOT NULL COMMENT '用户名',
  `friend` varchar(32) BINARY NOT NULL COMMENT '好友用户名',
  `state` int(11) NOT NULL COMMENT '是否同意申请,1:同意;0:未同意;2：拒绝',
  `time` datetime NOT NULL COMMENT '申请好友的时间',
  PRIMARY KEY (`id`)
)ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO `social_friendship` VALUES ('1', 'zxl', 'lqh', '1', '2013-07-01 20:48:29');
INSERT INTO `social_friendship` VALUES ('2', 'lqh', 'zxl', '1', '2013-07-02 20:48:35');
INSERT INTO `social_friendship` VALUES ('3', 'zxl', 'tyq', '1', '2013-07-03 20:48:40');
INSERT INTO `social_friendship` VALUES ('4', 'tyq', 'zxl', '1', '2013-07-04 20:48:45');
INSERT INTO `social_friendship` VALUES ('7', 'chenwenping', 'tyq', '1', '2013-07-05 20:48:50');
INSERT INTO `social_friendship` VALUES ('8', 'tyq', 'chenwenping', '1', '2013-07-06 20:48:56');
INSERT INTO `social_friendship` VALUES ('62', 'zxl', 'chenwenping', '0', '2013-07-19 16:24:59');
INSERT INTO `social_friendship` VALUES ('58', 'chenwenping', 'lqh', '1', '2013-07-10 21:27:14');
INSERT INTO `social_friendship` VALUES ('57', 'lqh', 'chenwenping', '1', '2013-07-10 21:27:14');



