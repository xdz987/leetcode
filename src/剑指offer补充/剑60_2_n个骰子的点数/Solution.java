package 剑指offer补充.剑60_2_n个骰子的点数;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法一：回溯+哈希表【超时】
 * 复杂度：O(6^n)
 */
class Solution {
    public double[] dicesProbability(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        backTrack(map, 0, 0, n);
        double total = 6;
        for (int i = 1; i < n; i++) {
            total *= 6;
        }
        double[] res = new double[map.size()];
        int resI = 0;
        for (int key : map.keySet()) {
            res[resI++] = map.get(key) / total;
        }
        return res;
    }

    private void backTrack(Map<Integer, Integer> map, int track, int depth, int limit) {
        if (depth == limit) {
            map.put(track, map.getOrDefault(track, 0) + 1);
            return;
        }

        for (int i = 1; i <= 6; i++) {
            track += i;
            backTrack(map, track, depth + 1, limit);
            track -= i;
        }
    }
}