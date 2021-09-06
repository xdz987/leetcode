package 周赛.周赛20200906.q5863_1_特殊的四元组;

class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    for(int l=k+1;l<n;l++){
                        if(nums[l] == sum){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
