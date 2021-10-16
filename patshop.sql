/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : patshop

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 21/01/2021 21:04:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pms_bid_result
-- ----------------------------
DROP TABLE IF EXISTS `pms_bid_result`;
CREATE TABLE `pms_bid_result` (
  `id` bigint(60) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(60) DEFAULT NULL COMMENT '用户id',
  `product_id` bigint(60) DEFAULT NULL COMMENT '商品id',
  `bid_result` int(1) DEFAULT NULL COMMENT '竞拍结果 0竞拍成功 1竞拍失败 2领先 3落后',
  `product_bid_coin` double(12,2) DEFAULT NULL COMMENT '商品成交最终价格',
  `product_icon` varchar(255) DEFAULT NULL COMMENT '竞拍商品',
  `product_bid_num` int(12) DEFAULT NULL COMMENT '竞拍次数',
  `product_title` varchar(60) DEFAULT NULL COMMENT '商品标题介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_bid_result
-- ----------------------------
BEGIN;
INSERT INTO `pms_bid_result` VALUES (1, 13, 28, 2, 15.00, '11.png', 6, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待');
INSERT INTO `pms_bid_result` VALUES (2, 12, 28, 3, 15.00, '11.png', 6, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待');
INSERT INTO `pms_bid_result` VALUES (3, 11, 28, 3, 15.00, '11.png', 6, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待');
INSERT INTO `pms_bid_result` VALUES (4, 11, 28, 3, 15.00, '11.png', 6, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待');
INSERT INTO `pms_bid_result` VALUES (5, 11, 28, 3, 15.00, '11.png', 6, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待');
INSERT INTO `pms_bid_result` VALUES (6, 12, 39, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `pms_bid_result` VALUES (7, 12, 38, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `pms_bid_result` VALUES (8, 12, 42, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `pms_bid_result` VALUES (9, 12, 29, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `pms_bid_result` VALUES (10, 12, 47, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `pms_bid_result` VALUES (11, 14, 38, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for pms_on_look
-- ----------------------------
DROP TABLE IF EXISTS `pms_on_look`;
CREATE TABLE `pms_on_look` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '围观表主键',
  `user_id` int(16) DEFAULT NULL COMMENT '用户id',
  `product_id` int(16) DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_on_look
-- ----------------------------
BEGIN;
INSERT INTO `pms_on_look` VALUES (1, 12, 28);
INSERT INTO `pms_on_look` VALUES (2, 12, 44);
INSERT INTO `pms_on_look` VALUES (3, 12, 40);
INSERT INTO `pms_on_look` VALUES (4, 12, 38);
INSERT INTO `pms_on_look` VALUES (5, 12, 39);
INSERT INTO `pms_on_look` VALUES (6, 12, 38);
INSERT INTO `pms_on_look` VALUES (7, 12, 42);
INSERT INTO `pms_on_look` VALUES (8, 12, 29);
INSERT INTO `pms_on_look` VALUES (9, 12, 47);
COMMIT;

-- ----------------------------
-- Table structure for pms_product
-- ----------------------------
DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime(6) DEFAULT NULL,
  `gmt_modified` datetime(6) DEFAULT NULL,
  `brand_id` bigint(20) DEFAULT NULL COMMENT '品牌id',
  `product_category_id` bigint(20) DEFAULT NULL COMMENT '商品分类id',
  `feight_template_id` bigint(20) DEFAULT NULL COMMENT '运费id',
  `product_attribute_category_id` bigint(20) DEFAULT NULL COMMENT '商品属性id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片',
  `delete_status` int(1) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `publish_status` int(1) DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `new_status` int(1) DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `recommand_status` int(1) DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `verify_status` int(1) DEFAULT NULL COMMENT '审核状态：0->未审核；1->审核通过',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `historical_pat_coin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '拍拍币历史价格，多个价格以逗号分隔',
  `sub_title` varchar(255) DEFAULT NULL COMMENT '副标题',
  `description` text COMMENT '商品描述',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `unit` varchar(16) DEFAULT NULL COMMENT '单位',
  `weight` decimal(10,2) DEFAULT NULL COMMENT '商品重量，默认为克',
  `preview_status` int(1) DEFAULT NULL COMMENT '是否为预告商品：0->不是；1->是',
  `service_ids` varchar(64) DEFAULT NULL COMMENT '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品关键字',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注意事项',
  `album_pics` varchar(255) DEFAULT NULL COMMENT '画册图片，连产品图片限制为5张，以逗号分割',
  `detail_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详细商品介绍',
  `detail_desc` text,
  `promotion_start_time` datetime DEFAULT NULL COMMENT '促销开始时间',
  `promotion_end_time` datetime DEFAULT NULL COMMENT '促销结束时间',
  `promotion_type` int(1) DEFAULT NULL COMMENT '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `product_category_name` varchar(255) DEFAULT NULL COMMENT '商品分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
-- Records of pms_product
-- ----------------------------
BEGIN;
INSERT INTO `pms_product` VALUES (1, NULL, NULL, 49, 7, 0, 0, '银色星芒刺绣网纱底裤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 1, 1, 1, 1, 100, 0, 100.00, NULL, '111', '111', 100, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, NULL, 0, '七匹狼', '生活百货');
INSERT INTO `pms_product` VALUES (2, NULL, NULL, 49, 7, 0, 0, '银色星芒刺绣网纱底裤2', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 1, 1, 1, 1, 1, 0, 100.00, NULL, '111', '111', 100, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤2', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, NULL, 0, '七匹狼', '生活百货');
INSERT INTO `pms_product` VALUES (3, NULL, NULL, 1, 7, 0, 0, '银色星芒刺绣网纱底裤3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 1, 1, 1, 1, 1, 0, 100.00, NULL, '111', '111', 100, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤3', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, NULL, 0, '万和', '生活百货');
INSERT INTO `pms_product` VALUES (4, NULL, NULL, 1, 7, 0, 0, '银色星芒刺绣网纱底裤4', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 1, 1, 1, 1, 1, 0, 100.00, NULL, '111', '111', 100, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤4', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, NULL, 0, '万和', '生活百货');
INSERT INTO `pms_product` VALUES (5, NULL, NULL, 1, 7, 0, 0, '银色星芒刺绣网纱底裤5', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 0, 1, 1, 1, 1, 0, 100.00, NULL, '111', '111', 100, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤5', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, NULL, 0, '万和', '生活百货');
INSERT INTO `pms_product` VALUES (6, NULL, NULL, 1, 7, 0, 0, '银色星芒刺绣网纱底裤6', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 1, 1, 1, 1, 1, 0, 100.00, NULL, '111', '111', 100, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤6', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, NULL, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (7, NULL, NULL, 1, 7, 0, 1, '女式超柔软拉毛运动开衫', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 0, 0, 0, 0, 0, 0, 249.00, '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 100, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (8, NULL, NULL, 1, 7, 0, 1, '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 0, 0, 0, 0, 0, 0, 249.00, '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 100, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (9, NULL, NULL, 1, 7, 0, 1, '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 0, 0, 0, 0, 0, 0, 249.00, '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 100, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (10, NULL, NULL, 1, 7, 0, 1, '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 0, 0, 0, 0, 0, 0, 249.00, '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 100, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (11, NULL, NULL, 1, 7, 0, 1, '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 1, 0, 1, 0, 0, 0, 249.00, '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 100, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (12, NULL, NULL, 1, 7, 0, 1, '女式超柔软拉毛运动开衫2', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 1, 0, 1, 0, 0, 0, 249.00, '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 100, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (13, NULL, NULL, 1, 7, 0, 1, '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 1, 0, 1, 0, 0, 0, 249.00, '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 100, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (14, NULL, NULL, 1, 7, 0, 1, '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 0, 0, 1, 0, 0, 0, 249.00, '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 100, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (18, NULL, NULL, 1, 7, 0, 1, '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 1, 0, 0, 1, 0, 0, 0, 249.00, '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 100, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (22, NULL, NULL, 6, 7, 0, 1, 'test', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', 1, 1, 0, 0, 0, 0, 0, 0.00, '0', 'test', '', 100, '', 0.00, 1, '1,2', '', '', '', '', '', NULL, NULL, 0, '小米', '外套');
INSERT INTO `pms_product` VALUES (23, NULL, NULL, 6, 19, 0, 1, '毛衫测试', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', 1, 1, 1, 1, 0, 0, 0, 99.00, '1000', '毛衫测试11', 'xxx', 100, '件', 1000.00, 1, '1,2,3', '毛衫测试', '毛衫测试', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', '毛衫测试', '毛衫测试', NULL, NULL, 2, '小米', '手机数码');
INSERT INTO `pms_product` VALUES (24, NULL, NULL, 6, 7, 0, NULL, 'xxx', '', 1, 0, 0, 0, 0, 0, 0, 0.00, '0', 'xxx', '', 100, '', 0.00, 0, '', '', '', '', '', '', NULL, NULL, 0, '小米', '外套');
INSERT INTO `pms_product` VALUES (26, NULL, NULL, 3, 19, 0, 3, '华为 HUAWEI P20 ', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 0, 1, 1, 1, 0, 100, 0, 3788.00, '0', 'AI智慧全面屏 6GB +64GB 亮黑色 全网通版 移动联通电信4G手机 双卡双待手机 双卡双待', '', 1000, '件', 0.00, 1, '2,3,1', '', '', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ab46a3cN616bdc41.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf5fN2522b9dc.jpg', '', '', NULL, NULL, 1, '华为', '手机数码');
INSERT INTO `pms_product` VALUES (27, NULL, NULL, 6, 19, 0, 3, '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', 0, 1, 1, 1, 0, 0, 0, 2699.00, '0', '骁龙845处理器，红外人脸解锁，AI变焦双摄，AI语音助手小米6X低至1299，点击抢购', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', 100, '', 0.00, 0, '', '', '', '', '', '', NULL, NULL, 3, '小米', '手机数码');
INSERT INTO `pms_product` VALUES (28, NULL, NULL, 6, 19, 0, 3, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', 0, 1, 1, 1, 0, 0, 0, 649.00, '0', '8天超长待机，137g轻巧机身，高通骁龙处理器小米6X低至1299，点击抢购', '', 100, '', 0.00, 0, '', '', '', '', '', '', NULL, NULL, 4, '小米', '手机数码');
INSERT INTO `pms_product` VALUES (29, NULL, NULL, 51, 19, 0, 3, 'Apple iPhone 8 Plus 64GB 红色特别版 移动联通电信4G手机', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 0, 1, 1, 1, 0, 0, 0, 5499.00, '0', '【限时限量抢购】Apple产品年中狂欢节，好物尽享，美在智慧！速来 >> 勾选[保障服务][原厂保2年]，获得AppleCare+全方位服务计划，原厂延保售后无忧。', '', 100, '', 0.00, 0, '', '', '', '', '', '', NULL, NULL, 0, '苹果', '手机数码');
INSERT INTO `pms_product` VALUES (30, NULL, NULL, 50, 8, 0, 1, 'HLA海澜之家简约动物印花短袖T恤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ad83a4fN6ff67ecd.jpg!cc_350x449.jpg', 0, 1, 1, 1, 0, 0, 0, 98.00, '0', '2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖', '', 100, '', 0.00, 0, '', '', '', '', '', '', NULL, NULL, 0, '海澜之家', 'T恤');
INSERT INTO `pms_product` VALUES (31, NULL, NULL, 50, 8, 0, 1, 'HLA海澜之家蓝灰花纹圆领针织布短袖T恤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ac98b64N70acd82f.jpg!cc_350x449.jpg', 0, 1, 0, 0, 0, 0, 0, 98.00, '0', '2018夏季新品短袖T恤男HNTBJ2E080A 蓝灰花纹80 175/92A/L80A 蓝灰花纹80 175/92A/L', '', 100, '', 0.00, 0, '', '', '', '', '', '', NULL, NULL, 0, '海澜之家', 'T恤');
INSERT INTO `pms_product` VALUES (32, NULL, NULL, 50, 8, 0, NULL, 'HLA海澜之家短袖T恤男基础款', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a51eb88Na4797877.jpg', 0, 1, 0, 0, 0, 0, 0, 68.00, '0', 'HLA海澜之家短袖T恤男基础款简约圆领HNTBJ2E153A藏青(F3)175/92A(50)', '', 100, '', 0.00, 0, '', '', '', '', '', '', NULL, NULL, 0, '海澜之家', 'T恤');
INSERT INTO `pms_product` VALUES (33, NULL, NULL, 6, 35, 0, NULL, '小米（MI）小米电视4A ', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b02804dN66004d73.jpg', 0, 1, 0, 0, 0, 0, 0, 2499.00, '0', '小米（MI）小米电视4A 55英寸 L55M5-AZ/L55M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视', '', 100, '', 0.00, 0, '', '', '', '', '', '', NULL, NULL, 0, '小米', '手机数码');
INSERT INTO `pms_product` VALUES (34, NULL, NULL, 6, 35, 0, NULL, '小米（MI）小米电视4A 65英寸', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b028530N51eee7d4.jpg', 0, 1, 0, 0, 0, 0, 0, 3999.00, '0', ' L65M5-AZ/L65M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视', '', 100, '', 0.00, 0, '', '', '', '', '', '', NULL, NULL, 0, '小米', '手机数码');
INSERT INTO `pms_product` VALUES (35, NULL, NULL, 58, 29, 0, NULL, '耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b235bb9Nf606460b.jpg', 0, 1, 0, 0, 0, 0, 0, 369.00, '0', '耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码', '', 100, '', 0.00, 0, '', '', '', '', '', '', NULL, NULL, 0, 'NIKE', '男鞋');
INSERT INTO `pms_product` VALUES (36, NULL, NULL, 58, 29, 0, NULL, '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', 0, 1, 1, 1, 0, 0, 0, 499.00, '0', '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', '', 100, '', 0.00, 0, '', '', '', '', '', '', NULL, NULL, 0, 'NIKE', '男鞋');
COMMIT;

-- ----------------------------
-- Table structure for pms_product1
-- ----------------------------
DROP TABLE IF EXISTS `pms_product1`;
CREATE TABLE `pms_product1` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(6) DEFAULT NULL COMMENT '修改时间',
  `product_category_id` bigint(20) DEFAULT NULL COMMENT '商品分类id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片',
  `delete_status` int(1) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `market_price` decimal(10,2) DEFAULT NULL COMMENT '市场价格',
  `current_price` decimal(10,2) DEFAULT NULL COMMENT '当前价格',
  `historical_pat_coin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '拍拍币历史价格，多个价格以逗号分隔',
  `sub_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '副标题',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `service_ids` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品关键字',
  `album_pics` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '画册图片，连产品图片限制为5张，以逗号分割',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品分类名称',
  `bids` int(10) DEFAULT NULL COMMENT '出价人数',
  `onlookers` int(20) DEFAULT NULL COMMENT '围观人数',
  `bid_countdown` timestamp(6) NULL DEFAULT NULL COMMENT '截拍时间',
  `start_price` decimal(10,2) DEFAULT NULL COMMENT '起拍价',
  `refund_rate` int(3) DEFAULT NULL COMMENT '退币比率',
  `handling_fee` decimal(10,2) DEFAULT NULL COMMENT '手续费',
  `markup` decimal(10,2) DEFAULT NULL COMMENT '加价幅度',
  `cur_pat_coin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '竞拍价格列表，多个价格以逗号分隔',
  `cur_pat_user_nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '竞拍玩家，多个玩家以逗号分隔',
  `cur_pat_user_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '竞拍玩家头像，多个头像以逗号分隔',
  `cur_pat_time` varchar(255) DEFAULT '' COMMENT '每次加价时间，多个时间以逗号分隔',
  `cur_pat_user_id` varchar(255) DEFAULT NULL COMMENT '竞拍玩家id，多个id以逗号分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='商品详情表';

-- ----------------------------
-- Records of pms_product1
-- ----------------------------
BEGIN;
INSERT INTO `pms_product1` VALUES (1, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (2, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (3, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (4, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (5, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (6, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (7, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (8, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (9, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (10, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (11, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (12, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (28, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-04 15:40:10.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-46-17,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (29, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.20, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 7, 50, '2020-06-11 19:22:53.000000', 0.50, 20, 0.50, 0.20, '15.2,15.0,1.0,0.8,0.6,0.4,0.2', '方响,天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-06-09 16-16-47,20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '12,13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (30, '2020-03-20 19:21:38.000000', '2020-03-20 19:21:42.000000', 2, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '11.png,11.png,11.png', 0, 200, 1999.00, 15.00, '11.2,12.0,9.23,13.4', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 999, '1,2,3', '小米手机', '11.png,11.png,11.png', '手机数码', 6, 50, '2020-05-29 19:22:26.000000', 0.50, 20, 0.50, 0.20, '15.0,1.0,0.8,0.6,0.4,0.2', '天然呆酱w ,方响,天然呆酱w ,方响,科技报馆,天然呆酱w', 'avatar3.jpg,avatar2.jpg,avatar3.jpg,avatar2.jpg,avatar1.jpg,avatar3.jpg', '20-05-02 17-44-08,20-04-28 11:01:51,20-04-28 10:23:39,20-04-28 09:10:11,20-04-28 08:32:40,20-04-28 08:31:31', '13,12,13,12,11,13');
INSERT INTO `pms_product1` VALUES (31, '2020-05-13 10:27:01.438000', '2020-05-13 10:27:01.438000', 5, 'HLA海澜之家简约动物印花短袖T恤', '158933682142913.jpg,158933682142913.jpg,158933682143013.jpg,', 0, 200, 399.00, 0.00, '', '2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖', 999, '1,2,3', '毛衫', '11.png,11.png,11.png', '生活百货', 0, 0, '2020-05-14 02:09:44.081000', 4.00, 20, 1.00, 1.20, '', '', '', '', '');
INSERT INTO `pms_product1` VALUES (32, '2020-05-20 16:11:58.778000', '2020-05-20 16:11:58.778000', 5, 'HLA海澜之家简约动物印花短袖T恤', '1589962318766,', 0, 200, 3999.00, 0.00, '', '2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖', 999, '1,2,3', '', '13.png,13.png,13.png', '生活百货', 0, 0, '2020-05-14 02:09:44.081000', 4.00, 20, 1.00, 1.20, '', '', '', '', '');
INSERT INTO `pms_product1` VALUES (33, '2020-05-20 16:13:04.700000', '2020-05-20 16:13:04.700000', 5, 'HLA海澜之家简约动物印花短袖T恤', '13.png,13.png,13.png', 0, 200, 3999.00, 0.00, '', '2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖', 999, '1,2,3', '', '13.png,13.png,13.png', '生活百货', 0, 0, '2020-05-14 02:09:44.081000', 4.00, 20, 1.00, 1.20, '', '', '', '', '');
INSERT INTO `pms_product1` VALUES (34, '2020-05-20 16:13:28.470000', '2020-05-20 16:13:28.470000', 5, 'HLA海澜之家简约动物印花短袖T恤', '13.png,13.png,13.png', 0, 200, 3999.00, 0.00, '', '2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖', 999, '1,2,3', '', '13.png,13.png,13.png', '生活百货', 0, 0, '2020-05-14 02:09:44.081000', 4.00, 20, 1.00, 1.20, '', '', '', '', '');
INSERT INTO `pms_product1` VALUES (35, '2020-05-20 16:14:13.776000', '2020-05-20 16:14:13.776000', 5, 'HLA海澜之家简约动物印花短袖T恤', '13.png,13.png,13.png', 0, 200, 3999.00, 0.00, '', '2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖', 999, '1,2,3', '', '13.png,13.png,13.png', '生活百货', 0, 0, '2020-05-14 02:09:44.081000', 4.00, 20, 1.00, 1.20, '', '', '', '', '');
INSERT INTO `pms_product1` VALUES (38, '2020-06-07 20:33:56.921000', '2020-06-07 20:33:56.921000', 2, '嘻嘻', '1591533236910Screenshot_20200607_013024_com.tencent.mobileqq.jpg,', 0, 200, 1999.00, 21.00, '', '嘿嘿', 999, '1,2,3', '', '1591533236911Screenshot_20200607_013016_com.tencent.mobileqq.jpg,', '手机数码', 2, 0, '2020-07-07 21:33:08.829000', 100.00, 20, 1.00, 3.00, '21.0,3.0,', ',方响,', 'null,avatar2.jpg,', '20-06-10 17-33-22,20-06-09 14-41-56,', '14,12,');
INSERT INTO `pms_product1` VALUES (39, '2020-06-08 10:48:39.299000', '2020-06-08 10:48:39.299000', 2, '海澜之家印花短袖', '1591584519293Screenshot_20200417_115839_com.taobao.taobao.jpg,1591584519294Screenshot_20200417_115831_com.taobao.taobao.jpg,', 0, 200, 1999.00, 1.00, '', '海澜之家', 999, '1,2,3', '', '1591584519295Screenshot_20200607_013016_com.tencent.mobileqq.jpg,1591584519295Screenshot_20200607_013024_com.tencent.mobileqq.jpg,', '手机数码', 1, 0, '2020-07-09 11:47:52.872000', 133.00, 20, 1.00, 1.00, '1.0,', '方响,', 'avatar2.jpg,', '20-06-09 14-41-31,', '12,');
INSERT INTO `pms_product1` VALUES (40, '2020-06-08 10:48:39.299000', '2020-06-08 10:48:39.299000', 2, '海澜之家印花短袖', '1591584519293Screenshot_20200417_115839_com.taobao.taobao.jpg,1591584519294Screenshot_20200417_115831_com.taobao.taobao.jpg,', 0, 200, 1999.00, 0.00, '', '海澜之家', 999, '1,2,3', '', '1591584519295Screenshot_20200607_013016_com.tencent.mobileqq.jpg,1591584519295Screenshot_20200607_013024_com.tencent.mobileqq.jpg,', '手办模型', 0, 0, '2020-07-09 11:47:52.872000', 133.00, 20, 1.00, 1.00, '', '', '', '', '');
INSERT INTO `pms_product1` VALUES (41, '2020-06-08 10:48:39.299000', '2020-06-08 10:48:39.299000', 2, '海澜之家印花短袖', '1591584519293Screenshot_20200417_115839_com.taobao.taobao.jpg,1591584519294Screenshot_20200417_115831_com.taobao.taobao.jpg,', 0, 200, 1999.00, 0.00, '', '海澜之家', 999, '1,2,3', '', '1591584519295Screenshot_20200607_013016_com.tencent.mobileqq.jpg,1591584519295Screenshot_20200607_013024_com.tencent.mobileqq.jpg,', '生活百货', 0, 0, '2020-07-09 11:47:52.872000', 133.00, 20, 1.00, 1.00, '', '', '', '', '');
INSERT INTO `pms_product1` VALUES (42, '2020-06-08 14:24:01.019000', '2020-06-08 14:24:01.019000', 5, '检查', '1591597441001mmexport1589021980433.jpg,', 0, 200, 3999.00, 1.00, '', '检查', 999, '1,2,3', '', '1591597441010mmexport1589022135812.jpg,1591597441010mmexport1589022133234.jpg,', '生活百货', 1, 0, '2020-07-09 14:23:15.419000', 15.00, 20, 1.00, 1.00, '1.0,', '方响,', 'avatar2.jpg,', '20-06-09 16-13-15,', '12,');
INSERT INTO `pms_product1` VALUES (43, '2020-06-08 14:37:46.926000', '2020-06-08 14:37:46.926000', 5, '测试', '1591598266919mmexport1589022135812.jpg,', 1, 200, 1399.00, 1.00, '', '123', 999, '1,2,3', '', '1591598266921Screenshot_20200503_094718_com.android.mms.jpg,', '生活百货', 0, 0, '2020-07-09 14:37:01.067000', 1.00, 20, 1.00, 1.00, '1.0,', '方响,', 'avatar2.jpg,', '20-06-08 21-37-38,', '12,');
INSERT INTO `pms_product1` VALUES (44, '2020-06-08 14:37:46.926000', '2020-06-08 14:37:46.926000', 5, '测试', '1591598266919mmexport1589022135812.jpg,', 1, 200, 1399.00, 2.00, '', '123', 999, '1,2,3', '', '1591598266921Screenshot_20200503_094718_com.android.mms.jpg,', '游戏点劵', 0, 0, '2020-07-09 14:37:01.067000', 1.00, 20, 1.00, 1.00, '2.0,', '方响,', 'avatar2.jpg,', '20-06-08 20-09-33,', '12,');
INSERT INTO `pms_product1` VALUES (45, '2020-06-09 16:31:12.488000', '2020-06-09 16:31:12.488000', 5, 'HLA海澜之家简约动物印花短袖T恤', '159169147246715.jpg,', 0, 200, 3999.00, 4.00, '', '2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖', 999, '1,2,3', '', '159169147247715.jpg,', '生活百货', 0, 0, '2020-05-14 02:09:44.081000', 4.00, 20, 1.00, 1.20, '', '', '', '', '');
INSERT INTO `pms_product1` VALUES (46, '2020-06-09 16:36:38.877000', '2020-06-09 16:36:38.877000', 3, '胖胖胖', '1591691791768IMG_20200430_101112.jpg,', 0, 200, 1399.00, 1.00, '', '胖胖胖', 999, '1,2,3', '', '1591691794512mmexport1589022130058.jpg,', '手办模型', 0, 0, '2020-07-10 16:36:42.975000', 1.00, 20, 1.00, 1.00, '', '', '', '', '');
INSERT INTO `pms_product1` VALUES (47, '2020-06-09 16:43:00.184000', '2020-06-09 16:43:00.184000', 6, '胖胖胖', '1591692180179IMG_20200430_104558.jpg,', 0, 200, 1399.00, 2.00, '', '胖胖胖', 999, '1,2,3', '', '1591692180180IMG_20200430_101112.jpg,', '游戏点劵', 1, 0, '2020-07-10 16:43:13.862000', 1.00, 20, 1.00, 1.00, '2.0,', '方响,', 'avatar2.jpg,', '20-06-09 16-44-00,', '12,');
INSERT INTO `pms_product1` VALUES (48, '2020-06-09 16:45:17.368000', '2020-06-09 16:45:17.368000', 6, '测试商品', '1591692317365IMG_20200605_200259.jpg,', 1, 200, 1499.00, 1.00, '', '测试商品', 999, '1,2,3', '', '1591692317366Screenshot_20200607_013024_com.tencent.mobileqq.jpg,', '游戏点劵', 0, 0, '2020-07-10 16:45:31.657000', 1.00, 20, 1.00, 1.00, '', '', '', '', '');
COMMIT;

-- ----------------------------
-- Table structure for pms_product_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category`;
CREATE TABLE `pms_product_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `gmt_create` date DEFAULT NULL COMMENT '创建日期',
  `gmt_modified` datetime(6) DEFAULT NULL COMMENT '修改日期',
  `category_name` varchar(12) DEFAULT NULL COMMENT '分类名称',
  `level` int(3) DEFAULT NULL COMMENT '商品分级',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上机分类的编号：0表示一级分类',
  `product_unit` varchar(6) DEFAULT NULL COMMENT '商品单位',
  `nav_status` int(3) DEFAULT NULL COMMENT '是否显示在导航栏：0->不显示；1->显示',
  `show_status` int(3) DEFAULT NULL COMMENT '展示状态',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关键字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品类目表';

-- ----------------------------
-- Records of pms_product_category
-- ----------------------------
BEGIN;
INSERT INTO `pms_product_category` VALUES (1, '2020-03-19', '2020-03-19 09:43:10.000000', '生活充值', 0, NULL, '件', 1, 1, NULL, '充值');
INSERT INTO `pms_product_category` VALUES (2, '2020-03-19', '2020-03-19 09:44:31.000000', '手机数码', 0, NULL, '件', 1, 1, NULL, '数码');
INSERT INTO `pms_product_category` VALUES (3, '2020-03-19', '2020-03-19 09:45:37.000000', '手办模型', 0, NULL, '件', 1, 1, NULL, '手办');
INSERT INTO `pms_product_category` VALUES (4, '2020-03-19', '2020-03-19 09:46:27.000000', '美妆好物', 0, NULL, '件', 1, 1, NULL, '美妆');
INSERT INTO `pms_product_category` VALUES (5, '2020-03-19', '2020-03-19 09:46:59.000000', '生活百货', 0, NULL, '件', 1, 1, NULL, '百货');
INSERT INTO `pms_product_category` VALUES (6, '2020-03-19', '2020-03-19 09:52:00.000000', '游戏点劵', 0, NULL, '件', 1, 1, NULL, '点劵');
COMMIT;

-- ----------------------------
-- Table structure for sms_home_advertise
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_advertise`;
CREATE TABLE `sms_home_advertise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `pic` varchar(500) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '上下线状态：0->下线；1->上线',
  `click_count` int(10) DEFAULT '0' COMMENT '点击数',
  `order_count` int(10) DEFAULT '0' COMMENT '下单数',
  `url` varchar(500) DEFAULT NULL COMMENT '链接地址',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20044445 DEFAULT CHARSET=utf8 COMMENT='首页轮播广告表';

-- ----------------------------
-- Records of sms_home_advertise
-- ----------------------------
BEGIN;
INSERT INTO `sms_home_advertise` VALUES (9, '电影推荐广告', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20181113/movie_ad.jpg', 1, 0, 0, 'www.baidu.com', '电影推荐广告', 100);
INSERT INTO `sms_home_advertise` VALUES (10, '汽车促销广告', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20181113/car_ad.jpg', 1, 0, 0, 'xxx', NULL, 99);
INSERT INTO `sms_home_advertise` VALUES (11, '汽车推荐广告', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20181113/car_ad2.jpg', 1, 0, 0, 'xxx', NULL, 98);
COMMIT;

-- ----------------------------
-- Table structure for sms_home_brand
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_brand`;
CREATE TABLE `sms_home_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` bigint(20) DEFAULT NULL,
  `brand_name` varchar(64) DEFAULT NULL,
  `recommend_status` int(1) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='首页推荐品牌表';

-- ----------------------------
-- Records of sms_home_brand
-- ----------------------------
BEGIN;
INSERT INTO `sms_home_brand` VALUES (1, 1, '万和', 1, 200);
INSERT INTO `sms_home_brand` VALUES (2, 2, '三星', 1, 0);
INSERT INTO `sms_home_brand` VALUES (6, 6, '小米', 1, 300);
INSERT INTO `sms_home_brand` VALUES (8, 5, '方太', 1, 100);
INSERT INTO `sms_home_brand` VALUES (31, 49, '七匹狼', 0, 0);
INSERT INTO `sms_home_brand` VALUES (32, 50, '海澜之家', 1, 0);
INSERT INTO `sms_home_brand` VALUES (33, 51, '苹果', 1, 0);
INSERT INTO `sms_home_brand` VALUES (34, 2, '三星', 0, 0);
INSERT INTO `sms_home_brand` VALUES (35, 3, '华为', 1, 0);
INSERT INTO `sms_home_brand` VALUES (36, 4, '格力', 1, 0);
INSERT INTO `sms_home_brand` VALUES (37, 5, '方太', 1, 0);
INSERT INTO `sms_home_brand` VALUES (38, 1, '万和', 1, 0);
INSERT INTO `sms_home_brand` VALUES (39, 21, 'OPPO', 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for sms_home_hot
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_hot`;
CREATE TABLE `sms_home_hot` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime(6) DEFAULT NULL,
  `gmt_modified` datetime(6) DEFAULT NULL,
  `product_id` bigint(255) DEFAULT NULL COMMENT '商品id',
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `category_name` varchar(20) DEFAULT NULL COMMENT '商品分类名',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图',
  `market_price` decimal(10,2) DEFAULT NULL COMMENT '市场价',
  `pat_price` decimal(10,2) DEFAULT NULL COMMENT '拍拍币价格',
  `bid_count` int(10) DEFAULT NULL COMMENT '出价次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='首页热门拍卖表';

-- ----------------------------
-- Records of sms_home_hot
-- ----------------------------
BEGIN;
INSERT INTO `sms_home_hot` VALUES (1, '2020-03-15 12:10:14.000000', '2020-03-15 12:10:22.000000', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '生活百货', '11.png', 649.00, 5.00, 5);
INSERT INTO `sms_home_hot` VALUES (2, '2020-03-15 19:47:55.000000', '2020-03-15 19:47:59.000000', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '手机数码', '11.png', 500.00, 8.00, 6);
INSERT INTO `sms_home_hot` VALUES (3, '2020-03-15 19:48:41.000000', '2020-03-15 19:48:43.000000', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '美妆好物', '11.png', 200.00, 2.00, 3);
INSERT INTO `sms_home_hot` VALUES (4, '2020-03-15 19:49:08.000000', '2020-03-15 19:49:10.000000', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '生活充值', '11.png', 900.00, 7.00, 6);
COMMIT;

-- ----------------------------
-- Table structure for sms_home_product
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_product`;
CREATE TABLE `sms_home_product` (
  `id` bigint(255) NOT NULL,
  `gmt_create` date DEFAULT NULL COMMENT '创建日期',
  `gmt_modify` date DEFAULT NULL COMMENT '修改日期',
  `product_id` bigint(255) DEFAULT NULL COMMENT '商品id',
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `category_name` varchar(20) DEFAULT NULL COMMENT '商品分类名',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图',
  `market_price` decimal(10,2) DEFAULT NULL COMMENT '市场价',
  `pat_price` decimal(10,2) DEFAULT NULL COMMENT '拍拍币价格',
  `bid_count` int(10) DEFAULT NULL COMMENT '出价次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='展示拍卖商品粗略信息表';

-- ----------------------------
-- Records of sms_home_product
-- ----------------------------
BEGIN;
INSERT INTO `sms_home_product` VALUES (1, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '生活充值', '11.png', 649.00, 5.00, 5);
INSERT INTO `sms_home_product` VALUES (2, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '手机数码', '11.png', 500.00, 8.00, 6);
INSERT INTO `sms_home_product` VALUES (3, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '手办模型', '11.png', 200.00, 2.00, 3);
INSERT INTO `sms_home_product` VALUES (4, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '美妆好物', '11.png', 900.00, 7.00, 6);
INSERT INTO `sms_home_product` VALUES (5, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '生活百货', '11.png', 649.00, 5.00, 5);
INSERT INTO `sms_home_product` VALUES (6, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '生活充值', '11.png', 500.00, 8.00, 6);
INSERT INTO `sms_home_product` VALUES (7, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '手机数码', '11.png', 200.00, 2.00, 3);
INSERT INTO `sms_home_product` VALUES (8, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '手机数码', '11.png', 900.00, 7.00, 6);
INSERT INTO `sms_home_product` VALUES (9, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '手办模型', '11.png', 649.00, 5.00, 5);
INSERT INTO `sms_home_product` VALUES (10, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '美妆好物', '11.png', 500.00, 8.00, 6);
INSERT INTO `sms_home_product` VALUES (11, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '生活百货', '11.png', 200.00, 2.00, 3);
INSERT INTO `sms_home_product` VALUES (12, '2020-03-15', '2020-03-15', 28, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '生活充值', '11.png', 900.00, 7.00, 6);
COMMIT;

-- ----------------------------
-- Table structure for sms_sec_topic
-- ----------------------------
DROP TABLE IF EXISTS `sms_sec_topic`;
CREATE TABLE `sms_sec_topic` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '二级话题分类主键id',
  `sec_topic_name` varchar(16) DEFAULT NULL COMMENT '二级话题名称',
  `is_hot` int(1) DEFAULT '0' COMMENT '热门话题 0不是 1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='首页二级话题表';

-- ----------------------------
-- Records of sms_sec_topic
-- ----------------------------
BEGIN;
INSERT INTO `sms_sec_topic` VALUES (1, '我买过的惊喜好物', 0);
INSERT INTO `sms_sec_topic` VALUES (2, '颜值给你带来的影响', 0);
INSERT INTO `sms_sec_topic` VALUES (3, '穿出来的女团风', 1);
INSERT INTO `sms_sec_topic` VALUES (4, '减龄穿搭怎么选', 1);
INSERT INTO `sms_sec_topic` VALUES (5, '装点你的美好生活', 0);
INSERT INTO `sms_sec_topic` VALUES (6, '荣耀30手机抢先买', 1);
INSERT INTO `sms_sec_topic` VALUES (7, '我买过的惊喜好物', 0);
INSERT INTO `sms_sec_topic` VALUES (8, '颜值给你带来的影响', 1);
INSERT INTO `sms_sec_topic` VALUES (9, '穿出来的女团风', 0);
INSERT INTO `sms_sec_topic` VALUES (10, '减龄穿搭怎么选', 0);
INSERT INTO `sms_sec_topic` VALUES (11, '装点你的美好生活', 0);
INSERT INTO `sms_sec_topic` VALUES (12, '荣耀30手机抢先买', 0);
INSERT INTO `sms_sec_topic` VALUES (13, '我买过的惊喜好物', 1);
INSERT INTO `sms_sec_topic` VALUES (14, '颜值给你带来的影响', 0);
INSERT INTO `sms_sec_topic` VALUES (15, '穿出来的女团风', 1);
INSERT INTO `sms_sec_topic` VALUES (16, '减龄穿搭怎么选', 0);
INSERT INTO `sms_sec_topic` VALUES (17, '装点你的美好生活', 0);
INSERT INTO `sms_sec_topic` VALUES (18, '荣耀30手机抢先买', 0);
INSERT INTO `sms_sec_topic` VALUES (19, '我买过的惊喜好物', 0);
INSERT INTO `sms_sec_topic` VALUES (20, '颜值给你带来的影响', 0);
COMMIT;

-- ----------------------------
-- Table structure for sms_topic
-- ----------------------------
DROP TABLE IF EXISTS `sms_topic`;
CREATE TABLE `sms_topic` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `topic_type` int(1) DEFAULT NULL COMMENT '话题类型0 纯文字 1图文',
  `topic_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '话题内容',
  `topic_image` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '话题图片，以逗号分隔',
  `user_id` int(20) DEFAULT NULL COMMENT '发表话题用户id',
  `create_time` datetime(6) DEFAULT NULL COMMENT '创建话题时间',
  `topic_category` varchar(12) CHARACTER SET utf8 DEFAULT NULL COMMENT '话题分类',
  `topic_title` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '话题标题',
  `sec_topic_id` int(20) DEFAULT NULL COMMENT '二级话题id',
  `hot_topic` int(1) DEFAULT NULL COMMENT '是否精选话题  0 不是 1 是',
  `user_nickname` varchar(16) DEFAULT NULL COMMENT '发表话题用户的nickname',
  `topic_hot_value` float(8,0) DEFAULT NULL COMMENT '话题热度',
  `user_avatar` text COMMENT '发表话题用户的头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='首页话题表';

-- ----------------------------
-- Records of sms_topic
-- ----------------------------
BEGIN;
INSERT INTO `sms_topic` VALUES (1, NULL, '刚收到货，手机好漂亮，未拆封，未激活，原装正品，官网旗舰店值得信赖，一直纠结手机颜色，这个颜色好喜欢，客服好有耐心，谢谢了！必须给5星，下次介绍朋友来买，物流速度飞快，上午下单，下午18.30就收到了，未发现什么缺点，要是送个无线充电器就好了！哈哈！👍👍👍👍👍👍', '1.jpg,2.jpg,3.jpg,4.jpg,5.jpg', 11, '2020-04-15 19:26:51.000000', '手机数码', NULL, 1, 1, '汉字知识君', 996, 'avatar1.jpg');
INSERT INTO `sms_topic` VALUES (2, NULL, '终于！终于！在包里找到了我最喜欢的这只口红了！薄唇mm必须入！超级好看！涂上被问最多的一个色！！温柔！', '6.jpg,7.jpg', 12, '2020-04-18 17:55:42.000000', '美妆好物', NULL, 2, 1, '方响', 1003, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (3, NULL, '给你们看看我的大手办 给你们看看我的大手办 ​ ​🐱​🐱​🐱', '8.jpg,9.jpg,10.jpg', 12, '2020-04-18 17:55:42.000000', '生活百货', NULL, 2, 1, '天然呆酱w ', 1003, 'avatar3.jpg');
INSERT INTO `sms_topic` VALUES (4, NULL, '终于！终于！在包里找到了我最喜欢的这只口红了！薄唇mm必须入！超级好看！涂上被问最多的一个色！！温柔！', '6.jpg,7.jpg', 12, '2020-04-18 17:55:42.000000', '美妆好物', NULL, 2, 1, '方响', 1003, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (5, NULL, '刚收到货，手机好漂亮，未拆封，未激活，原装正品，官网旗舰店值得信赖，一直纠结手机颜色，这个颜色好喜欢，客服好有耐心，谢谢了！必须给5星，下次介绍朋友来买，物流速度飞快，上午下单，下午18.30就收到了，未发现什么缺点，要是送个无线充电器就好了！哈哈！👍👍👍👍👍👍', '1.jpg,2.jpg,3.jpg,4.jpg,5.jpg', 11, '2020-04-15 19:26:51.000000', '手机数码', NULL, 1, 1, '汉字知识君', 996, 'avatar1.jpg');
INSERT INTO `sms_topic` VALUES (6, NULL, '终于！终于！在包里找到了我最喜欢的这只口红了！薄唇mm必须入！超级好看！涂上被问最多的一个色！！温柔！', '6.jpg,7.jpg', 12, '2020-04-18 17:55:42.000000', '美妆好物', NULL, 2, 1, '方响', 1003, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (7, NULL, '给你们看看我的大手办 给你们看看我的大手办 ​ ​🐱​🐱​🐱', '8.jpg,9.jpg,10.jpg', 12, '2020-04-18 17:55:42.000000', '生活百货', NULL, 2, 1, '天然呆酱w ', 1003, 'avatar3.jpg');
INSERT INTO `sms_topic` VALUES (8, NULL, '终于！终于！在包里找到了我最喜欢的这只口红了！薄唇mm必须入！超级好看！涂上被问最多的一个色！！温柔！', '6.jpg,7.jpg', 12, '2020-04-18 17:55:42.000000', '美妆好物', NULL, 2, 1, '方响', 1003, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (9, NULL, '刚收到货，手机好漂亮，未拆封，未激活，原装正品，官网旗舰店值得信赖，一直纠结手机颜色，这个颜色好喜欢，客服好有耐心，谢谢了！必须给5星，下次介绍朋友来买，物流速度飞快，上午下单，下午18.30就收到了，未发现什么缺点，要是送个无线充电器就好了！哈哈！👍👍👍👍👍👍', '1.jpg,2.jpg,3.jpg,4.jpg,5.jpg', 11, '2020-04-15 19:26:51.000000', '手机数码', NULL, 1, 1, '汉字知识君', 996, 'avatar1.jpg');
INSERT INTO `sms_topic` VALUES (10, NULL, '终于！终于！在包里找到了我最喜欢的这只口红了！薄唇mm必须入！超级好看！涂上被问最多的一个色！！温柔！', '6.jpg,7.jpg', 12, '2020-04-18 17:55:42.000000', '美妆好物', NULL, 2, 1, '方响', 1003, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (11, NULL, '给你们看看我的大手办 给你们看看我的大手办 ​ ​🐱​🐱​🐱', '8.jpg,9.jpg,10.jpg', 12, '2020-04-18 17:55:42.000000', '生活百货', NULL, 2, 1, '天然呆酱w ', 1003, 'avatar3.jpg');
INSERT INTO `sms_topic` VALUES (12, NULL, '终于！终于！在包里找到了我最喜欢的这只口红了！薄唇mm必须入！超级好看！涂上被问最多的一个色！！温柔！', '6.jpg,7.jpg', 12, '2020-04-18 17:55:42.000000', '美妆好物', NULL, 2, 1, '方响', 1003, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (46, 0, '几', '1591531838982IMG_20200605_212140.jpg,', 12, '2020-06-07 20:10:38.992000', '手机数码', '', 1, 0, '方响', 74, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (47, 0, '略略略', '1591532303130Screenshot_20200607_013024_com.tencent.mobileqq.jpg,', 12, '2020-06-07 20:18:23.139000', '手机数码', '', 2, 0, '方响', 409, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (48, 0, '咔咔咔', '1591532430055Screenshot_20200607_013016_com.tencent.mobileqq.jpg,', 12, '2020-06-07 20:20:30.063000', '手机数码', '', 3, 0, '方响', 733, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (49, 0, '坎坎坷坷', '1591532544430Screenshot_20200604_195912_com.tencent.mm.jpg,', 12, '2020-06-07 20:22:24.438000', '手机数码', '', 2, 0, '方响', 127, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (50, 0, '噼噼啪啪', '1591533584757Screenshot_20200607_201240_com.android.gallery3d.jpg,', 12, '2020-06-07 20:39:44.764000', '手机数码', '', 2, 0, '方响', 366, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (51, 0, '密密麻麻', '1591598575086Screenshot_20200607_224942_com.tencent.mobileqq.jpg,', 12, '2020-06-08 14:42:55.093000', '美妆好物', '', 5, 0, '方响', 185, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (52, 0, '密密麻麻', '1591598575354Screenshot_20200607_224942_com.tencent.mobileqq.jpg,', 12, '2020-06-08 14:42:55.358000', '美妆好物', '', 5, 0, '方响', 156, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (53, 0, '密密麻麻', '1591598575455Screenshot_20200607_224942_com.tencent.mobileqq.jpg,', 12, '2020-06-08 14:42:55.459000', '美妆好物', '', 5, 0, '方响', 962, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (54, 0, '密密麻麻', '1591598575646Screenshot_20200607_224942_com.tencent.mobileqq.jpg,', 12, '2020-06-08 14:42:55.650000', '美妆好物', '', 5, 0, '方响', 502, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (55, 0, '密密麻麻', '1591598575712Screenshot_20200607_224942_com.tencent.mobileqq.jpg,', 12, '2020-06-08 14:42:55.718000', '美妆好物', '', 5, 0, '方响', 186, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (56, 0, '测试话题', '1591692443541Screenshot_20200607_201240_com.android.gallery3d.jpg,', 12, '2020-06-09 16:47:23.550000', '游戏点劵', '', 1, 0, '方响', 893, 'avatar2.jpg');
INSERT INTO `sms_topic` VALUES (57, 0, '测试话题', '1591703805181Screenshot_20200607_013024_com.tencent.mobileqq.jpg,1591703805185Screenshot_20200607_013016_com.tencent.mobileqq.jpg,', 12, '2020-06-09 19:56:45.192000', '游戏点劵', '', 3, 0, '方响', 1000, 'avatar2.jpg');
COMMIT;

-- ----------------------------
-- Table structure for ums_member
-- ----------------------------
DROP TABLE IF EXISTS `ums_member`;
CREATE TABLE `ums_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_level_id` bigint(20) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `status` int(1) DEFAULT NULL COMMENT '帐号启用状态:0->禁用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `icon` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '头像',
  `gender` int(1) DEFAULT NULL COMMENT '性别：0->未知；1->男；2->女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在城市',
  `job` varchar(100) DEFAULT NULL COMMENT '职业',
  `personalized_signature` varchar(200) DEFAULT NULL COMMENT '个性签名',
  `pat_coin` int(11) DEFAULT NULL COMMENT '拍拍币',
  `growth` int(11) DEFAULT NULL COMMENT '成长值',
  `login_status` tinyint(1) DEFAULT '0' COMMENT '登陆状态',
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `manager` int(2) DEFAULT '0' COMMENT '权限管理 0普通用户、 1商家',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`),
  UNIQUE KEY `idx_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of ums_member
-- ----------------------------
BEGIN;
INSERT INTO `ums_member` VALUES (1, 4, 'test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'windir', '18061581849', 1, '2018-08-02 10:35:44', NULL, 1, '2009-06-01', '上海', '学生', 'test', 5000, NULL, 0, NULL, 0);
INSERT INTO `ums_member` VALUES (3, 4, 'windy', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'windy', '18061581848', 1, '2018-08-03 16:46:38', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0);
INSERT INTO `ums_member` VALUES (4, 4, 'zhengsan', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'zhengsan', '18061581847', 1, '2018-11-12 14:12:04', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0);
INSERT INTO `ums_member` VALUES (5, 4, 'lisi', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'lisi', '18061581841', 1, '2018-11-12 14:12:38', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0);
INSERT INTO `ums_member` VALUES (6, 4, 'wangwu', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'wangwu', '18061581842', 1, '2018-11-12 14:13:09', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0);
INSERT INTO `ums_member` VALUES (7, 4, 'lion', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'lion', '18061581845', 1, '2018-11-12 14:21:39', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0);
INSERT INTO `ums_member` VALUES (8, 4, 'shari', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'shari', '18061581844', 1, '2018-11-12 14:22:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0);
INSERT INTO `ums_member` VALUES (9, 4, 'aewen', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'aewen', '18061581843', 1, '2018-11-12 14:22:55', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0);
INSERT INTO `ums_member` VALUES (10, 1, 'xiaohuang', '123456', 'huanghuang', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0);
INSERT INTO `ums_member` VALUES (11, 6, '984133573', '123456', '科技报馆', '18852895348', 1, '2020-04-15 19:22:07', 'avatar1.jpg', 1, '2020-04-15', '杭州', '学生', '小博美有个学国画的姐姐想分享生活', 32, NULL, 0, NULL, 0);
INSERT INTO `ums_member` VALUES (12, 5, '18378583473', '123456', '方响', '18852895349', 1, '2020-04-18 17:38:42', 'avatar2.jpg', 0, '2020-04-18', '杭州', '学生', '超级马里奥码代码', 35, NULL, 0, NULL, 1);
INSERT INTO `ums_member` VALUES (13, 4, '18378583474', '123456', '天然呆酱w ', '18852895342', 1, '2020-04-18 18:02:04', 'avatar3.jpg', 1, '2020-04-18', '杭州', '学生', '小博美有个学国画的姐姐想分享生活', 89, NULL, 0, NULL, 0);
INSERT INTO `ums_member` VALUES (14, NULL, 'hqbdsb', 'sb', '', NULL, NULL, NULL, 'avatar3.jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for ums_sign_in
-- ----------------------------
DROP TABLE IF EXISTS `ums_sign_in`;
CREATE TABLE `ums_sign_in` (
  `id` bigint(60) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(60) DEFAULT NULL COMMENT '用户名',
  `sign_date` timestamp NULL DEFAULT NULL COMMENT '签到日期',
  `reward_coin` int(6) DEFAULT NULL COMMENT '奖励拍拍币',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='签到表';

-- ----------------------------
-- Records of ums_sign_in
-- ----------------------------
BEGIN;
INSERT INTO `ums_sign_in` VALUES (1, '18378583473', '2020-05-01 20:06:09', 3);
INSERT INTO `ums_sign_in` VALUES (2, '18378583473', '2020-05-04 20:06:09', 4);
INSERT INTO `ums_sign_in` VALUES (3, 'xiaohuang', '2020-05-03 08:07:16', 3);
INSERT INTO `ums_sign_in` VALUES (6, 'xiaohuang', '2020-05-05 08:08:54', 3);
INSERT INTO `ums_sign_in` VALUES (7, 'xiaohuang', '2020-05-05 08:49:22', 3);
INSERT INTO `ums_sign_in` VALUES (9, '18378583473', '2020-05-23 13:35:27', 3);
INSERT INTO `ums_sign_in` VALUES (10, '18378583473', '2020-06-07 00:47:54', 3);
INSERT INTO `ums_sign_in` VALUES (11, '18378583473', '2020-06-08 14:43:46', 4);
INSERT INTO `ums_sign_in` VALUES (12, '18378583473', '2020-06-09 21:07:55', 5);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
