package com.zxd.test.leetcode;

/**
 * @ClassName IsCousins_993
 * @Description https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * @Author xiaodong.zou
 * @Date 2021/5/17 20:58
 * @Version 1.0
 */
//993. 二叉树的堂兄弟节点
//        在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//
//        如果二叉树的两个节点深度相同，但父节点不同 ，则它们是一对堂兄弟节点。
//
//        我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
//
//        只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
//
//
//
//        示例 1：
//         1
//        / \
//       2  3
//      /
//     4
//        输入：root = [1,2,3,4], x = 4, y = 3
//        输出：false
//        示例 2：
//         1
//        / \
//       2  3
//       \   \
//        4   5
//        输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//        输出：true
//        示例 3：
//         1
//        / \
//       2  3
//       \
//        4
//        输入：root = [1,2,3,null,4], x = 2, y = 3
//        输出：false
//
//
//        提示：
//
//        二叉树的节点数介于 2 到 100 之间。
//        每个节点的值都是唯一的、范围为 1 到 100 的整数。
public class IsCousins_993 {

    public static void main(String[] args) {
        IsCousins_993 isCousins_993 = new IsCousins_993();
        TreeNode root = new TreeNode(1);
        TreeNode root_l = new TreeNode(2);
        TreeNode root_l_r = new TreeNode(4);
        TreeNode root_r = new TreeNode(3);
        TreeNode root_r_r = new TreeNode(5);
        root.left = root_l;
        root.right = root_r;
        root_l.right = root_l_r;
        root_r.right = root_r_r;
        System.out.println(isCousins_993.isCousins(root,5,4));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int[] X = dfs(null,root,x,0);
        int[] Y = dfs(null,root,y,0);
        if(X != null && Y != null){
            if(X[0] != Y[0] && X[1] == Y[1]){
                return true;
            }
        }
        return false;
    }

    private int[] dfs(TreeNode parent,TreeNode current,int x,int deep){
        if(current == null){
            return null;
        }
        if(current.val == x){
            if(parent != null){
                return new int[]{parent.val,deep};
            }else {
                return new int[]{-1,deep};
            }
        }
        int[] left = dfs(current,current.left,x,deep+1);
        if(left != null){
            return left;
        }
        return dfs(current,current.right,x,deep+1);
    }
}
