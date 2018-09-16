package com.zxd.test.leetcode;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2018-09-17 1:18
 **/

//最长回文子串
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
//
//        示例 1：
//
//        输入: "babad"
//        输出: "bab"
//        注意: "aba"也是一个有效答案。
//        示例 2：
//
//        输入: "cbbd"
//        输出: "bb"
public class Palindrome {

    public static String longestPalindrome(String s) {
        int length = s.length();
        if(length <=1){
            return s;
        }
        //最长回文字符个数
        int longest = 1;
        //最长回文字符串的开始和结束位置
        int b = 0;
        int e = 0;
        //情况1：回文按照某个字符对称
        for(int i=1;i<length;i++) {
            for (int before=i-1,after=i+1;before>-1&&after<length;before--,after++){
                if(s.charAt(before) == s.charAt(after)){
                    if(after-before+1>longest){
                        longest = after-before+1;
                        b = before;
                        e = after;
                    }
                }else{
                    break;
                }
            }
        }
        //情况2：回文中心对称
        for(int i=0;i<length;i++) {
            for (int before=i,after=i+1;before>-1&&after<length;before--,after++){
                if(s.charAt(before) == s.charAt(after)){
                    if(after-before+1>longest){
                        longest = after-before+1;
                        b = before;
                        e = after;
                    }
                }else{
                    break;
                }
            }
        }
        return s.substring(b,e+1);
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("cbbd"));
    }
}
