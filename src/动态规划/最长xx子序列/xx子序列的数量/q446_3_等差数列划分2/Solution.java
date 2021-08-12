package 动态规划.最长xx子序列.xx子序列的数量.q446_3_等差数列划分2;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法一：DP思想+Map数组
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long,Integer>[] freqs = new HashMap[n];
        int res = 0;
        for(int i=0;i<n;i++){
            Map<Long,Integer> freq = new HashMap<>();
            for(int j=0;j<i;j++){
                Long diff = (long)nums[i]-nums[j];
                int diffCount = freqs[j].getOrDefault(diff,0);
                res+=diffCount;
                freq.put(diff,freq.getOrDefault(diff,0)+1+diffCount);
            }
            freqs[i]=freq;
        }
        return res;
    }
}