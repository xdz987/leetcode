package 树.字典树.q648_2_单词替换;

import java.util.List;

/**
 * 方法一：字典树
 */
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        //(1)将词根插入前缀树
        Trie trie = new Trie();
        for (String pre : dictionary) {
            trie.insert(pre);
        }

        //(2)将句子拆分为单词数组
        String[] words = sentence.split(" ");

        //(3)查找每个单词是否存在词根替换，存在则替换
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String searchRes = trie.search(words[i]);
            if (searchRes != "")
                words[i] = searchRes;
            res.append(words[i]);
            res.append(" ");
        }

        //去掉最后一个空格
        return res.substring(0, res.length() - 1);
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    TrieNode cNode = new TrieNode();
                    cur.children[c - 'a'] = cNode;
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
        }

        //返回最短词根，不存在则返回""字符串
        public String search(String word) {
            TrieNode cur = root;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] != null) {
                    res.append(c);
                    cur = cur.children[c - 'a'];
                } else {
                    return "";
                }
                //到此节点为止为前缀则直接返回
                if (cur.isEnd) {
                    return res.toString();
                }
            }
            return "";
        }

        class TrieNode {
            boolean isEnd = false;
            TrieNode[] children = new TrieNode[26];
        }
    }
}
