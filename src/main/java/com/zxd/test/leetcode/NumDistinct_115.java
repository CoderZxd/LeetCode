package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/distinct-subsequences/
 * @Author zouxiaodong
 * @Date 2021/03/17 10:56
 */
//115. 不同的子序列
//        给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
//        字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
//        题目数据保证答案符合 32 位带符号整数范围。
//
//
//
//        示例 1：
//        输入：s = "rabbbit", t = "rabbit"
//        输出：3
//        解释：
//        如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//        (上箭头符号 ^ 表示选取的字母)
//        rabbbit
//        ^^^^ ^^
//        rabbbit
//        ^^ ^^^^
//        rabbbit
//        ^^^ ^^^

//        示例 2：
//        输入：s = "babgbag", t = "bag"
//        输出：5
//        解释：
//        如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
//        (上箭头符号 ^ 表示选取的字母)
//        babgbag
//        ^^ ^
//        babgbag
//        ^^    ^
//        babgbag
//        ^    ^^
//        babgbag
//          ^  ^^
//        babgbag
//            ^^^
//
//
//        提示：
//        0 <= s.length, t.length <= 1000
//        s 和 t 由英文字母组成
public class NumDistinct_115 {

    public static void main(String[] args) {
        NumDistinct_115 numDistinct_115 = new NumDistinct_115();
        System.out.println(numDistinct_115.numDistinct("babgbag","bag"));
    }

    public int numDistinct(String s, String t) {
        return backtrace(s,t,0,0);
    }

    /**
     * @Author zouxiaodong
     * @Description 回溯，超时
     * @Date 2021/03/17 14:33
     * @Param [s, t, idx1, idx2]
     * @return int
     **/
    private int backtrace(String s,String t,int idx1,int idx2){
        if(idx2 == t.length()){
            return 1;
        }
        if(idx1 == s.length()){
            return 0;
        }
        int res = 0;
        for(int i=idx1;i<s.length();i++){
            if(s.charAt(i) == t.charAt(idx2)){
                res+=backtrace(s,t,i+1,idx2+1);
            }
        }
        return res;
    }
}
