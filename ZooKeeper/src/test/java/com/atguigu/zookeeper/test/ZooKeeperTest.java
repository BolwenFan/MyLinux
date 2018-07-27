package com.atguigu.zookeeper.test;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author unclefan
 * @create 2018-07-19 20:04
 */
public class ZooKeeperTest {

    // 获取节点数据
    @Test
    public void test1() throws IOException, KeeperException, InterruptedException {

        //创建Zookeeper对象，建立连接
        ZooKeeper zooKeeper = new ZooKeeper("192.168.27.133:2181", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });

        // 调用Zookeeper对象方法获取指定节点的数据

        // 节点路径
        String path = "/fruit";

        // watch设置为false表示不启用通知机制
        boolean watcher = false;

        // 状态信息通过创建空的Stat对象提供
        Stat stat = new Stat();

        //获取到的数据是字节数组形式，需要加工成String
        byte[] data = zooKeeper.getData(path, watcher, stat);

        String s = new String(data);

        System.out.println(s);

    }

    // 创建节点
    @Test
    public void test2() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.27.133:2181", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });

        //通过常量值获取一个访问控制列表
        ArrayList<ACL> acls = ZooDefs.Ids.OPEN_ACL_UNSAFE;

        //通过CreateMode枚举类型获取节点类型
        CreateMode createMode = CreateMode.PERSISTENT;

        //执行创建节点操作
        String s = zooKeeper.create("/fruit/grape", "grape".getBytes(), acls, createMode);

        System.out.println(s);
    }

    // 更新节点的值
    @Test
    public void test3() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.27.133:2181", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });

        //Zookeeper要求在最新版的基础上修改节点值
        //如果不确定一个具体版本，则使用-1适配各种具体版本
        int version = -1;
        Stat stat = zooKeeper.setData("/fruit/grape", "bbb".getBytes(), version);

        System.out.println(stat);
    }

    // 观察者，一次性的，watcher用一次就无效
    @Test
    public void test4() throws IOException, KeeperException, InterruptedException {

        //创建Zookeeper对象，建立连接
        ZooKeeper zooKeeper = new ZooKeeper("192.168.27.133:2181", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });


        //指定一个具体的观察者对象，实现对指定节点的监控
        Watcher watcher = new Watcher() {
            //接收到Zookeeper的通知后，会执行process()方法
            @Override
            public void process(WatchedEvent event) {
                System.out.println("zookeeper那边改变了");
            }
        };

        //获取节点上当前值的同时，在节点上放置一个观察者对象，开始监控
        byte[] data = zooKeeper.getData("/fruit", watcher, new Stat());

        System.out.println(new String(data));

        //为了能够接收通知，当前程序需要一直运行
        while (true) {
            Thread.sleep(3000);
            System.out.println("我还活着");
        }
    }

    // 观察者，持续观察
    @Test
    public void test5() throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.27.133:2181", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });

        //核心逻辑：前面的Watcher失效后，通过方法的递归调用，设置一个新的Watcher
        getDataOwn(zooKeeper);

        //为了能够接收通知，当前程序需要一直运行
        while (true) {
            Thread.sleep(3000);
            System.err.println("我还活着***************************************");
        }
    }

    public void getDataOwn(ZooKeeper zooKeeper) {

        String resutl = null;

        try {
            byte[] data = zooKeeper.getData("/fruit", new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    //方法递归调用自己
                    getDataOwn(zooKeeper);
                }
            }, new Stat());

            resutl = new String(data);

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("当前节点值="+resutl);
    }
}
