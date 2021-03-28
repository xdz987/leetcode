package 图.并查集.q990_2_等式方程的可满足性;

/**
 * 并查集
 * 1. 递归联通相等边的顶点
 * 2. 再递归判断不等边的顶点是否联通，联通则false
 */
public class Solution {
    private int[] parent;
    private int[] size;

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        size = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int len = equations.length;

        for (int i = 0; i < len; i++) {
            if (equations[i].charAt(1) == '=') {
                union(equations[i].charAt(0) - 'a', equations[i].charAt(3) - 'a');
            }
        }

        for (int i = 0; i < len; i++) {
            if (equations[i].charAt(1) == '!') {
                if (connected(equations[i].charAt(0) - 'a', equations[i].charAt(3) - 'a'))
                    return false;
            }
        }
        return true;
    }



    public void union(int p, int q) {
        int rootQ = parent[q];
        int rootP = parent[p];
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

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
