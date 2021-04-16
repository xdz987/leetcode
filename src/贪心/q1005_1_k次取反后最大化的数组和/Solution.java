package 贪心.q1005_1_k次取反后最大化的数组和;

/**
 *
 * 方法一：暴力
 * Java：13% 50%
 */
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int n = A.length;
        int k = 0;
        int min = 0;
        int sum = 0;
        while (k < K) {
            sum = 0;
            for (int i = 0; i < n; i++) {
                min = A[min] > A[i] ? i : min;
                sum += A[i];
            }
            A[min] = A[min] * (-1);
            sum += A[min] < 0 ? A[min] * (-2) : A[min] * 2;
            k++;
        }
        return sum;
    }
}