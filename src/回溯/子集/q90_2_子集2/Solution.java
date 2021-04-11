package 回溯.子集.q90_2_子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在q78的基础上增加剪枝：元素相同且同层的节点剪掉
 * 方法一：回溯
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new ArrayList<>());
        //用于剪枝1
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int start, ArrayList<Integer> track) {
        if (nums.length == track.size())
            return;
        for (int i = start; i < nums.length; i++) {
            /* 与q78不同点，增加个剪枝 */
            //剪枝条件1：当元素相等且为同层时剪枝
            //实现剪枝1：元素值相等，并且i!=start（i==start说明为父子层）
            if (i != start && nums[i] == nums[i - 1])
                continue;

            track.add(nums[i]);
            //记录子集：即从1~n,2~n...n~n的track
            res.add(new ArrayList<>(track));
            //剪枝条件2：决策树子节点<父节点
            //实现剪枝2：传递i+1作为start
            backTrack(nums, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}