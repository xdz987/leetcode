package 位运算.异或运算.面1719_3_消失的两个数字;

import java.util.Arrays;

/**
 * 方法二：排序+双指针
 * Java：22% 74%
 * 复杂度：O(nlogn) O(1)
 */
public class Solution2 {
    public int[] missingTwo(int[] nums) {
        //(1)先降序
        Arrays.sort(nums);
        int n = nums.length;
        int[] res = new int[2];
        int resI = 0;
        int numI = 0;
        //(2)遍历元素。不相等说明存在消失的数，添加到res。到了结尾说明消失的数再尾部，也添加到res
        for (int i = 1; i <= n + 2; i++) {
            if (numI == n) {
                res[resI++] = i;
                continue;
            }
            if (nums[numI] == i)
                numI++;
            else if (nums[numI] > i)
                res[resI++] = i;
            //不存在nums[numI]小于i的情况
        }
        return res;
    }
}
