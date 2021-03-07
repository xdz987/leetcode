package 数组与矩阵.二分查找.q34_2_重复元素第一与最后位置;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(nums, 8)));
    }
}

/**
 * 左侧边界二分查找+右侧边界二分查找
 * 1. 左侧边界二分查找到最左边重复值索引 边界[0,length]
 * 2. 判断left==length或num[left]!=target，说明没有查到target,则直接return [-1,-1]
 * 3. 右侧边界二分查找到最右边重复值索引 边界[最左侧重复值索引,length]
 */
class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        //(1)初始化 确定边界等
        int left = 0;
        int right = nums.length;
        int[] result = new int[2];

        //(2)左侧边界二分查找 需判断是否存在target
        int leftIndex = binarySearch(nums, left, right, target, true);
        if (leftIndex == -1) {
            result[0] = result[1] = -1;
            return result;
        }
        result[0] = leftIndex;

        //(3)存在则进行右侧边界二分查找 无需判断是否存在
        left = leftIndex;
        right = nums.length;
        int rightIndex = binarySearch(nums, left, right, target, false);
        result[1] = rightIndex;

        return result;
    }

    //数组与矩阵.二分查找 direction=true为左侧边界二分查找，反之右侧
    public int binarySearch(int[] nums, int left, int right, int target, boolean direction) {
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                if (direction) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (direction) {
            if (left == nums.length) {
                return -1;
            }
            return nums[left] == target ? left : -1;
        } else {
            if (left == 0) {
                return -1;
            }
            return nums[left - 1] == target ? left - 1 : -1;
        }
    }
}