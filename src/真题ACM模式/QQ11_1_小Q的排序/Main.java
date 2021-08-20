package 真题ACM模式.QQ11_1_小Q的排序;

import java.util.Scanner;
import java.lang.Math;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        if(n <= 1){
            System.out.println(0);
            System.exit(0);
        }
        String s = in.nextLine();
        String[] sArr = s.split(" ");
        int[] nums = new int[n];
        for(int i=0;i<sArr.length;i++){
            nums[i] = Integer.parseInt(sArr[i]);
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        if(nums[0] == min || nums[n-1] == max){
            System.out.println(1);
            System.exit(0);
        }
        System.out.println(2);
    }
}