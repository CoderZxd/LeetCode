package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: 6.Z字形变换
 * @Version 1.0
 * @create 2018-09-18 0:32
 **/
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
//        比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
//        L   C   I   R
//        E T O E S I I G
//        E   D   H   N
//        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
//        请你实现这个将字符串进行指定行数变换的函数：
//
//        string convert(string s, int numRows);
//        示例 1:
//
//        输入: s = "LEETCODEISHIRING", numRows = 3
//        输出: "LCIRETOESIIGEDHN"
//        示例 2:
//
//        输入: s = "LEETCODEISHIRING", numRows = 4
//        输出: "LDREOEIIECIHNTSG"
//        解释:
//
//        L     D     R
//        E   O E   I I
//        E C   I H   N
//        T     S     G
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/zigzag-conversion
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class ConvertStringToZ_6 {

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
