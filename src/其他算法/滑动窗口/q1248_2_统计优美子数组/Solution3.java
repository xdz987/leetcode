package 其他算法.滑动窗口.q1248_2_统计优美子数组;

public class Solution3 {
    public int numberOfSubarrays(int[] nums, int k) {
        return sub(nums, k) - sub(nums, k - 1);
    }

    private int sub(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < n) {
            int rNum = nums[right];
            if (rNum % 2 == 1) {
                valid++;
            }
            right++;

            while (valid > k) {
                int lNum = nums[left];
                if (lNum % 2 == 1) {
                    valid--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
}
