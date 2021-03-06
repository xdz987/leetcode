package 二分查找.q33_2_旋转数组查元素;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        Search search = new Search();
        System.out.println(search.search(nums, 1));
    }
}

/**
 * 基本二分查找
 * 判断mid位于旋转数组的哪一边，再调整left和right
 */
class Search {
    public int search(int[] nums, int target) {
        //(1)初始化边界等
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;

        //(2)基本二分查找
        while (left <= right) {
            mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 位于右边即低段
            if (nums[mid] < nums[0]) {
                if (target > nums[mid] && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // 位于左边即高段 mid=0说明在左边
            else{
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}