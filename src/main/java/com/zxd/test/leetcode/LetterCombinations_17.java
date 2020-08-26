package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Description https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @Author zouxiaodong
 * @Date 2020/08/26 8:39
 */
//17. 电话号码的字母组合
//        给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//        示例:
//
//        输入："23"
//        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//        说明:
//        尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
public class LetterCombinations_17 {
    private Map<String,List<String>> mapping = new HashMap<>();

    public static void main(String[] args) {
        LetterCombinations_17 letterCombinations = new LetterCombinations_17();
        List<String> ss = letterCombinations.letterCombinations("2");
        System.out.println(ss);
    }

    public List<String> letterCombinations(String digits) {
        mapping.put("2",Arrays.asList(new String[]{"a","b","c"}));
        mapping.put("3",Arrays.asList(new String[]{"d","e","f"}));
        mapping.put("4",Arrays.asList(new String[]{"g","h","i"}));
        mapping.put("5",Arrays.asList(new String[]{"j","k","l"}));
        mapping.put("6",Arrays.asList(new String[]{"m","n","o"}));
        mapping.put("7",Arrays.asList(new String[]{"p","q","r","s"}));
        mapping.put("8",Arrays.asList(new String[]{"t","u","v"}));
        mapping.put("9",Arrays.asList(new String[]{"w","x","y","z"}));
        return recursive(digits);
    }

    private List<String> recursive(String s){
        List<String> resultList = new ArrayList<>(10);
        if(s == null || "".equals(s)){
            return resultList;
        }
        if(s.length() == 1){
            resultList.addAll(mapping.get(s));
            return resultList;
        }
        String endChar = s.substring(s.length()-1);
        String subStr = s.substring(0,s.length()-1);
        List<String> nums = mapping.get(endChar);
        for(String num:nums){
            List<String> subNUmList = recursive(subStr);
            for (String subNum:subNUmList){
                resultList.add(subNum+num);
            }
        }
        return resultList;
    }
}
