package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * @Author zouxiaodong
 * @Date 2021/04/13 9:07
 */
//783. 二叉搜索树节点最小距离
//        给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//        注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
//
//
//
//        示例 1：
//         4
//        / \
//       2   6
//      / \
//     1   3
//        输入：root = [4,2,6,1,3]
//        输出：1
//        示例 2：
//         1
//        / \
//       0   48
//          / \
//         12  49
//
//        输入：root = [1,0,48,null,null,12,49]
//        输出：1
//
//        提示：
//        树中节点数目在范围 [2, 100] 内
//        0 <= Node.val <= 10^5
public class MinDiffInBST_783 {
    private int pre = -1;
    private int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        MinDiffInBST_783 minDiffInBST_783 = new MinDiffInBST_783();
        TreeNode root = new TreeNode(1);
        TreeNode root_l = new TreeNode(0);
        TreeNode root_r = new TreeNode(48);
        TreeNode root_r_l = new TreeNode(12);
        TreeNode root_r_r = new TreeNode(49);
        root.left = root_l;
        root.right = root_r;
        root_r.left = root_r_l;
        root_r.right = root_r_r;
        System.out.println(minDiffInBST_783.minDiffInBST(root));
    }

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        if(pre != -1){
            ans = Math.min(ans,root.val-pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}
