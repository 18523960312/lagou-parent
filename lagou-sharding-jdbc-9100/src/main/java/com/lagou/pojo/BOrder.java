package com.lagou.pojo;

import lombok.Data;

@Data
public class BOrder {
    private Long id;
    private Integer companyId;
    private Integer userId;
    private String name;
}
