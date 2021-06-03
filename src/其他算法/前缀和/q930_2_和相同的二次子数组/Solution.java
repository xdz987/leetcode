package 其他算法.前缀和.q930_2_和相同的二次子数组;

public class Solution {
    public static void main(String[] args) {
        int[] A = new int[]{1, 0, 1, 0, 1};
        int S = 2;
        NumSubarraysWithSum numSubarraysWithSum = new NumSubarraysWithSum();
        System.out.println(numSubarraysWithSum.numSubarraysWithSum(A, S));
    }
}

/**
 * 方法一：前缀和
 */
class NumSubarraysWithSum {
    // 优化前缀和 int[]
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] map = new int[n + 1];
        int res = 0;
        int preSum = 0;
        map[0] = 1;
        for (int i = 0; i < n; i++) {
            preSum += nums[i] & 1;
            if (preSum - goal >= 0) {
                res += map[preSum - goal];
            }
            map[preSum]++;
        }
        return res;
    }
}