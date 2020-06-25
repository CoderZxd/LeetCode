package com.zxd.test.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
        System.out.println(wordBreak.wordBreak_offical("leetcode", Arrays.asList(new String[]{"leet", "code"})));
        System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList(new String[]{"apple", "pen"})));
        System.out.println(wordBreak.wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));
        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})));
        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})));

    }

    /**
     * 递归
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 95.01% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 8.00% 的用户
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        //如果字符串s为空，说明可以完全匹配，返回true
        if("".equals(s)){
            return true;
        }
        int len = s.length();
        //从未部开始匹配(从头部开始匹配也一样),找到第一个字符串在wordDict中，然后递归判断剩余字符串是否符合要求
        for(int i=len-1;i>=0;i--){
            String subStr = s.substring(i);
            //如果当前字符串在wordDict中,递归求解剩余字符串时候满足要求
            if(wordDict.contains(subStr)){
                //剩余字符串
                String newS = s.substring(0,i);
                //如果剩余字符串依然是subStr结尾，则需要求新的需要递归的字符串，直到不是以subStr结尾的字符串
                while (newS.endsWith(subStr)){
                    newS = newS.substring(0,newS.length()-subStr.length());
                }
                //如果有结果为true,则说明该字符串满足条件，可以直接返回true
                boolean subResult = wordBreak(newS,wordDict);
                if(subResult){
                    return true;
                }
            }
        }
        //遍历到最后没有符合要求的，返回false
        return false;
    }

    /**
     * 官方题解：动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_offical(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
