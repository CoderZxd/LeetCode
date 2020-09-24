package com.zxd.test.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * @Author zouxiaodong
 * @Date 2020/09/24 8:08
 */
//501. 二叉搜索树中的众数
//        给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
//        假定 BST 有如下定义：
//
//        结点左子树中所含结点的值小于等于当前结点的值
//        结点右子树中所含结点的值大于等于当前结点的值
//        左子树和右子树都是二叉搜索树
//        例如：
//        给定 BST [1,null,2,2],
//
//        1
//         \
//          2
//         /
//        2
//        返回[2].
//
//        提示：如果众数超过1个，不需考虑输出顺序
//
//        进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
public class FindMode_501 {

    Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_r = new TreeNode(2);
        TreeNode root_r_l = new TreeNode(2);
        root.right = root_r;
        root_r.left = root_r_l;
        FindMode_501 findMode501 = new FindMode_501();
        int[] re = findMode501.findMode(root);
        System.out.println(re);
    }

    public int[] findMode(TreeNode root) {
        inOrder(root);
        if(map.isEmpty()){
            return new int[]{};
        }
        List<Map.Entry<Integer,Integer>> list = map.entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        int maxNum = list.get(0).getValue();
        for (Map.Entry<Integer,Integer> ele:list){
            if(ele.getValue()>=maxNum){
                result.add(ele.getKey());
            }
        }
        int[] resultArray = new int[result.size()];
        for(int i=0;i<result.size();i++){
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        map.put(node.val,map.getOrDefault(node.val,0)+1);
        inOrder(node.right);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */