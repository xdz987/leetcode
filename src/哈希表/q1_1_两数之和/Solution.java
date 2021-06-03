package 哈希表.q1_1_两数之和;

import java.util.HashMap;
import java.util.Map;

public class Solution {
}

/**
 * Map使用 空间换取时间
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> existMap= new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(existMap.containsKey(target-nums[i])){
                return new int[]{existMap.get(target-nums[i]),i};
            }
            existMap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
