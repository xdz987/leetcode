package 其他算法.前缀和.q1248_2_统计优美子数组;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        NumberOfSubarrays numberOfSubarrays = new NumberOfSubarrays();
        System.out.println(numberOfSubarrays.numberOfSubarrays(nums, k));
    }
}


/**
 * 方法一：前缀和
 * 同q560
 */
class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] map = new int[n + 1];
        map[0] = 1;
        int res = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num & 1;
            //因为preSum-k作为数组下标
            if (preSum - k >= 0) {
                res += map[preSum - k];
            }
            map[preSum]++;
        }
        return res;
    }
}
