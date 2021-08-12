package 图.并查集.q200_2_岛屿数量;

/**
 * 方法二：DFS
 */
public class Solution2 {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //(1)遍历所有节点，统计岛屿数量
        int isLandCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //(2)只有为陆地才需要进行DFS
                if (grid[i][j] == '1') {
                    dfs(grid,i,j,n,m);
                    isLandCount++;
                }
            }
        }
        return isLandCount;
    }

    //以某块陆地为中心向四周（上下左右）DFS
    public void dfs(char[][] grid, int row, int col, int n, int m) {
        //base case：当节点越界、已访问过、为'水'
        if(row<0||col<0||row==n||col==m||grid[row][col] =='.'||grid[row][col]=='0')
            return;
        //(1)设为已访问过 '0'
        grid[row][col] = '.';

        //(2)向当前的节点四周继续dfs
        dfs(grid,row-1,col,n,m);
        dfs(grid,row,col-1,n,m);
        dfs(grid,row+1,col,n,m);
        dfs(grid,row,col+1,n,m);
    }
}
