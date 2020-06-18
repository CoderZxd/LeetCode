package com.zxd.test.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title: RecoverFromPreorder_1028
 * @Description:
 * @Author xiaodong.zou
 * @Date 2020/6/18 9:04
 */
//1028. 从先序遍历还原二叉树
//		我们从二叉树的根节点 root 开始进行深度优先搜索。
//
//		在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
//
//		如果节点只有一个子节点，那么保证该子节点为左子节点。
//
//		给出遍历输出 S，还原树并返回其根节点 root。
//
//
//
//		示例 1：
//              1
//            /  \
//           2    5
//          / \  / \
//         3  4 6   7
//
//		输入："1-2--3--4-5--6--7"
//		输出：[1,2,5,3,4,6,7]
//		示例 2：
//              1
//            /  \
//           2    5
//          /    /
//         3    6
//        /    /
//       4    7
//		输入："1-2--3---4-5--6---7"
//		输出：[1,2,5,3,null,6,null,4,null,7]
//		示例 3：
//             1
//            /
//          401
//         /   \
//       349   88
//       /
//      90
//
//		输入："1-401--349---90--88"
//		输出：[1,401,null,349,88,90]
//
//
//		提示：
//
//		原始树中的节点数介于 1 和 1000 之间。
//		每个节点的值介于 1 和 10 ^ 9 之间。
public class RecoverFromPreorder_1028 {

	public static void main(String[] args) {
		RecoverFromPreorder_1028 recoverFromPreorder_1028 = new RecoverFromPreorder_1028();
		recoverFromPreorder_1028.recoverFromPreorder("1-2--3---4-5--6---7");
	}

	/**
	 *
	 * @param S
	 * @return
	 */
	public TreeNode recoverFromPreorder(String S) {
		Deque<TreeNode> path = new LinkedList<TreeNode>();
		int pos = 0;
		while (pos < S.length()) {
			int level = 0;
			while (S.charAt(pos) == '-') {
				++level;
				++pos;
			}
			int value = 0;
			while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
				value = value * 10 + (S.charAt(pos) - '0');
				++pos;
			}
			TreeNode node = new TreeNode(value);
			if (level == path.size()) {
				if (!path.isEmpty()) {
					path.peek().left = node;
				}
			}
			else {
				while (level != path.size()) {
					path.pop();
				}
				path.peek().right = node;
			}
			path.push(node);
		}
		while (path.size() > 1) {
			path.pop();
		}
		return path.peek();
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