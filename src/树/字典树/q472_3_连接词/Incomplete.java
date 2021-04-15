package 树.字典树.q472_3_连接词;

import 树.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法一：后缀树 + 多次搜索 + DFS
 * 思路：
 * 1. 以后缀的方式构建字典树，这样是为了定位【字典中的单词】位于【查询的单词】中的定位
 * 2. 以后缀的方式查询单词A，以单词A的每个字符作为起点查找所有【字典中单词】，并保存【字典中单词】于单词A中下标的开始与结尾至【下标二维数组】
 * - 剪枝：
 * (1)第一个字符就不符合，返回false
 * (2)位于中间，【下标二维数组】的最后一个元素，不与新增的【下标对/数组】先链接：如List[0,2]，新push[5,7]，2+1≠5，返回false
 * 3. 从【下标二维数组】中以0或length-1的下标作为起点，如[11,9]查找[x,y]中y为8的【下标对/数组】，进而进行查找链接，直到0，说明为【连接词】。例如[0,4]=>[5,7](不存在y为8的下标对/数组，false)、[5,8]=>[9,11]，为连接词。同时链接的下标数组>=2
 * - 由于为后缀树，所以查询的方式是【从尾链查到头】所有[x,y]是以x作为链接点。反之则是y作为链接点
 * - 【下标二维数组】特点：按序，升序或降序
 * <p>
 * 注意事项：
 * 1. 存在如etdogs、dogs冲突，所以不能将wor的长度存在isEnd位置，需使用StringBuilder自己拼接word
 * 2. 【下标二维数组】需排除查询的【单词自身】的【下标对/数组】
 * 3. 空字符串也算word，所以当存在""时，每个字典都构成连接词
 */
class Incomplete {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        //(1)初始化字典树
        Trie trie = new Trie();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            trie.insert(words[i]);
        }

        //(2)查找所有连接词
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (!words[i].isEmpty() && trie.findConcatenatedWord(words[i])) {
                res.add(words[i]);
            }
        }

        return res;
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        //后缀树
        public void insert(String word) {
            TrieNode cur = root;
            int len = word.length();
            for (int i = len - 1; i >= 0; i--) {
                int cIndex = word.charAt(i) - 'a';
                if (cur.children[cIndex] == null)
                    cur.children[cIndex] = new TrieNode();
                cur = cur.children[cIndex];
            }
            cur.isEnd = true;
        }

        public boolean findConcatenatedWord(String word) {
            int len = word.length();
            //(1)组成数组位于word索引的开始于结尾索引
            List<int[]> wordIndexList = new ArrayList<>();
            //(2)以word的每个字符为起点查找存在于word位置并记录下标，len不-1是因为substring区间为[x,y)
            for (int i = len; i > 0; i--) {
                String subWord = word.substring(0, i);
                find(subWord, wordIndexList);
            }

            //(3)判断是否为连接词
            return concatenated(wordIndexList);
        }

        public void find(String subWord, List<int[]> wordIndexList) {
            TrieNode cur = root;
            int len = subWord.length();
            //字典中的word。累加字符，记录单词
            int dictWordLen = 0;
//            StringBuilder sb = new StringBuilder();
            for (int i = len - 1; i >= 0; i--) {
                int cIndex = subWord.charAt(i) - 'a';
                if (cur.children[cIndex] == null)
                    return;
//                sb.append(subWord.charAt(i));
                dictWordLen++;
                //将下标插入下标二维数组
                if (cur.children[cIndex].isEnd) {
                    int[] wordPosition = new int[2];
                    wordPosition[0] = i;
                    wordPosition[1] = i + (dictWordLen - 1);
                    wordIndexList.add(wordPosition);
                }
                cur = cur.children[cIndex];
            }
        }

        private boolean concatenated(List<int[]> wordIndexList) {
            if (wordIndexList.isEmpty()) return false;
            int len = wordIndexList.size();
            /* 暂时搁这，因为可能要用到回溯或者动态规划，待学完回来补 */
            /* 回来了，可用回溯、欧拉通路 */
            for (int i = 0; i < len; i++) {
                System.out.println(Arrays.toString(wordIndexList.get(i)));
                System.out.println("---------");
            }
            return false;
        }


        class TrieNode {
            boolean isEnd = false;
            TrieNode[] children = new TrieNode[26];
        }
    }
}