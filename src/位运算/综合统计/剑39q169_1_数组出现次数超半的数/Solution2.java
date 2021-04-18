package 位运算.综合统计.剑39q169_1_数组出现次数超半的数;

/**
 * 方法二：摩尔投票
 * Java：99% 68%
 * 复杂度：O(n) O(1)
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int vote = 0;
        int mode = 0;
        for (int i = 0; i < n; i++) {
            //(1)票数为0则重置mode
            if (vote == 0) mode = nums[i];
            //(2)重置时必+1。当不相等时票数-1
            vote += nums[i] == mode ? 1 : -1;
        }
        return mode;
    }
}
