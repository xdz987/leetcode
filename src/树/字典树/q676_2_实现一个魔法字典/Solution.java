package 树.字典树.q676_2_实现一个魔法字典;

public class Solution {

}

/**
 * 方法一：字典树(模糊搜索)
 * 思路：对单词的每个字符进行模糊搜索(排除等于该字符的节点)，最好的情况是第一个，最坏的情况是最后一个模糊搜索
 *
 * Java执行：50% 18%
 */
class MagicDictionary {

    TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            insert(dictionary[i]);
        }
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

    public boolean search(String searchWord) {
        TrieNode cur = root;
        int length = searchWord.length();
        //(1)遍历searchWord所有字符，对每个字符尝试模糊搜索
        for (int i = 0; i < length; i++) {
            int cIndex = searchWord.charAt(i) - 'a';

            //(1.1)模糊搜索，不包括等于自身的字符，否则就不是模糊搜索了
            //如：等于自身的字符+后半段符合条件的字符=整段字符都符合，即无需替换字符，不符题意为false
            for (int j = 0; j < 26; j++) {
                if (cur.children[j] != null && j != cIndex) {
                    if (searchHelp(searchWord.substring(i + 1), cur.children[j])) {
                        return true;
                    }
                }
            }

            //(1.2)到此说明没有return true，判断该字符是否存在
            //不存在则说明：cIndex不符合，cIndex之和的字符至少一个不符合，那么两个字符不符合，不是魔法单词
            if (cur.children[cIndex] == null)
                return false;
            cur = cur.children[cIndex];
        }
        //(2)到此说明：前缀树不存在该单词（例如前缀树存在Hello，查询的是H*ll）
        return false;
    }

    //从cur开始判断子串是否存在
    public boolean searchHelp(String subWord, TrieNode cur) {
        for (int i = 0; i < subWord.length(); i++) {
            int cIndex = subWord.charAt(i) - 'a';
            if (cur.children[cIndex] == null)
                return false;
            cur = cur.children[cIndex];
        }
        return cur.isEnd;
    }

    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
}