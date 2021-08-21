package 真题ACM模式.XM10_1_爬楼梯;

import java.util.Scanner;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<3){
            System.out.println(n);
            System.exit(0);
        }
        BigInteger ppre = BigInteger.valueOf(1);
        BigInteger pre = BigInteger.valueOf(2);
        BigInteger cur = BigInteger.valueOf(3);
        for(int i=3;i<=n;i++){
            cur = pre.add(ppre);
            ppre = pre;
            pre = cur;
        }
        System.out.println(cur);
    }
}