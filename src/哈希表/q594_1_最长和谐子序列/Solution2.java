package 哈希表.q594_1_最长和谐子序列;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法二：哈希表
 * Java：87% 68%
 * 复杂度：O(N) O(N)
 */
public class Solution2 {
    public int findLHS(int[] nums) {
        //(1)保存数组各元素的频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //(2)当存在元素差值为1的元素时，保存相加频率
        int res = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                res = Math.max(map.get(num) + map.get(num + 1), res);
            }
        }
        return res;
    }
}
