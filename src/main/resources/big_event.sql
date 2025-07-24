/*
 Navicat Premium Dump SQL

 Source Server         : 192.168.2.84-mysql
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : 192.168.2.84:3306
 Source Schema         : big_event

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 24/07/2025 17:12:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章标题',
  `content` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章内容',
  `cover_img` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章封面',
  `state` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '草稿' COMMENT '文章状态: 只能是[已发布] 或者 [草稿]',
  `category_id` int UNSIGNED NULL DEFAULT NULL COMMENT '文章分类ID',
  `create_user` int UNSIGNED NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `del_flag` int NOT NULL DEFAULT -1 COMMENT '删除标识，默认1未删除0-已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_article_category`(`category_id` ASC) USING BTREE,
  INDEX `fk_article_user`(`create_user` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '如何才能克服', '心中无鑫', 'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '已发布', 9, 3, '2025-07-07 10:38:56', '2025-07-15 08:56:58', -1);
INSERT INTO `article` VALUES (2, '长沙旅游攻略', '天安门...爱去哪去哪...', 'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '草稿', 2, 3, '2025-07-07 10:44:19', '2025-07-15 08:57:06', 2);
INSERT INTO `article` VALUES (3, '长沙旅游攻略', '天安门...爱去哪去哪...', 'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '草稿', 2, 3, '2025-07-07 10:47:53', '2025-07-07 14:14:49', 3);
INSERT INTO `article` VALUES (4, 'springIOC还可以这么用', 'IOC通过控制bean之间的依赖关系，方便对bean进行管理', 'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '草稿', 2, 3, '2025-07-07 11:29:44', '2025-07-07 11:29:44', -1);
INSERT INTO `article` VALUES (5, 'spring设计模式详解', 'spring框架中使用了大量的设计模式,其中最常见的就是单例模式', 'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '草稿', 2, 3, '2025-07-07 11:31:00', '2025-07-07 11:31:00', -1);
INSERT INTO `article` VALUES (6, 'mysql中的索引使用', 'mysql中使用索引可以极大的提高查询效率', 'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '草稿', 2, 3, '2025-07-07 11:32:03', '2025-07-07 11:32:03', -1);
INSERT INTO `article` VALUES (7, '1315', '2699', 'https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png', '草稿', 2, 3, '2025-07-10 17:14:52', '2025-07-15 08:56:41', 7);
INSERT INTO `article` VALUES (8, '关于postgresql索引的使用', '<p>在项目的实际使用过程中有时候需要</p>', 'https://yang199-big-event.oss-cn-beijing.aliyuncs.com/08010313-f72f-41ae-af61-96e027385191.jpg', '已发布', 17, 3, '2025-07-11 15:36:24', '2025-07-11 15:36:24', -1);
INSERT INTO `article` VALUES (9, '长沙旅游攻略', '<p>天安门...爱去哪去哪...我从来没去过，我一定要去</p>', 'https://yang199-big-event.oss-cn-beijing.aliyuncs.com/38db366c-8edd-4122-ae9d-0759cb2cfff7.jpg', '已发布', 2, 3, '2025-07-14 16:02:54', '2025-07-14 16:02:54', -1);
INSERT INTO `article` VALUES (10, '1315我修改了你', '<p>2699122212121512</p>', 'https://yang199-big-event.oss-cn-beijing.aliyuncs.com/36b1441e-49f1-4f0e-af2f-15315aee671d.jpg', '已发布', 2, 3, '2025-07-14 16:04:00', '2025-07-14 16:04:00', -1);
INSERT INTO `article` VALUES (11, '人生应该如何规划', '<p>2699122212121512</p>', 'https://yang199-big-event.oss-cn-beijing.aliyuncs.com/36b1441e-49f1-4f0e-af2f-15315aee671d.jpg', '已发布', 2, 3, '2025-07-14 16:04:57', '2025-07-15 08:50:39', -1);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名称',
  `category_alias` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类别名',
  `create_user` int UNSIGNED NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `del_flag` int NOT NULL DEFAULT -1 COMMENT '删除标识，默认1未删除0-已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_category_user`(`create_user` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (2, '军事', 'js', 3, '2025-06-30 11:39:03', '2025-07-16 14:30:36', -1);
INSERT INTO `category` VALUES (9, '新闻', 'xw', 3, '2025-07-04 10:59:21', '2025-07-11 09:13:10', -1);
INSERT INTO `category` VALUES (16, '财经', 'cj', 3, '2025-07-10 17:57:12', '2025-07-11 09:13:36', -1);
INSERT INTO `category` VALUES (17, '生活', 'shenghuo', 3, '2025-07-11 09:12:38', '2025-07-11 09:12:38', -1);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `perm_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限code',
  `perm_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `del_flag` bigint NOT NULL DEFAULT -1 COMMENT '删除标识，默认1未删除，删除后设置为主键的值',
  `url_pattern` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求路径如 \'/api/users/​**​\'',
  `http_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '请求方式GET,POST...',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, 'user:userInfo', '获取用户详细信息', '2025-07-17 17:47:07', '2025-07-17 17:47:07', -1, '/user/userInfo', 'GET');
INSERT INTO `sys_permission` VALUES (2, 'article:getPageData', '文章分页列表', '2025-07-18 08:57:16', '2025-07-18 08:57:16', -1, '/article/getPageData', 'POST');
INSERT INTO `sys_permission` VALUES (3, 'article:delete', '删除文章', '2025-07-18 08:58:47', '2025-07-18 08:58:47', -1, '/article', 'DELETE');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色code',
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `del_flag` int NOT NULL DEFAULT -1 COMMENT '删除标识，默认-1未删除，删除后将该字段的值设置为主键值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'visitor', '访客', '2025-07-17 17:24:56', '2025-07-17 17:24:56', -1);
INSERT INTO `sys_role` VALUES (2, 'developer', '开发者', '2025-07-17 17:26:24', '2025-07-17 17:26:24', -1);
INSERT INTO `sys_role` VALUES (3, 'ADMIN', '管理员', '2025-07-17 17:27:17', '2025-07-17 17:27:17', -1);

-- ----------------------------
-- Table structure for sys_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_perm`;
CREATE TABLE `sys_role_perm`  (
  `role_id` bigint NOT NULL COMMENT '角色id',
  `perm_id` bigint NOT NULL COMMENT '权限id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `del_flag` int NOT NULL DEFAULT -1 COMMENT '删除标识，默认1未删除，已删除设置为主键的值',
  PRIMARY KEY (`perm_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_perm
-- ----------------------------
INSERT INTO `sys_role_perm` VALUES (3, 1, '2025-07-18 09:17:11', '2025-07-18 09:17:11', -1);
INSERT INTO `sys_role_perm` VALUES (3, 2, '2025-07-18 09:17:11', '2025-07-18 09:17:11', -1);
INSERT INTO `sys_role_perm` VALUES (3, 3, '2025-07-18 09:17:11', '2025-07-18 09:17:11', -1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint NOT NULL COMMENT '用户id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `del_flag` int NOT NULL DEFAULT -1 COMMENT '删除标识，默认-1未删除，已删除设置为主键的值',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (6, 1, '2025-07-18 09:33:58', '2025-07-18 09:33:58', -1);
INSERT INTO `sys_user_role` VALUES (6, 2, '2025-07-18 09:33:58', '2025-07-18 09:33:58', -1);
INSERT INTO `sys_user_role` VALUES (6, 3, '2025-07-18 09:33:58', '2025-07-18 09:33:58', -1);
INSERT INTO `sys_user_role` VALUES (9, 1, '2025-07-23 17:43:27', '2025-07-23 17:43:27', -1);
INSERT INTO `sys_user_role` VALUES (9, 2, '2025-07-23 17:43:27', '2025-07-23 17:43:27', -1);
INSERT INTO `sys_user_role` VALUES (9, 3, '2025-07-23 17:43:27', '2025-07-23 17:43:27', -1);
INSERT INTO `sys_user_role` VALUES (10, 1, '2025-07-23 18:17:55', '2025-07-23 18:17:55', -1);
INSERT INTO `sys_user_role` VALUES (10, 2, '2025-07-23 18:17:56', '2025-07-23 18:17:56', -1);
INSERT INTO `sys_user_role` VALUES (10, 3, '2025-07-23 18:17:56', '2025-07-23 18:17:56', -1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '昵称',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '邮箱',
  `user_pic` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '头像',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `del_flag` int NOT NULL DEFAULT -1 COMMENT '删除标识，默认1未删除0-已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC, `del_flag` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (9, 'liubei', '$2a$10$QVfbJPoGyb/o36vZTITQ8eSJosX18wPUGUDL2T0h5maJRuZlaoV0q', '', '', '', '2025-07-23 11:36:42', '2025-07-23 11:36:42', -1);
INSERT INTO `user` VALUES (10, 'guanyu', '$2a$10$dZdXV5sCg5GJOW7auT5yY.mBvCMVF2KRM57BZ38uEBYGvQjpu3ali', '关云长', 'guanyu@163.com', 'https://yang199-big-event.oss-cn-beijing.aliyuncs.com/b26ad4fe-b712-487e-a6bc-81cb8285f671.jpg', '2025-07-23 15:12:43', '2025-07-24 14:45:31', -1);

SET FOREIGN_KEY_CHECKS = 1;
