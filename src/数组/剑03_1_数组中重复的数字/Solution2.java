package 数组.剑03_1_数组中重复的数字;

import java.util.Arrays;

/**
 * 方法二：排序
 */
public class Solution2 {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1])
                return nums[i];
        }
        return -1;
    }
}
