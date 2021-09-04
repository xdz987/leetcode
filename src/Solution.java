import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        int[] vals = new int[n];
        boolean noBigger = true;
        long sum = 0;
        for(int i=0;i<n;i++){
            vals[i] = in.nextInt();
            sum+=vals[i];
            if(vals[i]>m){
                noBigger=false;
            }
        }
        if(noBigger){
            System.out.println(sum);
        }else{
            Arrays.sort(vals);
            long del = 0;
            for(int i=0;i<k;i++){
                del+=vals[i];
            }
            long cal = 0;
            for(int i=0;vals[i]<=m;i++){
                cal+=vals[i];
            }
            System.out.println(Math.max(sum-del,cal+vals[n-1]));
        }
    }
}