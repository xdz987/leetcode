package 树.前缀树;

/**
 * 字典树——小写字母
 */
public class Trie {
    //根节点
    TrieNode root;

    //初始化根节点
    public Trie() {
        root = new TrieNode();
    }

    //插入单词API void
    public void insert(String word) {
        TrieNode node = root;
        //循环插入单词/串的每个字符
        for (int i = 0; i < word.length(); i++) {
            //如不存再word[i]字符，则插入。指针node指向word[i]字符的节点
            if (node.children[word.charAt(i) - 'a'] == null)
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            node = node.children[word.charAt(i) - 'a'];
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
            if (node.children[word.charAt(i) - 'a'] == null)
                return false;
            node = node.children[word.charAt(i) - 'a'];
        }
        return node.count > 0;
    }

    //查找是否存在以prefix为前缀的单词 boolean
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        //循环查找单词的每个字符，node作为游标
        for (int i = 0; i < prefix.length(); i++) {
            if (node.children[prefix.charAt(i) - 'a'] == null)
                return false;
            node = node.children[prefix.charAt(i) - 'a'];
        }
        return node.preCount > 0;
    }

    private class TrieNode {
        //以该节点作为结尾的单词/串的个数
        int count;
        //以该节点作为前缀的单词/串的个数
        int preCount;
        //存在子节点的数组
        TrieNode[] children;

        TrieNode() {
            //26个字母
            children = new TrieNode[26];
            count = 0;
            preCount = 0;
        }
    }
}
