package 回溯.子集.q78_2_子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法一：回溯
 * 复杂度：O(2^n) O(n)
 * Java：100% 98%
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backTrack(nums, 0, new ArrayList());
        return res;
    }

    private void backTrack(int[] nums, int start, ArrayList<Integer> track) {
        if (nums.length == track.size())
            return;
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            //记录子集：即从1~n,2~n...n~n的track
            res.add(new ArrayList<>(track));
            //剪枝条件：决策树子节点<父节点
            //实现剪枝：传递i+1作为start
            backTrack(nums, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}
