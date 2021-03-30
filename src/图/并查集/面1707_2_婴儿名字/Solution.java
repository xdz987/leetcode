package 图.并查集.面1707_2_婴儿名字;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 并查集[按字典序union] + 前缀和
 */
public class Solution {
    //并查集parent
    Map<String, String> parent;
    //parent name附带前缀和频率
    Map<String, Integer> freqPreSum;

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        int nameLen = names.length;
        int synLen = synonyms.length;

        //(1)初始化并查集
        parent = new HashMap<>();
        freqPreSum = new HashMap<>();
        for (int i = 0; i < nameLen; i++) {
            //(1.1)拆分为姓名和频率
            String[] tmp = names[i].split("\\(");
            String name = tmp[0];
            int freq = Integer.parseInt(tmp[1].substring(0, tmp[1].length() - 1));
            //初始祖先为自己
            parent.put(name, name);
            //初始前缀和等于自己
            freqPreSum.put(name, freq);
        }

        //(2)联通同义的name
        for (int i = 0; i < synLen; i++) {
            String[] synonym = synonyms[i].substring(1, synonyms[i].length() - 1).split(",");
            String name1 = synonym[0];
            String name2 = synonym[1];
            //(2.1)names存在未覆盖synonyms所有姓名的情况，进行补充，name未覆盖不存在即为0
            if (!parent.containsKey(name1)) {
                parent.put(name1, name1);
                freqPreSum.put(name1,0);
            }
            if (!parent.containsKey(name2)) {
                parent.put(name2, name2);
                freqPreSum.put(name2,0);
            }
            //(2.2)如果不存在的name为最小字典序那岂不是以names数组不存在的name为root了？
            //根据题意，是以synonyms的最小字典序为准，而不是以names为准，所以是正确情况
            union(name1, name2);
        }

        //(3)统计真实姓名的频率
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, String> entry : parent.entrySet()) {
            String rootName = find(entry.getKey());
            //(3.1)判断根节点是否为自己，只有无重义的没名和重义名的root节点会进if
            if (rootName.equals(entry.getKey()))
                res.add(rootName + "(" + freqPreSum.get(rootName) + ")");
        }

        return res.toArray(new String[res.size()]);
    }

    //find祖先和路径压缩
    public String find(String name) {
        while (!name.equals(parent.get(name))) {
            parent.put(parent.get(name), parent.get(parent.get(name)));
            name = parent.get(name);
        }
        return name;
    }

    //合并parent，并更新前缀和freq
    public void union(String name1, String name2) {
        String rootN1 = find(name1);
        String rootN2 = find(name2);
        if (rootN1.equals(rootN2)) return;
        //以字典集最小的name为root，并累加freq
        if (rootN1.compareTo(rootN2) < 0) {
            parent.put(rootN2, rootN1);
            freqPreSum.put(rootN1, freqPreSum.get(rootN1) + freqPreSum.get(rootN2));
        } else {
            parent.put(rootN1, rootN2);
            freqPreSum.put(rootN2, freqPreSum.get(rootN1) + freqPreSum.get(rootN2));
        }
    }
}
