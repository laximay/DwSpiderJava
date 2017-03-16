#创建数据库

CREATE DATABASE dw_spider;
use dw_spider;
CREATE TABLE cas_prodecut
(
    cas_name VARCHAR(100) NOT NULL COMMENT '化合物英文学名',
    cas_no VARCHAR(50) PRIMARY KEY NOT NULL COMMENT '产品编号',
    synonyms VARCHAR(1000) NOT NULL COMMENT '同义词',
    formula VARCHAR(50) NOT NULL COMMENT '化学公式',
    exact_mass VARCHAR(50) COMMENT '精确质量',
    molecular_weight VARCHAR(50) COMMENT '分子量',
    psa VARCHAR(50),
    logp VARCHAR(50),
    cas_url VARCHAR(500)
);
CREATE TABLE indexs
(
    url VARCHAR(500) PRIMARY KEY NOT NULL COMMENT '索引的链接',
    visited INT(11) COMMENT '是否已经收录'
);