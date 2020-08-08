package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RecoverTree_99
 * @Description https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @Author xiaodong.zou
 * @Date 2020/8/8 19:43
 * @Version 1.0
 */
//99. 恢复二叉搜索树
//        二叉搜索树中的两个节点被错误地交换。
//        请在不改变其结构的情况下，恢复这棵树。
//
//        示例 1:
//
//        输入: [1,3,null,null,2]
//        1
//       /
//      3
//       \
//        2
//
//        输出: [3,1,null,null,2]
//        3
//       /
//      1
//       \
//        2

//        示例 2:
//
//        输入: [3,1,4,null,null,2]
//         3
//        / \
//       1   4
//          /
//         2
//
//        输出: [2,1,4,null,null,3]
//         2
//        / \
//      1   4
//         /
//        3
//        进阶:
//        使用 O(n)空间复杂度的解法很容易实现。
//        你能想出一个只使用常数空间的解决方案吗？
public class RecoverTree_99 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode r_l = new TreeNode(2);
        root.left = left;
        root.right = right;
        right.left = r_l;
        RecoverTree_99 recoverTree = new RecoverTree_99();
        recoverTree.recoverTree(root);
        System.out.println();
    }

    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        inOrder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }

    private void inOrder(TreeNode treeNode,List<Integer> inOrderList){
        if(treeNode == null){
            return;
        }
        inOrder(treeNode.left,inOrderList);
        inOrderList.add(treeNode.val);
        inOrder(treeNode.right,inOrderList);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */