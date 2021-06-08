package 数组.q697_1_数组的度;

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
        int n = nums.length;
        Map<Integer, int[]> map = new HashMap<>();

        //(2)查找所有元素出现的次数 并保存度、第一次出现位置、最后出现位置
        //最大频率
        int maxFreq = 1;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int[] tmp = map.get(nums[i]);
                tmp[0]++;
                tmp[2] = i;
                maxFreq = Math.max(maxFreq, tmp[0]);
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        //(3)从出现最多次数的元素中查找 最小度数的元素
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] params = entry.getValue();
            //只有最大频率才有必要进行比较
            if (params[0] == maxFreq) {
                res = Math.min(res, params[2] - params[1] + 1);
            }
        }
        return res;
    }
}