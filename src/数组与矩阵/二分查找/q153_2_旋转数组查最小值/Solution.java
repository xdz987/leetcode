package 数组与矩阵.二分查找.q153_2_旋转数组查最小值;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin(nums));
    }
}

/**
 * 基本二分查找
 * 在两种边界(高段与低端)种，不断压缩右侧边界，并找到最小值
 */
class FindMin {
    public int findMin(int[] nums) {
        //(1)初始化边界等
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        //(2)左侧边界二分查找 两种边界
        while (left < right) {
            mid = left + ((right - left) >>> 1);
            //说明mid位于右边即低端
            if (nums[mid] < nums[0]) {
                //判断是否到达旋转的点 此时mid为最小值索引 mid-1为最大值索引
                if (nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                } else {
                    right = mid;
                }
            }
            //说明mid位于左边即高段 要查min值，所以跳过
            else {
                left = mid + 1;
            }
        }
        //到此说明数组只有一个元素
        return nums[0];
    }
}