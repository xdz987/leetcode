package 二分查找.q162_2_寻找峰值;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(nums));
    }
}

/**
 * 基本二分查找
 * mid与与mid+1或者mid-1比较，哪边大哪边的区间就有峰值
 * nums[-1]=nums[n]=-∞
 */
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        //(1)初始化边界
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        //(2)基本二分查找峰值
        while (left < right) {
            mid = left + ((right - left) >>> 1);
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}