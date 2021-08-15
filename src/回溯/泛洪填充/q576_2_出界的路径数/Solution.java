package 回溯.泛洪填充.q576_2_出界的路径数;

/**
 * 方法一：暴力法【超时】
 */
class Solution {
    int res = 0;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dfs(m,n,startRow,startColumn,maxMove);
        return res;
    }

    private void dfs(int m,int n,int row,int col,int move){
        if(row<0 || col<0 || row==m || col == n){
            res++;
            return;
        }
        if(move == 0)
            return;
        dfs(m,n,row+1,col,move-1);
        dfs(m,n,row,col+1,move-1);
        dfs(m,n,row-1,col,move-1);
        dfs(m,n,row,col-1,move-1);
    }
}