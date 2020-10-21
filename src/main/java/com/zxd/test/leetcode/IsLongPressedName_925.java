package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/long-pressed-name/
 * @Author zouxiaodong
 * @Date 2020/10/21 8:23
 */
//925. 长按键入
//        你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
//        你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
//
//
//
//        示例 1：
//
//        输入：name = "alex", typed = "aaleex"
//        输出：true
//        解释：'alex' 中的 'a' 和 'e' 被长按。
//        示例 2：
//
//        输入：name = "saeed", typed = "ssaaedd"
//        输出：false
//        解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
//        示例 3：
//
//        输入：name = "leelee", typed = "lleeelee"
//        输出：true
//        示例 4：
//
//        输入：name = "laiden", typed = "laiden"
//        输出：true
//        解释：长按名字中的字符并不是必要的。
//
//
//        提示：
//        name.length <= 1000
//        typed.length <= 1000
//        name 和 typed 的字符都是小写字母。
public class IsLongPressedName_925 {

    public static void main(String[] args) {
        IsLongPressedName_925 isLongPressedName_925 = new IsLongPressedName_925();
        System.out.println(isLongPressedName_925.isLongPressedName("alex","aaleex"));
        System.out.println(isLongPressedName_925.isLongPressedName("saeed","ssaaedd"));
        System.out.println(isLongPressedName_925.isLongPressedName("leelee","lleeelee"));
        System.out.println(isLongPressedName_925.isLongPressedName("laiden","laiden"));
        System.out.println(isLongPressedName_925.isLongPressedName("pyplrz","ppyypllr"));
        System.out.println(isLongPressedName_925.isLongPressedName("alex","alexxr"));
    }

    public boolean isLongPressedName(String name, String typed) {
        if(name.equals(typed)){
            return true;
        }
        int len_name = name.length();
        int len_typed = typed.length();
        int last_j = 0;
        if(len_name<=len_typed){
            char charAtJ = ' ';
            for(int i=0,j=0;i<len_name;){
                if(j>=len_typed){
                    return false;
                }
                if(name.charAt(i) == typed.charAt(j)){
                    charAtJ = typed.charAt(j);
                    i++;
                    j++;
                }else if(typed.charAt(j) == charAtJ){
                    j++;
                }else{
                    return false;
                }
                last_j = j;
            }
            if(last_j<len_typed){
                char lastChar = name.charAt(len_name-1);
                while (last_j<len_typed){
                    if(typed.charAt(last_j) != lastChar){
                        return false;
                    }
                    last_j++;
                }
            }
            return true;
        }
        return false;
    }
}
