package com.zxd.test.leetcode;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2019-05-28 21:51
 **/
public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
        Queue<Long> queue = new LinkedBlockingQueue(10);
        while(true){
            long tail = System.currentTimeMillis();
            boolean isOfferd = queue.offer(tail);
            if(!isOfferd){
                Long head = queue.peek();
                if(tail - head <= 1000){
                    System.out.println("线程Sleep");
                    Thread.sleep(2000L);
                    System.out.println("TTTTTTTTTTTTTTTTTTTTTTTT");
                    queue.clear();
                }else{
                    Long headNew = queue.poll();
                    queue.offer(tail);
                    System.out.println(":::::::::::::::"+headNew);
                }
            }
            Integer t = new Random().nextInt(200);
            System.out.println(t);
            Thread.sleep(t);
        }
    }
}
