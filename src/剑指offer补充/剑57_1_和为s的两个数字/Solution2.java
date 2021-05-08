package 剑指offer补充.剑57_1_和为s的两个数字;

/**
 * 方法二：双指针
 * Java：95% 68%
 * 复杂度：O(N) O(1)
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum==target){
                return new int[]{nums[left],nums[right]};
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{};
    }
}