package 其他算法.双指针.q27_1_移除元素;

/**
 * 方法二：双指针
 * Java：100% 93%
 * 复杂度：O(n) O(1)
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        //(1)遍历数组
        while (left <= right) {
            //(2)相等则将元素交换到最右边
            if (nums[left] == val) {
                swap(nums, left, right);
                right--;
            }
            //(3)不相等left右移
            else {
                left++;
            }
        }
        //因为是下标所以需+1
        return right + 1;
    }

    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}