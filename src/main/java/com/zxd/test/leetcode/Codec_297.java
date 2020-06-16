package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Codec_297
 * @Description: https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @Author xiaodong.zou
 * @Date 2020/6/16 9:48
 */
//297. 二叉树的序列化与反序列化
//		序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//
//		请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//
//		示例:
//
//		你可以将以下二叉树：
//
//		 1
//		/ \
//	   2   3
//		  / \
//		 4   5
//
//		序列化为 "[1,2,3,null,null,4,5]"
//		提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
//
//		说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
public class Codec_297 {

	public static void main(String[] args) {
		TreeNode treeNode_7 = new TreeNode(7);
		TreeNode treeNode_6 = new TreeNode(6);
		TreeNode treeNode_5 = new TreeNode(5);
		TreeNode treeNode_4 = new TreeNode(4);
		TreeNode treeNode_3 = new TreeNode(3);
		TreeNode treeNode_2 = new TreeNode(2);
		TreeNode treeNode_1 = new TreeNode(1);
		treeNode_3.left = treeNode_6;
		treeNode_3.right = treeNode_7;
		treeNode_2.left = treeNode_4;
		treeNode_2.right = treeNode_5;
		treeNode_1.left = treeNode_2;
		treeNode_1.right = treeNode_3;
		Codec_297 codec_297 = new Codec_297();
//		treeNode_1.right = treeNode_2;
//		List<Integer> preOrderList = new ArrayList<>();
//		codec_297.preOrder(treeNode_1,preOrderList);
//		List<Integer> inOrderList = new ArrayList<>();
//		codec_297.inOrder(treeNode_1,inOrderList);
		String serialize = codec_297.serialize(treeNode_1);
		System.out.println(serialize);
		codec_297.deserialize(serialize);
	}

	//通过树的先序+中序或者中序+后序可以实现树的反序化
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null){
			return null;
		}
		StringBuffer preOrderSb = new StringBuffer();
		preOrder(root,preOrderSb);
		StringBuffer inOrderSb = new StringBuffer();
		inOrder(root,inOrderSb);
		return preOrderSb.deleteCharAt(preOrderSb.lastIndexOf(",")).toString()+"|"+inOrderSb.deleteCharAt(inOrderSb.lastIndexOf(",")).toString();
	}

	/**
	 * 先序遍历
	 * @param root
	 * @return
	 */
	private void preOrder(TreeNode root, StringBuffer sb){
		if(root == null){
			return;
		}
//		System.out.println(root.val);
		sb.append(root.val).append(",");
		preOrder(root.left,sb);
		preOrder(root.right,sb);
	}


	/**
	 * 中序遍历
	 * @param root
	 * @return
	 */
	private void inOrder(TreeNode root,StringBuffer sb){
		if(root == null){
			return;
		}
		inOrder(root.left,sb);
//		System.out.println(root.val);
		sb.append(root.val).append(",");
		inOrder(root.right,sb);
	}

	/**
	 * 后序遍历
	 * @param root
	 * @return
	 */
	private void postOrder(TreeNode root,List<Integer> postOrderList){
		if(root == null){
			return;
		}
		postOrder(root.left,postOrderList);
//		System.out.println(root.val);
		postOrder(root.right,postOrderList);
		postOrderList.add(root.val);
	}


	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(null == data){
			return null;
		}
		String[] arrays = data.split("\\|");
		String[] preOrderArray = arrays[0].split(",");
		String[] inOrderArray = arrays[1].split(",");
		TreeNode root =  buildTree(preOrderArray,inOrderArray);
		return root;
	}

	public TreeNode buildTree(String[] preorder, String[] inorder) {
		//不管什么遍历方式，结果长度肯定是一样的，都是总结点数
		if(preorder.length!= inorder.length || preorder.length<1){
			return null;
		}
		//只有一个节点，那就是根节点
		if(preorder.length == 1){
			return new TreeNode(Integer.parseInt(preorder[0]));
		}
		//在中序遍历结果中找根节点
		int index = -1;
		for(int i=0;i<inorder.length;i++){
			if(inorder[i].equals(preorder[0])){
				index=i;
				break;
			}
		}
		//没找到，说明数据有问题
		if(index==-1){
			return null;
		}
		//找到根节点了
		TreeNode root = new TreeNode(Integer.parseInt(preorder[0]));
		//得到左子树的前序遍历结果
		String[] lChildPrev = new String[index];
		System.arraycopy(preorder,1,lChildPrev,0,index);
		//得到左子树的中序遍历结果
		String[] lChildin = new String[index];
		System.arraycopy(inorder,0,lChildin,0,index);
		//通过递归，得到左子树结构
		root.left=buildTree(lChildPrev,lChildin);

		//得到右子树的前序遍历结果
		String[] rChildPrev = new String[inorder.length-1-index];
		System.arraycopy(preorder,index+1,rChildPrev,0,inorder.length-1-index);
		//得到右子树的中序遍历结果
		String[] rChildin = new String[inorder.length-1-index];
		System.arraycopy(inorder,index+1,rChildin,0,inorder.length-1-index);
		//通过递归，得到右子树结构
		root.right=buildTree(rChildPrev,rChildin);
		//得到完整的二叉树结构
		return root;
	}
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */