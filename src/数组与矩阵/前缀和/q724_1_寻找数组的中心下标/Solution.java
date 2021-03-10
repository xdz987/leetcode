package 数组与矩阵.前缀和.q724_1_寻找数组的中心下标;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.pivotIndex(nums));
    }
}

//未完成
/**
 * 左右指针
 * 前缀和
 */
class PivotIndex {

//    //前缀和
//    public int pivotIndex(int[] nums) {
//        //(1)初始化前缀和容器、结果res
//
//    }

    //左右指针
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int leftSum = 0;
        int rightSum = 0;

        while (right != left) {
            if (leftSum > rightSum) {
                rightSum += nums[right];
                right--;
            } else {
                leftSum += nums[left];
                left++;
            }
        }

        return leftSum == rightSum ? left + 1 : -1;
    }
}