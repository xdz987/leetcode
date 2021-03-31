package 树.字典树.q820_2_单词的压缩编码;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 方法二：后缀树
 */
public class Solution2 {
    public int minimumLengthEncoding(String[] words) {
        //(1)排序，将长的字符串放前面
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        //(2)将每个word插入字典树，判断是否存在后缀，存在则不统计
        Trie trie = new Trie();
        int res = 0;
        for (String word : words) {
            if (!trie.searchWith(word)) {
                res += word.length() + 1;
            }
            trie.insert(word);
        }
        return res;
    }

    //字典树
    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            //反转word再插入树
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    TrieNode cNode = new TrieNode();
                    cur.children[c - 'a'] = cNode;
                }
                cur = cur.children[c - 'a'];
            }
        }

        public boolean searchWith(String prefix) {
            TrieNode cur = root;
            //反转prefix搜索
            for (int i = prefix.length() - 1; i >= 0; i--) {
                char c = prefix.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
        }
    }
}
