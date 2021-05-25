package 树.字典树.面1717_2_多次搜索;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 【二刷：淘汰此方法。之前不够熟练，就像《农场主与火鸡》一样在总结规律】
 *
 * 方法二：后缀树
 * 方案：以big的每个字符作为起点截取整段big查找于Trie
 *
 * 选用后缀树原因：方便定位到small词于big中的的起始位置
 * 例：
 * 思路是截取big中length~0或0~length长度的串。
 * 采用前缀是：0~length,1~length,2~length。到了Trie.find函数for循环从0开始，将失去small于big中的定位。
 * 采用后缀是：0~length,0~length-1，0~length-2。到了Trie.find函数的for循环的位置对应着big的位置，没有失去small于big中的定位
 *
 * Jav运行时间：406ms，30% 7%
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 test = new Solution2();
        String big = "mississippi";
        String[] smalls = new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"};
        int[][] res = test.multiSearch(big, smalls);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] multiSearch(String big, String[] smalls) {
        //(1)初始化前缀树、插入单词
        //初始化Map作为保存结果<small单词位于smalls数组的位置，small位于big的数组>
        Map<Integer, LinkedList<Integer>> statistics = new LinkedHashMap<>();
        Trie trie = new Trie();
        for (int i = 0; i < smalls.length; i++) {
            trie.insert(smalls[i], i);
            statistics.put(i, new LinkedList<>());
        }

        //(2)统计smalls词，截取0~length,0~length-1...进行查找，结果放入Map
        int length = big.length();
        for (int i = length; i >= 0; i--) {
            String partBig = big.substring(0, i);
            trie.find(partBig, statistics);
        }

        //(3)整理数据输出
        int[][] res = new int[smalls.length][];
        for (Map.Entry<Integer, LinkedList<Integer>> entry : statistics.entrySet()) {
            int size = entry.getValue().size();
            int[] tmp = new int[size];
            for (int i = 0; i < size; i++) {
                tmp[i] = entry.getValue().get(i);
            }
            res[entry.getKey()] = tmp;
        }
        return res;
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        //后缀插入，结尾字符存放为small位于smalls的下标索引
        public void insert(String word, int smallPosition) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int cIndex = word.charAt(i) - 'a';
                if (cur.children[cIndex] == null)
                    cur.children[cIndex] = new TrieNode();
                cur = cur.children[cIndex];
            }
            cur.smallPosition = smallPosition;
        }

        //后缀查找
        public void find(String partBig, Map<Integer, LinkedList<Integer>> statistics) {
            TrieNode cur = root;
            //后缀查找，i如果为small结尾，则为对应着small在big中的开始位置
            for (int i = partBig.length() - 1; i >= 0; i--) {
                int cIndex = partBig.charAt(i) - 'a';
                if (cur.children[cIndex] == null)
                    return;
                if (cur.children[cIndex].smallPosition != -1)
                    //题目要求small查询结果降序，这里是后缀树所以采用头插法还原为升序
                    statistics.get(cur.children[cIndex].smallPosition).add(0,i);
                cur = cur.children[cIndex];
            }
        }
    }

    class TrieNode {
        int smallPosition = -1;
        TrieNode[] children = new TrieNode[26];
    }
}
