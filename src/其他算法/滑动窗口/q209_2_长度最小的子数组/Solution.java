package 其他算法.滑动窗口.q209_2_长度最小的子数组;

public class Solution {
    public static void main(String[] args) {
        int target = 4;
        int[] nums = new int[]{1, 4, 4};
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(target, nums));
    }
}

/**
 * 满足条件最小窗口
 * 缩小窗口的条件为窗口内元素之和大于target
 */
class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        //(1)初始化窗口指针、当前窗口元素之和、当前最小连续子数组长度
        int left = 0;
        int right = 0;
        int windowSum = 0;
        int res = Integer.MAX_VALUE;

        //滑动窗口
        while (right < nums.length) {
            //(2)right向右拓展窗口
            int lNum = nums[right];
            right++;
            windowSum += lNum;

            //(3)窗口元素之和>=target缩小窗口
            while (windowSum >= target) {
                //保存当前最小长度
                res = Math.min(res, right - left);

                int rNum = nums[left];
                left++;
                windowSum -= rNum;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
