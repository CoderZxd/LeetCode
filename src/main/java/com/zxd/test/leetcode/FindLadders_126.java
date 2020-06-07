package com.zxd.test.leetcode;

import java.util.*;

/**
 * @ClassName FindLadders_126
 * @Description https://leetcode-cn.com/problems/word-ladder-ii/
 * @Author xiaodong.zou
 * @Date 2020/6/7 10:46
 * @Version 1.0
 */
//126. 单词接龙 II
//        给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
//
//        每次转换只能改变一个字母。
//        转换过程中的中间单词必须是字典中的单词。
//        说明:
//
//        如果不存在这样的转换序列，返回一个空列表。
//        所有单词具有相同的长度。
//        所有单词只由小写字母组成。
//        字典中不存在重复的单词。
//        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//        示例 1:
//
//        输入:
//        beginWord = "hit",
//        endWord = "cog",
//        wordList = ["hot","dot","dog","lot","log","cog"]
//
//        输出:
//        [
//        ["hit","hot","dot","dog","cog"],
//        ["hit","hot","lot","log","cog"]
//        ]
//        示例 2:
//
//        输入:
//        beginWord = "hit"
//        endWord = "cog"
//        wordList = ["hot","dot","dog","lot","log"]
//
//        输出: []
//
//        解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
public class FindLadders_126 {

    private static final int INF = 1 << 20;
    private Map<String, Integer> wordId; // 单词到id的映射
    private ArrayList<String> idWord; // id到单词的映射
    private ArrayList<Integer>[] edges; // 图的边

    public static void main(String[] args) {
        String[] wordArray = new String[]{"hot","dot","dog","lot","log","cog"};
        String beginWord = "hit";
        String endWord = "cog";
    }

//    方法一：广度优先搜索
//            思路
//
//    本题要求的是最短转换序列，看到最短首先想到的就是 BFS。想到 BFS 自然而然的就能想到图，但是本题并没有直截了当的给出图的模型，因此我们需要把它抽象成图的模型。
//
//    我们可以把每个单词都抽象为一个点，如果两个单词可以只改变一个字母进行转换，那么说明他们之间有一条双向边。因此我们只需要把满足转换条件的点相连，就形成了一张图。
//    根据示例 1 中的输入，我们可以建出下图：
//
//
//
//    基于该图，我们以 hit 为图的起点， 以cog 为终点进行广度优先搜索（BFS），寻找 hit 到 cog 的最短路径。下图即为答案中的一条路径。
//
//
//
//    最大的难点解决了，我们再考虑其他要求。本题要求输出所有的最短路径。那么我们在到达某个点的时候需要把它前面经过的点一起记录下来放到一起，当到达终点的时候一起输出到结果中。
//
//    算法
//
//    基于上面的思路我们考虑如何编程实现。
//
//    方便起见，我们先给每一个单词标号，即给每个单词分配一个 id。创建一个由单词 word到 id 对应的映射 wordId，并将 beginWord 与 wordList 中所有的单词都加入这个映射中。
//    之后我们检查 endWord 是否在该映射内，若不存在，则输入无解。我们可以使用哈希表实现上面的映射关系。
//
//    同理我们可以创建一个由对应 id 到 word 的映射 idWord，方便最后输出结果。由于 id 实际上是整数且连续，所以这个映射用数组实现即可。
//
//    接下来我们将 idWord 中的单词两两匹配，检查它们是否可以通过改变一个字母进行互相转换。如果可以，则在这两个点之间建一条双向边。
//
//    为了保留相同长度的多条路径，我们采用 cost 数组，其中 cost[i] 表示 beginWord 对应的点到第 i 个点的代价（即转换次数）。初始情况下其所有元素初始化为无穷大。
//
//    接下来将起点加入队列开始广度优先搜索，队列的每一个节点中保存从起点开始的所有路径。
//
//    对于每次取出的节点 now，每个节点都是一个数组，数组中的最后一个元素为当前路径的最后节点 last :
//
//    若该节点为终点，则将其路径转换为对应的单词存入答案;
//    若该节点不为终点，则遍历和它连通的节点（假设为 to ）中满足cost[to]>=cost[now]+1 的加入队列，并更新 cost[to]=cost[now]+1。如果 cost[to]<cost[now]+1，说明这个节点已经被访问过，不需要再考虑。
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/word-ladder-ii/solution/dan-ci-jie-long-ii-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        // 将wordList所有单词加入wordId中 相同的只保留一个 // 并为每一个单词分配一个id
        for (String word : wordList) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, id++);
                idWord.add(word);
            }
        }
        // 若endWord不在wordList中 则无解
        if (!wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }
        // 把beginWord也加入wordId中
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }

        // 初始化存边用的数组
        edges = new ArrayList[idWord.size()];
        for (int i = 0; i < idWord.size(); i++) {
            edges[i] = new ArrayList<>();
        }
        // 添加边
        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                // 若两者可以通过转换得到 则在它们间建一条无向边
                if (transformCheck(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int dest = wordId.get(endWord); // 目的ID
        List<List<String>> res = new ArrayList<>(); // 存答案
        int[] cost = new int[id]; // 到每个点的代价
        for (int i = 0; i < id; i++) {
            cost[i] = INF; // 每个点的代价初始化为无穷大
        }

        // 将起点加入队列 并将其cost设为0
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        q.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;

        // 开始广度优先搜索
        while (!q.isEmpty()) {
            ArrayList<Integer> now = q.poll();
            int last = now.get(now.size() - 1); // 最近访问的点
            if (last == dest) { // 若该点为终点则将其存入答案res中
                ArrayList<String> tmp = new ArrayList<>();
                for (int index : now) {
                    tmp.add(idWord.get(index)); // 转换为对应的word
                }
                res.add(tmp);
            } else { // 该点不为终点 继续搜索
                for (int i = 0; i < edges[last].size(); i++) {
                    int to = edges[last].get(i);
                    // 此处<=目的在于把代价相同的不同路径全部保留下来
                    if (cost[last] + 1 <= cost[to]) {
                        cost[to] = cost[last] + 1;
                        // 把to加入路径中
                        ArrayList<Integer> tmp = new ArrayList<>(now); tmp.add(to);
                        q.add(tmp); // 把这个路径加入队列
                    }
                }
            }
        }
        return res;
    }

    // 两个字符串是否可以通过改变一个字母后相等
    boolean transformCheck(String str1, String str2) {
        int differences = 0;
        for (int i = 0; i < str1.length() && differences < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                ++differences;
            }
        }
        return differences == 1;
    }
}
