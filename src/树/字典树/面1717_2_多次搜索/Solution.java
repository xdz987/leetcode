package 树.字典树.面1717_2_多次搜索;

import java.util.*;

/**
 * 方法一：前缀树
 * Java运行时间：45ms 78%
 */
public class Solution {
    List<List<Integer>> resList = new ArrayList();

    public int[][] multiSearch(String big, String[] smalls) {
        Trie trie = new Trie(big);
        int n = smalls.length;
        for (int i = 0; i < n; i++) {
            trie.insert(smalls[i], i);
            resList.add(new ArrayList<>());
        }

        int len = big.length();
        for (int i = 0; i < len; i++) {
            trie.search(i, len);
        }

        int[][] res = new int[n][];
        int resI = 0;
        for (List<Integer> list : resList) {
            int[] tmp = new int[list.size()];
            int i = 0;
            for (int num : list) {
                tmp[i++] = num;
            }
            res[resI++] = tmp;
        }
        return res;
    }

    class Trie {
        char[] big;
        TrieNode root;

        Trie(String big) {
            this.big = big.toCharArray();
            root = new TrieNode();
        }

        public void insert(String word, int position) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int cI = c - 'a';
                if (cur.children[cI] == null) {
                    cur.children[cI] = new TrieNode();
                }
                cur = cur.children[cI];
            }
            cur.position = position;
        }

        public void search(int start, int end) {
            TrieNode cur = root;
            for (int i = start; i < end; i++) {
                int cI = big[i] - 'a';
                if (cur.children[cI] == null) {
                    return;
                }
                cur = cur.children[cI];
                if (cur.position != -1) {
                    resList.get(cur.position).add(start);
                }
            }
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int position = -1;
        }
    }
}
