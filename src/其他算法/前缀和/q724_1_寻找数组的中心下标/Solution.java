package 其他算法.前缀和.q724_1_寻找数组的中心下标;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, -1, -1, -1, -1, 0};
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.pivotIndex(nums));
        System.out.println(-5%(5));
    }
}

/**
 * 前缀和：
 * (1)左边元素之和sum = 所有元素之和total - sum - nums[i](中心)
 * (2)即num[i] = total - 2*sum，i即为中心下标
 */
class PivotIndex {

    //前缀和
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num:nums)
            sum+=num;
        int preSum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == (sum-2*preSum)){
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }
}
