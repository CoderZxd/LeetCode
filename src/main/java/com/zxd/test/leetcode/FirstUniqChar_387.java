package com.zxd.test.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @Author zouxiaodong
 * @Date 2020/12/23 9:02
 */
//387. 字符串中的第一个唯一字符
//        给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//        示例：
//        s = "leetcode"
//        返回 0
//
//        s = "loveleetcode"
//        返回 2
public class FirstUniqChar_387 {

    public static void main(String[] args) {
        FirstUniqChar_387 firstUniqChar_387 = new FirstUniqChar_387();
        System.out.println(firstUniqChar_387.firstUniqChar("leetcode"));
        System.out.println(firstUniqChar_387.firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar_387.firstUniqChar("cc"));
    }

    public int firstUniqChar(String s) {
        int len = s.length();
        if(len <= 1){
            return len-1;
        }
        int[][] charNums = new int[26][2];
        Arrays.fill(charNums,new int[]{len,0});
        for(int i=0;i<len;i++){
            if(charNums[s.charAt(i)-'a'][0] == len){
                charNums[s.charAt(i)-'a'] = new int[]{i,1};
            }else{
                //直接设置字符长度+1
                charNums[s.charAt(i)-'a'] = new int[]{len+1,1};
            }
        }
        Arrays.sort(charNums, Comparator.comparingInt(o -> o[0]));
        return (charNums[0][0] == len+1 || charNums[0][0] == len )?-1:charNums[0][0];
    }
}
