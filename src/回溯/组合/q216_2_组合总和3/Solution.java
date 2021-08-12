package 回溯.组合.q216_2_组合总和3;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：回溯
 * Java：100% 76%
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k, n, 1, new ArrayList<>(), 0);
        return res;
    }

    private void backTrack(int k, int n, int start, ArrayList<Integer> track, int trackSum) {
        if (track.size() == k) {
            //save track
            if (trackSum == n)
                res.add(new ArrayList<>(track));
            return;
        }
        if(trackSum>n)
            return;

        int limit = Math.min(9,n);
        for (int i = start; i <= limit; i++) {
            trackSum += i;
            track.add(i);
            backTrack(k, n, i + 1, track, trackSum);
            trackSum -= track.get(track.size() - 1);
            track.remove(track.size() - 1);
        }
    }
}