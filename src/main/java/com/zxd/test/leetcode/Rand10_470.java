package com.zxd.test.leetcode;

import java.util.Random;

/**
 * @ClassName Rand10_470
 * @Description TODO
 * @Author xiaodong.zou
 * @Date 2021/9/5 12:20
 * @Version 1.0
 */
//470. 用 Rand7() 实现 Rand10()
//        已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
//
//        不要使用系统的 Math.random() 方法。
//
//
//
//        示例 1:
//
//        输入: 1
//        输出: [7]
//        示例 2:
//
//        输入: 2
//        输出: [8,4]
//        示例 3:
//
//        输入: 3
//        输出: [8,1,10]
//
//
//        提示:
//
//        rand7 已定义。
//        传入参数: n 表示 rand10 的调用次数。
//
//
//        进阶:
//
//        rand7()调用次数的 期望值 是多少 ?
//        你能否尽量少调用 rand7() ?
public class Rand10_470 {

    /**古典概型
     1. 第一次rand7限定[1,6]，判断奇偶性，概率是1/2
     2. 第二次rand7限定[1,5]，概率是1/5
     3. 二者结合可以得出10种概率相同的结果
     */
    public int rand10() {
        int first, second;
        while ((first = rand7()) > 6);
        while ((second = rand7()) > 5);
        return (first&1) == 1 ? second : 5+second;
    }

    public int rand10_1() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    public int rand7(){
        return new Random().nextInt(7)+1;
    }

    public static void main(String[] args) {
        Rand10_470 rand10_470 = new Rand10_470();
        for(int i=0;i<10;i++){
            System.out.println(rand10_470.rand10());
        }
    }
}
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */