package com.zxd.test.leetcode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @Author zouxiaodong
 * @Date 2020/09/28 8:16
 */
//117. 填充每个节点的下一个右侧节点指针 II
//        给定一个二叉树
//
//        struct Node {
//        int val;
//        Node *left;
//        Node *right;
//        Node *next;
//        }
//        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
//        初始状态下，所有 next 指针都被设置为 NULL。
//
//        进阶：
//
//        你只能使用常量级额外空间。
//        使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
//        示例：
//               1                   1 -> NULL
//             /   \               /  \
//            2     3             2 -> 3 -> NULL
//           / \     \           / \    \
//          4   5     7         4-> 5 -> 7 -> NULL
//            Figure A               Figure B
//        输入：root = [1,2,3,4,5,null,7]
//        输出：[1,#,2,3,#,4,5,7,#]
//        解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
//
//
//        提示：
//        树中的节点数小于 6000
//        -100 <= node.val <= 100
public class Connect_117 {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node root_l = new Node(2);
        Node root_l_l = new Node(4);
        Node root_l_r = new Node(5);
        Node root_r = new Node(3);
        Node root_r_r = new Node(7);
        root.left = root_l;
//        root.right = root_r;
//        root_l.left = root_l_l;
//        root_l.right = root_l_r;
//        root_r.right = root_r_r;
        Connect_117 connect117 = new Connect_117();
        connect117.connect(root);
    }

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            Node last = null;
            for(int i=1;i<=n;i++){
                Node node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                if(i != 1){
                    last.next = node;
                }
                last = node;
            }
        }
        return root;
    }


    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
