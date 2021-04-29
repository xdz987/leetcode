package 哈希表.q202_1_快乐数;

import java.util.HashSet;
import java.util.Set;

/**
 * 方法一：哈希表
 * Java：99% 45%
 * 复杂度：O(N) O(N)
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int cur = n;
        while (cur != 1 && !set.contains(cur)) {
            set.add(cur);
            cur = getSplitSum(cur);
        }
        return cur == 1;
    }

    private int getSplitSum(int num) {
        int sum = 0;
        while (num != 0) {
            int tmp = num % 10;
            sum += tmp * tmp;
            num = num / 10;
        }
        return sum;
    }
}