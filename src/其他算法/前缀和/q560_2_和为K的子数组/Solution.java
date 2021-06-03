package 其他算法.前缀和.q560_2_和为K的子数组;

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
    //二刷：前缀和
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int res = 0;
        int preSum = 0;
        for(int i=0;i<n;i++){
            preSum += nums[i];
            if(map.containsKey(preSum-k)){
                res+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return res;
    }
}
