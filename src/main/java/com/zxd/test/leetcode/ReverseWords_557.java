package com.zxd.test.leetcode;

import java.util.Stack;

/**
 * @ClassName ReverseWords_557
 * @Description https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @Author xiaodong.zou
 * @Date 2020/8/30 12:09
 * @Version 1.0
 */
//557. 反转字符串中的单词 III
//        给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
//        示例：
//
//        输入："Let's take LeetCode contest"
//        输出："s'teL ekat edoCteeL tsetnoc"
//
//
//        提示：
//
//        在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
public class ReverseWords_557 {

    public static void main(String[] args) {
        ReverseWords_557 words557 = new ReverseWords_557();
        System.out.println(words557.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(c != ' '){
                stack.push(c);
            }else{
                while(!stack.empty()){
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
        }
        if(!stack.isEmpty()){
            while(!stack.empty()){
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }
}
