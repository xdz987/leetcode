package 其他算法.二分查找.剑11q154_3_可重复旋转数组查最小值;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 3, 3};
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin(nums));
    }
}

/**
 * q153的延续 左侧边界二分查找
 */
class FindMin {
    public int findMin(int[] nums) {
        //(1)初始化边界等
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        //(2)左侧边界二分查找
        while (left < right) {
            mid = left + ((right - left) >>> 1);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                // 存在重复，跳过重复数字
                right--;
            }
        }

        return nums[left];
    }
}