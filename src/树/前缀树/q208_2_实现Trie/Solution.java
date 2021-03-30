package 树.前缀树.q208_2_实现Trie;

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word.isEmpty()) return;
        TrieNode cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (cur.children[word.charAt(i) - 'a'] == null)
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            cur = cur.children[word.charAt(i) - 'a'];
            cur.preCount++;
        }
        cur.count++;
    }

    public boolean search(String word) {
        if (word.isEmpty()) return false;
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null)
                return false;
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.count > 0;
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) return false;
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.children[prefix.charAt(i) - 'a'] == null)
                return false;
            cur = cur.children[prefix.charAt(i) - 'a'];
        }
        return cur.preCount > 0;
    }

    class TrieNode {
        int count;
        int preCount;
        TrieNode[] children;

        TrieNode() {
            count = 0;
            preCount = 0;
            children = new TrieNode[26];
        }
    }
}
