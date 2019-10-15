package com.zxd.test.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRU<k,v> {

    private int capacity;

    private int count;

    private Map<k,Node<k,v>> nodeMap;

    private Node<k,v> head;

    private Node<k,v> tail;

    public LRU(int capacity){
        if(capacity < 1){
            throw new IllegalArgumentException(String.valueOf(capacity));
        }
        this.capacity = capacity;
        this.nodeMap = new HashMap<>(16);
        Node headNode = new Node(null,null);
        Node tailNode = new Node(null,null);
        headNode.next = tailNode;
        tailNode.pre = headNode;
        this.head = headNode;
        this.tail = tailNode;
    }

    public void put(k key,v value){
        Node<k,v> node = nodeMap.get(key);
        if(node == null){
            if(count >= capacity){
                removeNode();
            }
            node = new Node(key,value);
            addNode(node);
        }else{
            removeNodeFromList(node);
            addNodeToHead(node);
        }
    }

    private void addNode(Node<k,v> node){
        addNodeToHead(node);
        nodeMap.put(node.key,node);
        count++;
    }

    private void addNodeToHead(Node<k,v> node){
        Node next = head.next;
        next.pre = node;
        node.next = next;
        node.pre = head;
        head.next = node;
    }

    private void removeNode(){
        Node node = tail.pre;
        removeNodeFromList(node);
        nodeMap.remove(node.key);
        count--;
    }

    private void removeNodeFromList(Node<k,v> node){
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.next = null;
        next.pre = null;
    }

    class Node<k,v>{

        private k key;

        private v value;

        private Node next;

        private Node pre;

        public Node(k key,v value){
            this.key = key;
            this.value = value;
        }

    }
}
