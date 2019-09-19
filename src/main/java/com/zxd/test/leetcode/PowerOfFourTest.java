package com.zxd.test.leetcode;

//给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
//
//        示例 1:
//
//        输入: 16
//        输出: true
//        示例 2:
//
//        输入: 5
//        输出: false
//        进阶：
//        你能不使用循环或者递归来完成本题吗？
public class PowerOfFourTest {
    public static boolean isPowerOfFour(int num) {
        if((num != 1 && num % 4 != 0) || num == 0){
            return false;
        }
        if(num == 1){
            return true;
        }
        int value = num >>> 2;
        while(true){
            if(value != 1 && value % 4 != 0){
                return false;
            }else if(value == 1){
                return true;
            }else{
                value = value >>> 2;
            }
        }
    }

    public static boolean isPowerOfFour2(int num){
        while ( (num != 0)  && (num % 4 == 0)) {
            num = num >>> 2;
        }
        return num == 1;
    }

    public static boolean isPowerOfFour3(int num){
        if(num < 0){
            return false;
        }
        if((num & (num -1)) != 0){
            return false;
        }
        if((num & 0x55555555) == num){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(PowerOfFourTest.isPowerOfFour3(63));
    }
}
