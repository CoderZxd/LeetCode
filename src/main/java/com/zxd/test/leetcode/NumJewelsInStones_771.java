package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NumJewelsInStones_771
 * @Description https://leetcode-cn.com/problems/jewels-and-stones/
 * @Author xiaodong.zou
 * @Date 2020/10/2 17:54
 * @Version 1.0
 */
//771. 宝石与石头
//        给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
//
//        J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
//
//        示例 1:
//
//        输入: J = "aA", S = "aAAbbbb"
//        输出: 3
//        示例 2:
//
//        输入: J = "z", S = "ZZ"
//        输出: 0
//        注意:
//
//        S 和 J 最多含有50个字母。
//        J 中的字符不重复。
public class NumJewelsInStones_771 {

    public static void main(String[] args) {
        NumJewelsInStones_771 numJewelsInStones_771 = new NumJewelsInStones_771();
        System.out.println(numJewelsInStones_771.numJewelsInStones("aA","aAAbbbb"));
        System.out.println(numJewelsInStones_771.numJewelsInStones("z","ZZ"));
        System.out.println(numJewelsInStones_771.numJewelsInStones_1("aA","aAAbbbb"));
        System.out.println(numJewelsInStones_771.numJewelsInStones_1("z","ZZ"));
    }

    public int numJewelsInStones(String J, String S) {
        int res = 0;
        if(S != null && S.length() > 0){
            String[] J_Array = J.split("");
            String[] S_Array = S.split("");
            Set<String> J_Set = new HashSet<>(Arrays.asList(J_Array));
            for(String s:S_Array){
                if(J_Set.contains(s)){
                    res++;
                }
            }
        }
        return res;
    }

    public int numJewelsInStones_1(String J, String S) {
        int res = 0;
        if(S != null && S.length() > 0){
            int len_J = J.length();
            int[] J_Array = new int[123];
            for(int i=0;i<len_J;i++){
                J_Array[J.charAt(i)] = 1;
            }
            int len = S.length();
            for(int i=0;i<len;i++){
                if(J_Array[S.charAt(i)] == 1){
                    res++;
                }
            }
        }
        return res;
    }
}
