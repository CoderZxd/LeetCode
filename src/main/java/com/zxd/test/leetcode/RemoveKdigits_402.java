package com.zxd.test.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName RemoveKdigits_402
 * @Description https://leetcode-cn.com/problems/remove-k-digits/
 * @Author xiaodong.zou
 * @Date 2020/11/15 9:59
 * @Version 1.0
 */
//402. 移掉K位数字
//        给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
//
//        注意:
//
//        num 的长度小于 10002 且 ≥ k。
//        num 不会包含任何前导零。
//        示例 1 :
//
//        输入: num = "1432219", k = 3
//        输出: "1219"
//        解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
//        示例 2 :
//
//        输入: num = "10200", k = 1
//        输出: "200"
//        解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
//        示例 3 :
//
//        输入: num = "10", k = 2
//        输出: "0"
//        解释: 从原数字移除所有的数字，剩余为空就是0。
public class RemoveKdigits_402 {

    public static void main(String[] args) {
        RemoveKdigits_402 removeKdigits_402 = new RemoveKdigits_402();
        String result = removeKdigits_402.removeKdigits("1432219",3);
        System.out.println(result);
    }


    /**
     * 方法一：贪心 + 单调栈
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
