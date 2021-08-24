package 真题ACM模式.QR13_2_日本旅行;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = 6;
        int[] v = new int[]{1,5,10,50,100,500};
        int[] w = new int[n];
        for(int i = 0; i < 6; i++){
            w[i] = Integer.parseInt(str[i]);
        }
        int target = Integer.parseInt(str[6]);
        int res = 0;
        for(int i=n-1;i>=0 && target>0;i--){
            for(int j=0;j<w[i] && target>=v[i];j++){
                target-=v[i];
                res++;
            }
        }
        System.out.println(target==0?res:"NOWAY");
    }
}