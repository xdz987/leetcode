package 回溯.组合.q39_2_组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法一：回溯
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] candidates, int target, int start, ArrayList<Integer> track) {
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //剪枝条件1：元素从小到达，target-当前元素<0，右边同样一定小于0
            //实现剪枝：<0直接break
            if (target - candidates[i] < 0)
                break;

            track.add(candidates[i]);
            //剪枝条件2：决策树子节点<=父节点
            //实现剪枝2：传递i作为start
            backTrack(candidates, target - candidates[i], i, track);
            track.remove(track.size() - 1);
        }
    }
}
