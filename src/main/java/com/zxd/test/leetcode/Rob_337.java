package com.zxd.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description https://leetcode-cn.com/problems/house-robber-iii/
 * @Author zouxiaodong
 * @Date 2020/08/05 10:15
 */
//337. 打家劫舍 III
//        在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
//        这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
//        一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
//        如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//        计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
//        示例 1:
//        输入: [3,2,3,null,3,null,1]
//         3
//        / \
//       2   3
//        \   \
//         3   1
//        输出: 7
//        解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.

//        示例 2:
//        输入: [3,4,5,1,3,null,1]
//          3
//         / \
//        4   5
//       / \   \
//      1   3   1
//        输出: 9
//        解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
public class Rob_337 {

    public static void main(String[] args) {

    }

//    方法一：动态规划
//    简化一下这个问题：一棵二叉树，树上的每个点都有对应的权值，每个点有两种状态（选中和不选中），问在不能同时选中有父子关系的点的情况下，能选中的点的最大权值和是多少。
//    我们可以用 f(o)表示选择o 点的情况下，o节点的子树上被选择的节点的最大权值和；g(o) 表示不选择 o节点的情况下，o节点的子树上被选择的节点的最大权值和；l和 r 代表 o 的左右孩子。
//    当 o 被选中时，o 的左右孩子都不能被选中，故 o被选中情况下子树上被选中点的最大权值和为 l和 r 不被选中的最大权值和相加，即f(o)=g(l)+g(r)。
//    当 o 不被选中时，o 的左右孩子可以被选中，也可以不被选中。对于 o的某个具体的孩子 x，它对 o 的贡献是 x 被选中和不被选中情况下权值和的较大值。故g(o)=max{f(l),g(l)}+max{f(r),g(r)}。
//    至此，我们可以用哈希映射来存 f 和 g的函数值，用深度优先搜索的办法后序遍历这棵二叉树，我们就可以得到每一个节点的 f和 g。根节点的 f 和 g 的最大值就是我们要找的答案。

    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
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