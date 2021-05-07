package 剑指offer补充.剑61_1_扑克牌中的顺子;

import java.util.Arrays;

/**
 * 方法一：找规律
 */
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                joker++;
                continue;
            }
            if (nums[i] == nums[i + 1])
                return false;
        }
        return nums[4] - nums[joker] < 5;
    }
}
