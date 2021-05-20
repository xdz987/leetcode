package 图.并查集.q721_2_账户合并;

import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        UF uf = new UF(len);
        //<邮箱，账号id>
        Map<String, Integer> emailToId = new HashMap<>();
        //以下将账号id作为祖先，将邮箱联通到账号id下，如存在重复邮箱，则说明是同一个人，将账号id进行联通
        for (int i = 0; i < len; i++) {
            int sum = accounts.get(i).size();
            //遍历账号i下所有email
            for (int j = 1; j < sum; j++) {
                String email = accounts.get(i).get(j);
                //不存在，直接email-->i
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, i);
                }
                //存在，不用put进emailToId，联通重复email的账户id(为一个人)
                else {
                    uf.union(i, emailToId.get(email));
                }
            }
        }

        //以上完成并查集算法
        //以下考核Java基础语法的操作

        //将数据整理成整理到成：账户id：邮箱列表
        //因为还要对邮箱列表按字符ASCII排序
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToId.entrySet()) {
            int id = uf.find(entry.getValue());
            //获取账户id对应邮箱列表，如不存在则初始化
            List<String> emails = idToEmails.getOrDefault(id, new ArrayList<>());
            emails.add(entry.getKey());
            //覆盖，如：{email1}-->{email1,email2}
            idToEmails.put(id, emails);
            new PriorityQueue<String>((a,b)->a.compareTo(b));
        }

        //将数据整理成最终格式
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : idToEmails.entrySet()) {
            String name = accounts.get(entry.getKey()).get(0);
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> tmp = new ArrayList<>();
            tmp.add(name);
            tmp.addAll(emails);
            res.add(tmp);
        }
        return res;
    }
}

class UF {
    private int[] parent;
    private int[] size;

    public UF(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
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

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}