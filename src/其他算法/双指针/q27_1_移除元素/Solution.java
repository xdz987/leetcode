package 其他算法.双指针.q27_1_移除元素;

/**
 * 方法二：双指针
 * Java：100% 93%
 * 复杂度：O(n) O(1)
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int right = n;
        int left = 0;
        while(left<right){
            while(left<right && nums[left] == val){
                nums[left] = nums[--right];
            }
            left++;
        }
        return right;
    }
}