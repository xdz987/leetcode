package 回溯.泛洪填充.q576_2_出界的路径数;

/**
 * 方法二：记忆化递归
 */
public class Solution2 {
    int[][][] memo;
    int mod = (int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new int[m][n][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int move = 0;move<=maxMove;move++){
                    memo[i][j][move]=-1;
                }
            }
        }
        return dfs(m,n,maxMove,startRow,startColumn);
    }

    private int dfs(int m, int n, int move, int row, int col){
        if(row<0 || col<0 || row==m || col == n)
            return 1;
        if(move == 0)
            return 0;
        if(memo[row][col][move]!=-1){
            return memo[row][col][move];
        }
        int count = 0;
        count = (count+dfs(m,n,move-1,row+1,col))%mod;
        count = (count+dfs(m,n,move-1,row,col+1))%mod;
        count = (count+dfs(m,n,move-1,row-1,col))%mod;
        count = (count+dfs(m,n,move-1,row,col-1))%mod;
        memo[row][col][move] = count;

        return count;
    }
}
