package 剑指offer补充.剑57_1_和为s的两个数字;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 方法一：哈希表
 * Java：10% 13%
 * 复杂度：O(N) O(N)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(target-nums[i])){
                return new int[]{target-nums[i],nums[i]};
            }
            set.add(nums[i]);
        }
        return new int[]{};
    }
}