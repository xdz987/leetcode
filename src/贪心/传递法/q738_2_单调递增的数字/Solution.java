package 贪心.传递法.q738_2_单调递增的数字;

/**
 * 方法一：贪心
 * Java：95% 80%
 * 局部最优：
 * 1. 符合单调递增的前提下，最大的数字
 */
class Solution {
    public int monotoneIncreasingDigits(int N) {
        //(1)将数字转换为数组
        char[] nums = String.valueOf(N).toCharArray();
        int n = nums.length;
        //(2)遍历每一位数字
        for (int i = n - 1; i > 0; i--) {
            //(3)当后一位小于前一位，说明不符合递增，那么退一位
            if (nums[i] < nums[i - 1]) {
                //(3.1)退一位
                nums[i - 1] = (char) (nums[i - 1] - 1);
                //(3.2)后面所有数字都等于9999...。因为【贪心1】，即最大数字
                for (int j = i; j < n; j++) {
                    nums[j] = '9';
                }
            }
        }
        //(4)转换为int
        return Integer.valueOf(String.valueOf(nums));
    }
}