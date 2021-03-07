package 数组与矩阵.数组思路.q697_1_数组的度;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        FindShortestSubArray findShortestSubArray = new FindShortestSubArray();
        System.out.println(findShortestSubArray.findShortestSubArray(nums));
    }
}

/**
 * 查找集合中元素出现的次数 如相同则返回度最小的
 */
class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        //(1)初始化容器 元素:[度，第一次出现位置，最后出现位置]
        Map<Integer, int[]> map = new HashMap<>();

        //(2)查找所有元素出现的次数 并保存度、第一次出现位置、最后出现位置
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        //(3)从出现最多次数的元素中查找 最小度数的元素
        int maxTimes = 0;
        int minLen = 0;
        for (Map.Entry<Integer, int[]> elEntry : map.entrySet()) {
            int[] elParams = elEntry.getValue();
            if (elParams[0] > maxTimes) {
                maxTimes = elParams[0];
                minLen = elParams[2] - elParams[1] + 1;
            } else if (elParams[0] == maxTimes) {
                if (minLen > (elParams[2] - elParams[1] + 1)) {
                    maxTimes = elParams[0];
                    minLen = elParams[2] - elParams[1] + 1;
                }
            }
        }
        return minLen;
    }
}