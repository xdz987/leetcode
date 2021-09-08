package 笔试.完美世界20210907.购买课程的排列数;

import java.util.*;


public class ac85 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param prices int整型一维数组
     * @param pocket int整型
     * @return int整型
     */
    int res = 0;
    public int purchaseCourses (int[] prices, int pocket) {
        int n = prices.length;
        Arrays.sort(prices);
        boolean[] visited = new boolean[n];
        backTrack(prices,visited,pocket,0,0);
        return res;
    }
    private void backTrack(int[] prices,boolean[] visited,int pocket,int cources,int start){
        if (cources == 2){
            res++;
            return;
        }
        for(int i=start;i<prices.length;i++){
            if(visited[i])
                continue;
            if (pocket-prices[i]<0){
                break;
            }
            visited[i] = true;
            backTrack(prices,visited,pocket-prices[i],cources+1,i);
            visited[i] = false;
        }
    }
}