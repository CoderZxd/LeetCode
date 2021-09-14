package com.zxd.test.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * @Author zouxiaodong
 * @Date 2021/09/14 9:24
 */
//524. 通过删除字母匹配到字典里最长单词
//        给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
//
//        如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
//
//
//
//        示例 1：
//        输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//        输出："apple"

//        示例 2：
//        输入：s = "abpcplea", dictionary = ["a","b","c"]
//        输出："a"
//
//
//        提示：
//        1 <= s.length <= 1000
//        1 <= dictionary.length <= 1000
//        1 <= dictionary[i].length <= 1000
//        s 和 dictionary[i] 仅由小写英文字母组成
public class FindLongestWord_524 {

    public static void main(String[] args) {
        FindLongestWord_524 findLongestWord_524 = new FindLongestWord_524();
        System.out.println(findLongestWord_524.findLongestWord("abpcplea",Arrays.asList(new String[]{"ale","apple","monkey","plea"})));
        System.out.println(findLongestWord_524.findLongestWord("abpcplea",Arrays.asList(new String[]{"a","b","c"})));
        System.out.println(findLongestWord_524.findLongestWord("abce",Arrays.asList(new String[]{"abe","abc"})));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        int len = s.length();
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o2.length()-o1.length();
            }
        });
        for(String ele:dictionary){
            int i=0,j=0,lenEle=ele.length();
            while (i<len && j< lenEle){
                if(s.charAt(i) == ele.charAt(j)){
                    j++;
                }
                i++;
            }
            if(j== lenEle){
                return ele;
            }
        }
        return "";
    }
}
