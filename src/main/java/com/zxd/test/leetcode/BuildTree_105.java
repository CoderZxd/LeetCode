package com.zxd.test.leetcode;

/**
 * @Title: BuildTree_105
 * @Description: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @Author xiaodong.zou
 * @Date 2020/5/22 9:10
 */
//105. 从前序与中序遍历序列构造二叉树
//		根据一棵树的前序遍历与中序遍历构造二叉树。
//
//		注意:
//		你可以假设树中没有重复的元素。
//
//		例如，给出
//
//		前序遍历 preorder = [3,9,20,15,7]
//		中序遍历 inorder = [9,3,15,20,7]
//		返回如下的二叉树：
//
//		 3
//		/ \
//	   9  20
//		  / \
//		15   7
public class BuildTree_105 {

	public static void main(String[] args) {

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		//不管什么遍历方式，结果长度肯定是一样的，都是总结点数
		if(preorder.length!= inorder.length || preorder.length<1){
			return null;
		}
		//只有一个节点，那就是根节点
		if(preorder.length == 1){
			return new TreeNode(preorder[0]);
		}
		//在中序遍历结果中找根节点
		int index = -1;
		for(int i=0;i<inorder.length;i++){
			if(inorder[i]==preorder[0]){
				index=i;
				break;
			}
		}
		//没找到，说明数据有问题
		if(index==-1){
			return null;
		}
		//找到根节点了
		TreeNode root = new TreeNode(preorder[0]);
		//得到左子树的前序遍历结果
		int[] lChildPrev = new int[index];
		System.arraycopy(preorder,1,lChildPrev,0,index);
		//得到左子树的中序遍历结果
		int[] lChildin = new int[index];
		System.arraycopy(inorder,0,lChildin,0,index);
		//通过递归，得到左子树结构
		root.left=buildTree(lChildPrev,lChildin);

		//得到右子树的前序遍历结果
		int[] rChildPrev = new int[inorder.length-1-index];
		System.arraycopy(preorder,index+1,rChildPrev,0,inorder.length-1-index);
		//得到右子树的中序遍历结果
		int[] rChildin = new int[inorder.length-1-index];
		System.arraycopy(inorder,index+1,rChildin,0,inorder.length-1-index);
		//通过递归，得到右子树结构
		root.right=buildTree(rChildPrev,rChildin);
		//得到完整的二叉树结构
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