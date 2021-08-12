package 树.字典树.q211_2_添加与搜索单词;

/**
 * 方法一：字典树
 * 基本与字典树相同，只是增加模糊搜搜的逻辑
 * 模糊搜索逻辑：字符为特殊字符(模糊)时
 * 1. 搜索该层节点的所有children
 * 2. 字符串截取起点作为该节点
 * 3. 并以该children节点作为起点搜索
 */
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

    public boolean search2(String word) {
        return searchHelp2(root,word.toCharArray(),0);
    }
    private boolean searchHelp2(TrieNode cur,char[] wArr,int index){
        for(int i=index;i<wArr.length;i++){
            char c = wArr[i];
            if(wArr[i] == '.'){
                for(int j=0;j<26;j++){
                    if(cur.children[j] !=null && searchHelp2(cur.children[j],wArr,i+1)){
                        return true;
                    }
                }
                return false;
            }

            if(cur.children[c-'a'] == null)
                return false;
            cur = cur.children[c-'a'];
        }
        return cur.count>0;
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