package 回溯.组合.q77_2_组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1, new ArrayList<>());
        return res;
    }

    private void backTrack(int n, int k, int start, ArrayList<Integer> track) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        //剪枝条件：决策树子节点位置<父节点位置
        //实现剪枝：传递i+1作为start
        for (int i = start; i <= n; i++) {
            track.add(i);
            backTrack(n, k, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}
