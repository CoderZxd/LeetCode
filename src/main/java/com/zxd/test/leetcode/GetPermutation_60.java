package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/permutation-sequence/
 * @Author zouxiaodong
 * @Date 2020/09/07 15:45
 */
//60. 第k个排列
//        给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
//        按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//        "123"
//        "132"
//        "213"
//        "231"
//        "312"
//        "321"
//        给定 n 和 k，返回第 k 个排列。
//
//        说明：
//        给定 n 的范围是 [1, 9]。
//        给定 k 的范围是[1,  n!]。

//        示例 1:
//        输入: n = 3, k = 3
//        输出: "213"
//
//        示例 2:
//        输入: n = 4, k = 9
//        输出: "2314"
public class GetPermutation_60 {

    public static void main(String[] args) {
        GetPermutation_60 getPermutation = new GetPermutation_60();
        System.out.println(getPermutation.getPermutation(3,2));
//        System.out.println(getPermutation.getPermutation(3,3));
//        System.out.println(getPermutation.getPermutation(4,9));
//        System.out.println(getPermutation.getPermutation(1,1));
    }

    public String getPermutation(int n, int k) {
        StringBuffer resultsb = new StringBuffer("");
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=n;i++){
            sb.append(i);
        }
        if(k == 1){
            return sb.toString();
        }
        String s = recursive(n,k);
        int len = s.length();
        for(int i=0;i<len;i++){
            int index = s.charAt(i)-'0';
            if(index == 0){
                resultsb.append(sb);
                break;
            }else{
                index--;
                char c = sb.charAt(index);
                sb.deleteCharAt(index);
                resultsb.append(c);
            }
        }
        return resultsb.toString();
    }


    public String recursive(int n, int k) {
        if(n == 1){
            return "0";
        }
        if(k == 0){
            StringBuffer sb = new StringBuffer("");
            for(int i=1;i<n;i++){
                sb.append("1");
            }
            sb.append("0");
            return sb.toString();
        }
        int nums = 1;
        for(int i=1;i<n;i++){
            nums *= i;
        }
        int num = new Double(Math.ceil((double)k/nums)).intValue();
        return num+recursive(n-1,k-nums);
    }
}
