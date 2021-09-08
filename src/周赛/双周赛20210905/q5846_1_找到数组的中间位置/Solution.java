package 周赛.双周赛20210905.q5846_1_找到数组的中间位置;

class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        if(n==1)return 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int preSum = 0;
        for(int i=0;i<n;i++){
            int tmp = preSum;
            preSum +=nums[i];
            if(sum-tmp == preSum){
                return i;
            }
        }
        return -1;
    }
}