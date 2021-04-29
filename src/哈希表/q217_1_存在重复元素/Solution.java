package 哈希表.q217_1_存在重复元素;

import java.util.HashSet;
import java.util.Set;

/**
 * 方法一：HashSet
 * Java：42% 37%
 * 复杂度：O(N) O(N)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}