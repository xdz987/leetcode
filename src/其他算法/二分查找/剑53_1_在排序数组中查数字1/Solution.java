package 其他算法.二分查找.剑53_1_在排序数组中查数字1;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        Search search = new Search();
        System.out.println(search.search(nums, target));
    }
}

/**
 * 二分查找
 * 左侧边界二分查找
 */
class Search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        //(1)找到等于target的最左侧值下标
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        //(2)从该下标向右遍历等于target的值，res++，直到不相等直接break
        int res = 0;
        while (left < n && nums[left] == target) {
            res++;
            left++;
        }

        return res;
    }
}
