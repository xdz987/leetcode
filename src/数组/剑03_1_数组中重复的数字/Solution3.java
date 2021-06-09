package 数组.剑03_1_数组中重复的数字;

/**
 * 方法三：交换法
 */
public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        //(1)遍历所有元素
        for (int i = 0; i < nums.length; i++) {
            //(2)如果下标不等于下标对应的值，则交换值对应的下标，使得后一下标等于下标上的值，如[2]=5,[5]=8==>[2]=8,[5]=5
            while (nums[i]!=i) {
                //(3)相等说明下标已经交换过了，即重复，直接返回
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = tmp;
            }
        }
        return -1;
    }
}
