package com.zxd.test.leetcode;

/**
 * @ClassName LengthOfLastWord_58
 * @Description https://leetcode-cn.com/problems/length-of-last-word/
 * @Author xiaodong.zou
 * @Date 2021/9/21 19:54
 * @Version 1.0
 */
//58. 最后一个单词的长度
//        给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
//
//        单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
//
//
//
//        示例 1：
//
//        输入：s = "Hello World"
//        输出：5
//        示例 2：
//
//        输入：s = "   fly me   to   the moon  "
//        输出：4
//        示例 3：
//
//        输入：s = "luffy is still joyboy"
//        输出：6
//
//
//        提示：
//
//        1 <= s.length <= 10^4
//        s 仅有英文字母和空格 ' ' 组成
//        s 中至少存在一个单词
public class LengthOfLastWord_58 {

    public static void main(String[] args) {
        LengthOfLastWord_58 lengthOfLastWord_58 = new LengthOfLastWord_58();
        System.out.println(lengthOfLastWord_58.lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord_58.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord_58.lengthOfLastWord("luffy is still joyboy"));
    }

    public int lengthOfLastWord(String s) {
        int len = s.length();
        int result = 0;
        for(int i=len-1;i>=0;i--){
            if(result !=0 && s.charAt(i) == ' '){
                break;
            }else if(s.charAt(i) != ' '){
                result++;
            }
        }
        return result;
    }
}
