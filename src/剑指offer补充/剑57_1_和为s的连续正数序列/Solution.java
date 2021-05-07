package 剑指offer补充.剑57_1_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：滑动窗口
 * Java：55% 68%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int windowSum = 1;
        int left = 1;
        int right = 2;
        while (right < target) {
            System.out.println(windowSum);
            if (windowSum == target) {
                int[] tmp = new int[right - left];
                int leftCopy = left;
                int i = 0;
                while (leftCopy < right) {
                    tmp[i++] = leftCopy;
                    leftCopy++;
                }
                list.add(tmp);
                windowSum += right;
                right++;
            } else if (windowSum > target) {
                windowSum -= left;
                left++;
            } else {
                windowSum += right;
                right++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
