package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/word-break-ii/
 * @Author zouxiaodong
 * @Date 2020/11/02 9:02
 */
//140. 单词拆分 II
//        给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
//
//        说明：
//
//        分隔时可以重复使用字典中的单词。
//        你可以假设字典中没有重复的单词。
//        示例 1：
//
//        输入:
//        s = "catsanddog"
//        wordDict = ["cat", "cats", "and", "sand", "dog"]
//        输出:
//        [
//        "cats and dog",
//        "cat sand dog"
//        ]
//        示例 2：
//
//        输入:
//        s = "pineapplepenapple"
//        wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//        输出:
//        [
//        "pine apple pen apple",
//        "pineapple pen apple",
//        "pine applepen apple"
//        ]
//        解释: 注意你可以重复使用字典中的单词。
//        示例 3：
//
//        输入:
//        s = "catsandog"
//        wordDict = ["cats", "dog", "sand", "and", "cat"]
//        输出:
//        []
public class WordBreak_140 {

    List<List<String>> resultList = new ArrayList<>();

    List<String> tempList = new ArrayList<>();

    public static void main(String[] args) {
        WordBreak_140 wordBreak_140 = new WordBreak_140();
//        String[] dict = new String[]{"cat", "cats", "and", "sand", "dog"};
//        wordBreak_140.wordBreak("catsanddog", Arrays.asList(dict));
        String[] dict = new String[]{"apple", "pen", "applepen", "pine", "pineapple"};
        wordBreak_140.wordBreak("pineapplepenapple", Arrays.asList(dict));
//        String[] dict = new String[]{"cats", "dog", "sand", "and", "cat"};
//        wordBreak_140.wordBreak("catsandog", Arrays.asList(dict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        dfs(s,0,tempList,wordDict);
        if(!resultList.isEmpty()){
            for(List<String> eleList:resultList){
                StringBuffer sb = new StringBuffer();
                for(String ele:eleList){
                    sb.append(ele).append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                result.add(sb.toString());
            }
        }
        return result;
    }

    /**
     * @Author zouxiaodong
     * @Description 回溯，31/36执行超时
     * @Date 2020/11/02 10:23
     * @Param [s, start, tempList, wordDict]
     * @return void
     **/
    private void dfs(String s,int start,List<String> tempList,List<String> wordDict){
        int len = s.length();
        if(start == len){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for(int j=start+1;j<=len;j++){
            String str = s.substring(start,j);
            if(wordDict.contains(str)){
                tempList.add(str);
                dfs(s,j,tempList,wordDict);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
