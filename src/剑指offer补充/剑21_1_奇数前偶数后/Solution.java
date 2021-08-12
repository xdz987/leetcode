package 剑指offer补充.剑21_1_奇数前偶数后;

/**
 * 方法一：双指针
 * Java：98% 83%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            if (left < right) {
                nums[left] ^= nums[right];
                nums[right] ^= nums[left];
                nums[left] ^= nums[right];
            }
        }
        return nums;
    }

    //三刷：更简洁
    public int[] exchange3(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            if((nums[left]&1) == 1){
                left++;
            }else{
                swap(nums,left,right);
                right--;
            }
        }
        return nums;
    }
    private void swap(int[] nums,int i1,int i2){
        if(i1!=i2){
            int tmp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = tmp;
        }
    }
}