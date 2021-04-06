package 数组与矩阵.数组思路.剑03_1_数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

/**
 * 方法一：Set
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return num;
        }
        return -1;
    }
}