package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/binary-tree-paths/
 * @Author zouxiaodong
 * @Date 2020/09/04 8:50
 */
//257. 二叉树的所有路径
//        给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例:
//
//        输入:
//
//         1
//        / \
//       2   3
//        \
//         5
//
//        输出: ["1->2->5", "1->3"]
//
//        解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
public class BinaryTreePaths_257 {

    List<String> resultList = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_l = new TreeNode(2);
        TreeNode root_l_r = new TreeNode(5);
        TreeNode root_r = new TreeNode(3);
        root.left = root_l;
        root.right = root_r;
        root_l.right = root_l_r;
        BinaryTreePaths_257 binaryTreePaths = new BinaryTreePaths_257();
        binaryTreePaths.binaryTreePaths(root);
        System.out.println(binaryTreePaths.resultList);

    }

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return resultList;
    }

    private void dfs(TreeNode node,String path){
        if(node == null){
            return;
        }
        if("".equals(path)){
            path = node.val+"";
        }else{
            path += "->"+node.val;
        }
        if(node.left == null && node.right == null){
//            path += "->"+node.val;
            resultList.add(path);
            return;
        }
//        if("".equals(path)){
//            path = node.val+"";
//        }else{
//            path += "->"+node.val;
//        }
        dfs(node.left,path);
        dfs(node.right,path);
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