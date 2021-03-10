package com.zxd.test.leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description https://leetcode-cn.com/problems/basic-calculator/
 * @Author zouxiaodong
 * @Date 2021/03/10 14:40
 */
//224. 基本计算器
//        实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
//
//        示例 1：
//        输入：s = "1 + 1"
//        输出：2

//        示例 2：
//        输入：s = " 2-1 + 2 "
//        输出：3

//        示例 3：
//        输入：s = "(1+(4+5+2)-3)+(6+8)"
//        输出：23
//
//
//        提示：
//        1 <= s.length <= 3 * 10^5
//        s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
//        s 表示一个有效的表达式
public class Calculate_224 {

    public static void main(String[] args) {
        Calculate_224 calculate_224 = new Calculate_224();
        System.out.println(calculate_224.calculate("(10+(40+5+20)-30)+(16+8)"));
//        System.out.println(calculate_224.calculate("1 + 1"));
//        System.out.println(calculate_224.calculate("12-1+2"));
    }

    public int calculate(String s) {
        int result = 0;
        Deque<String> stack = new LinkedList<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)==' '){
                continue;
            }else if(s.charAt(i)=='(' || s.charAt(i)=='+' || s.charAt(i)=='-' || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                stack.push(s.charAt(i)+"");
            }else if(s.charAt(i)==')'){
                int tempValue = 0;
                int number = 0;
                int power=0;
                while (!stack.peek().equals("(")){
                    String pop = stack.pop();
                    if(pop.equals("+")){
                        tempValue+=number;
                        number=0;
                        power=0;
                    }else if(pop.equals("-")){
                        tempValue-=number;
                        number=0;
                        power=0;
                    }else{
                        //连续数字计算实际数值
                        number=(int) Math.pow(10,power)*Integer.parseInt(pop)+number;
                        power++;
                    }
                }
                //将"("出栈
                stack.pop();
                tempValue+=number;
                //局部计算结果压栈
                stack.push(tempValue+"");
            }
        }
        int number=0;
        int power=0;
        while (!stack.isEmpty()){
            String pop = stack.pop();
            if(pop.equals("+")){
                result+=number;
                number=0;
                power=0;
            }else if(pop.equals("-")){
                result-=number;
                number=0;
                power=0;
            }else{
                //连续数字计算实际数值
                number=(int) Math.pow(10,power)*Integer.parseInt(pop)+number;
                power++;
            }
        }
        return result+number;
    }
}
