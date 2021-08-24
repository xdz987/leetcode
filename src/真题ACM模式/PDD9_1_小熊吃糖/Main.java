package 真题ACM模式.PDD9_1_小熊吃糖;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] candy = new int[m];
        for(int i=0;i<m;i++)
            candy[i]=in.nextInt();
        int[][] bears = new int[n][2];
        Map<Integer,Integer> mapPos = new HashMap<>();
        for(int i=0;i<n;i++){
            bears[i][0] = in.nextInt();
            bears[i][1] = in.nextInt();
            mapPos.put(bears[i][0],i);
        }
        Arrays.sort(candy);
        Arrays.sort(bears,(n1,n2)->n1[0]-n2[0]);
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(bears[i][1]>=candy[j]){
                    bears[i][1]-=candy[j];
                    candy[j]=0;
                }
            }
            res[mapPos.get(bears[i][0])] = bears[i][1];
        }
        for(int i=0;i<n;i++){
            System.out.println(res[i]);
        }
    }
}