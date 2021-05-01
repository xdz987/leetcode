package 哈希表.q454_2_四数之和2;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法一：哈希表
 * Java：27% 83%
 * 复杂度：O(N^2) O(N^2)
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        //(1)保存A+B的结果到Map
        Map<Integer, Integer> sumAB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A[i] + B[j];
                sumAB.put(sum, sumAB.getOrDefault(sum, 0) + 1);
            }
        }

        //(2)遍历C和D，count累加-(A+B)对应value
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += sumAB.getOrDefault(-(C[i] + D[j]), 0);
            }
        }
        return count;
    }
}