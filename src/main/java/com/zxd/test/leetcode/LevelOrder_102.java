package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Title: LevelOrder_102
 * @Description: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @Author xiaodong.zou
 * @Date 2020/5/13 9:31
 */
//102. 二叉树的层序遍历
//		给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
//		示例：
//		二叉树：[3,9,20,null,null,15,7],
//
//		3
//		/ \
//		9  20
//		/  \
//		15   7
//		返回其层次遍历结果：
//
//		[
//		[3],
//		[9,20],
//		[15,7]
//		]
public class LevelOrder_102 {

	public static void main(String[] args) {
		TreeNode treeNode7 = new TreeNode(7);
		TreeNode treeNode15 = new TreeNode(15);
		TreeNode treeNode20 = new TreeNode(20);
		TreeNode treeNode9 = new TreeNode(9);
		TreeNode treeNode3 = new TreeNode(3);
		treeNode20.right = treeNode7;
		treeNode9.left = treeNode15;
		treeNode3.left = treeNode9;
		treeNode3.right = treeNode20;
		levelOrder(treeNode3);
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> resultList = new ArrayList<>(10);
		if(root != null){
			Map<TreeNode,Integer> treeNodeToLevelMap = new HashMap<>(16);
			TreeMap<Integer,List<Integer>> levelToResultMap = new TreeMap<>();
			Queue<TreeNode> bfs = new LinkedList<>();
			bfs.add(root);
			treeNodeToLevelMap.put(root,0);
			List<Integer> tempList = new ArrayList<>(1);
			tempList.add(root.val);
			levelToResultMap.put(0,tempList);
			resultList.add(tempList);
			while (!bfs.isEmpty()){
				TreeNode cur = bfs.poll();
				System.out.println(cur.val);
				if(cur.left != null){
					bfs.add(cur.left);
					treeNodeToLevelMap.put(cur.left,treeNodeToLevelMap.get(cur)+1);
					if(levelToResultMap.containsKey(treeNodeToLevelMap.get(cur)+1)){
						levelToResultMap.get(treeNodeToLevelMap.get(cur)+1).add(cur.left.val);
					}else{
						List<Integer> temp = new ArrayList<>(1);
						temp.add(cur.left.val);
						levelToResultMap.put(treeNodeToLevelMap.get(cur)+1,temp);
						resultList.add(temp);
					}
				}
				if(cur.right != null){
					bfs.add(cur.right);
					treeNodeToLevelMap.put(cur.right,treeNodeToLevelMap.get(cur)+1);
					if(levelToResultMap.containsKey(treeNodeToLevelMap.get(cur)+1)){
						levelToResultMap.get(treeNodeToLevelMap.get(cur)+1).add(cur.right.val);
					}else{
						List<Integer> temp = new ArrayList<>(1);
						temp.add(cur.right.val);
						levelToResultMap.put(treeNodeToLevelMap.get(cur)+1,temp);
						resultList.add(temp);
					}
				}
			}
			System.out.println(treeNodeToLevelMap);
			System.out.println(levelToResultMap);
			System.out.println(resultList);
		}
		return resultList;
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