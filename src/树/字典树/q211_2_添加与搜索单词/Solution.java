package 树.字典树.q211_2_添加与搜索单词;


class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                TrieNode cNode = new TrieNode();
                cur.children[c - 'a'] = cNode;
            }
            cur = cur.children[c - 'a'];
            cur.preCount++;
        }
        cur.count++;
    }

    public boolean search(String word) {
        return searchHelp(word, root);
    }

    private boolean searchHelp(String word, TrieNode cur) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            //模糊搜索，循环所有的字符
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] != null) {
                        if (searchHelp(word.substring(i + 1), cur.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            }

            if (cur.children[c - 'a'] == null)
                return false;
            cur = cur.children[c - 'a'];
        }
        return cur.count > 0;
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