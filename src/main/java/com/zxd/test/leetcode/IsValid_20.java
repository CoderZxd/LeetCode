package com.zxd.test.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description https://leetcode-cn.com/problems/valid-parentheses/
 * @Author zouxiaodong
 * @Date 2020/08/14 8:01
 */
//20. 有效的括号
//        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        注意空字符串可被认为是有效字符串。
//
//        示例 1:
//
//        输入: "()"
//        输出: true
//        示例 2:
//
//        输入: "()[]{}"
//        输出: true
//        示例 3:
//
//        输入: "(]"
//        输出: false
//        示例 4:
//
//        输入: "([)]"
//        输出: false
//        示例 5:
//
//        输入: "{[]}"
//        输出: true
public class IsValid_20 {

    public static void main(String[] args) {
        IsValid_20 isValid_20 = new IsValid_20();
//        System.out.println(isValid_20.isValid("()"));
//        System.out.println(isValid_20.isValid("()[]{}"));
//        System.out.println(isValid_20.isValid("(]"));
        System.out.println(isValid_20.isValid("([)]"));
//        System.out.println(isValid_20.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if(len %2 != 0){
            return false;
        }
        for(int i=0;i<len;i++){
            Character c = s.charAt(i);
            if(stack.empty()){
               if(c == ')' || c == ']' || c == '}' ){
                   return false;
               }else{
                   stack.push(c);
               }
            }else {
                if(c == '(' || c == '[' || c == '{'){
                    stack.push(c);
                }else{
                    Character character = stack.pop();
                    if((character == '(' && c != ')') || (character == '[' && c != ']') || (character == '{' && c != '}')){
                        return false;
                    }
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
}
