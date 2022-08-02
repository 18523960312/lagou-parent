package com.lagou;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * hint进行强制路由
 */
public class MyHint implements HintShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(
            Collection<String> collection,
            HintShardingValue<Long> hintShardingValue) {
        List<String> list = new ArrayList<>();
        for (String datasource : collection) { // 这里指的是配置文件的ds0,ds1两个数据源
            for (Long value : hintShardingValue.getValues()) {
                if(datasource.endsWith(String.valueOf(value % 2))){
                    list.add(datasource);
                }
            }
        }
        return list;
    }
}
