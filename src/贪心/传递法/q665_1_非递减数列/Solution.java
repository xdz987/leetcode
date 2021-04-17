package 贪心.传递法.q665_1_非递减数列;

/**
 * 方法一：贪心
 * Java：100% 40%
 * 局部最优：修改数字满足
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        boolean used = false;
        //(1)遍历所有元素
        for (int i = 1; i < n; i++) {
            //(2)当符合非递减性质时，选择其一进行改变
            if (nums[i - 1] > nums[i]) {
                if (!used)
                    used = true;
                else {
                    return false;
                }
                //(2.1)当前i大于等于i-2，说明需要改变i-1的值才符合非递减性质
                if (i == 1 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                }
                //(2.2)否则说明需要改变i的值才符合非递减性质
                else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
}