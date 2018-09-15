package com.zxd.test.leetcode;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2018-09-13 2:29
 **/
//无重复字符的最长子串
//        给定一个字符串，找出不含有重复字符的最长子串的长度。
//
//        示例 1:
//
//        输入: "abcabcbb"
//        输出: 3
//        解释: 无重复字符的最长子串是 "abc"，其长度为 3。
//        示例 2:
//
//        输入: "bbbbb"
//        输出: 1
//        解释: 无重复字符的最长子串是 "b"，其长度为 1。
//        示例 3:
//
//        输入: "pwwkew"
//        输出: 3
//        解释: 无重复字符的最长子串是 "wke"，其长度为 3。
//        请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
public class LongestNoRepeatString {

    public static int lengthOfLongestSubstring(String s) {
        if(null == s || "".equals(s)){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int returnValue = 1;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j < s.length();j++){
                if(s.substring(i,j).indexOf(s.charAt(j)) >= 0){
                    if(j-i > returnValue){
                        returnValue = j - i;
                    }
                    break;
                }else {
                    if(j-i+1>returnValue){
                        returnValue = j-i+1;
                    }
                }
            }
        }
        return returnValue;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
