package 数组与矩阵.前缀和.q930_2_和相同的二次子数组;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] A = new int[]{1, 0, 1, 0, 1};
        int S = 2;
        NumSubarraysWithSum numSubarraysWithSum = new NumSubarraysWithSum();
        System.out.println(numSubarraysWithSum.numSubarraysWithSum(A, S));
    }
}

/**
 * 前缀和
 * 暴力前缀和
 * 优化前缀和 HashMap
 * 优化前缀和 int[]
 */
class NumSubarraysWithSum {
    //暴力前缀和
//    public int numSubarraysWithSum(int[] A, int S) {
//        int[] preSum = new int[A.length + 1];
//        int res = 0;
//
//        int i = 1;
//        for (int num : A) {
//            preSum[i] = preSum[i - 1] + num;
//            i++;
//        }
//
//        for (i = preSum.length - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if (preSum[i] - preSum[j] == S) {
//                    res++;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(preSum));
//        return res;
//    }

    //优化前缀和 HashMap
//    public int numSubarraysWithSum(int[] A, int S) {
//        HashMap<Integer, Integer> preSum = new HashMap<>();
//        preSum.put(0, 1);
//        int res = 0;
//
//        int sum_right = 0;
//        int sum_left = 0;
//        for (int i = 0; i < A.length; i++) {
//            sum_right += A[i];
//            sum_left = sum_right - S;
//
//            if (preSum.containsKey(sum_left)) {
//                res += preSum.get(sum_left);
//            }
//
//            preSum.put(sum_right, preSum.getOrDefault(sum_right, 0) + 1);
//        }
//        return res;
//    }

    // 优化前缀和 int[]
    public int numSubarraysWithSum(int[] A, int S) {
        //由于A[i]为0或1，所以A前缀和小于A.length
        int[] preSum = new int[A.length + 1];
        preSum[0] = 1;
        int res = 0;

        int sum_right = 0;
        int sum_left = 0;
        for (int i = 0; i < A.length; i++) {
            sum_right += A[i];
            sum_left = sum_right - S;

            if (sum_left >= 0) {
                res += preSum[sum_left];
            }
            preSum[sum_right]++;
        }

        return res;
    }
}