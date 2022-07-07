package com.lagou.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
@RefreshScope
public class YmlPojo {
    @Value("${maqianqian}")
    private String maqianqian;
}
