package 剑指offer补充.剑51_3_逆序对;

/**
 * 方法一：暴力【超时】
 */
class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    res++;
                }
            }
        }
        return res;
    }
}