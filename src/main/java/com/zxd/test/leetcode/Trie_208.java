package com.zxd.test.leetcode;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @Author zouxiaodong
 * @Date 2021/04/14 11:23
 */
//208. 实现 Trie (前缀树)
//        Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
//
//        请你实现 Trie 类：
//
//        Trie() 初始化前缀树对象。
//        void insert(String word) 向前缀树中插入字符串 word 。
//        boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
//        boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
//
//
//        示例：
//
//        输入
//        ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//        [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//        输出
//        [null, null, true, false, true, null, true]
//
//        解释
//        Trie trie = new Trie();
//        trie.insert("apple");
//        trie.search("apple");   // 返回 True
//        trie.search("app");     // 返回 False
//        trie.startsWith("app"); // 返回 True
//        trie.insert("app");
//        trie.search("app");     // 返回 True
//
//
//        提示：
//
//        1 <= word.length, prefix.length <= 2000
//        word 和 prefix 仅由小写英文字母组成
//        insert、search 和 startsWith 调用次数 总计 不超过 3 * 10^4 次
public class Trie_208 {

    private Trie_208[] children;
    private boolean isEnd;

    public Trie_208() {
        children = new Trie_208[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie_208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie_208();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie_208 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie_208 searchPrefix(String prefix) {
        Trie_208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie_208 trie_208 = new Trie_208();
        trie_208.insert("apple");
        System.out.println(trie_208.search("apple"));
        System.out.println(trie_208.search("app"));
        System.out.println(trie_208.startsWith("app"));
        trie_208.insert("app");
        System.out.println(trie_208.search("app"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */