package 真题ACM模式.阿里_2021_编程题.挑选物品;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

/**
 * 同LC300，但DP复杂度O(n^2)会超时，必须采用二分法降到(OlogN)
 *
 */
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for(int i=0;i<total;i++){
            int n = Integer.parseInt(br.readLine());
            int[][] nums = new int[n][2];
            String[] params1 = br.readLine().split(" ");
            String[] params2 = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                nums[j][0] = Integer.parseInt(params1[j]);
                nums[j][1] = Integer.parseInt(params2[j]);
            }
            //x升序，y降序
            Arrays.sort(nums,(n1,n2)->{
                if(n1[0]==n2[0])
                    //x相同的情况下y更大的排序在前面（不然的话会重复统计相同的x）
                    return n2[1]-n1[1];
                else
                    return n1[0]-n2[0];
            });
            int res = 0;
            int[] tail = new int[n];
            for(int j=0;j<n;j++){
                int left = 0;
                int right = res;
                while(left<right){
                    int mid = left+((right-left)>>1);
                    if(tail[mid]<nums[j][1])
                        left = mid+1;
                    else
                        right = mid;
                }
                tail[left] = nums[j][1];
                if(right == res){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}