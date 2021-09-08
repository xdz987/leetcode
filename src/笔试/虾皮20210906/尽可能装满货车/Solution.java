package 笔试.虾皮20210906.尽可能装满货车;

public class Solution {
    public static void main(String[] args) {
        System.out.println(bestFit(21,new int[]{8,3,12}));
    }
    public static int bestFit(int V, int[] item) {
        int n = item.length;
        if(n==0) return V;
        int sum = 0;
        for(int i=0;i<item.length;i++){
            sum+=item[i];
        }
        if(sum<=V) return V-sum;
        int[] dp = new int[V+1];
        for(int i=0;i<n;i++){
            for(int j=V;j>=0;j--){
                if(j>=item[i] && dp[j-item[i]]+item[i]<=V) {
                    dp[j] = Math.max(dp[j],dp[j - item[i]] + item[i]);
                }
            }
        }
        return V-dp[V];
    }
}
