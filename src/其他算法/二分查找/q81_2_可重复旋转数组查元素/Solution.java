package 其他算法.二分查找.q81_2_可重复旋转数组查元素;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        Search search = new Search();
        System.out.println(search.search(nums, 2));
    }
}

/**
 * q33的延伸 基本二分查找
 * 在判定mid所处边界前先去重
 */
class Search {
    public boolean search(int[] nums, int target) {
        //(1)初始化边界
        int length = nums.length;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        //(2)基本二分查找target
        while (left <= right) {
            mid = left + ((right - left) >>> 1);
            if (target == nums[mid]) {
                return true;
            }
            // 去重
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            //左半部分
            if (nums[mid] > nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                //右半部分
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    //二刷
    public boolean search2(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target)
                return true;
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }
            if (nums[mid] > nums[0]) {
                if (target >= nums[0] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}