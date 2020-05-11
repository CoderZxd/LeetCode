package com.zxd.test.leetcode;


import java.util.*;

/**
 * @ClassName LowestCommonAncestor_236
 * @Description https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @Author xiaodong.zou
 * @Date 2020/5/10 10:58
 * @Version 1.0
 */
//236. 二叉树的最近公共祖先
//        给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//        例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//
//        示例 1:
//
//        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//        输出: 3
//        解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//        示例 2:
//
//        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//        输出: 5
//        解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//
//        说明:
//
//        所有节点的值都是唯一的。
//        p、q 为不同节点且均存在于给定的二叉树中。
public class LowestCommonAncestor_236 {

    public static void main(String[] args) {
        TreeNode treeNode_4 = new TreeNode(4);
        TreeNode treeNode_7 = new TreeNode(7);
        TreeNode treeNode_2 = new TreeNode(2);
        treeNode_2.left = treeNode_7;
        treeNode_2.right = treeNode_4;
        TreeNode treeNode_6 = new TreeNode(6);
        TreeNode treeNode_5 = new TreeNode(5);
        treeNode_5.left = treeNode_6;
        treeNode_5.right = treeNode_2;
        TreeNode treeNode_0 = new TreeNode(0);
        TreeNode treeNode_8 = new TreeNode(8);
        TreeNode treeNode_1 = new TreeNode(1);
        treeNode_1.left = treeNode_0;
        treeNode_1.right = treeNode_8;
        TreeNode treeNode_3 = new TreeNode(3);
        treeNode_3.left = treeNode_5;
        treeNode_3.right = treeNode_1;
        prefs(treeNode_3);
        System.out.println("-----------------------------");
        infs(treeNode_3);
        System.out.println("-----------------------------");
        afterfs(treeNode_3);
        System.out.println("-----------------------------");
        dfs(treeNode_3);
        System.out.println("=====================================");
        lowestCommonAncestor(treeNode_3,new TreeNode(5),new TreeNode(4));
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
//    方法二：存储父节点
//            思路
//
//    我们可以用哈希表存储所有节点的父节点，然后我们就可以利用节点的父节点信息从 p 结点开始不断往上跳，并记录已经访问过的节点，再从 q 节点开始不断往上跳，如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先。
//
//    算法
//
//    从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针。
//    从 p 节点开始不断往它的祖先移动，并用数据结构记录已经访问过的祖先节点。
//    同样，我们再从 q 节点开始不断往它的祖先移动，如果有祖先已经被访问过，即意味着这是 p 和 q 的深度最深的公共祖先，即 LCA 节点。
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<Integer> visitedSet = new HashSet<>(16);
        Map<Integer, TreeNode> parentsMap = new HashMap<>(16);
        getParents(root,parentsMap);
        while(p != null){
            visitedSet.add(p.val);
            p = parentsMap.get(p.val);
        }
        while (q!= null){
            if(visitedSet.contains(q.val)){
                return q;
            }
            q = parentsMap.get(q.val);
        }
        return null;
    }

    /**
     * 获取节点的父节点信息
     * @param treeNode
     * @param parentsMap
     */
    public static void getParents(TreeNode treeNode,Map<Integer, TreeNode> parentsMap){
        if(treeNode.left != null){
            parentsMap.put(treeNode.left.val,treeNode);
            getParents(treeNode.left,parentsMap);
        }
        if(treeNode.right != null){
            parentsMap.put(treeNode.right.val,treeNode);
            getParents(treeNode.right,parentsMap);
        }
    }


    /**
     * 前序遍历
     * @param treeNode
     */
    public static void prefs(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        System.out.println(treeNode.val);
        prefs(treeNode.left);
        prefs(treeNode.right);
    }

    /**
     * 中序遍历
     * @param treeNode
     */
    public static void infs(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        infs(treeNode.left);
        System.out.println(treeNode.val);
        infs(treeNode.right);
    }

    /**
     * 后序遍历
     * @param treeNode
     */
    public static void afterfs(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        afterfs(treeNode.left);
        afterfs(treeNode.right);
        System.out.println(treeNode.val);
    }

    /**
     * 广度优先遍历
     * @param treeNode
     */
    public static void dfs(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        // 先进先出
        while (!queue.isEmpty()) {
            TreeNode tempTreeNode = queue.remove();
            System.out.println(tempTreeNode.val);
            if (tempTreeNode.left != null){
                queue.add(tempTreeNode.left);
            }
            if (tempTreeNode.right != null){
                queue.add(tempTreeNode.right);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
