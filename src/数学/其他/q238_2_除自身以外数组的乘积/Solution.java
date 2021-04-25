package 数学.其他.q238_2_除自身以外数组的乘积;

/**
 * 方法一：对角矩阵前缀和
 * Java：100% 74%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 1, right = 1;
        //如：nums[1,2,3,4]
        //下面：res[1,1,2,6]
        for (int i = 0; i < n; i++) {
            res[i] = left;
            left *= nums[i];
        }
        //下面：[24,12,8,6]
        for (int i = n - 1; i > 0; i--) {
            right *= nums[i];
            res[i - 1] *= right;
        }
        return res;
    }
}