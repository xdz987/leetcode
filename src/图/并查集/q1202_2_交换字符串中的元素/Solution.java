package 图.并查集.q1202_2_交换字符串中的元素;

import java.util.*;

/**
 * 方法一：并查集+手动排序字符。
 */
public class Solution {
    int[] parent;
    int[] size;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        //(1)并查集初始化
        int len = s.length();
        parent = new int[len];
        size = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        //(2)将能够交换的字符的索引进行联通
        for (int i = 0; i < pairs.size(); i++) {
            union(pairs.get(i).get(0), pairs.get(i).get(1));
        }

        //(3)将同一祖先的字符的索引整理成Map，<祖先字符索引，祖先下的字符索引列表>
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int parent = find(i);
            List<Integer> tmp = map.getOrDefault(parent, new ArrayList<>());
            tmp.add(i);
            //覆盖
            map.put(parent, tmp);
        }

        //(4)将同一祖先的字符进行 "字典序最小" 进行排序
        char[] ss = s.toCharArray();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int cIndexSize = entry.getValue().size();
            //(4.1)先填充为#，方便排完序后回填
            List<Character> tmp = new ArrayList<>();
            for (int i = 0; i < cIndexSize; i++) {
                tmp.add(ss[entry.getValue().get(i)]);
                ss[entry.getValue().get(i)] = '#';
            }
            //(4.2)对同一祖先的字符进行排序
            Collections.sort(tmp);
            //(4.3)回填
            int j = 0;
            for (int i = 0; i < len; i++) {
                if (ss[i] == '#') {
                    ss[i] = tmp.get(j++);
                }
            }
        }
        return new String(ss);
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int q, int p) {
        int rootQ = find(q);
        int rootP = find(p);
        if (rootP == rootQ)
            return;

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }
}