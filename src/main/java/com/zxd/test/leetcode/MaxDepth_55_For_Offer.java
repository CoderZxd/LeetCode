package com.zxd.test.leetcode;

/**
 * @Title: MaxDepth_55_For_Offer
 * @Description: https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @Author xiaodong.zou
 * @Date 2020/6/20 13:47
 */
//剑指 Offer 55 - I. 二叉树的深度
//		输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
//
//		例如：
//
//		给定二叉树 [3,9,20,null,null,15,7]，
//
//		 3
//		/ \
//	   9  20
//		 /  \
//		15   7
//		返回它的最大深度 3 。
//
//
//
//		提示：
//
//		节点总数 <= 10000
//		注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
public class MaxDepth_55_For_Offer {

	private int maxDepth = 0;

	public static void main(String[] args) {
		MaxDepth_55_For_Offer maxDepth55ForOffer = new MaxDepth_55_For_Offer();
		TreeNode root = new TreeNode(1);
		TreeNode node_2 = new TreeNode(2);
		TreeNode node_3 = new TreeNode(3);
		root.left = node_2;
		root.right = node_3;
		TreeNode node_4 = new TreeNode(4);
		TreeNode node_5 = new TreeNode(5);
		node_2.left = node_4;
		node_2.right = node_5;
		System.out.println("max depth:"+maxDepth55ForOffer.maxDepth(root));
		System.out.println("max depth:"+maxDepth55ForOffer.maxDepth_1(root));
	}

	public int maxDepth(TreeNode root) {
		dfs(root,0);
		return maxDepth;
	}

	/**
	 * 递归解决
	 * @param root
	 * @return
	 */
	public int maxDepth_1(TreeNode root) {
		return root == null?0:Math.max(maxDepth_1(root.left),maxDepth_1(root.right))+1;
	}

	/**
	 * 深度优先遍历
	 * @param node
	 * @param depth
	 */
	private void dfs(TreeNode node,int depth){
		if(node == null){
			return;
		}
		if(++depth>maxDepth){
			maxDepth = depth;
		}
//		System.out.println(node.val+"--->"+ depth);
		dfs(node.left,depth);
		dfs(node.right,depth);
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