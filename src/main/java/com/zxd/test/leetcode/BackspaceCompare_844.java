package com.zxd.test.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description https://leetcode-cn.com/problems/backspace-string-compare/
 * @Author zouxiaodong
 * @Date 2020/10/19 8:21
 */
//844. 比较含退格的字符串
//        给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
//
//        注意：如果对空文本输入退格字符，文本继续为空。
//
//
//
//        示例 1：
//
//        输入：S = "ab#c", T = "ad#c"
//        输出：true
//        解释：S 和 T 都会变成 “ac”。
//        示例 2：
//
//        输入：S = "ab##", T = "c#d#"
//        输出：true
//        解释：S 和 T 都会变成 “”。
//        示例 3：
//
//        输入：S = "a##c", T = "#a#c"
//        输出：true
//        解释：S 和 T 都会变成 “c”。
//        示例 4：
//
//        输入：S = "a#c", T = "b"
//        输出：false
//        解释：S 会变成 “c”，但 T 仍然是 “b”。
//
//
//        提示：
//
//        1 <= S.length <= 200
//        1 <= T.length <= 200
//        S 和 T 只含有小写字母以及字符 '#'。
//
//
//        进阶：
//
//        你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
public class BackspaceCompare_844 {

    public static void main(String[] args) {
        BackspaceCompare_844 backspaceCompare_844 = new BackspaceCompare_844();
        System.out.println(backspaceCompare_844.backspaceCompare("ab##","c#d#"));
        System.out.println(backspaceCompare_844.backspaceCompare("a##c","#a#c"));
        System.out.println(backspaceCompare_844.backspaceCompare("a#c","b"));
        System.out.println(backspaceCompare_844.backspaceCompare("xywrrmp","xywrrmu#p"));
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        int len_s = S.length();
        for(int i=0;i<len_s;i++){
            if(S.charAt(i) == '#' && !s.isEmpty()){
                s.pop();
            }else if(S.charAt(i) != '#'){
                s.push(S.charAt(i));
            }
        }
        Stack<Character> t = new Stack<>();
        int len_t = T.length();
        for(int i=0;i<len_t;i++){
            if(T.charAt(i) == '#' && !t.isEmpty()){
                t.pop();
            }else if(T.charAt(i) != '#'){
                t.push(T.charAt(i));
            }
        }
        if(t.size() != s.size()){
            return false;
        }
        while (!t.isEmpty()){
            if(t.pop() != s.pop()){
                return false;
            }
        }
        return true;
    }
}
