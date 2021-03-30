package 树.前缀树;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树——任意字符
 */
public class Trie2 {
    //根节点
    TrieNode root;

    //初始化根节点
    public Trie2() {
        root = new TrieNode();
    }

    //插入单词API void
    public void insert(String word) {
        TrieNode node = root;
        //循环插入单词/串的每个字符
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                TrieNode cNode = new TrieNode();
                node.children.put(c, cNode);
            }
            node = node.children.get(c);
            //以该字符为前缀的单词/串+1
            node.preCount++;
        }
        //以该字符为结尾的单词/串+1
        node.count++;
    }

    //搜索单词API boolean
    public boolean search(String word) {
        TrieNode node = root;
        //循环查找单词的每个字符，node作为游标
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c))
                return false;
            node = node.children.get(c);
        }
        return node.count > 0;
    }

    //查找是否存在以prefix为前缀的单词 boolean
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        //循环查找单词的每个字符，node作为游标
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!node.children.containsKey(c))
                return false;
            node = node.children.get(c);
        }
        return node.preCount > 0;
    }

    private class TrieNode {
        //以该节点作为结尾的单词/串的个数
        int count;
        //以该节点作为前缀的单词/串的个数
        int preCount;
        //存在子节点的数组
        Map<Character, TrieNode> children;

        TrieNode() {
            children = new HashMap<>();
            count = 0;
            preCount = 0;
        }
    }
}
