package 图.并查集.q1202_2_交换字符串中的元素;

import java.util.*;

/**
 * 方法二：并查集+小顶堆(jdk自带)
 */
public class Solution2 {
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

        //(3)将同一祖先的字符的索引整理成Map <祖先字符索引，小顶堆(队列)<祖先下的字符列表>>
        char[] ss = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int parent = find(i);
            //添加字符到map对应祖先的小顶堆
            if (map.containsKey(parent)) {
                map.get(parent).offer(ss[i]);
            } else {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(ss[i]);
                map.put(parent, minHeap);
            }
        }

        //(4)整理返回数据
        //关于小顶堆：例如并查集中某祖先3-->[5,3,4,6]，而再map中则是祖先3-->小顶堆[a,c,e,b]（即字符完全对应索引，但最小字符在顶部）
        //当循环到3,4,5,6时，会去[a,c,e,b]中取一个字符-->[a,c,e,b]->[b,c,e]->[c,e]->[e]
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int parent = find(i);
            //保存祖先parent的最小字符
            sb.append(map.get(parent).poll());
        }
        return sb.toString();
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
