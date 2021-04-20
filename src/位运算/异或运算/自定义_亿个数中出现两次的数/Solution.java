package 位运算.异或运算.自定义_亿个数中出现两次的数;

/**
 * 题目：有2.5亿个数，其中只有一个数出现两次，其他的数都出现一次。在内存紧张的情况下，怎么找出这个重复数？
 * - 限制：只适用已知数组值得范围，如M~N存在一个重复数，其中M,N为确定值
 * 方法一：位运算——异或
 * 复杂度：O(n) O(1)
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 1, 2, 3, 6, 7, 8, 3, 9};
        System.out.println(findRepeat(nums, 1, 10));
    }

    public static int findRepeat(int[] nums, int start, int end) {
        int n = nums.length;
        int repeat = 0;
        for (int i = 0; i < n; i++) {
            repeat ^= i;
        }
        for (int num : nums) {
            repeat ^= num;
        }
        return repeat;
    }
}
