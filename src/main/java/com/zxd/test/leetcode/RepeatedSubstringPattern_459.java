package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/repeated-substring-pattern/
 * @Author zouxiaodong
 * @Date 2020/08/24 8:36
 */
//459. 重复的子字符串
//        给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
//
//        示例 1:
//
//        输入: "abab"
//
//        输出: True
//
//        解释: 可由子字符串 "ab" 重复两次构成。
//        示例 2:
//
//        输入: "aba"
//
//        输出: False
//        示例 3:
//
//        输入: "abcabcabcabc"
//
//        输出: True
//
//        解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
public class RepeatedSubstringPattern_459 {

    public static void main(String[] args) {
        RepeatedSubstringPattern_459 pattern = new RepeatedSubstringPattern_459();
        System.out.println(pattern.repeatedSubstringPattern("abab"));
        System.out.println(pattern.repeatedSubstringPattern("abc"));
        System.out.println(pattern.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(pattern.repeatedSubstringPattern("ababab"));
        System.out.println(pattern.repeatedSubstringPattern("ababababab"));
        System.out.println(pattern.repeatedSubstringPattern("babbabbabbabbab"));
        System.out.println(pattern.repeatedSubstringPattern("zzz"));
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len==1){
            return false;
        }
        String preSubStr = s.substring(0,len/2);
        String sufSubStr = s.substring(len/2);
        if(preSubStr.equals(sufSubStr)){
            return true;
        }else{
            for(int i=1;i<=len/2;i++){
                String substr = s.substring(0,i);
                if(isStartWithStr(substr,s)){
                    return true;
                }
            }
            return false;
        }

    }

    private boolean isStartWithStr(String prefix,String str){
        if(str.length() == 0){
            return true;
        }
        if(!str.startsWith(prefix)){
            return false;
        }
        return isStartWithStr(prefix,str.substring(prefix.length()));
    }
}
