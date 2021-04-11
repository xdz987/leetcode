package 回溯.组合.q40_2_组合总和2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类似q47
 * 方法一：回溯
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] candidates, int start, int target, ArrayList<Integer> track) {
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //剪枝3条件：candidates作为从小到大排序，左边的已经不满足即<0了，右边肯定不满足直接剪枝
            //实现剪枝：当前i小于target直接break
            if (target - candidates[i] < 0)
                break;

            //剪枝1条件：同层相邻元素相等
            //实现剪枝1：判断i==i-1判断是否相等，i>start判断是否为同一层
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            track.add(candidates[i]);
            //剪枝2条件：决策树子节点下标(于candidates)<=父节点下标
            //实现剪枝2：传递i+1作为循环start
            backTrack(candidates, i + 1, target - candidates[i], track);
            track.remove(track.size() - 1);
        }
    }
}
