package 树.字典树.q648_2_单词替换;

import java.util.List;

/**
 * 方法一：字典树
 */
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        //(1)将词根插入前缀树
        Trie trie = new Trie();
        for(String word:dictionary){
            trie.insert(word);
        }

        //(2)将句子拆分为单词数组
        String[] sentenceArr = sentence.split(" ");

        //(3)查找每个单词是否存在词根替换，存在则替换
        StringBuilder res = new StringBuilder();
        for(String word:sentenceArr){
            res.append(trie.find(word));
            res.append(" ");
        }

        //取掉最后一个空格
        return res.substring(0,res.length()-1);
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for(char c:word.toCharArray()){
                if(cur.children[c-'a'] ==null){
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.isEnd = true;
        }

        //返回最短词根，不存在则返回""字符串
        public String find(String word) {
            TrieNode cur = root;
            StringBuilder sb = new StringBuilder();
            for(char c:word.toCharArray()){
                sb.append(c);
                if(cur.children[c-'a'] == null){
                    return word;
                }else{
                    if(cur.children[c-'a'].isEnd){
                        return sb.toString();
                    }
                    cur = cur.children[c-'a'];
                }
            }
            return word;
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;
        }
    }
}
