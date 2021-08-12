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
        for(char c:key.toCharArray()){
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(cur.children[c-'a'] == null){
                return 0;
            }
            cur = cur.children[c-'a'];
        }
        return fuzzySum(cur);
    }

    //深度遍历并累加cur下的所有字符的val
    private int fuzzySum(TrieNode cur){
        int res = cur.val;
        for(int i=0;i<26;i++){
            if(cur.children[i]!=null){
                res += fuzzySum(cur.children[i]);
            }
        } 
        return res;
    }

    class TrieNode{
        TrieNode[] children;
        int val;
        TrieNode(){
            children = new TrieNode[26];
            val = 0;
        }
    }
}