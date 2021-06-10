package 哈希表.q349_1_两个数组的交集;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 方法一：哈希表
 * Java：94% 58%
 * 复杂度：O(n+m) O(n+m)
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> list = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num))
                list.add(num);
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int num : list)
            res[i++] = num;
        return res;
    }
}