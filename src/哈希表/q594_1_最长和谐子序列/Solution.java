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
        for (int i = 0, j = 0; i < n; i++) {
            //(2.1)差值超过1则跳过
            if (nums[i] - nums[j] > 1) j++;
            //(2.2)找到差值为1，则j~i符合最大最小差值为1的需求
            if (nums[i] - nums[j] == 1) {
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}