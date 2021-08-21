package 真题ACM模式.XM8_2_最少立方数之和;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i=2;i<=N;i++){
            dp[i] = i;
            for(int j=2;j*j*j<=i;j++){
                dp[i] = Math.min(dp[i-j*j*j]+1,dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}