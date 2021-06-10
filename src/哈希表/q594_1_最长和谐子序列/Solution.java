package 哈希表.q594_1_最长和谐子序列;

import java.util.Arrays;

/**
 * 方法一：排序+双指针
 * Java：100% 86%
 * 复杂度：O(NlogN) O(1)
 */
class Solution {
    public int findLHS(int[] nums) {
        //(1)先对nums数组排序
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        //(2)遍历所有元素
        int start = 0;
        for (int end = 1; end < nums.length; end++) {
            //(2.1)差值超过1则跳过
            if (nums[end] - nums[start] > 1) {
                start++;
            }
            //(2.2)找到差值为1，则j~i符合最大最小差值为1的需求
            if (nums[end] - nums[start] == 1) {
                res = Math.max(res, end - start + 1);
            }
        }
        return res;
    }
}