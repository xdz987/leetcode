package 数组与矩阵.二分查找.q287_2_寻找重复数;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 4, 2, 6, 5, 7, 9, 8, 7};
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(nums));
    }
}

/**
 * 方法一：同q645类型，使用额外数组而去重，但空间为O(n)
 * 方法二：数组与矩阵.二分查找+抽屉原理
 */
class FindDuplicate {
    // 时间为O(n) 空间为(On)
//    public int findDuplicate(int[] nums) {
//        //(1)初始化 额外数组
//        byte[] markNums = new byte[nums.length + 1];
//        int repeat = 0;
//
//        //(2)查找重复的数
//        for (int num : nums) {
//            if (markNums[num] != 0) {
//                repeat = num;
//                break;
//            }
//            markNums[num] = 1;
//        }
//        return repeat;
//    }

    // 时间为O(nlogn) 空间为O(1)
    public int findDuplicate(int[] nums) {
        //(1)初始化 确定边界和长度 中间数 抽屉计数
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        int mid = 0;
        int count = 0;

        //(2)数组与矩阵.二分查找
        while (left < right) {
            mid = left + ((left - right) >>> 1);
            count = 0;
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