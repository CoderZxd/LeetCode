package com.zxd.test.leetcode;

/**
 * @ClassName IsAnagram_242
 * @Description https://leetcode-cn.com/problems/valid-anagram/
 * @Author xiaodong.zou
 * @Date 2020/11/22 20:12
 * @Version 1.0
 */
//242. 有效的字母异位词
//        给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//        示例 1:
//
//        输入: s = "anagram", t = "nagaram"
//        输出: true
//        示例 2:
//
//        输入: s = "rat", t = "car"
//        输出: false
//        说明:
//        你可以假设字符串只包含小写字母。
//
//        进阶:
//        如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
public class IsAnagram_242 {


    public static void main(String[] args) {
        IsAnagram_242 isAnagram_242 = new IsAnagram_242();
//        System.out.println(isAnagram_242.isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram_242.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();
        if(len_s != len_t){
            return false;
        }
        int[] tempArray = new int[26];
        for(int i=0;i<len_s;i++){
            tempArray[s.charAt(i)-'a']++;
            tempArray[t.charAt(i)-'a']--;
        }
        for(int ele:tempArray){
            if(ele != 0){
                return false;
            }
        }
        return true;
    }
}
