package com.lagou.zkclient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

public class NodeOperation {

    public static void main1(String[] args) throws InterruptedException {
        //与zk进行关联
        ZkClient zkClient = new ZkClient("10.253.130.23:2181");
        // 创建持久化节点
        zkClient.createPersistent("/zkclient-persistent", "123");
        //进行监控子节点
        zkClient.subscribeChildChanges("/zkclient-persistent", new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println(s+"==="+list.toString());
            }
        });
        //创建临时节点
        zkClient.createEphemeral("/zkclient-persistent/t1", "t1");

        Thread.sleep(Integer.MAX_VALUE);
    }

    public static void main(String[] args) throws InterruptedException {
        //与zk进行关联
        ZkClient zkClient = new ZkClient("10.253.130.23:2181");
        //进行创建节点
        zkClient.createPersistent("/jjj", "big");
        //进行监控内容变化的操作
        zkClient.subscribeDataChanges("/jjj", new IZkDataListener() {
            /**
             * @param s : path
             * @param o : data
             * @throws Exception
             */
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println(s+";"+o);
            }

            /**
             * 表示删除数据的
             * @param s : path
             * @throws Exception
             */
            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println(s);
            }
        });

        zkClient.writeData("/jjj", " so big");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
