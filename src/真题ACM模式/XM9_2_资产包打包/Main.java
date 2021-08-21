package 真题ACM模式.XM9_2_资产包打包;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String[] s = in.nextLine().replaceAll(","," ").split(" ");
        int N = Integer.parseInt(s[0]);
        int type = Integer.parseInt(s[1]);
        int[] w = new int[type];
        int[] v = new int[type];
        for(int i=0;i<type;i++){
            w[i] = Integer.parseInt(s[i+2]);
            v[i] = Integer.parseInt(s[i+type+2]);
        }
        //非状态压缩
//        int[][] dp = new int[N+1][type+1];
//        for(int weight = 1;weight<=N;weight++){
//            for(int goods = 1;goods<=type;goods++){
//                if(weight-w[goods-1]>=0)
//                    dp[weight][goods] = Math.max(dp[weight][goods-1],
//                            dp[weight-w[goods-1]][goods-1]+v[goods-1]);
//            }
//        }
//        System.out.println(dp[N][type]);
        //状态压缩
        int[] dp = new int[N+1];
        for(int goods = 0;goods<type;goods++){
            for(int weight = N;weight>=1 && weight>=w[goods];weight--){
                dp[weight] = Math.max(dp[weight],dp[weight-w[goods]]+v[goods]);
            }
        }
        System.out.println(dp[N]);
    }
}