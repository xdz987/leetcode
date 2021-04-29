package 哈希表.q128_3_最长连续序列;

import java.util.Arrays;

/**
 * 方法一：排序+双指针
 * Java：94% 96%
 * 复杂度：O(NlogN) O(1)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        //(1)先进行排序
        Arrays.sort(nums);
        int res = 0;
        int count = 1;
        //(2)遍历所有元素
        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            //(2.1)如果相邻元素之差小于1则直接跳过（说明值相等）
            if (diff < 1)
                continue;
            //(2.2)如果相邻元素之差大于1，说明连续序列中断了，重新计数
            else if (diff > 1)
                count = 1;
            //(2.3)相邻元素之差刚好等于1，计数
            else
                count++;
            //(2.4)保存最长连续序列即count
            res = Math.max(count, res);
        }
        return res;
    }
}