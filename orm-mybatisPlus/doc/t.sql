DROP DATABASE IF EXISTS hello;
CREATE DATABASE hello DEFAULT CHARACTER SET utf8;
USE hello;

DROP TABLE IF EXISTS `t_user`;
DROP TABLE IF EXISTS `t_blog`;
SET NAMES utf8mb4;

CREATE TABLE `t_user`
(
    `id`           BIGINT(0) NOT NULL AUTO_INCREMENT,
    `user_name`    VARCHAR(64) NOT NULL COMMENT '用户名（不能重复）',
    `nick_name`    VARCHAR(64) NOT NULL COMMENT '昵称（可以重复）',
    `email`        VARCHAR(64) COMMENT '邮箱',
    `create_time`  DATETIME(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  DATETIME(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `deleted_flag` BIGINT(0) NOT NULL DEFAULT 0 COMMENT '0：未删除 其他：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `index_user_name_deleted_flag`(`user_name`, `deleted_flag`),
    KEY `index_create_time`(`create_time`)
) ENGINE = InnoDB COMMENT = '用户';

CREATE TABLE `t_blog`
(
    `id`           BIGINT(0) NOT NULL AUTO_INCREMENT,
    `user_id`      BIGINT(0) NOT NULL,
    `user_name`    VARCHAR(64) NOT NULL,
    `title`        VARCHAR(256) CHARACTER SET utf8mb4 NOT NULL COMMENT '标题',
    `description`  VARCHAR(256) CHARACTER SET utf8mb4 NOT NULL COMMENT '摘要',
    `content`      LONGTEXT CHARACTER SET utf8mb4 NOT NULL COMMENT '内容',
    `create_time`  DATETIME(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  DATETIME(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `deleted_flag` BIGINT(0) NOT NULL DEFAULT 0 COMMENT '0：未删除 其他：已删除',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `index_user_id`(`user_id`),
    KEY `index_create_time`(`create_time`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '博客';

INSERT INTO `t_user` VALUES (1, 'knife', '刀刃', 'abc@qq.com', '2021-01-23 09:33:36', '2021-01-23 09:33:36', 0);
INSERT INTO `t_user` VALUES (2, 'sky', '天蓝', '123@qq.com', '2021-01-24 18:12:21', '2021-01-24 18:12:21', 0);

INSERT INTO `t_blog` VALUES (1, 1, 'knife', 'Java中枚举的用法',
                             '本文介绍Java的枚举类的使用',
                             '本文介绍Java的枚举类的使用',
                             '2021-01-23 11:33:36', '2021-01-23 11:33:36', 0);
INSERT INTO `t_blog` VALUES (2, 1, 'knife', 'Java中泛型的用法',
                             '本文介绍Java的泛型的使用。',
                             '本文介绍Java的泛型的使用。',
                             '2021-01-28 23:37:37', '2021-01-28 23:37:37', 0);
INSERT INTO `t_blog` VALUES (3, 1, 'knife', 'Java的HashMap的原理',
                             '本文介绍Java的HashMap的原理。',
                             '本文介绍Java的HashMap的原理。',
                             '2021-05-28 09:06:06', '2021-05-28 09:06:06', 0);
INSERT INTO `t_blog` VALUES (4, 1, 'knife', 'Java中BigDecimal的用法',
                             '本文介绍Java的BigDecimal的使用。',
                             '本文介绍Java的BigDecimal的使用。',
                             '2021-06-24 20:36:54', '2021-06-24 20:36:54', 0);
INSERT INTO `t_blog` VALUES (5, 1, 'knife', 'Java中反射的用法',
                             '本文介绍Java的反射的使用。',
                             '本文介绍Java的反射的使用。',
                             '2021-10-28 22:24:18', '2021-10-28 22:24:18', 0);


INSERT INTO `t_blog` VALUES (6, 2, 'sky', 'Vue-cli的使用',
                             'Vue-cli是Vue的一个脚手架工具',
                             'Vue-cli可以用来创建vue项目',
                             '2021-02-23 11:34:36', '2021-02-25 14:33:36', 0);
INSERT INTO `t_blog` VALUES (7, 2, 'sky', 'Vuex的用法',
                             'Vuex是vue用于共享变量的插件',
                             '一般使用vuex来共享变量',
                             '2021-03-28 23:37:37', '2021-03-28 23:37:37', 0);