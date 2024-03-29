package com.zxd.test.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName CheckValidString_678
 * @Description https://leetcode-cn.com/problems/valid-parenthesis-string/
 * @Author xiaodong.zou
 * @Date 2021/9/12 20:35
 * @Version 1.0
 */
//678. 有效的括号字符串
//        给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
//
//        任何左括号 ( 必须有相应的右括号 )。
//        任何右括号 ) 必须有相应的左括号 ( 。
//        左括号 ( 必须在对应的右括号之前 )。
//        * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
//        一个空字符串也被视为有效字符串。
//        示例 1:
//
//        输入: "()"
//        输出: True
//        示例 2:
//
//        输入: "(*)"
//        输出: True
//        示例 3:
//
//        输入: "(*))"
//        输出: True
//        注意:
//
//        字符串大小将在 [1，100] 范围内。
public class CheckValidString_678 {

    public static void main(String[] args) {

    }

    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<Integer>();
        Deque<Integer> asteriskStack = new LinkedList<Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIndex = leftStack.pop();
            int asteriskIndex = asteriskStack.pop();
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }

    public boolean checkValidString_2(String s) {
        int minCount = 0, maxCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
    }
}
