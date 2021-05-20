package 图.并查集.q130_2_被围绕的区域;

class Solution3 {
    int[] parent;
    int[] size;
    int[][] d = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        parent = new int[n * m + 1];
        size = new int[n * m + 1];
        for (int i = 0; i < n * m + 1; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int dummy = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (board[i][j] == 'O') {
                        union(dummy, i * m + j);
                    }
                }else{
                    if (board[i][j] == 'O') {
                        for (int k = 0; k < 4; k++) {
                            int x = d[k][0] + i;
                            int y = d[k][1] + j;
                            if (board[x][y] == 'O') {
                                union(i * m + j, x * m + y);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O' && !connect(i * m + j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int p, int q) {
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
    }

    private boolean connect(int x, int y) {
        return find(x) == find(y);
    }
}