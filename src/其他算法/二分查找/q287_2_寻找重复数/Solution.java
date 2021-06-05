package 其他算法.二分查找.q287_2_寻找重复数;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 4, 2, 6, 5, 7, 9, 8, 7};
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(nums));
    }
}

/**
 * 方法二：其他算法.二分查找+抽屉原理
 */
class FindDuplicate {
    // 时间为O(nlogn) 空间为O(1)
    public int findDuplicate(int[] nums) {
        //(1)初始化 确定边界和长度 中间数 抽屉计数
        int len = nums.length;
        int left = 1;
        int right = len - 1;

        //(2)其他算法.二分查找
        while (left < right) {
            int mid = (left+right)>>1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            //(3)抽屉原理
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}