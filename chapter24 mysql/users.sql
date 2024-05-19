/*
 Navicat MySQL Data Transfer

 Source Server         : 本体MySQL
 Source Server Type    : MySQL
 Source Server Version : 80400
 Source Host           : localhost:3306
 Source Schema         : db01

 Target Server Type    : MySQL
 Target Server Version : 80400
 File Encoding         : 65001

 Date: 15/05/2024 21:02:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` (`id`, `name`, `address`) VALUES (1, '田中', '大阪');
INSERT INTO `users` (`id`, `name`, `address`) VALUES (2, '藤原', '奈良');
INSERT INTO `users` (`id`, `name`, `address`) VALUES (3, '池下', '京都');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
