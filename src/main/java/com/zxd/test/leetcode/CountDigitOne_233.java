package com.zxd.test.leetcode;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2019-03-18 21:55
 **/
//        233. 数字1的个数（https://leetcode-cn.com/problems/number-of-digit-one/）
//        给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
//
//        示例:
//
//        输入: 13
//        输出: 6
//        解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
public class CountDigitOne_233 {
    public static void main(String[] args){
        System.out.println(countOneByrRecursive(20));
        System.out.println(countOne(824883294));
    }


    /**
     * class_name: countOne
     * param: [n]
     * describe: 递归计算n TODO:数值偏大会导致stackoverflow异常
     * creat_user: CoderZZ
     * creat_date: 2019-03-18
     * creat_time: 22:13
     **/
    private static int countOneByrRecursive (int n){
        if(n==0 || n==1){
            return n;
        }else{
            return f(n) + countOneByrRecursive(n-1);
        }
    }


    /**
     * class_name: countOne
     * param: [n]
     * describe: 非递归方式计算，提交提示“超出时间限制”(36 / 40 个通过测试用例)
     * creat_user: CoderZZ
     * creat_date: 2019-03-18
     * creat_time: 22:44
     **/
    private static int countOne(int n){
        int count = 0;
        for(int i = 0;i<=n;i++){
            int divisor = i; //除数
            int remainder = 0; //余数
            while(divisor > 0){
                if(divisor == 1){
                    count ++;
                }
                if(remainder == 1){
                    count ++;
                }
                remainder = divisor % 10;
                divisor = divisor / 10;
            }
        }
        return count;
    }

    /**
     * class_name: f
     * param: [n]
     * describe: 计算数字n包含1的个数
     * creat_user: CoderZZ
     * creat_date: 2019-03-18
     * creat_time: 22:13
     **/
    private static int f(int n){
        int count = 0;
        int divisor = n; //除数
        int remainder = 0; //余数
        while(divisor > 0){
            if(divisor == 1){
                count ++;
            }
            if(remainder == 1){
                count ++;
            }
            remainder = divisor % 10;
            divisor = divisor / 10;
        }
        return count;
    }



}
