package com.zxd.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description https://leetcode-cn.com/problems/permutation-in-string/
 * @Author zouxiaodong
 * @Date 2021/02/10 9:17
 */
//567. 字符串的排列
//        给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//        换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
//        示例1:
//        输入: s1 = "ab" s2 = "eidbaooo"
//        输出: True
//        解释: s2 包含 s1 的排列之一 ("ba").
//
//        示例2:
//        输入: s1= "ab" s2 = "eidboaoo"
//        输出: False
//
//        注意：
//        输入的字符串只包含小写字母
//        两个字符串的长度都在 [1, 10,000] 之间
public class CheckInclusion_567 {

    public static void main(String[] args) {
        CheckInclusion_567 checkInclusion_567 = new CheckInclusion_567();
        System.out.println(checkInclusion_567.checkInclusion("ab","eidoaoba"));
        System.out.println(checkInclusion_567.checkInclusion("ab","eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> numbersMap = new HashMap<>();
        int len = s1.length();
        for(int i=0;i<len;i++){
            numbersMap.put(s1.charAt(i),numbersMap.getOrDefault(s1.charAt(i),0)+1);
        }
        int length = s2.length();
        Map<Character,Integer> tempMap = new HashMap<>();
        label:
        for(int i=0;i<=length-len;i++){
            String s = s2.substring(i,i+len);
            for(int j=0;j<len;j++){
                if(!numbersMap.containsKey(s.charAt(j))){
                    tempMap.clear();
                    continue label;
                }else{
                    tempMap.put(s.charAt(j),tempMap.getOrDefault(s.charAt(j),0)+1);
                }
            }
            for(Character cr:tempMap.keySet()){
                if(!tempMap.get(cr).equals(numbersMap.get(cr))){
                    tempMap.clear();
                    continue label;
                }
            }
            return true;
        }
        return false;
    }
}
