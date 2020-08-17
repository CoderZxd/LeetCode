package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/balanced-binary-tree/
 * @Author zouxiaodong
 * @Date 2020/08/17 8:18
 */
//110. 平衡二叉树
//        给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//        本题中，一棵高度平衡二叉树定义为：
//
//        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//        示例 1:
//
//        给定二叉树 [3,9,20,null,null,15,7]
//
//         3
//        / \
//       9  20
//         /  \
//        15   7
//        返回 true 。
//
//        示例 2:
//
//        给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//         1
//        / \
//       2   2
//      / \
//     3   3
//    / \
//   4   4
//        返回 false 。
public class IsBalanced_110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root_l = new TreeNode(9);
        TreeNode root_r = new TreeNode(20);
        TreeNode root_r_l = new TreeNode(15);
        TreeNode root_r_r = new TreeNode(7);
        root_r.left = root_r_l;
        root_r.right = root_r_r;
        root.left = root_l;
        root.right = root_r;
        IsBalanced_110 isBalanced = new IsBalanced_110();
        System.out.println(isBalanced.isBalanced(root));
        TreeNode root2 = new TreeNode(1);
        TreeNode root2_l = new TreeNode(2);
        TreeNode root2_r = new TreeNode(2);
        TreeNode root2_l_l = new TreeNode(3);
        TreeNode root2_l_r = new TreeNode(3);
        TreeNode root2_l_l_l = new TreeNode(4);
        TreeNode root2_l_l_r = new TreeNode(4);
        root2_l_l.left = root2_l_l_l;
        root2_l_r.right = root2_l_l_r;
        root2_l.left = root2_l_l;
        root2_l.right = root2_l_r;
        root2.left = root2_l;
        root2.right = root2_r;
        System.out.println(isBalanced.isBalanced(root2));
        TreeNode root3 = new TreeNode(1);
        TreeNode root3_l = new TreeNode(2);
        TreeNode root3_l_l = new TreeNode(3);
        TreeNode root3_l_l_l = new TreeNode(4);
        TreeNode root3_r = new TreeNode(2);
        TreeNode root3_r_r = new TreeNode(3);
        TreeNode root3_r_r_r = new TreeNode(4);
        root3.left = root3_l;
        root3.right = root3_r;
        root3_l.left = root3_l_l;
        root3_l_l.left = root3_l_l_l;
        root3_r.right = root3_r_r;
        root3_r_r.right = root3_r_r_r;
        System.out.println(isBalanced.isBalanced(root3));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(dfs(root.left) - dfs(root.right)) > 1){
            return false;
        }
        if(!isBalanced(root.left) || !isBalanced(root.right)){
            return false;
        }
        return true;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(dfs(node.left),dfs(node.right))+1;
    }
}
