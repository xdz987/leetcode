package 其他算法.二分查找.q34_2_重复元素第一与最后位置;

class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n;
        int[] res = new int[2];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length) {
            return new int[]{-1, -1};
        }
        res[0] = nums[left] == target ? left : -1;

        right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == 0) {
            return new int[]{-1, -1};
        }
        res[1] = nums[left - 1] == target ? left - 1 : -1;
        return res;
    }
}