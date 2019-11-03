package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolTest
 * @Description TODO
 * @Author xiaodong.zou
 * @Date 2019/11/3 13:51
 * @Version 1.0
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        final Map<Integer, List<Integer>> testMap = new ConcurrentHashMap<>(16);
        for(int i=0;i<100000;i++){
            int key = i % 10;
            if(testMap.containsKey(key)){
               testMap.get(key).add(i);
            }else{
                List<Integer> integers = new ArrayList<Integer>();
                integers.add(i);
                testMap.put(key,integers);
            }
        }
        ExecutorService threadPool = new ThreadPoolExecutor(10,12,1000L,TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
        for(int i=0;i<10;i++){
            final int finalI = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                    List<Integer> messageList = testMap.get(finalI);
                    for(Integer e:messageList){
                        System.out.println(Thread.currentThread().getName()+"----->"+e);
                    }
                }
            });
        }
    }
}
