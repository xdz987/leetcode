package 树.字典树.面1717_2_多次搜索;

import java.util.*;

/**
 * 题意：类似于相当于统计文章中的敏感词并记录下标
 * 方法一：前缀树 + 双指针
 * 方案：以big的每个字符作为起点向后截取串查找前缀树
 *
 * Java运行时间：1867ms，时间空间都在10%以内
 */
public class Solution {
    public static void main(String[] args) {
        Solution test = new Solution();
        String big = "mississippi";
        String[] smalls = new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"};
        int[][] res = test.multiSearch(big, smalls);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] multiSearch(String article, String[] sensitive) {
        //(1)初始化前缀树、插入单词。初始化statistics存储结构，记录sensitive词汇顺序（方便后面转换为数组）
        Map<String, List<Integer>> statistics = new LinkedHashMap<>();
        Trie trie = new Trie();
        for (int i = 0; i < sensitive.length; i++) {
            trie.insert(sensitive[i]);
            statistics.put(sensitive[i], new LinkedList<>());
        }

        //(2)统计sensitive词。start指针0~length遍历article，end指向单词结尾
        int length = article.length();
        int start = 0;
        int end = 0;
        while (start < length) {
            //subString为[x,y)
            String word = article.substring(start, end + 1);
            //(2.1)不是敏感词字符，跳过该字符
            if (!trie.searchWith(word)) {
                end = ++start;
            }
            //(2.2)是敏感字符前缀，统计，end指针向前
            else {
                if (statistics.containsKey(word))
                    statistics.get(word).add(start);
                //(2.2.1)不停止，end+1继续判断是否为敏感词字符
                end++;
            }

            //(2.3)补充，start未结束，end已经超过结尾
            if (end > length - 1) {
                end = ++start;
            }
        }

        //(3)整理数据
        int[][] res = new int[sensitive.length][];
        int rIndex = 0;
        for (Map.Entry<String, List<Integer>> entry : statistics.entrySet()) {
            int size = entry.getValue().size();
            int[] tmp = new int[size];
            for (int i = 0; i < size; i++) {
                tmp[i] = entry.getValue().get(i);
            }
            res[rIndex++] = tmp;
        }
        return res;
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int cIndex = word.charAt(i) - 'a';
                if (cur.children[cIndex] == null)
                    cur.children[cIndex] = new TrieNode();
                cur = cur.children[cIndex];
            }
            cur.isEnd = true;
        }

        public boolean searchWith(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int cIndex = word.charAt(i) - 'a';
                if (cur.children[cIndex] == null)
                    return false;
                cur = cur.children[cIndex];
            }
            return true;
        }
    }

    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
}
