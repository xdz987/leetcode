package 图.并查集.q721_2_账户合并;

import java.util.*;

/**
 * 方法二：并查集+优先队列/堆
 */
class Solution2 {
    int[] parent;
    int[] size;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        List<List<String>> res = new ArrayList<>();
        Map<String,Integer> emailToId = new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> account = accounts.get(i);
            for(int j=1;j<account.size();j++){
                if(!emailToId.containsKey(account.get(j))){
                    emailToId.put(account.get(j),i);
                }else{
                    union(i,emailToId.get(account.get(j)));
                }
            }
        }
        Map<Integer, PriorityQueue<String>> idToEmails = new HashMap<>();
        for(String email:emailToId.keySet()){
            int rootId = find(emailToId.get(email));
            if(!idToEmails.containsKey(rootId)){
                idToEmails.put(rootId,new PriorityQueue<String>());
            }
            idToEmails.get(rootId).offer(email);
        }

        for(int id:idToEmails.keySet()){
            List<String> tmp = new ArrayList<>();
            tmp.add(accounts.get(id).get(0));
            while(!idToEmails.get(id).isEmpty()){
                tmp.add(idToEmails.get(id).poll());
            }
            res.add(tmp);
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