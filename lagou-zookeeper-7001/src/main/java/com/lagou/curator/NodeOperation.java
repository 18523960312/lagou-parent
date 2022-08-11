package com.lagou.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class NodeOperation {

    /**
     * 进行创建连接
     * @param args
     */
    public static void main1(String[] args) {
        //第二种方式
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
        CuratorFramework client =CuratorFrameworkFactory.builder()
                .connectString("10.253.130.23:2181")
                .sessionTimeoutMs(5000)
                .sessionTimeoutMs(3000)
                .retryPolicy(retryPolicy)
                .namespace("base")
                .build();
        client.start();
    }

    /**
     * 创建节点
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //第二种方式
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
        CuratorFramework client =CuratorFrameworkFactory.builder()
                .connectString("10.253.130.23:2181")
                .sessionTimeoutMs(5000)
                .sessionTimeoutMs(3000)
                .retryPolicy(retryPolicy)
                .namespace("base")
                .build();
        client.start();

        String s = client.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/curator-persistent", "init".getBytes());
        System.out.println(s);
    }


}
