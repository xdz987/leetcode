package 树.字典树.q677_2_键值映射;

public class Solution {

}

/**
 * 方法一：字典树 + DFS
 */
class MapSum {
    TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    //插入word，word的最后一个字符存储val值
    public void insert(String key, int val) {
        TrieNode cur = root;
        for (int i = 0; i < key.length(); i++) {
            int cIndex = key.charAt(i) - 'a';
            //不存在则新建节点
            if (cur.children[cIndex] == null) {
                TrieNode cNode = new TrieNode();
                cur.children[cIndex] = cNode;
            }
            cur = cur.children[cIndex];
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        //(1)判断是否存在prefix开头的word
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int cIndex = prefix.charAt(i) - 'a';
            if (cur.children[cIndex] == null) {
                return 0;
            }
            cur = cur.children[cIndex];
        }

        //(2)dfs递归遍历所有以prefix为前缀的单词的val，并进行累加
        //先加当前节点/字符的val
        sum = cur.val;
        dfs(cur);
        return sum;
    }

    //深度遍历并累加cur下的所有字符的val
    int sum;
    private void dfs(TrieNode cur) {
        for (int i = 0; i < 26; i++) {
            if (cur.children[i] != null) {
                sum += cur.children[i].val;
                dfs(cur.children[i]);
            }
        }
    }

    class TrieNode {
        int val = 0;
        TrieNode[] children = new TrieNode[26];
    }
}