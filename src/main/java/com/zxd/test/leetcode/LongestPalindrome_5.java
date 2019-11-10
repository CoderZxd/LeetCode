package com.zxd.test.leetcode;

/**
 * @ClassName LongestPalindrome_5
 * @Description 5. 最长回文子串
 * @Author xiaodong.zou
 * @Date 2019/11/10 19:23
 * @Version 1.0
 */
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//        示例 1：
//
//        输入: "babad"
//        输出: "bab"
//        注意: "aba" 也是一个有效答案。
//        示例 2：
//
//        输入: "cbbd"
//        输出: "bb"
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/longest-palindromic-substring
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class LongestPalindrome_5 {

    public static String longestPalindrome(String s) {
        int strLen = s.length();
        if(s != null && strLen<=1){
            return s;
        }
        int start = 0;
        int end = 0;
        //1.某个字符对称
        for(int i=1;i<strLen;i++){
            for(int l=i-1,r=i+1;l>=0 && r<strLen;l--,r++){
                if(s.charAt(l) == s.charAt(r)){
                    if(r-l > end-start){
                        start = l;
                        end = r;
                    }
                }else{
                    break;
                }
            }
        }
        //2.中心对称
        for(int i=0;i<strLen;i++){
            for(int l=i,r=i+1;l>=0 && r<strLen;l--,r++){
                if(s.charAt(l) == s.charAt(r)){
                    if(r-l > end-start){
                        start = l;
                        end = r;
                    }
                }else{
                    break;
                }
            }
        }
        return s.substring(start,end+1);
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

}
