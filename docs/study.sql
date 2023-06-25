-- ----------------------------
-- Table structure for table `ums_admin`
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;

CREATE TABLE `ums_admin` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
   `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
   `icon` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '头像',
   `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '邮箱',
   `nick_name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '昵称',
   `note` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '备注信息',
   `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
   `login_time` datetime(3) DEFAULT NULL COMMENT '最后登录时间',
   `status` int DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='后台用户表';

-- ----------------------------
-- Data for the table `ums_admin`
-- ----------------------------
INSERT INTO `ums_admin`(`id`,`username`,`password`,`icon`,`email`,`nick_name`,`note`,`create_time`,`login_time`,`status`) VALUES
(14,'admin123','IeNDSCiF8ZeOdI7BlYZ1Oajx2X201qg91PBC8qAXBx4=','aassss','aa@.com','ssss','aa','2023-05-25 17:57:25.397',NULL,1);
