package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * @Author zouxiaodong
 * @Date 2020/11/24 8:19
 */
//222. 完全二叉树的节点个数
//        给出一个完全二叉树，求出该树的节点个数。
//
//        说明：
//        完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
//        并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
//
//        示例:
//
//        输入:
//         1
//        / \
//       2   3
//      / \  /
//     4  5 6
//
//        输出: 6
public class CountNodes_222 {

    public static void main(String[] args) {
        CountNodes_222 countNodes_222 = new CountNodes_222();
        TreeNode root = new TreeNode(1);
        TreeNode root_l = new TreeNode(2);
        TreeNode root_r = new TreeNode(3);
        TreeNode root_l_l = new TreeNode(4);
        TreeNode root_l_r = new TreeNode(5);
        TreeNode root_r_l = new TreeNode(6);
        root.left = root_l;
        root.right = root_r;
        root_l.left = root_l_l;
        root_l.right = root_l_r;
        root_r.left = root_r_l;
        System.out.println(countNodes_222.countNodes(root));
    }

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }


    /**
     * @Author zouxiaodong
     * @Description 方法一：二分查找 + 位运算
     * @Date 2020/11/24 8:31
     * @Param [root]
     * @return int
     **/
    public int countNodes_offical(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
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