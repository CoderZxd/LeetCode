package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/combinations/
 * @Author zouxiaodong
 * @Date 2020/09/08 8:32
 */
//77. 组合
//        给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//        示例:
//
//        输入: n = 4, k = 2
//        输出:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]
public class Combine_77 {

    public static void main(String[] args) {

    }

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(temp,n, k, 0);
        return ans;
    }

    public void dfs(List<Integer> temp,int n, int k, int x) {
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=x+1;i<=n;i++){
            temp.add(i);
            dfs(temp,n,k,i);
            temp.remove(temp.size()-1);
        }
    }
}
