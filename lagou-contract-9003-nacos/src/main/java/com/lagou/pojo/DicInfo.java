package com.lagou.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * CREATE TABLE `dic_info` (
 *   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
 *   `dict_group_code` varchar(50) DEFAULT NULL COMMENT '字典code',
 *   `dict_group_desc` varchar(200) DEFAULT NULL COMMENT '字典描述',
 *   `dict_value` varchar(100) DEFAULT NULL COMMENT '值',
 *   `dict_value_desc` varchar(1024) DEFAULT NULL COMMENT '值描述',
 *   `create_tlr` bigint(20) DEFAULT NULL,
 *   `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 *   `last_upd_tlr` bigint(20) DEFAULT NULL,
 *   `last_upd_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
 *   `parent_id` varchar(50) DEFAULT NULL COMMENT '父字典code',
 *   PRIMARY KEY (`id`) USING BTREE
 * ) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8 COMMENT='字典表';
 */
@Data
public class DicInfo {
    private Integer id;
    private String dictGroupCode; //字典code
    private String dictGroupDesc; //
    private String doctValue;
    private String dictValueDesc;
    private Integer createTlr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date createDate;
    private Integer lastUpdTlr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date lastUpdDate;
    private String parentId;
}
