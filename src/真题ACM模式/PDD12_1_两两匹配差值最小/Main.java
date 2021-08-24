package 真题ACM模式.PDD12_1_两两匹配差值最小;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = n-1;
        while(left<right){
            int sum = nums[left]+nums[right];
            max = Math.max(max,sum);
            min = Math.min(min,sum);
            left++;
            right--;
        }
        System.out.println(max-min);
    }
}