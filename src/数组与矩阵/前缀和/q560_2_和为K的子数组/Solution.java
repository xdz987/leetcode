package 数组与矩阵.前缀和.q560_2_和为K的子数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(nums, k));
    }
}

/**
 * 题目：求后前缀和-前前缀和是否等于K
 * 前缀和结合题目：从小到达保存前缀和。循环当前的前缀和-K等于(存在)先前执行保存的前缀和，存在则说明该区间满足条件
 */
class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        //(1)初始化前缀和容器、满足条件的计数器
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int res = 0;

        //(2)计算前缀和并累加满足条件区间(前缀和)
        int sum_left = 0;
        int sum_right = 0;
        for (int i = 0; i < nums.length; i++) {
            sum_right += nums[i];
            sum_left = sum_right - k;

            //(3)查看前面保存的前缀和是否存在前缀和
            if (preSum.containsKey(sum_left)) {
                res += preSum.get(sum_left);
            }

            //(4)保存前缀和
            preSum.put(sum_right, preSum.getOrDefault(sum_right, 0) + 1);
            Set<Integer> existSet= new HashSet<>();
            existSet.add(15);
            existSet.contains(Integer.MAX_VALUE);
        }
        return res;
    }
}
