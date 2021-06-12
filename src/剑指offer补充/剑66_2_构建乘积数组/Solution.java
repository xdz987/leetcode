package 剑指offer补充.剑66_2_构建乘积数组;

import java.util.Arrays;

/**
 * 方法一：线性遍历/前缀和
 * Java：82% 48%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if(n==0) return new int[]{};
        int[] res = new int[n];
        int preSum = 1;
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            preSum *= a[i - 1];
            res[i] = preSum;
        }
        preSum = 1;
        for (int i = n - 1; i > 0; i--) {
            preSum *= a[i];
            res[i - 1] *= preSum;
        }
        return res;
    }
}