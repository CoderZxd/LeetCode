package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/power-of-three/
 * @Author zouxiaodong
 * @Date 2021/09/23 11:24
 */
//326. 3的幂
//        给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
//        整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
//
//        示例 1：
//        输入：n = 27
//        输出：true

//        示例 2：
//        输入：n = 0
//        输出：false

//        示例 3：
//        输入：n = 9
//        输出：true

//        示例 4：
//        输入：n = 45
//        输出：false
//
//
//        提示：
//        -2^31 <= n <= 2^31 - 1
//
//        进阶：
//        你能不使用循环或者递归来完成本题吗？
public class IsPowerOfThree_326 {

    public static void main(String[] args) {
        IsPowerOfThree_326 isPowerOfThree_326 = new IsPowerOfThree_326();
        System.out.println(isPowerOfThree_326.isPowerOfThree_1(27));
        System.out.println(isPowerOfThree_326.isPowerOfThree_1(0));
        System.out.println(isPowerOfThree_326.isPowerOfThree_1(9));
        System.out.println(isPowerOfThree_326.isPowerOfThree_1(45));
        System.out.println(isPowerOfThree_326.isPowerOfThree_1(3));
        System.out.println(isPowerOfThree_326.isPowerOfThree_1(1));
    }

    /**
     * @Author zouxiaodong
     * @Description 在题目给定的 32 位有符号整数的范围内，最大的 3的幂为 3^19=1162261467。我们只需要判断 n是否是 3^19的约数即可。
     * @Date 2021/09/23 14:17
     * @Param [n]
     * @return boolean
     **/
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    /**
     * @Author zouxiaodong
     * @Description 递归
     * @Date 2021/09/23 13:56
     * @Param [n]
     * @return boolean
     **/
    public boolean isPowerOfThree_2(int n) {
        if(n == 1 || n == 3){
            return true;
        }
        if(n == 0 || n % 3 != 0){
            return false;
        }
        return isPowerOfThree(n/3);
    }

    /**
     * @Author zouxiaodong
     * @Description 循环
     * @Date 2021/09/23 13:53
     * @Param [n]
     * @return boolean
     **/
    public boolean isPowerOfThree_1(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
