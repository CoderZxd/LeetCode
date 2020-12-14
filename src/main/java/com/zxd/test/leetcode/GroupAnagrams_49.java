package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Description https://leetcode-cn.com/problems/group-anagrams/
 * @Author zouxiaodong
 * @Date 2020/12/14 8:56
 */
//49. 字母异位词分组
//        给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//        示例:
//        输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        说明：
//        所有输入均为小写字母。
//        不考虑答案输出的顺序。
public class GroupAnagrams_49 {

    public static void main(String[] args) {
        GroupAnagrams_49 groupAnagrams_49 = new GroupAnagrams_49();
        System.out.println(groupAnagrams_49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String ele:strs){
            String[] eleArray = ele.split("");
            Arrays.sort(eleArray);
            String key = String.join("",eleArray);
            if(map.containsKey(key)){
                map.get(key).add(ele);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(ele);
                map.put(key,temp);
                resultList.add(temp);
            }
        }
        return resultList;
    }
}
