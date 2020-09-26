/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : pig-farm

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 26/09/2020 23:49:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_disease
-- ----------------------------
DROP TABLE IF EXISTS `t_disease`;
CREATE TABLE `t_disease`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '疾病名称',
  `symptoms` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '症状表现',
  `measure` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '治疗处方',
  `cause` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '防疫措施',
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参考图片',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_disease
-- ----------------------------
INSERT INTO `t_disease` VALUES (1, '链球菌', '食欲废绝', '大剂量青霉素和链霉素混合肌肉注射，连用3-5日', '注意环境卫生', NULL, '2020-09-26 16:01:47');
INSERT INTO `t_disease` VALUES (2, '蓝耳', '耳朵发蓝', '蓝耳疫苗', '没有做好蓝耳疫苗', NULL, '2020-09-26 16:43:50');

SET FOREIGN_KEY_CHECKS = 1;
