# miaosha_user
CREATE TABLE miaosha_user (
	id BIGINT ( 20 ) NOT NULL COMMENT "用户ID,手机号码",
	nickname VARCHAR ( 255 ) NOT NULL,
	password VARCHAR ( 32 ) DEFAULT NULL COMMENT 'MD5(MD5(pass明文+固定salt) + salt)',
	salt VARCHAR ( 10 ) DEFAULT NULL,
	head VARCHAR ( 128 ) DEFAULT NULL COMMENT '头像,云存储的ID',
	register_date datetime DEFAULT NULL COMMENT '注册时间',
	last_login_date datetime DEFAULT NULL COMMENT '上次登陆时间',
	login_count INT ( 11 ) DEFAULT '0' COMMENT '登陆次数',
	PRIMARY KEY(id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;


# goods
CREATE TABLE goods(
	id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
	good_name VARCHAR(16) DEFAULT NULL COMMENT '商品名称',
	goods_title VARCHAR(64) DEFAULT NULL COMMENT '商品标题',
	goods_img VARCHAR(64) DEFAULT NULL COMMENT '商品图片',
	goods_detail LONGTEXT COMMENT '商品详情介绍',
	goods_price DECIMAL(10,2) DEFAULT 0.00 COMMENT '商品单价',
	goods_stock INT(11) DEFAULT 0 COMMENT '商品库存，-1表示没有限制',
	PRIMARY KEY(id)
)ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

INSERT INTO goods VALUES(1,'iPhoneX','Apple iPhone X(A1865) 64G 银色 移动联通电信4G手机','/img/iphonex.png','Apple iPhone X(A1865) 64G 银色 移动联通电信4G手机',9999,10),(2,'HuaWeiMate 40','HuaWeiMate10 64G 白色 移动联通电信4G手机','/img/mate10.png','Apple iPhone X(A1865) 64G 银色 移动联通电信4G手机',9999,10);

# miaosha_goods
CREATE TABLE miaosha_goods(
	id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀的商品ID',
	good_id BIGINT(20) DEFAULT NULL COMMENT '商品ID',
	miaosha_price decimal(10,2) COMMENT '秒杀价',
	stock_count int(11) DEFAULT NULL COMMENT '库存数量',
	start_date DATETIME DEFAULT NULL COMMENT '秒杀开始时间',
	end_date DATETIME DEFAULT NULL COMMENT '秒杀结束时间',

	PRIMARY KEY(id)
)ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;


# order_info
create table order_info(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    user_id BIGINT(20) DEFAULT NULL COMMENT '用户ID',
    goods_id BIGINT(20) DEFAULT NULL COMMENT '商品ID',
    delivery_addr_id BIGINT(20) DEFAULT NULL COMMENT '收获地址ID',
    goods_name varchar(16) DEFAULT NULL COMMENT '冗余过来的商品名称',
    goods_count int(11) DEFAULT 0 COMMENT '商品数量',
    goods_price decimal(10,2) DEFAULT 0.00 COMMENT '商品单价',
    order_channel tinyint(4)  DEFAULT 0 COMMENT '1PC 2Android 3IOS',
    status tinyint(4) DEFAULT 0 COMMENT '订单状态:  0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成',
    create_date DATETIME DEFAULT NULL COMMENT '订单创建时间',
    pay_date DATETIME  DEFAULT NULL COMMENT '订单支付时间',
    PRIMARY KEY(id)
)ENGINE=INNODB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;



# miaosha_order
create table miaosha_order(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    user_id BIGINT(20) DEFAULT NULL COMMENT '用户ID',
    order_id BIGINT(20) DEFAULT NULL COMMENT '订单ID',
    goods_id BIGINT(20) DEFAULT NULL COMMENT '商品ID',
    PRIMARY KEY(id)
)ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;


