package 树.字典树.q820_2_单词的压缩编码;

import java.util.Arrays;

/**
 * 方法二：后缀树
 */
public class Solution2 {
    public int minimumLengthEncoding(String[] words) {
        //(1)升序，将长的字符串放前面
        Arrays.sort(words, (s1, s2) -> (s2.length() - s1.length()));

        //(2)将每个word插入字典树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie.indicesLen;
    }

    class Trie {
        TrieNode root;
        int indicesLen = 0;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
                cur.preCount++;
            }
            //为1说明是新单词，累加长度
            if (cur.preCount == 1) {
                indicesLen += word.length() + 1;
            }
        }

        class TrieNode {
            TrieNode[] children;
            int preCount;

            TrieNode() {
                children = new TrieNode[26];
                preCount = 0;
            }
        }
    }
}
