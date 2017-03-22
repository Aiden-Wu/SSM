/*
Navicat MySQL Data Transfer

Source Server         : localdb
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : est

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-06-24 16:09:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(127) DEFAULT NULL,
  `zhName` varchar(255) DEFAULT NULL,
  `enName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', 'AD', '安道爾', 'ANDORRA');
INSERT INTO `country` VALUES ('2', 'AE', '阿拉伯聯合酋長國', 'UNITED ARAB EMIRATES');
INSERT INTO `country` VALUES ('3', 'AF', '阿富汗', 'AFGHANISTAN');
INSERT INTO `country` VALUES ('4', 'AG', '安提瓜及巴布達', 'ANTIGUA AND BARBUDA');
INSERT INTO `country` VALUES ('5', 'AI', '安圭拉島', 'ANGUILLA');
INSERT INTO `country` VALUES ('6', 'AL', '阿爾巴尼亞', 'ALBANIA');
INSERT INTO `country` VALUES ('7', 'AM', '亞美尼亞', 'ARMENIA');
INSERT INTO `country` VALUES ('8', 'AO', '安哥拉', 'ANGOLA');
INSERT INTO `country` VALUES ('9', 'AR', '阿根廷', 'ARGENTINA');
INSERT INTO `country` VALUES ('10', 'AS', '薩摩亞 (美國屬土)', 'SAMOA, USA TERRITORY');
INSERT INTO `country` VALUES ('11', 'AT', '奧地利', 'AUSTRIA');
INSERT INTO `country` VALUES ('12', 'AW', '亞魯巴', 'ARUBA');
INSERT INTO `country` VALUES ('13', 'AU', '澳大利亞', 'AUSTRALIA');
INSERT INTO `country` VALUES ('14', 'AZ', '阿塞拜疆', 'AZERBAIJAN');
INSERT INTO `country` VALUES ('15', 'BA', '波斯尼亞 - 黑塞哥維那', 'BOSNIA AND HERZEGOVINA');
INSERT INTO `country` VALUES ('16', 'BB', '巴巴多斯', 'BARBADOS');
INSERT INTO `country` VALUES ('17', 'BD', '孟加拉', 'BANGLADESH');
INSERT INTO `country` VALUES ('18', 'BE', '比利時', 'BELGIUM');
INSERT INTO `country` VALUES ('19', 'BF', '布基納法索', 'BURKINA FASO');
INSERT INTO `country` VALUES ('20', 'BG', '保加利亞', 'BULGARIA');
INSERT INTO `country` VALUES ('21', 'BH', '巴林', 'BAHRAIN');
INSERT INTO `country` VALUES ('22', 'BI', '布隆迪', 'BURUNDI');
INSERT INTO `country` VALUES ('23', 'BJ', '貝寧', 'BENIN');
INSERT INTO `country` VALUES ('24', 'BM', '百慕達', 'BERMUDA');
INSERT INTO `country` VALUES ('25', 'BN', '文萊達魯薩蘭國', 'BRUNEI DARUSSALAM');
INSERT INTO `country` VALUES ('26', 'BO', '玻利維亞', 'BOLIVIA');
INSERT INTO `country` VALUES ('27', 'BS', '巴哈馬', 'BAHAMAS');
INSERT INTO `country` VALUES ('28', 'BW', '博茨瓦納', 'BOTSWANA');
INSERT INTO `country` VALUES ('29', 'BY', '白俄罗斯', 'BELARUS');
INSERT INTO `country` VALUES ('30', 'BZ', '伯利茲', 'BELIZE');
INSERT INTO `country` VALUES ('31', 'CA', '加拿大', 'CANADA');
INSERT INTO `country` VALUES ('32', 'CC', '科科斯群島', 'COCOS(KEELING)ISLANDS');
INSERT INTO `country` VALUES ('33', 'CD', '剛果(民主共和國)', 'CONGO (DEM. REP. OF)');
INSERT INTO `country` VALUES ('34', 'CF', '中非共和國', 'CENTRAL AFRICAN REPUBLIC');
INSERT INTO `country` VALUES ('35', 'CG', '剛果', 'CONGO (REP. OF)');
INSERT INTO `country` VALUES ('36', 'CH', '瑞士', 'SWITZERLAND');
INSERT INTO `country` VALUES ('37', 'CI', '科特迪瓦(象牙海岸)', 'COTE D\'IVOIRE');
INSERT INTO `country` VALUES ('38', 'CK', '庫克群島', 'COOK ISLANDS');
INSERT INTO `country` VALUES ('39', 'CL', '智利', 'CHILE');
INSERT INTO `country` VALUES ('40', 'CM', '喀麥隆', 'CAMEROON');
INSERT INTO `country` VALUES ('41', 'CN', '中國', 'CHINA');
INSERT INTO `country` VALUES ('42', 'CO', '哥倫比亞', 'COLOMBIA');
INSERT INTO `country` VALUES ('43', 'CR', '哥斯達黎加', 'COSTA RICA');
INSERT INTO `country` VALUES ('44', 'CU', '古巴', 'CUBA');
INSERT INTO `country` VALUES ('45', 'CV', '佛得角群島', 'CAPE VERDE');
INSERT INTO `country` VALUES ('46', 'CX', '聖誕島', 'CHRISTMAS ISLAND');
INSERT INTO `country` VALUES ('47', 'CY', '塞浦路斯', 'CYPRUS');
INSERT INTO `country` VALUES ('48', 'CZ', '捷克', 'CZECH REPUBLIC');
INSERT INTO `country` VALUES ('49', 'DE', '德國', 'GERMANY');
INSERT INTO `country` VALUES ('50', 'DJ', '吉布提', 'DJIBOUTI');
INSERT INTO `country` VALUES ('51', 'DK', '丹麥', 'DENMARK');
INSERT INTO `country` VALUES ('52', 'DM', '多米尼加島', 'DOMINICA');
INSERT INTO `country` VALUES ('53', 'DO', '多米尼加共和國', 'DOMINICAN REPUBLIC');
INSERT INTO `country` VALUES ('54', 'DZ', '阿爾及利亞', 'ALGERIA');
INSERT INTO `country` VALUES ('55', 'EC', '厄瓜多爾', 'ECUADOR');
INSERT INTO `country` VALUES ('56', 'EE', '愛沙尼亞', 'ESTONIA');
INSERT INTO `country` VALUES ('57', 'EG', '埃及', 'EGYPT');
INSERT INTO `country` VALUES ('58', 'ER', '厄立特里亞', 'ERITREA');
INSERT INTO `country` VALUES ('59', 'ES', '西班牙', 'SPAIN');
INSERT INTO `country` VALUES ('60', 'ET', '埃塞俄比亞', 'ETHIOPIA');
INSERT INTO `country` VALUES ('61', 'FI', '芬蘭', 'FINLAND');
INSERT INTO `country` VALUES ('62', 'FJ', '斐濟', 'FIJI');
INSERT INTO `country` VALUES ('63', 'FK', '福克蘭群島', 'FALKLAND ISLAND (MALVINAS)');
INSERT INTO `country` VALUES ('64', 'FM', '密克羅尼西亞', 'MICRONESIA  (FEDERATED  STATES OF)');
INSERT INTO `country` VALUES ('65', 'FO', '法羅群島', 'FAROE ISLANDS');
INSERT INTO `country` VALUES ('66', 'FR', '法國', 'FRANCE');
INSERT INTO `country` VALUES ('67', 'GA', '加薘', 'GABON');
INSERT INTO `country` VALUES ('68', 'GB', '英國', 'UNITED KINGDOM');
INSERT INTO `country` VALUES ('69', 'GD', '格林納達', 'GRENADA');
INSERT INTO `country` VALUES ('70', 'GE', '格魯吉亞', 'GEORGIA');
INSERT INTO `country` VALUES ('71', 'GF', '法屬圭亞那', 'FRENCH GUIANA');
INSERT INTO `country` VALUES ('72', 'XE', '加沙及汗尤尼斯', 'GAZA AND KHAN YUNIS');
INSERT INTO `country` VALUES ('73', 'GH', '加納', 'GHANA');
INSERT INTO `country` VALUES ('74', 'GI', '直布羅陀', 'GIBRALTAR');
INSERT INTO `country` VALUES ('75', 'GL', '格陵蘭', 'GREENLAND');
INSERT INTO `country` VALUES ('76', 'GM', '岡比亞', 'GAMBIA');
INSERT INTO `country` VALUES ('77', 'GN', '新幾內亞', 'GUINEA');
INSERT INTO `country` VALUES ('78', 'GP', '瓜德羅普島', 'GUADELOUPE');
INSERT INTO `country` VALUES ('79', 'GQ', '赤道幾內亞', 'EQUATORIAL  GUINEA');
INSERT INTO `country` VALUES ('80', 'GR', '希臘', 'GREECE');
INSERT INTO `country` VALUES ('81', 'GS', '南喬治亞島和南桑德韋奇島', 'SOUTH GEORGIA AND THE SOUTH SANDWICH ISL');
INSERT INTO `country` VALUES ('82', 'GT', '危地馬拉', 'GUATEMALA');
INSERT INTO `country` VALUES ('83', 'GU', '關島', 'GUAM');
INSERT INTO `country` VALUES ('84', 'GW', '幾內亞比紹', 'GUINEA-BISSAU');
INSERT INTO `country` VALUES ('85', 'GY', '圭亞那', 'GUYANA');
INSERT INTO `country` VALUES ('86', 'HN', '洪都拉斯', 'HONDURAS');
INSERT INTO `country` VALUES ('87', 'HR', '克羅地亞', 'CROATIA');
INSERT INTO `country` VALUES ('88', 'HT', '海地', 'HAITI');
INSERT INTO `country` VALUES ('89', 'HU', '匈牙利', 'HUNGARY');
INSERT INTO `country` VALUES ('90', 'ID', '印度尼西亞', 'INDONESIA');
INSERT INTO `country` VALUES ('91', 'IE', '愛爾蘭', 'IRELAND');
INSERT INTO `country` VALUES ('92', 'IL', '以色列', 'ISRAEL');
INSERT INTO `country` VALUES ('93', 'IN', '印度', 'INDIA');
INSERT INTO `country` VALUES ('94', 'IQ', '伊拉克', 'IRAQ');
INSERT INTO `country` VALUES ('95', 'IR', '伊朗', 'IRAN (ISLAMIC REPUBLIC OF)');
INSERT INTO `country` VALUES ('96', 'IS', '冰島', 'ICELAND');
INSERT INTO `country` VALUES ('97', 'IT', '意大利', 'ITALY');
INSERT INTO `country` VALUES ('98', 'JM', '牙買加', 'JAMAICA');
INSERT INTO `country` VALUES ('99', 'JO', '約旦', 'JORDAN');
INSERT INTO `country` VALUES ('100', 'JP', '日本', 'JAPAN');
INSERT INTO `country` VALUES ('101', 'KE', '肯尼亞', 'KENYA');
INSERT INTO `country` VALUES ('102', 'KG', '吉爾吉斯', 'KYRGYZSTAN');
INSERT INTO `country` VALUES ('103', 'KH', '柬埔寨', 'CAMBODIA');
INSERT INTO `country` VALUES ('104', 'KI', '基里巴斯', 'KIRIBATI');
INSERT INTO `country` VALUES ('105', 'KM', '科摩羅', 'COMOROS');
INSERT INTO `country` VALUES ('106', 'KN', '聖基茨和尼維斯', 'SAINT KITTS AND NEVIS');
INSERT INTO `country` VALUES ('107', 'KP', '北韓', 'KOREA, DEMOCRATIC  PEOPLE\'S REPUBLIC OF');
INSERT INTO `country` VALUES ('108', 'KR', '南韓', 'KOREA,REPUBLIC OF');
INSERT INTO `country` VALUES ('109', 'KW', '科威特', 'KUWAIT');
INSERT INTO `country` VALUES ('110', 'KY', '開曼群島', 'CAYMAN ISLANDS');
INSERT INTO `country` VALUES ('111', 'KZ', '哈薩克', 'KAZAKHSTAN');
INSERT INTO `country` VALUES ('112', 'LA', '老撾', 'LAO PEOPLE\'S DEMOCRATIC  REPUBLIC');
INSERT INTO `country` VALUES ('113', 'LB', '黎巴嫩', 'LEBANON');
INSERT INTO `country` VALUES ('114', 'LC', '聖盧西亞', 'SAINT LUCIA');
INSERT INTO `country` VALUES ('115', 'LI', '列支敦士登', 'LIECHTENSTEIN');
INSERT INTO `country` VALUES ('116', 'LK', '斯里蘭卡', 'SRI LANKA');
INSERT INTO `country` VALUES ('117', 'LR', '利比里亞', 'LIBERIA');
INSERT INTO `country` VALUES ('118', 'LS', '萊索托', 'LESOTHO');
INSERT INTO `country` VALUES ('119', 'LT', '立陶宛', 'LITHUANIA');
INSERT INTO `country` VALUES ('120', 'LU', '盧森堡', 'LUXEMBOURG');
INSERT INTO `country` VALUES ('121', 'LV', '拉脫維亞', 'LATVIA');
INSERT INTO `country` VALUES ('122', 'LY', '利比亞', 'LIBYA');
INSERT INTO `country` VALUES ('123', 'MA', '摩洛哥', 'MOROCCO');
INSERT INTO `country` VALUES ('124', 'MC', '摩納哥', 'MONACO');
INSERT INTO `country` VALUES ('125', 'MD', '摩爾多瓦', 'MOLDOVA, REPUBLIC OF');
INSERT INTO `country` VALUES ('126', 'ME', '黑山共和國', 'MONTENEGRO');
INSERT INTO `country` VALUES ('127', 'MG', '馬達加斯加', 'MADAGASCAR');
INSERT INTO `country` VALUES ('128', 'MH', '馬紹爾群島', 'MARSHALL ISLANDS');
INSERT INTO `country` VALUES ('129', 'MK', '馬其頓', 'MACEDONIA  (REP. OF) (FORMER YOGOSLAVIA)');
INSERT INTO `country` VALUES ('130', 'ML', '馬里', 'MALI');
INSERT INTO `country` VALUES ('131', 'MM', '緬甸', 'MYANMAR');
INSERT INTO `country` VALUES ('132', 'MN', '蒙古', 'MONGOLIA');
INSERT INTO `country` VALUES ('133', 'MP', '馬里亞納群島  (北)', 'MARIANA ISLANDS (NORTHERN)');
INSERT INTO `country` VALUES ('134', 'MQ', '馬提尼克島', 'MARTINIQUE');
INSERT INTO `country` VALUES ('135', 'MR', '毛里塔尼亞', 'MAURITANIA');
INSERT INTO `country` VALUES ('136', 'MS', '蒙特塞拉特', 'MONTSERRAT');
INSERT INTO `country` VALUES ('137', 'MT', '馬爾他', 'MALTA');
INSERT INTO `country` VALUES ('138', 'MU', '毛里求斯', 'MAURITIUS');
INSERT INTO `country` VALUES ('139', 'MV', '馬爾代夫', 'MALDIVES');
INSERT INTO `country` VALUES ('140', 'MW', '馬拉維', 'MALAWI');
INSERT INTO `country` VALUES ('141', 'MX', '墨西哥', 'MEXICO');
INSERT INTO `country` VALUES ('142', 'MY', '馬來西亞', 'MALAYSIA');
INSERT INTO `country` VALUES ('143', 'MZ', '莫桑比克', 'MOZAMBIQUE');
INSERT INTO `country` VALUES ('144', 'NA', '納米比亞', 'NAMIBIA');
INSERT INTO `country` VALUES ('145', 'NC', '新喀里多尼亞', 'NEW CALEDONIA');
INSERT INTO `country` VALUES ('146', 'NE', '尼日爾', 'NIGER');
INSERT INTO `country` VALUES ('147', 'NF', '諾褔克島', 'NORFOLK ISLAND');
INSERT INTO `country` VALUES ('148', 'NG', '尼日利亞', 'NIGERIA');
INSERT INTO `country` VALUES ('149', 'NI', '尼加拉瓜', 'NICARAGUA');
INSERT INTO `country` VALUES ('150', 'NL', '荷蘭', 'NETHERLANDS');
INSERT INTO `country` VALUES ('151', 'AN', '荷屬安的列斯群島', 'NETHERLANDS  ANTILLES');
INSERT INTO `country` VALUES ('152', 'NO', '挪威', 'NORWAY');
INSERT INTO `country` VALUES ('153', 'NP', '尼泊爾', 'NEPAL');
INSERT INTO `country` VALUES ('154', 'NR', '瑙魯', 'NAURU');
INSERT INTO `country` VALUES ('155', 'NZ', '新西蘭', 'NEW ZEALAND');
INSERT INTO `country` VALUES ('156', 'OM', '阿曼', 'OMAN');
INSERT INTO `country` VALUES ('157', 'PA', '巴拿馬', 'PANAMA');
INSERT INTO `country` VALUES ('158', 'PE', '秘魯', 'PERU');
INSERT INTO `country` VALUES ('159', 'PF', '法屬波利尼西亞', 'FRENCH POLYNESIA');
INSERT INTO `country` VALUES ('160', 'PG', '巴布亞新幾內亞', 'PAPUA NEW GUINEA');
INSERT INTO `country` VALUES ('161', 'PH', '菲律賓', 'PHILIPPINES');
INSERT INTO `country` VALUES ('162', 'PK', '巴基斯坦', 'PAKISTAN');
INSERT INTO `country` VALUES ('163', 'PL', '波蘭', 'POLAND');
INSERT INTO `country` VALUES ('164', 'PM', '聖皮埃爾和密克隆群島', 'SAINT PIERRE AND MIQUELON');
INSERT INTO `country` VALUES ('165', 'PN', '皮特凱恩島', 'PITCAIRN');
INSERT INTO `country` VALUES ('166', 'PR', '波多黎各', 'PUERTO RICO');
INSERT INTO `country` VALUES ('167', 'PT', '葡萄牙', 'PORTUGAL');
INSERT INTO `country` VALUES ('168', 'PY', '巴拉圭', 'PARAGUAY');
INSERT INTO `country` VALUES ('169', 'QA', '卡塔爾', 'QATAR');
INSERT INTO `country` VALUES ('170', 'RE', '留尼汪島', 'REUNION');
INSERT INTO `country` VALUES ('171', 'RO', '羅馬尼亞', 'ROMANIA');
INSERT INTO `country` VALUES ('172', 'RS', '塞爾維亞', 'SERBIA');
INSERT INTO `country` VALUES ('173', 'RU', '俄羅斯 (俄羅斯聯邦)', 'RUSSIAN FEDERATION');
INSERT INTO `country` VALUES ('174', 'RW', '盧旺達', 'RWANDA');
INSERT INTO `country` VALUES ('175', 'SA', '沙地阿拉伯', 'SAUDI ARABIA');
INSERT INTO `country` VALUES ('176', 'SB', '所羅門群島', 'SOLOMON ISLANDS');
INSERT INTO `country` VALUES ('177', 'SC', '塞舌爾', 'SEYCHELLES');
INSERT INTO `country` VALUES ('178', 'SD', '蘇丹', 'SUDAN');
INSERT INTO `country` VALUES ('179', 'SE', '瑞典', 'SWEDEN');
INSERT INTO `country` VALUES ('180', 'SG', '新加坡', 'SINGAPORE');
INSERT INTO `country` VALUES ('181', 'SH', '聖赫勒拿島', 'SAINT HELENA');
INSERT INTO `country` VALUES ('182', 'SI', '斯洛文尼亞', 'SLOVENIA');
INSERT INTO `country` VALUES ('183', 'SJ', '斯匹次卑爾根群島', 'SPITSBERGEN(SVALBARD)');
INSERT INTO `country` VALUES ('184', 'SK', '斯洛伐克', 'SLOVAK REPUBLIC');
INSERT INTO `country` VALUES ('185', 'SL', '塞拉里昂', 'SIERRA LEONE');
INSERT INTO `country` VALUES ('186', 'SM', '聖馬力諾', 'SAN MARINO');
INSERT INTO `country` VALUES ('187', 'SN', '塞內加爾', 'SENEGAL');
INSERT INTO `country` VALUES ('188', 'SO', '索馬里', 'SOMALIA');
INSERT INTO `country` VALUES ('189', 'SR', '蘇里南', 'SURINAME');
INSERT INTO `country` VALUES ('190', 'ST', '聖多美和普林西比', 'SAO TOME AND PRINCIPE');
INSERT INTO `country` VALUES ('191', 'SV', '薩爾瓦多', 'EL SALVADOR');
INSERT INTO `country` VALUES ('192', 'SY', '阿拉伯敘利亞共和國 (敘利亞)', 'SYRIAN ARAB REPUBLIC');
INSERT INTO `country` VALUES ('193', 'SZ', '斯威士蘭', 'SWAZILAND');
INSERT INTO `country` VALUES ('194', 'TC', '特克斯和凱科斯群島', 'TURKS AND CAICOS ISLANDS');
INSERT INTO `country` VALUES ('195', 'TD', '乍得', 'CHAD');
INSERT INTO `country` VALUES ('196', 'TG', '多哥', 'TOGO');
INSERT INTO `country` VALUES ('197', 'TH', '泰國', 'THAILAND');
INSERT INTO `country` VALUES ('198', 'TJ', '塔吉克', 'TAJIKISTAN');
INSERT INTO `country` VALUES ('199', 'TM', '土庫曼', 'TURKMENISTAN');
INSERT INTO `country` VALUES ('200', 'TN', '突尼斯', 'TUNISIA');
INSERT INTO `country` VALUES ('201', 'TO', '湯加', 'TONGA');
INSERT INTO `country` VALUES ('202', 'TP', '東帝汶', 'EAST TIMOR A)');
INSERT INTO `country` VALUES ('203', 'TR', '土耳其', 'TURKEY');
INSERT INTO `country` VALUES ('204', 'TT', '千里達和多巴哥', 'TRINIDAD AND TOBAGO');
INSERT INTO `country` VALUES ('205', 'TV', '圖瓦盧', 'TUVALU');
INSERT INTO `country` VALUES ('206', 'TW', '台灣', 'TAIWAN');
INSERT INTO `country` VALUES ('207', 'TZ', '坦桑尼亞', 'TANZANIA');
INSERT INTO `country` VALUES ('208', 'UA', '烏克蘭', 'UKRAINE');
INSERT INTO `country` VALUES ('209', 'UG', '烏干達', 'UGANDA');
INSERT INTO `country` VALUES ('210', 'US', '美國', 'UNITED STATES');
INSERT INTO `country` VALUES ('211', 'UY', '烏拉圭', 'URUGUAY');
INSERT INTO `country` VALUES ('212', 'UZ', '烏茲別克', 'UZBEKISTAN');
INSERT INTO `country` VALUES ('213', 'VA', '梵蒂岡', 'VATICAN CITY STATE (HOLY SEE)');
INSERT INTO `country` VALUES ('214', 'VC', '聖文森特和格林納丁斯', 'SAINT VINCENT AND THE GRENADINES');
INSERT INTO `country` VALUES ('215', 'VE', '委內瑞拉', 'VENEZUELA');
INSERT INTO `country` VALUES ('216', 'VG', '托爾托拉島(英屬處女群島)', 'TORTOLA (BRITISH VIRGIN ISLANDS)');
INSERT INTO `country` VALUES ('217', 'VI', '美屬處女群島', 'VIRGIN ISLANDS (U.S.)');
INSERT INTO `country` VALUES ('218', 'VN', '越南', 'VIET NAM');
INSERT INTO `country` VALUES ('219', 'VU', '瓦努阿圖', 'VANUATU');
INSERT INTO `country` VALUES ('220', 'WF', '瓦利斯群島和富圖納群島', 'WALLIS AND FUTUNA ISLANDS');
INSERT INTO `country` VALUES ('221', 'WS', '西薩摩亞', 'SAMOA, WESTERN');
INSERT INTO `country` VALUES ('222', 'XA', '加那利群島', 'CANARY ISLANDS');
INSERT INTO `country` VALUES ('223', 'XB', '特里斯坦 - 達庫尼亞島', 'TRISTAN DA CUNHA');
INSERT INTO `country` VALUES ('224', 'XD', '阿森松', 'ASCENSION');
INSERT INTO `country` VALUES ('225', 'XE', '加沙及汗尤尼斯', 'GAZA AND KHAN YUNIS');
INSERT INTO `country` VALUES ('226', 'XF', '科西嘉島', 'CORSICA');
INSERT INTO `country` VALUES ('227', 'XG', '北非西班牙屬土', 'SPANISH TERRITORIES  OF N. AFRICA');
INSERT INTO `country` VALUES ('228', 'XH', '亞速爾', 'AZORES');
INSERT INTO `country` VALUES ('229', 'XI', '馬德拉', 'MADEIRA');
INSERT INTO `country` VALUES ('230', 'XJ', '巴利阿里群島', 'BALEARIC ISLANDS');
INSERT INTO `country` VALUES ('231', 'XK', '加羅林群島', 'CAROLINE ISLANDS');
INSERT INTO `country` VALUES ('232', 'XL', '新西蘭屬土島嶼', 'NEW ZEALAND ISLANDS TERRITORIES');
INSERT INTO `country` VALUES ('233', 'XM', '威克島', 'WAKE ISLAND');
INSERT INTO `country` VALUES ('234', 'XO', '科索夫', 'KOSOVO');
INSERT INTO `country` VALUES ('235', 'YE', '也門', 'YEMEN (REPUBLIC OF)');
INSERT INTO `country` VALUES ('236', 'ZA', '南非', 'SOUTH AFRICA');
INSERT INTO `country` VALUES ('237', 'ZM', '贊比亞', 'ZAMBIA');
INSERT INTO `country` VALUES ('238', 'ZW', '津巴布韋', 'ZIMBABWE');
INSERT INTO `country` VALUES ('239', 'ZH', '中国', 'China');
INSERT INTO `country` VALUES ('240', 'BR', '巴西', 'Brazil');

-- ----------------------------
-- Table structure for data_auth
-- ----------------------------
DROP TABLE IF EXISTS `data_auth`;
CREATE TABLE `data_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `orgId` bigint(20) NOT NULL,
  `orgName` varchar(64) DEFAULT NULL,
  `type` tinyint(3) NOT NULL COMMENT '类别，1-客户，2-客户机构，3-客户机构部门，4-邮局，5-邮局机构，6-邮局机构部门',
  `code` varchar(255) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_auth
-- ----------------------------
INSERT INTO `data_auth` VALUES ('1', '1', 'EST组织架构', '0', null, '2016-06-06 15:31:08');
INSERT INTO `data_auth` VALUES ('2', '2', '客户', '1', null, '2016-06-06 15:31:08');
INSERT INTO `data_auth` VALUES ('3', '3', '邮局', '4', null, '2016-06-06 15:31:08');
INSERT INTO `data_auth` VALUES ('4', '4', '马邮', '5', null, '2016-06-14 16:48:07');
INSERT INTO `data_auth` VALUES ('5', '5', '泰邮', '5', null, '2016-06-14 16:48:07');
INSERT INTO `data_auth` VALUES ('6', '6', '巴邮', '5', null, '2016-06-14 16:48:07');
INSERT INTO `data_auth` VALUES ('7', '7', '华邮', '5', null, '2016-06-14 16:48:07');
INSERT INTO `data_auth` VALUES ('8', '8', '马邮-VP', '6', null, '2016-06-14 16:51:52');
INSERT INTO `data_auth` VALUES ('9', '9', '马邮-SVP', '6', null, '2016-06-14 16:51:52');
INSERT INTO `data_auth` VALUES ('10', '10', '泰邮', '6', null, '2016-06-14 16:51:52');
INSERT INTO `data_auth` VALUES ('11', '11', '巴邮-马尼拉', '6', null, '2016-06-14 16:51:52');
INSERT INTO `data_auth` VALUES ('12', '12', '巴邮-巴厘岛', '6', null, '2016-06-14 16:51:52');
INSERT INTO `data_auth` VALUES ('13', '13', '巴邮-普吉岛', '6', null, '2016-06-14 16:51:52');
INSERT INTO `data_auth` VALUES ('14', '14', '华邮', '6', null, '2016-06-14 16:51:53');
INSERT INTO `data_auth` VALUES ('15', '15', '顺友', '2', null, '2016-06-14 16:54:05');
INSERT INTO `data_auth` VALUES ('16', '16', '深圳处理中心', '3', null, '2016-06-14 16:54:05');

-- ----------------------------
-- Table structure for detail_list
-- ----------------------------
DROP TABLE IF EXISTS `detail_list`;
CREATE TABLE `detail_list` (
  `postoffice` varchar(127) DEFAULT NULL,
  `accountNo` varchar(127) DEFAULT NULL,
  `transportLine` varchar(127) DEFAULT NULL,
  `ppiNo` varchar(127) DEFAULT NULL,
  `postofficeAddr` varchar(255) DEFAULT NULL,
  `serviceType` varchar(8) DEFAULT NULL,
  `airwayBillNo` varchar(127) DEFAULT NULL,
  `dispatchType` varchar(8) DEFAULT NULL,
  `truckingNo` varchar(127) DEFAULT NULL,
  `truckingNoId` bigint(20) DEFAULT '-1',
  `payMode` varchar(8) DEFAULT NULL,
  `estimateBagNum` decimal(19,6) DEFAULT NULL,
  `estimateTotalWeight` decimal(19,6) DEFAULT NULL,
  `actualBagNum` decimal(19,6) DEFAULT NULL,
  `actualTotalWeight` decimal(19,6) DEFAULT NULL,
  `dispatchDate` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `estimateArrivceDate` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `actualArrivceDate` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `dispatchNo` varchar(127) DEFAULT NULL COMMENT '主键',
  `customerName` varchar(127) DEFAULT NULL COMMENT '上传人机构名称',
  `customerNo` varchar(127) DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `statusTime` timestamp NULL DEFAULT NULL COMMENT '状态时间',
  `countryCode` varchar(1024) DEFAULT NULL,
  `createPerson` varchar(127) DEFAULT NULL COMMENT '创建人',
  `addWho` varchar(127) DEFAULT NULL,
  `addDate` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `updateWho` varchar(127) DEFAULT NULL,
  `updateDate` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `jgOrgId` bigint(20) DEFAULT NULL COMMENT '机构id',
  `bmOrgId` bigint(20) DEFAULT NULL COMMENT '部门id',
  `cJgOrgId` bigint(20) DEFAULT NULL COMMENT '客户机构Id',
  `cBmOrgId` bigint(20) DEFAULT NULL COMMENT '客户部门Id',
  `postofficeEnName` varchar(127) DEFAULT NULL COMMENT '邮局英文名',
  `submitDate` timestamp NULL DEFAULT NULL COMMENT '提交日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of detail_list
-- ----------------------------

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `dispatchDate` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '出发日期',
  `postoffice` varchar(127) DEFAULT NULL,
  `transportLine` varchar(127) DEFAULT NULL,
  `customerNo` varchar(127) DEFAULT NULL COMMENT '账户编号',
  `dispatchNo` varchar(127) DEFAULT NULL,
  `dispatchType` varchar(8) DEFAULT NULL,
  `lockedBagNo` varchar(127) DEFAULT NULL,
  `ppiNo` varchar(127) DEFAULT NULL,
  `airwayBillNo` varchar(127) DEFAULT NULL,
  `truckingNo` varchar(127) DEFAULT NULL,
  `eta` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `referenceId` varchar(127) DEFAULT NULL,
  `bagNo` varchar(127) DEFAULT NULL,
  `shipperName` varchar(255) DEFAULT NULL,
  `shipperAddress1` varchar(500) DEFAULT NULL,
  `shipperAddress2` varchar(500) DEFAULT NULL,
  `shipperCity` varchar(500) DEFAULT NULL,
  `shipperState` varchar(500) DEFAULT NULL,
  `shipperPostalCode` varchar(127) DEFAULT NULL,
  `shipperCountryCode` varchar(127) DEFAULT NULL,
  `receiverAddress1` varchar(500) DEFAULT NULL,
  `receiverAddress2` varchar(500) DEFAULT NULL,
  `receiverCity` varchar(255) DEFAULT NULL,
  `receiverState` varchar(255) DEFAULT NULL,
  `receiverPostcode` varchar(127) DEFAULT NULL,
  `receiverCountryCode` varchar(8) DEFAULT NULL,
  `receiverName` varchar(255) DEFAULT NULL,
  `receiverPhone` varchar(127) DEFAULT NULL,
  `receiverEmail` varchar(127) DEFAULT NULL,
  `itemDescription` varchar(500) DEFAULT NULL,
  `qty` decimal(19,6) DEFAULT NULL,
  `weight` decimal(19,6) DEFAULT NULL,
  `length` decimal(19,6) DEFAULT NULL,
  `height` decimal(19,6) DEFAULT NULL,
  `width` decimal(19,6) DEFAULT NULL,
  `itemValue` decimal(19,6) DEFAULT NULL,
  `referenceIdentificationB` varchar(255) DEFAULT NULL,
  `terms` varchar(127) DEFAULT NULL,
  `cn35` varchar(127) DEFAULT NULL,
  `cn38` varchar(127) DEFAULT NULL,
  `countryCode` varchar(1024) DEFAULT NULL,
  `addWho` varchar(127) DEFAULT NULL,
  `addDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updateWho` varchar(127) DEFAULT NULL,
  `updateDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `postofficeEnName` varchar(127) DEFAULT NULL COMMENT '邮局英文名',
  `sealNo` varchar(15) DEFAULT NULL COMMENT '扎袋数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------

-- ----------------------------
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parentId` bigint(20) NOT NULL COMMENT '父机构ID',
  `name` varchar(50) DEFAULT NULL COMMENT '机构名',
  `ename` varchar(50) DEFAULT NULL COMMENT '英文名称',
  `no` varchar(12) DEFAULT NULL COMMENT '机构代码',
  `type` tinyint(3) NOT NULL COMMENT '机构类型,0-邮局，1-客户',
  `level` tinyint(3) NOT NULL COMMENT '级别，0-组织架构，1-客户/邮局，2-机构，3-部门',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态',
  `creater` bigint(20) DEFAULT NULL COMMENT '添加人',
  `createrName` varchar(64) DEFAULT NULL COMMENT '添加人用户名',
  `isTransport` bit(1) DEFAULT NULL COMMENT '是否转运线',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `phoneNum` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `createDate` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `updateDate` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of org
-- ----------------------------
INSERT INTO `org` VALUES ('1', '0', 'EST组织架构', 'EST', '001', '-1', '0', '1', '0', '', '\0', '', '', '2016-06-13 15:15:24', '2016-05-16 17:57:22');
INSERT INTO `org` VALUES ('2', '1', '客户', 'Client', '002', '1', '1', '1', '0', '', '\0', '', '', '2016-06-03 19:14:15', '2016-05-16 17:57:22');
INSERT INTO `org` VALUES ('3', '1', '邮局', 'Post Office', '003', '0', '1', '1', '0', '', '\0', '', '', '2016-06-13 15:15:22', '2016-05-16 17:57:22');
INSERT INTO `org` VALUES ('4', '3', '马邮', 'MY', 'MY', '0', '2', '1', '0', '', '\0', '', '', '2016-06-13 14:35:12', '2016-06-13 14:35:12');
INSERT INTO `org` VALUES ('5', '3', '泰邮', 'TH', 'TH', '0', '2', '1', '0', '', '\0', '', '', '2016-06-13 14:37:48', '2016-06-13 14:37:48');
INSERT INTO `org` VALUES ('6', '3', '巴邮', 'PY', 'PY', '0', '2', '1', '0', '', '\0', '', '', '2016-06-13 14:40:30', '2016-06-13 14:40:30');
INSERT INTO `org` VALUES ('7', '3', '华邮', 'TW', 'TW', '0', '2', '1', '0', '', '\0', '', '', '2016-06-13 14:41:50', '2016-06-13 14:41:50');
INSERT INTO `org` VALUES ('8', '4', '马邮-VP', 'MYVP', 'MY01', '0', '3', '1', '0', '', '\0', '', '', '2016-06-13 14:48:21', '2016-06-13 14:48:21');
INSERT INTO `org` VALUES ('9', '4', '马邮-SVP', 'MYSVP', 'MY02', '0', '3', '1', '0', '', '\0', '', '', '2016-06-13 14:50:06', '2016-06-13 14:50:06');
INSERT INTO `org` VALUES ('10', '5', '泰邮', 'THTY', 'TH01', '0', '3', '1', '0', '', '\0', '', '', '2016-06-13 14:57:12', '2016-06-13 14:57:12');
INSERT INTO `org` VALUES ('11', '6', '巴邮-马尼拉', 'PYMNL', 'PY01', '0', '3', '1', '0', '', '\0', '', '', '2016-06-13 15:04:10', '2016-06-13 15:04:10');
INSERT INTO `org` VALUES ('12', '6', '巴邮-巴厘岛', 'PYBLD', 'PY02', '0', '3', '1', '0', '', '\0', '', '', '2016-06-13 15:05:21', '2016-06-13 15:05:07');
INSERT INTO `org` VALUES ('13', '6', '巴邮-普吉岛', 'PYPJD', 'PY03', '0', '3', '1', '0', '', '\0', '', '', '2016-06-13 16:52:32', '2016-06-13 15:11:04');
INSERT INTO `org` VALUES ('14', '7', '华邮', 'TWYG', 'TW01', '0', '3', '1', '0', '', '\0', '', '', '2016-06-13 16:52:52', '2016-06-13 15:14:29');
INSERT INTO `org` VALUES ('15', '2', '顺友', 'SY', 'JG0000001', '1', '2', '1', '0', null, '\0', null, null, '2016-06-14 17:15:40', '2016-06-14 15:29:28');
INSERT INTO `org` VALUES ('16', '15', '深圳处理中心', 'SZCenter', 'BM0000001', '1', '3', '1', '0', null, '\0', null, null, '2016-06-14 15:46:44', '2016-06-14 15:46:47');

-- ----------------------------
-- Table structure for package
-- ----------------------------
DROP TABLE IF EXISTS `package`;
CREATE TABLE `package` (
  `packageNo` varchar(127) DEFAULT NULL COMMENT '邮袋编号',
  `dispatchType` varchar(8) DEFAULT NULL COMMENT '邮寄类型',
  `estimatePackageNum` decimal(19,6) DEFAULT NULL COMMENT '预报总包裹数',
  `actualPackageNum` decimal(19,6) DEFAULT NULL COMMENT '实际总包裹数',
  `estimatePackageWeight` decimal(19,6) DEFAULT NULL COMMENT '邮袋预报总重量',
  `actualPackageWeight` decimal(19,6) DEFAULT NULL COMMENT '邮袋实际总重量',
  `inputDate` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '录入重量时间',
  `errorValue` decimal(19,6) DEFAULT NULL COMMENT '误差值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `dispatchNo` varchar(127) DEFAULT NULL COMMENT '批次号',
  `countryCode` varchar(1024) DEFAULT NULL COMMENT '目的国代码',
  `addWho` varchar(127) DEFAULT NULL COMMENT '添加人',
  `addDate` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '添加时间',
  `updateWho` varchar(127) DEFAULT NULL COMMENT '修改人',
  `updateDate` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `serviceType` varchar(8) DEFAULT NULL COMMENT '服务类型',
  `customerName` varchar(127) DEFAULT NULL COMMENT '客户名称',
  `customerNo` varchar(127) DEFAULT NULL COMMENT '客户编号',
  `cn35` varchar(127) DEFAULT NULL COMMENT 'cn35',
  `cn38` varchar(127) DEFAULT NULL,
  `postoffice` varchar(127) DEFAULT NULL COMMENT '邮局',
  `postofficeEnName` varchar(127) DEFAULT NULL COMMENT '邮局英文名',
  `sealNo` varchar(15) DEFAULT NULL COMMENT '扎袋数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of package
-- ----------------------------

-- ----------------------------
-- Table structure for package_operate_info
-- ----------------------------
DROP TABLE IF EXISTS `package_operate_info`;
CREATE TABLE `package_operate_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dispatchNo` varchar(127) DEFAULT NULL,
  `bagNo` varchar(127) DEFAULT NULL,
  `referenceId` varchar(127) DEFAULT NULL,
  `operateType` tinyint(3) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `type` tinyint(3) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of package_operate_info
-- ----------------------------

-- ----------------------------
-- Table structure for post_client
-- ----------------------------
DROP TABLE IF EXISTS `post_client`;
CREATE TABLE `post_client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `postId` bigint(20) NOT NULL COMMENT '邮局Id',
  `postName` varchar(50) DEFAULT NULL COMMENT '邮局名称',
  `accountNo` varchar(30) NOT NULL,
  `clientId` bigint(20) NOT NULL COMMENT '客户Id',
  `clientName` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `ppiNo` varchar(50) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `creater` bigint(20) DEFAULT NULL COMMENT '创建人',
  `createrName` varchar(50) DEFAULT NULL COMMENT '创建人名称',
  `createDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `updateDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_client
-- ----------------------------

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(127) DEFAULT NULL COMMENT '资源名称',
  `ename` varchar(127) DEFAULT NULL COMMENT '资源英文名称',
  `type` varchar(20) DEFAULT NULL COMMENT '资源类型（按钮，目录）',
  `pid` bigint(20) DEFAULT NULL COMMENT '父资源ID',
  `pids` varchar(50) DEFAULT NULL COMMENT '父资源ids',
  `url` varchar(100) DEFAULT NULL COMMENT '资源URL',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `icon` varchar(20) DEFAULT NULL COMMENT '图标',
  `createId` bigint(20) DEFAULT NULL,
  `createName` varchar(50) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `userType` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO `resources` VALUES ('0', '系统管理', 'Systems Management', 'menu', null, null, '#', null, null, null, null, '2016-06-14 15:58:48', 'admin');
INSERT INTO `resources` VALUES ('1', '客户预报清单', 'Client Pre DetailList', 'menu', '0', null, '#', '1', 'icon-cogs', null, null, '2016-06-14 15:09:26', 'client');
INSERT INTO `resources` VALUES ('2', '邮局预报清单', 'Reverse Alert List', 'menu', '0', null, '#', '2', 'icon-dashboard', null, null, '2016-06-24 16:05:08', 'post');
INSERT INTO `resources` VALUES ('3', '组织机构', 'Organization', 'menu', '0', null, '#', '3', 'icon-group', null, null, '2016-05-27 15:43:58', 'admin');
INSERT INTO `resources` VALUES ('4', '客户信息维护', 'Customer Info', 'menu', '0', null, '#', '4', 'icon-comment-alt', null, null, '2016-05-27 15:44:08', 'client,admin');
INSERT INTO `resources` VALUES ('5', '邮局信息维护', 'Post Office Info', 'menu', '0', null, '#', '5', 'icon-envelope', null, null, '2016-05-27 15:44:15', 'post,admin');
INSERT INTO `resources` VALUES ('6', '代码管理', 'Code', 'menu', '0', null, '#', '6', 'icon-flag-checkered', null, null, '2016-05-27 15:44:23', 'admin');
INSERT INTO `resources` VALUES ('7', '日志管理', 'Log', 'menu', '0', null, '#', '7', 'icon-rss-sign', null, null, '2016-05-27 15:44:27', 'admin');
INSERT INTO `resources` VALUES ('8', '新增', 'Add Pre Alert', 'menu', '1', null, '/client/toAddOrder.html', '1', null, null, null, '2016-05-27 15:44:41', 'client');
INSERT INTO `resources` VALUES ('9', '预报中列表', 'Pre Alert In Progress', 'menu', '1', null, '/client/toOrderList.html', '2', null, null, null, '2016-06-01 10:39:41', 'client');
INSERT INTO `resources` VALUES ('10', '历史列表', 'Pre Alert History', 'menu', '1', null, '/client/toHistoryOrderList.html', '3', null, null, null, '2016-06-01 10:39:44', 'client');
INSERT INTO `resources` VALUES ('11', '待处理清单', 'Reverse Alert', 'menu', '2', null, '/post/pendingList.html', '1', null, null, null, '2016-06-24 16:05:44', 'post');
INSERT INTO `resources` VALUES ('12', '处理中清单', 'CN Process', 'menu', '2', null, '/post/doingList.html', '2', null, null, null, '2016-06-24 16:06:11', 'post');
INSERT INTO `resources` VALUES ('13', '已完成清单', 'History', 'menu', '2', null, '/post/finishList.html', '3', null, null, null, '2016-06-24 16:06:32', 'post');
INSERT INTO `resources` VALUES ('14', '机构管理', 'Organization', 'menu', '3', null, '/org/list.html', '1', null, null, null, '2016-05-27 15:45:37', 'admin');
INSERT INTO `resources` VALUES ('15', '人员管理', 'Personnel', 'menu', '3', null, '/estmanager/user.html', '2', null, null, null, '2016-05-27 15:45:55', 'admin');
INSERT INTO `resources` VALUES ('16', '操作权限管理', 'Operating Rights', 'menu', '3', null, '/resources/list.html', '3', null, null, null, '2016-05-27 15:45:57', 'admin');
INSERT INTO `resources` VALUES ('17', '数据权限管理', 'Data Access', 'menu', '3', null, '/estmanager/dataAuth.html', '4', null, null, null, '2016-05-27 15:46:00', 'admin');
INSERT INTO `resources` VALUES ('18', '基本信息', 'Basic Info', 'menu', '4', null, '/estmanager/client/basic.html', '1', null, null, null, '2016-05-27 15:46:15', 'client,admin');
INSERT INTO `resources` VALUES ('19', '基本信息', 'Basic Info', 'menu', '5', null, '/org/post/basic.html', '1', null, null, null, '2016-05-30 16:16:37', 'post,admin');
INSERT INTO `resources` VALUES ('20', '部门信息', 'Department Info', 'menu', '5', null, '/org/post/depart.html', '2', null, null, null, '2016-05-27 15:46:50', 'post,admin');
INSERT INTO `resources` VALUES ('21', '国家二字代码', 'Country Code', 'menu', '6', null, '/country/list.html', '1', null, null, null, '2016-05-27 15:46:55', 'admin');
INSERT INTO `resources` VALUES ('22', 'excel上传', null, 'button', '8', null, '/client/uploadExcel.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('23', '查询上传清单列表', null, 'button', '9', null, '/client/list/getFirstDetailList.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('24', '删除清单列表', null, 'button', '9', null, '/client/list/deleteDetailListByDispatchNo.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('25', '清单提交', null, 'button', '9', null, '/client/list/submitDetailList.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('26', '获取邮包列表', null, 'button', '9', null, '/post/package.html', '4', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('27', '更新邮包', null, 'button', '9', null, '/client/updatePackageInfo.html', '5', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('28', '查询历史清单列表', null, 'button', '10', null, '/client/list/getCommitDetailList.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('29', '删除历史清单列表', null, 'button', '10', null, '/client/list/deleteDetailListByDispatchNo.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('30', '下载历史清单', null, 'button', '10', null, '/client/list/downloadDetailList.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('31', '获取邮包列表', null, 'button', '10', null, '/post/package.html', '4', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('32', '查询待处理列表', null, 'button', '11', null, '/post/list/pending.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('33', '获取邮包', null, 'button', '11', null, '/post/package.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('34', '输入重量', null, 'button', '11', null, '/post/inputWeigt.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('35', '查询处理列表', null, 'button', '12', null, '/post/list/doing.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('36', '获取邮包', null, 'button', '12', null, '/post/package.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('37', '导出excel', null, 'button', '12', null, '/post/exportExcel.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('38', '批量更新明细', null, 'button', '12', null, '/post/finishDetailBatch.html', '4', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('39', '查询权限树', null, 'button', '14', null, '/dataAuth/orgTree.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('40', '查询机构', null, 'button', '14', null, '/org/query.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('41', '添加机构', null, 'button', '14', null, '/org/add.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('42', '更新机构', null, 'button', '14', null, '/org/update.html', '5', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('43', '删除机构', null, 'button', '14', null, '/org/delete.html', '6', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('44', '查询权限树', null, 'button', '15', null, '/dataAuth/orgTree.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('45', '查询用户', null, 'button', '15', null, '/user/query.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('46', '添加用户', null, 'button', '15', null, '/user/add.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('47', '更新用户', null, 'button', '15', null, '/user/update.html', '4', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('48', '删除用户', null, 'button', '15', null, '/user/del.html', '5', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('49', '重置密码', null, 'button', '15', null, '/user/resetPassword.html', '6', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('50', '查看权限树', null, 'button', '16', null, '/dataAuth/orgTree.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('51', '更新权限', null, 'button', '16', null, '/resources/update.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('52', '查询权限', null, 'button', '16', null, '/resources/query.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('53', '查询用户', null, 'button', '16', null, '/user/query.html', '4', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('54', '查看机构树', null, 'button', '17', null, '/dataAuth/orgTree.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('55', '获取授权', null, 'button', '17', null, '/dataAuth/auth.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('56', '获取权限树', null, 'button', '17', null, '/dataAuth/authTree.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('57', '查询用户', null, 'button', '17', null, '/user/query.html', '4', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('58', '删除邮局', null, 'button', '18', null, '/org/deletePostClientById.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('59', '获取客户列表', null, 'button', '18', null, '/clientInfo/clientList.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('60', '获取邮局', null, 'button', '18', null, '/org/getPostOfficeByClientId.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('61', '添加客户', null, 'button', '18', null, '/clientInfo/addClient.html', '4', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('62', '更新机构', null, 'button', '18', null, '/org/update.html', '5', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('63', '删除机构', null, 'button', '18', null, '/org/delete.html', '6', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('64', '添加邮局', null, 'button', '18', null, '/clientInfo/addPost.html', '7', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('65', '获取邮局列表', null, 'button', '19', null, '/org/post/list.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('66', '添加部门', null, 'button', '19', null, '/org/depart/add.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('67', '部门管理', null, 'button', '19', null, '/org/post/depart.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('68', '部门管理', null, 'button', '19', null, '/estmanager/post/depart.html', '4', null, null, null, '2016-05-23 18:17:57', null);
INSERT INTO `resources` VALUES ('69', '更新机构', null, 'button', '19', null, '/org/update.html', '5', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('70', '添加部门', null, 'button', '19', null, '/org/depart/delete.html', '6', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('71', '获取部门列表', null, 'button', '20', null, '/org/depart/list.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('72', '更新机构', null, 'button', '20', null, '/org/update.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('73', '删除部门', null, 'button', '20', null, '/org/depart/delete.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('74', '获取航运线', null, 'button', '20', null, '/estmanager/getTrunkingLine.html', '4', null, null, null, '2016-05-23 18:17:57', null);
INSERT INTO `resources` VALUES ('75', '添加航线', null, 'button', '20', null, '/estmanager/addTrunkingLine.html', '5', null, null, null, '2016-05-23 18:17:57', null);
INSERT INTO `resources` VALUES ('76', '更新航线', null, 'button', '20', null, '/estmanager/updateTrunkingLine.html', '6', null, null, null, '2016-05-23 18:17:57', null);
INSERT INTO `resources` VALUES ('77', '删除航线', null, 'button', '20', null, '/estmanager/deleteTrunkingLine.html', '7', null, null, null, '2016-05-23 18:17:57', null);
INSERT INTO `resources` VALUES ('78', '获取代码', null, 'button', '21', null, '/country/countryList.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('79', '添加代码', null, 'button', '21', null, '/country/countryAdd.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('80', '更新代码', null, 'button', '21', null, '/country/countryUpdate.html', '3', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('81', '删除代码', null, 'button', '21', null, '/country/countryDelete.html', '4', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('82', '查询日志列表', null, 'button', '312', null, '/log/logList.html', '1', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('83', '查询机构编号', '', 'button', '18', '', '/org/queryNo.html', '1', '', null, '', '2016-05-31 11:31:00', '');
INSERT INTO `resources` VALUES ('84', '日志管理', 'Log', 'menu', '7', null, '/log/list.html', '1', null, null, null, '2016-05-31 15:18:04', 'admin');
INSERT INTO `resources` VALUES ('85', '跳到明细页面', null, 'button', '9', null, '/client/toOrderDetail.html', '6', null, null, null, '2016-06-14 15:07:10', null);
INSERT INTO `resources` VALUES ('86', '调到历史页面', null, 'button', '10', null, '/client/toHistoryOrderDetail.html', '6', null, null, null, '2016-05-25 12:06:30', null);
INSERT INTO `resources` VALUES ('87', '请求结单数据', null, 'button', '13', null, '/post/list/finish.html', '1', null, null, null, '2016-05-24 17:10:12', null);
INSERT INTO `resources` VALUES ('88', '查询航线', null, 'button', '8', null, '/client/getTrunkingLineListByDepartmentID.html', '4', null, null, null, '2016-05-27 13:58:49', null);
INSERT INTO `resources` VALUES ('89', '请求历史清单中的包裹列表', null, 'button', '10', null, '/client/package.html', '1', null, null, null, '2016-05-24 20:23:09', null);
INSERT INTO `resources` VALUES ('90', '检查批次号', null, 'button', '8', null, '/client/checkDispatchNo.html', '5', null, null, null, '2016-05-25 15:05:40', null);
INSERT INTO `resources` VALUES ('91', '进度条', null, 'button', '8', null, '/client/checkProcess.html', '1', null, null, null, '2016-05-27 11:17:19', null);
INSERT INTO `resources` VALUES ('92', '获取UUID', null, 'button', '8', null, '/client/getUUID.html', null, null, null, null, '2016-05-27 11:17:26', null);
INSERT INTO `resources` VALUES ('93', '查询机构编号', null, 'button', '14', null, '/org/queryNo.html', null, null, null, null, '2016-05-31 11:32:25', null);
INSERT INTO `resources` VALUES ('94', '查询机构编号', null, 'button', '20', null, '/org/queryNo.html', null, null, null, null, '2016-05-31 11:32:42', null);
INSERT INTO `resources` VALUES ('95', '批量录入CN35', null, 'button', '12', null, '/post/inputCN35.html', null, null, null, null, '2016-06-22 16:08:17', null);
INSERT INTO `resources` VALUES ('96', '获取邮包', null, 'button', '13', null, '/post/package.html', '2', null, null, null, '2016-05-22 11:00:00', null);
INSERT INTO `resources` VALUES ('97', '更新航班信息', null, 'button', '10', null, '/client/updateTruckingNo.html', null, null, null, null, '2016-06-20 17:14:21', null);
INSERT INTO `resources` VALUES ('98', '录入CN38', null, 'button', '13', null, '/post/inputCN38.html', null, null, null, null, '2016-06-22 16:08:17', null);
INSERT INTO `resources` VALUES ('99', '清单总览', 'Rverse Alert', 'menu', '2', null, '/post/allList.html', '4', null, null, null, '2016-06-24 15:28:38', 'post');

-- ----------------------------
-- Table structure for trunking_line
-- ----------------------------
DROP TABLE IF EXISTS `trunking_line`;
CREATE TABLE `trunking_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '航线名称',
  `price` decimal(19,4) DEFAULT NULL COMMENT '航线价格',
  `no` varchar(50) DEFAULT NULL COMMENT '航线id',
  `start` varchar(64) DEFAULT NULL COMMENT '航线起点',
  `end` varchar(64) DEFAULT NULL COMMENT '航线终点',
  `isTransport` varchar(4) DEFAULT NULL COMMENT '是否转运',
  `trunkStatus` varchar(4) DEFAULT NULL COMMENT '状态',
  `createName` varchar(50) DEFAULT NULL COMMENT '创建人名字',
  `creater` bigint(20) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updateDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `departmentName` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `departmentID` bigint(20) DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trunking_line
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(64) DEFAULT NULL,
  `salt` char(4) DEFAULT NULL COMMENT '名称',
  `name` varchar(50) DEFAULT NULL,
  `userType` tinyint(3) DEFAULT NULL COMMENT '用户类型，0-邮局，1-客户',
  `userStatus` tinyint(3) DEFAULT NULL COMMENT '用户状态，1-有效，0-无效',
  `status` bit(1) DEFAULT NULL COMMENT '数据状态',
  `title` varchar(50) DEFAULT NULL COMMENT '人员类型,老板、经理、财务、文员、业务人员、司机、仓库人员、客服',
  `no` char(10) DEFAULT NULL,
  `orgId` bigint(20) DEFAULT NULL COMMENT '机构Id',
  `createDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `updateDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `creater` bigint(20) DEFAULT NULL,
  `createrName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'b7ebb54899593452754af0c4af67000a', '234', '管理员', '-1', '1', '', '管理员', 'RY000001', '1', '2016-06-14 15:24:57', '2016-05-16 18:21:26', null, null);
INSERT INTO `user` VALUES ('2', 'szcenter', 'db3b8594e92e858457d19ba480444932', '9797', 'szcenter', '1', '1', '', '老板', 'RY000001', '16', '2016-06-14 15:55:05', '2016-06-14 15:55:05', null, null);

-- ----------------------------
-- Table structure for user_data_auth
-- ----------------------------
DROP TABLE IF EXISTS `user_data_auth`;
CREATE TABLE `user_data_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `dataAuthId` bigint(20) DEFAULT NULL,
  `creater` bigint(20) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_data_auth
-- ----------------------------

-- ----------------------------
-- Table structure for user_login_info
-- ----------------------------
DROP TABLE IF EXISTS `user_login_info`;
CREATE TABLE `user_login_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `type` tinyint(3) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_login_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_resources
-- ----------------------------
DROP TABLE IF EXISTS `user_resources`;
CREATE TABLE `user_resources` (
  `userId` bigint(20) DEFAULT NULL,
  `resourcesId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_resources
-- ----------------------------
INSERT INTO `user_resources` VALUES ('1', '3');
INSERT INTO `user_resources` VALUES ('1', '4');
INSERT INTO `user_resources` VALUES ('1', '5');
INSERT INTO `user_resources` VALUES ('1', '6');
INSERT INTO `user_resources` VALUES ('1', '7');
INSERT INTO `user_resources` VALUES ('1', '14');
INSERT INTO `user_resources` VALUES ('1', '15');
INSERT INTO `user_resources` VALUES ('1', '16');
INSERT INTO `user_resources` VALUES ('1', '17');
INSERT INTO `user_resources` VALUES ('1', '18');
INSERT INTO `user_resources` VALUES ('1', '19');
INSERT INTO `user_resources` VALUES ('1', '20');
INSERT INTO `user_resources` VALUES ('1', '21');
INSERT INTO `user_resources` VALUES ('1', '84');
INSERT INTO `user_resources` VALUES ('2', '1');
INSERT INTO `user_resources` VALUES ('2', '8');
INSERT INTO `user_resources` VALUES ('2', '9');
INSERT INTO `user_resources` VALUES ('2', '10');
