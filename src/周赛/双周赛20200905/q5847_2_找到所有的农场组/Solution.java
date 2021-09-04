package 周赛.双周赛20200905.q5847_2_找到所有的农场组;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int maxRow=0;
    int maxCol=0;
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j] == 1){
                    maxRow = 0;
                    maxCol = 0;
                    dfs(land,i,j,n,m);
                    list.add(new int[]{i,j,maxRow,maxCol});
                }
            }
        }
        int[][] res = new int[list.size()][4];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(int[][] land,int row,int col,int n,int m){
        if(row<0 || row==n || col<0 || col == m || land[row][col] == 2 || land[row][col] == 0){
            return;
        }
        land[row][col] = 2;
        if(row>=maxRow && col>=maxCol){
            maxRow = row;
            maxCol = col;
        }
        dfs(land,row+1,col,n,m);
        dfs(land,row,col+1,n,m);
        dfs(land,row-1,col,n,m);
        dfs(land,row,col-1,n,m);
    }
}