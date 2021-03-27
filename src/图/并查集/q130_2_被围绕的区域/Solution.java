package 图.并查集.q130_2_被围绕的区域;

//并查集
class UF {
    private int count;
    private int[] parent;
    private int[] size;

    //初始化并查集parent数组、size数组
    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    //合并两个联通分量
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        //相等说明已经联通
        if (rootP == rootQ) {
            return;
        }
        //小树联通到大树
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        //联通分量-1
        count--;
    }

    //查找祖先
    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    //判断是否联通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    //联通分量总数
    public int count() {
        return count;
    }
}

public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        //行长度
        int n = board[0].length;
        //列长度
        int m = board.length;
        UF uf = new UF(n * m + 1);
        //虚拟祖先
        int dummy = n * m;
        //将区域首列与尾列的'O'联通dummy
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                //第i行第一个
                uf.union(i * n, dummy);
            if (board[i][n - 1] == 'O')
                //第i行第n-1个(即最后一个)
                uf.union(i * n + n - 1, dummy);
        }
        //将区域首行与尾行的'O'联通dummy
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                uf.union(i, dummy);
            if (board[m - 1][i] == 'O')
                uf.union(n * (m - 1) + i, dummy);
        }

        //初始化方向控制数组
        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        //将O相互联通
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O')
                            uf.union(x * n + y, i * n + j);
                    }
                }
            }
        }

        //所有不与dummy联通的O，都要被替换
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connected(i * n + j, dummy))
                    board[i][j] = 'X';
            }
        }
    }
}
