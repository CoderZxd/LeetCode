package com.zxd.test.leetcode;

/**
 * @ClassName SortedArrayToBST_108
 * @Description https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @Author xiaodong.zou
 * @Date 2020/7/3 10:28
 * @Version 1.0
 */
//108. 将有序数组转换为二叉搜索树
//        将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
//        本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//        示例:
//
//        给定有序数组: [-10,-3,0,5,9],
//
//        一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//          0
//        / \
//      -3   9
//      /   /
//    -10  5
public class SortedArrayToBST_108 {

    public static void main(String[] args) {
        SortedArrayToBST_108 sortedArrayToBST = new SortedArrayToBST_108();
        TreeNode root = sortedArrayToBST.sortedArrayToBST(new int[]{-10,-3,0,1,5,9});
        System.out.println(root);
    }

    /**
     * 递归
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int len = nums.length;
        int rootIndex = len/2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        int[] leftNums = new int[rootIndex];
        int[] rightNums = new int[len-rootIndex-1];
        System.arraycopy(nums,0,leftNums,0,rootIndex);
        System.arraycopy(nums,rootIndex+1,rightNums,0,len-rootIndex-1);
        root.left = sortedArrayToBST(leftNums);
        root.right = sortedArrayToBST(rightNums);
        return root;
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