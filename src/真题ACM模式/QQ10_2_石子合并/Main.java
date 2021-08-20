package 真题ACM模式.QQ10_2_石子合并;

import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        int heap = in.nextInt();
        for(int i=1;i<n;i++){
            int num = in.nextInt();
            res+=heap*num;
            heap+=num;
        }
        System.out.println(res);
    }
}