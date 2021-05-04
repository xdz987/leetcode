package 动态规划.最长xx子序列.最长递增子序列.q674_1_最长连续递增序列;

/**
 * 方法二：滑动窗口
 * Java：99% 74%
 * 复杂度：O(N) O(1)
 */
public class Solution2 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int left = 0;
        int right = 1;
        int res = 1;
        while (right < n) {
            if (nums[right] > nums[right - 1]) {
                res = Math.max(right - left + 1, res);
            } else {
                left = right;
            }
            right++;
        }
        return res;
    }
}
