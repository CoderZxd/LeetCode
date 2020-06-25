package com.zxd.test.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName WordBreak_139
 * @Description https://leetcode-cn.com/problems/word-break/
 * @Author xiaodong.zou
 * @Date 2020/6/25 10:18
 * @Version 1.0
 */

//139. 单词拆分
//        给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
//        说明：
//
//        拆分时可以重复使用字典中的单词。
//        你可以假设字典中没有重复的单词。
//        示例 1：
//
//        输入: s = "leetcode", wordDict = ["leet", "code"]
//        输出: true
//        解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//        示例 2：
//
//        输入: s = "applepenapple", wordDict = ["apple", "pen"]
//        输出: true
//        解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//        注意你可以重复使用字典中的单词。
//        示例 3：
//
//        输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//        输出: false
public class WordBreak_139 {

    public static void main(String[] args) {

        WordBreak_139 wordBreak = new WordBreak_139();
//        System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
//        System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList(new String[]{"apple", "pen"})));
        System.out.println(wordBreak.wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));

    }

    /**
     * 递归
     *29 / 36 个通过测试用例
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if("".equals(s)){
            return true;
        }
        int len = s.length();
        for(int i=1;i<=len;i++){
            String subStr = s.substring(0,i);
            if(wordDict.contains(subStr)){
                String newS = s.substring(i);
                boolean subResult = wordBreak(newS,wordDict);
                if(subResult){
                    return true;
                }
            }
        }
        return false;
    }
}
