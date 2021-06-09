package 数组.剑03_1_数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

/**
 * 方法一：intMap
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int[] map = new int[n];
        for(int i=0;i<n;i++){
            map[nums[i]]++;
            if(map[nums[i]]>1)
                return nums[i];
        }
        return -1;
    }
}