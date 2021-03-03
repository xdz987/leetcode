package 数组.q769_2_分割数组;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 3};
        MaxChunksToSorted maxChunksToSorted = new MaxChunksToSorted();
        System.out.println(maxChunksToSorted.maxChunksToSorted(nums));
    }
}

/**
 * 如果第i位的值等于前i位的最大值，则说明可切为块
 */
class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        //(1)初始化
        int res = 0;
        int right = 0;

        //(2)循环判断是否可切分
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(arr[i], right);
            if (right == i) {
                res++;
            }
        }
        return res;
    }
}
