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

 Date: 29/09/2020 22:40:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_feeding
-- ----------------------------
DROP TABLE IF EXISTS `t_feeding`;
CREATE TABLE `t_feeding`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '饲养程序',
  `stage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '阶段',
  `job` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作内容',
  `spacing` int(11) NULL DEFAULT NULL COMMENT '距前一个阶段间隔天数',
  `step` int(11) NULL DEFAULT NULL COMMENT '步骤',
  `remark` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_feeding
-- ----------------------------
INSERT INTO `t_feeding` VALUES (1000, '仔猪护理', '出生前准备', '1，提前打开保温灯或保温灯，使保温箱温度稳定在35°C\n2，准备剪刀，棉线，碘酒，毛巾，接生粉，温水', 0, 0, '', '2020-09-29 22:17:13');
INSERT INTO `t_feeding` VALUES (1001, '仔猪护理', '出生后', '1，去除身上和口腔粘液，撒上接生粉\n2，棉线扎紧脐带，留3-5厘米剪掉，碘酒消毒\n3，称重记录\n4，放入保温箱，吃初乳', 0, 1, '', '2020-09-29 22:40:22');

SET FOREIGN_KEY_CHECKS = 1;
