package 哈希表.q128_2_最长连续序列;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 方法二：哈希表
 * Java：21% 22%
 * 复杂度：O(N) O(N)
 */
public class Solution2 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        //(1)记录nums数组元素的频率
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //(2)计数最长连续序列
        int res = 1;
        for (int num : map.keySet()) {
            //(2.1)找到连续序列最小的元素，再开始计数
            if (!map.containsKey(num - 1)) {
                //(2.2)从小到大计数最长连续序列
                int count = 1;
                while (map.containsKey(num + 1)) {
                    count++;
                    num++;
                }
                res = Math.max(count, res);
            }
        }
        return res;
    }

    //二刷：更简洁
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(++num)) {
                    count++;
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }
}
