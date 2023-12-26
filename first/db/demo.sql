/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 26/12/2023 16:33:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '职工ID',
  `emp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '职员姓名',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别 可选范围[男，女]',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '年龄',
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称 可选范围[业务部，后勤部，人事部]',
  `emp_degree_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学历 可选范围[大专，本科，研究生]',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 74 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '张一', '男', '25', '业务部', '本科');
INSERT INTO `employee` VALUES (2, '张二', '女', '26', '人事部', '本科');
INSERT INTO `employee` VALUES (3, '张三', '男', '27', '后勤部', '大专');
INSERT INTO `employee` VALUES (4, '张四', '女', '28', '人事部', '大专');
INSERT INTO `employee` VALUES (5, '张五', '男', '29', '后勤部', '大专');
INSERT INTO `employee` VALUES (6, '张六', '女', '29', '后勤部', '本科');
INSERT INTO `employee` VALUES (7, '张七', '男', '33', '业务部', '研究生');
INSERT INTO `employee` VALUES (8, '张八', '男', '32', '业务部', '本科');
INSERT INTO `employee` VALUES (9, '张九', '女', '33', '业务部', '大专');
INSERT INTO `employee` VALUES (10, '李一', '女', '45', '业务部', '研究生');
INSERT INTO `employee` VALUES (11, '李二', '女', '19', '人事部', '本科');
INSERT INTO `employee` VALUES (12, '李三', '男', '28', '业务部', '研究生');
INSERT INTO `employee` VALUES (13, '李四', '女', '46', '后勤部', '研究生');
INSERT INTO `employee` VALUES (14, '李五', '男', '58', '业务部', '大专');
INSERT INTO `employee` VALUES (15, '李六', '女', '22', '人事部', '研究生');
INSERT INTO `employee` VALUES (16, '李七', '男', '26', '后勤部', '大专');
INSERT INTO `employee` VALUES (17, '李八', '男', '25', '人事部', '研究生');
INSERT INTO `employee` VALUES (18, '李九', '女', '29', '后勤部', '研究生');
INSERT INTO `employee` VALUES (19, '王一', '男', '45', '后勤部', '本科');
INSERT INTO `employee` VALUES (20, '王二', '女', '21', '业务部', '本科');
INSERT INTO `employee` VALUES (21, '王三', '男', '21', '业务部', '大专');
INSERT INTO `employee` VALUES (22, '王四', '男', '23', '业务部', '大专');
INSERT INTO `employee` VALUES (23, '王五', '女', '33', '业务部', '大专');
INSERT INTO `employee` VALUES (24, '王六', '男', '45', '人事部', '本科');
INSERT INTO `employee` VALUES (25, '王七', '男', '35', '业务部', '研究生');
INSERT INTO `employee` VALUES (26, '王八', '男', '41', '后勤部', '本科');
INSERT INTO `employee` VALUES (27, '王九', '女', '25', '业务部', '大专');
INSERT INTO `employee` VALUES (28, '赵一', '男', '26', '人事部', '研究生');
INSERT INTO `employee` VALUES (29, '赵二', '男', '10', '后勤部', '本科');
INSERT INTO `employee` VALUES (30, '赵三', '女', '21', '人事部', '研究生');
INSERT INTO `employee` VALUES (31, '赵四', '男', '19', '后勤部', '研究生');
INSERT INTO `employee` VALUES (32, '赵五', '女', '35', '后勤部', '大专');
INSERT INTO `employee` VALUES (33, '赵六', '男', '24', '业务部', '研究生');
INSERT INTO `employee` VALUES (34, '赵七', '男', '29', '业务部', '大专');
INSERT INTO `employee` VALUES (35, '赵八', '女', '33', '业务部', '研究生');
INSERT INTO `employee` VALUES (36, '赵九', '男', '10', '业务部', '本科');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `routes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', 'admin', 'Super Administrator. Have access to view all pages.', '[{\\\"path\\\":\\\"/redirect\\');
INSERT INTO `sys_role` VALUES (2, 'editor', 'editor', 'Normal Editor. Can see all pages except permission page', '[{\\\"path\\\":\\\"/redirect\\');
INSERT INTO `sys_role` VALUES (3, 'visitor', 'visitor', 'Just a visitor. Can only see the home page and the document page', '[{\\\"path\\\":\\\"\\');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `roles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '[\\\"admin\\\"]', 'I am a super administrator', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'admin', '123456');

SET FOREIGN_KEY_CHECKS = 1;
