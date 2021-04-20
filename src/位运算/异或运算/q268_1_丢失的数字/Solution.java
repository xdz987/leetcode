package 位运算.异或运算.q268_1_丢失的数字;

/**
 * 方法一：位运算——异或
 * Java：100% 70%
 * 复杂度：O(n) O(1)
 */
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        //(1)假如丢失的数字是n，n会被保留到最后，否则会被抵消
        int disappear = n;
        //(2)异或两次抵消重复数，找到消失的数字
        for (int i = 0; i < n; i++) {
            disappear ^= i;
            disappear ^= nums[i];
        }
        return disappear;
    }
}