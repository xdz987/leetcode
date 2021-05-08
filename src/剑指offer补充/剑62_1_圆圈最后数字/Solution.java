package 剑指offer补充.剑62_1_圆圈最后数字;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：模拟
 * Java：20% 8%
 * 复杂度：O(N) O(N)
 */
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int mod = 0;
        while (n > 1) {
            mod = (mod + m - 1) % n;
            list.remove(mod);
            n--;
        }
        return list.get(0);
    }
}