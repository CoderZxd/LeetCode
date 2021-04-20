package com.zxd.test.leetcode;

import java.util.stream.StreamSupport;

/**
 * @ClassName StrStr_28
 * @Description https://leetcode-cn.com/problems/implement-strstr/
 * @Author xiaodong.zou
 * @Date 2021/4/20 21:18
 * @Version 1.0
 */
//28. 实现 strStr()
//        实现 strStr() 函数。
//        给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
//
//        说明：
//        当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//        对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
//
//        示例 1：
//        输入：haystack = "hello", needle = "ll"
//        输出：2
//        示例 2：
//        输入：haystack = "aaaaa", needle = "bba"
//        输出：-1
//        示例 3：
//        输入：haystack = "", needle = ""
//        输出：0
//
//        提示：
//        0 <= haystack.length, needle.length <= 5 * 10^4
//        haystack 和 needle 仅由小写英文字符组成
public class StrStr_28 {

    public static void main(String[] args) {
        StrStr_28 strStr_28 = new StrStr_28();
        System.out.println(strStr_28.strStr("hello","ll"));
        System.out.println(strStr_28.strStr("aaaaa","bba"));
        System.out.println(strStr_28.strStr("",""));
    }
    public int strStr(String haystack, String needle) {
        if(needle==null||"".equals(needle)){
            return 0;
        }
        int l1 = haystack.length(),l2 = needle.length();
        if(l1>=l2){
            for(int i=0;i<=l1-l2;i++){
                int j=0;
                while (j<l2){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        j=0;
                        break;
                    }
                    j++;
                }
                if(j==l2){
                    return i;
                }
            }
        }
        return -1;
    }
}
