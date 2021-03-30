package 图.并查集.面1707_2_婴儿名字;

import java.util.*;

/**
 * 并查集-僵硬版（超时）
 * 重点：并查集的parent要以实际计算目标为准！
 * 比如本题的parent应当是names数组，而不是synonyms数组。因为synonyms数组没有全覆盖names数组的所有name，导致需要些额外逻辑，变得很麻烦
 */
public class OverTime {
    int[] parent;
    int[] size;

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        //(1)初始化并查集
        int lenNames = names.length;
        int lenSyn = synonyms.length;
        parent = new int[lenNames];
        size = new int[lenNames];
        for (int i = 0; i < lenNames; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        //(2)联通同名。只有synonyms[i]的两个名字都存在于names时才需要联通
        for (int i = 0; i < lenSyn; i++) {
            String[] synonym = synonyms[i].substring(1, synonyms[i].length() - 1).split(",");
            boolean name1Exist = false;
            boolean name2Exist = false;
            int name2Index = -1;
            int name1Index = -1;
            for (int j = 0; j < lenNames; j++) {
                String name = names[j].split("\\(")[0];
                if (name.equals(synonym[0])) {
                    name1Exist = true;
                    name1Index = j;
                }
                if (name.equals(synonym[1])) {
                    name2Exist = true;
                    name2Index = j;
                }
            }
            if (name1Exist && name2Exist)
                union(name1Index, name2Index);
        }

        //(3)将频率进行累加统计 <name的祖先,freq>
        Map<Integer, Integer> parentToFreq = new HashMap<>();
        // <name的祖先，最小name> 存放最小name
        Map<Integer, String> parentToMinName = new HashMap<>();
        for (int i = 0; i < lenNames; i++) {
            //(3.1)拆分为姓名和频率
            String[] tmp = names[i].split("\\(");
            String name = tmp[0];
            int freq = Integer.parseInt(tmp[1].substring(0, tmp[1].length() - 1));
            int parent = find(i);
            parentToFreq.put(parent, parentToFreq.getOrDefault(parent, 0) + freq);

            //(3.2)始终保持最字典序的name
            if (parentToMinName.containsKey(parent)) {
                if (parentToMinName.get(parent).compareTo(name) > 0) {
                    parentToMinName.put(parent, name);
                }
            } else {
                parentToMinName.put(parent, name);
            }
        }

        //(4)整理数据
        int realNameSize = parentToFreq.size();
        String[] res = new String[realNameSize];
        int j = 0;
        for (Map.Entry<Integer, Integer> entry : parentToFreq.entrySet()) {
            StringBuilder realName = new StringBuilder();
            String name = parentToMinName.get(entry.getKey());
            realName.append(name);
            realName.append("(");
            realName.append(entry.getValue());
            realName.append(")");
            res[j++] = realName.toString();
        }

        return res;
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
        if (rootP == rootQ) return;
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }
}
