package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: Z字形变换
 * @Version 1.0
 * @create 2018-09-18 0:32
 **/
//Z字形变换
//        将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
//
//        P   A   H   N
//        A P L S I I G
//        Y   I   R
//        之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
//
//        实现一个将字符串进行指定行数变换的函数:
//
//        string convert(string s, int numRows);
//        示例 1:
//
//        输入: s = "PAYPALISHIRING", numRows = 3
//        输出: "PAHNAPLSIIGYIR"
//        示例 2:
//
//        输入: s = "PAYPALISHIRING", numRows = 4
//        输出: "PINALSIGYAHRPI"
//        解释:
//
//        P     I    N
//        A   L S  I G
//        Y A   H R
//        P     I
public class ConvertStringToZ {

    public static String convert(String s, int numRows) {
        List<StringBuffer> rows = new ArrayList<StringBuffer>();
        if(numRows == 1){
            return  s;
        }
        for(int i=0;i<Math.min(s.length(),numRows);i++){
            rows.add(new StringBuffer());
        }
        int currentRow =0;
        boolean goingDown = false;
        for(char c:s.toCharArray()){
           rows.get(currentRow).append(c);
           if(currentRow == 0 || currentRow == numRows -1){
               goingDown = !goingDown;
           }
           currentRow += goingDown ? 1 : -1;
        }
        StringBuffer sb = new StringBuffer();
        for(StringBuffer row:rows){
            System.out.println(row.toString());
            sb.append(row);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        convert("PAYPALISHIRING",3);
    }
}
