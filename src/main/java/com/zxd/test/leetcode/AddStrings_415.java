package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/add-strings/
 * @Author zouxiaodong
 * @Date 2020/08/03 9:08
 */
//415. 字符串相加
//        给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//        注意：
//
//        num1 和num2 的长度都小于 5100.
//        num1 和num2 都只包含数字 0-9.
//        num1 和num2 都不包含任何前导零。
//        你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
public class AddStrings_415 {

    public static void main(String[] args) {
        AddStrings_415 addStrings = new AddStrings_415();
        System.out.println(addStrings.addStrings("99999","1"));
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0){
            return num2;
        }
        if(num2 == null || num2.length() == 0){
            return num1;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        for(int i= len1-1,j=len2-1;i>=0 || j>= 0;i--,j--){
           int sum = (i>=0?Integer.parseInt(String.valueOf(num1.charAt(i))):0) + (j>=0?Integer.parseInt(String.valueOf(num2.charAt(j))):0) + carry;
           carry = sum/10;
           sb.append(sum%10);
        }
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
