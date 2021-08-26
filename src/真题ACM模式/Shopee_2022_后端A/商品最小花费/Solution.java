package 真题ACM模式.Shopee_2022_后端A.商品最小花费;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型
     */
    public int cost (int[] array) {
        // write code here
        int n = array.length;
        if(n<=1)return n;
        int[] cost = new int[n];
        Arrays.fill(cost,1);
        for(int i=1;i<n;i++){
            if(array[i]>array[i-1]){
                cost[i] = cost[i-1]+1;
            }
        }
        for(int i=n-1;i>0;i--){
            if(array[i-1]>array[i]){
                cost[i-1] = cost[i]+1;
            }
        }
        int res = 0;
        for(int num:cost){
            res+=num;
        }
        return res;
    }
}