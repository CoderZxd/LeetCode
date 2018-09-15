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

//    解法二
//    Java（假设字符集为 ASCII 128）
//
//    以前的我们都没有对字符串 s 所使用的字符集进行假设。
//
//    当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
//
//    常用的表如下所示：
//
//    int [26] 用于字母 ‘a’ - ‘z’或 ‘A’ - ‘Z’
//    int [128] 用于ASCII码
//    int [256] 用于扩展ASCII码
//            复杂度分析
//
//    时间复杂度：O(n)，索引 j 将会迭代 n 次。
//
//    空间复杂度（HashMap）：O(min(m, n))，与之前的方法相同。
//
//    空间复杂度（Table）：O(m)，m是字符集的大小。
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans =  Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
