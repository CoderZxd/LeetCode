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
    /**
     * 通过广度遍历，找出节点与节点之前的父子关系(一个父节点的两个子节点位置为2n+1,2n+2)，2n+1即奇数一定是左节点，2n+2即偶数一定是右节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer,Integer> valToPosMap = new HashMap<>(16);
        Map<Integer,TreeNode> posToTreeNodeMap = new HashMap<>(16);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        valToPosMap.put(root.val,0);
        posToTreeNodeMap.put(0,root);
        // 先进先出
        while (!queue.isEmpty()) {
            TreeNode tempTreeNode = queue.remove();
            if (tempTreeNode.left != null){
                queue.add(tempTreeNode.left);
                valToPosMap.put(tempTreeNode.left.val,valToPosMap.get(tempTreeNode.val)*2+1);
                posToTreeNodeMap.put(valToPosMap.get(tempTreeNode.val)*2+1,tempTreeNode.left);
            }
            if (tempTreeNode.right != null){
                queue.add(tempTreeNode.right);
                valToPosMap.put(tempTreeNode.right.val,valToPosMap.get(tempTreeNode.val)*2+2);
                posToTreeNodeMap.put(valToPosMap.get(tempTreeNode.val)*2+2,tempTreeNode.right);
            }
        }
        System.out.println("valToPosMap---->"+valToPosMap);
        //找出节点所有的父节点位置，找到离该节点最近的相同的节点即为最近父节点
        //找节点p所有的父节点位置
        int posP = valToPosMap.get(p.val);
        System.out.println("posP----->"+posP);
        List<Integer> parentsP = new ArrayList<>(10);
        //将P的位置加入
        parentsP.add(posP);
        getParentsPos(posP,parentsP);
        System.out.println("parentsP---->"+parentsP);
        int posQ = valToPosMap.get(q.val);
        System.out.println("posQ----->"+posQ);
        List<Integer> parentsQ = new ArrayList<>(10);
        //将Q的位置加入
        parentsQ.add(posQ);
        getParentsPos(posQ,parentsQ);
        System.out.println("parentsQ---->"+parentsQ);
        //找到parentsP和parentsQ最大的相同数即为最近的父节点所在的位置
        int commonParentPos = -1;
        int parentPSize = parentsP.size();
        int parentQSize = parentsQ.size();
        int i = 0,j = 0;
        while (i<parentPSize || j<parentQSize){
            if(parentsP.get(i).equals(parentsQ.get(j))){
                commonParentPos = parentsP.get(i);
                break;
            }
            if(parentsP.get(i) > parentsQ.get(j)){
                i++;
            }else{
                j++;
            }
        }
        System.out.println("commonParentPos===="+commonParentPos);
        //将该位置的节点进行返回
        TreeNode treeNode = posToTreeNodeMap.get(commonParentPos);
        return treeNode;
    }

    /**
     * 获取父节点位置列表
     * @param pos
     * @param parents
     */
    private static void getParentsPos(int pos, List<Integer> parents){
        if(pos%2==0){
            int parent =  (pos-2)/2;
            if(parent < 0){
                return;
            }
            parents.add(parent);
            getParentsPos(parent,parents);
        }
        if(pos%2==1){
            int parent =  (pos-1)/2;
            if(parent < 0){
                return;
            }
            parents.add(parent);
            getParentsPos(parent,parents);
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
