package com.zxd.test.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName IsSymmetric_101
 * @Description https://leetcode-cn.com/problems/symmetric-tree/
 * @Author xiaodong.zou
 * @Date 2020/5/31 10:48
 * @Version 1.0
 */
//101. 对称二叉树
//        给定一个二叉树，检查它是否是镜像对称的。
//
//
//
//        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//         1
//        / \
//       2   2
//      / \ / \
//     3  4 4  3
//
//
//        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//        1
//       / \
//      2   2
//      \   \
//      3    3
//
//
//        进阶：
//
//        你可以运用递归和迭代两种方法解决这个问题吗？
public class IsSymmetric_101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2_left = new TreeNode(2);
        TreeNode node2_right = new TreeNode(2);
        TreeNode node3_left = new TreeNode(3);
        TreeNode node4_right = new TreeNode(4);
        TreeNode node4_left = new TreeNode(4);
        TreeNode node3_right = new TreeNode(3);
        node2_left.left = node3_left;
        node2_left.right = node4_right;
        root.left = node2_left;
        node2_right.left = node4_left;
        node2_right.right = node3_right;
        root.right = node2_right;
        System.out.println(isSymmetric(root));
        TreeNode root2 = new TreeNode(1);
        TreeNode node2_left_1 = new TreeNode(2);
        TreeNode node2_left_2 = new TreeNode(2);
        TreeNode node2_right_1 = new TreeNode(2);
        TreeNode node2_right_2 = new TreeNode(2);
        node2_right_1.left = node2_right_2;
        node2_left_1.left = node2_left_2;
        root2.left = node2_left_1;
        root2.right = node2_right_1;
        System.out.println(isSymmetric(root2));
//        bfs(root);
//        System.out.println("===========================");
//        dfs(root);
//        System.out.println("===========================");
//        afs(root);
//        System.out.println("===========================");
//        bbfs(root);
        System.out.println("-----------------------------");
        System.out.println(isMirror(root,root));
        System.out.println(isMirror(root2,root2));
    }


    public static boolean isSymmetric(TreeNode root) {
        return ifSymmetric(root,root);
    }

    /**
     * 方法一 ：递归，如果左子树的left与右子树的right同为null或者值相同，并且左子树的right与右子树的left同为null或者值相同，则当前节点对称；递归进行校验
     * @param leftNode
     * @param rightNode
     * @return
     */
    private static boolean ifSymmetric(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }
        if(leftNode == null || rightNode == null){
            return false;
        }
        return leftNode.val == rightNode.val && ifSymmetric(leftNode.left,rightNode.right) && ifSymmetric(leftNode.right,rightNode.left);
    }


    /**
     * 方法二:广度优先遍历实现迭代方法
     * @return
     */
    private static boolean isMirror(TreeNode leftNode,TreeNode rightNode){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(leftNode);
        queue.offer(rightNode);
        while (!queue.isEmpty()){
            leftNode = queue.poll();
            rightNode = queue.poll();
            if(leftNode == null && rightNode == null){
                return true;
            }
            if(leftNode == null || rightNode == null || leftNode.val != rightNode.val){
                return false;
            }
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }



    private static void dfs(TreeNode node,List<Integer> elements){
        if(node == null){
            elements.add(null);
            return;
        }
        dfs(node.left,elements);
        elements.add(node.val);
        dfs(node.right,elements);
    }

    private static void bfs(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        bfs(node.left);
        bfs(node.right);
    }

    private static void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        System.out.println(node.val);
        dfs(node.right);
    }

    private static void afs(TreeNode node){
        if(node == null){
            return;
        }
        afs(node.left);
        afs(node.right);
        System.out.println(node.val);
    }

    private static void bbfs(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.val);
            if(treeNode.left != null){
                queue.add(treeNode.left);
            }
            if(treeNode.right != null){
                queue.add(treeNode.right);
            }
        }
    }

    private static void bfs(TreeNode node,List<Integer> elements){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode != null){
                elements.add(treeNode.val);
            }else{
                elements.add(null);
            }
            if(treeNode!= null){
                queue.add(treeNode.left);
            }
            if(treeNode != null){
                queue.add(treeNode.right);
            }
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
}
