package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Description https://leetcode-cn.com/problems/find-common-characters/
 * @Author zouxiaodong
 * @Date 2020/10/14 8:17
 */
//1002. 查找常用字符
//        给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
//        例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
//
//        你可以按任意顺序返回答案。
//
//        示例 1：
//
//        输入：["bella","label","roller"]
//        输出：["e","l","l"]
//        示例 2：
//
//        输入：["cool","lock","cook"]
//        输出：["c","o"]
//
//
//        提示：
//
//        1 <= A.length <= 100
//        1 <= A[i].length <= 100
//        A[i][j] 是小写字母
public class CommonChars_1002 {

    public static void main(String[] args) {
        CommonChars_1002 commonChars_1002 = new CommonChars_1002();
        System.out.println(commonChars_1002.commonChars(new String[]{"bella","label","roller"}));
        System.out.println(commonChars_1002.commonChars(new String[]{"cool","lock","cook"}));
    }

    public List<String> commonChars(String[] A) {
        List<String> resultList = new ArrayList<>();
        List<Map<String,Integer>> charList = new ArrayList<>();
        String minStr = "";
        int minLen = 101;
        for(String str:A){
            String[] strArray = str.split("");
            if(strArray.length < minLen){
                minStr = str;
                minLen = strArray.length;
            }
            Map<String,Integer> map = new HashMap<>(strArray.length);
            for(String key:strArray){
                map.put(key,map.getOrDefault(key,0)+1);
            }
            charList.add(map);
        }
        String[] minArray = minStr.split("");
        Set<String> minCharSet = new HashSet<>(Arrays.asList(minArray));
        label:
        for(String ele:minCharSet){
            int eleNums = 101;
            for(Map<String,Integer> eleMap:charList){
                if(!eleMap.containsKey(ele)){
                    continue label;
                }
                if(eleMap.get(ele) < eleNums){
                    eleNums = eleMap.get(ele);
                }
            }
            for(int i=0;i<eleNums;i++){
                resultList.add(ele);
            }
        }
        return resultList;
    }

    public List<String> commonChars_1(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
