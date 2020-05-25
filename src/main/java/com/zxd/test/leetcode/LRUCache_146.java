package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: LRUCache_146
 * @Description: https://leetcode-cn.com/problems/lru-cache/
 * @Author xiaodong.zou
 * @Date 2020/5/25 9:17
 */

//146. LRU缓存机制
//		运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
//		获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//		写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
//		进阶:
//
//		你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
//		示例:
//
//		LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//		cache.put(1, 1);
//		cache.put(2, 2);
//		cache.get(1);       // 返回  1
//		cache.put(3, 3);    // 该操作会使得密钥 2 作废
//		cache.get(2);       // 返回 -1 (未找到)
//		cache.put(4, 4);    // 该操作会使得密钥 1 作废
//		cache.get(1);       // 返回 -1 (未找到)
//		cache.get(3);       // 返回  3
//		cache.get(4);       // 返回  4

public class LRUCache_146 {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // 返回  1
		cache.put(3, 3);    // 该操作会使得密钥 2 作废
		System.out.println(cache.get(2));       // 返回 -1 (未找到)
		cache.put(4, 4);    // 该操作会使得密钥 1 作废
		System.out.println(cache.get(1));       // 返回 -1 (未找到)
		System.out.println(cache.get(3));       // 返回  3
		System.out.println(cache.get(4));       // 返回  4
	}

}


class LRUCache {

	private int capacity = 0;

	private Map<Integer,Node> cacheMap = new HashMap<>(16);

	private Node head;

	private Node tail;

	private int count = 0;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		Node headNode = new Node(null,null);
		Node tailNode = new Node(null,null);
		headNode.next = tailNode;
		tailNode.pre = headNode;
		this.head = headNode;
		this.tail = tailNode;
	}

	public int get(int key) {
		if(cacheMap.containsKey(key)){
			Node node = cacheMap.get(key);
			//将node从原node中摘除
			Node pre = node.pre;
			Node next = node.next;
			pre.next = next;
			next.pre = pre;
			//将node加入到头部
			Node headNext = head.next;
			node.next = headNext;
			node.pre = head;
			headNext.pre = node;
			head.next = node;
			return node.val;
		}
		return -1;
	}

	public void put(int key, int value) {
		Node node = cacheMap.get(key);
		if(node == null){
			if(count<capacity){
				Node newNode = new Node(key,value);
				Node headNext = head.next;
				headNext.pre = newNode;
				newNode.pre = head;
				head.next = newNode;
				newNode.next = headNext;
				cacheMap.put(key,newNode);
				count++;
			}else{
				//先删除尾节点
				Node tailPre = tail.pre;
				Node tailPrePre = tailPre.pre;
				tailPre.next = tail;
				tail.pre = tailPrePre;
				tailPre.next = null;
				tailPre.pre = null;
				cacheMap.remove(tailPre.key);
				count--;
				//再添加
				Node newNode = new Node(key,value);
				Node headNext = head.next;
				headNext.pre = newNode;
				newNode.pre = head;
				head.next = newNode;
				newNode.next = headNext;
				cacheMap.put(key,newNode);
				count++;
			}
		}else{
			//移动至头部
			Node pre = node.pre;
			Node next = node.next;
			pre.next = next;
			next.pre = pre;
			Node headNext = head.next;
			head.next = node;
			node.next = headNext;
			headNext.pre = node;
			node.pre = head;
		}
	}
}

class Node{
	Integer key;
	Integer val;
	Node pre;
	Node next;
	Node(Integer key,Integer val){
		this.key = key;
		this.val = val;
	}
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */