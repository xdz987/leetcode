package 其他算法.二分查找.剑53_1_在排序数组中查数字2;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));
    }
}

/**
 * 二分查找
 */
class MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}