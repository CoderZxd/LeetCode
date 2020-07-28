package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/is-subsequence/
 * @Author zouxiaodong
 * @Date 2020/07/27 8:25
 */
//392. 判断子序列
//        给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//        你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
//        字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//
//        示例 1:
//        s = "abc", t = "ahbgdc"
//        返回 true.
//
//        示例 2:
//        s = "axc", t = "ahbgdc"
//        返回 false.
//
//        后续挑战 :
//        如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
public class IsSubsequence_392 {

    public static void main(String[] args) {
        IsSubsequence_392 subsequence = new IsSubsequence_392();
        System.out.println(subsequence.isSubsequence("abc","ahbgdc"));
        System.out.println(subsequence.isSubsequence("axc","ahbgdc"));
        System.out.println(subsequence.isSubsequence("acb","ahbgdc"));
        System.out.println(subsequence.isSubsequence("bcd","uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuubcd"));
    }

    /**
     * @Author zouxiaodong
     * @Description 双指针移动判断，记录t上次匹配位置,下次匹配从该位置+1开始
     * @Date 2020/07/27 8:52
     * @Param [s, t]
     * @return boolean
     **/
    public boolean isSubsequence(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();
        if(len_s>len_t){
            return false;
        }
        int lastPos = 0;
        label_1:
        for(int i=0;i<len_s;i++){
            char temp = s.charAt(i);
            //如果上次匹配的位置+1大于t的长度,则t已经无剩余字符串匹配了,返回false
            if(lastPos > len_t -1){
                return false;
            }
            for(int j=lastPos;j<len_t;j++){
                if(t.charAt(j) == temp){
                    lastPos = j + 1;
                    continue label_1;
                }
                //如果j已经匹配至末尾并且s还有未匹配的字符,则直接返回false
                if(j == len_t-1 && i < len_s){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @Author zouxiaodong
     * @Description 官方题解：双指针
     * @Date 2020/07/27 9:18
     * @Param [s, t]
     * @return boolean
     **/
    public boolean isSubsequence_offical(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
