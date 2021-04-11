package 回溯.排列.q47_2_全排列2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法一：回溯
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, used, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, boolean[] used, ArrayList track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //(2.1)used[i]为true则说明该数字(路径)已经选过了
            if (used[i])
                continue;

            //剪枝条件：同层相邻元素相等
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            //(2.2)做选择。前序遍历，添加该节点为已选择数字(路径)
            track.add(nums[i]);
            used[i] = true;
            //(2.3)进入下一层决策树。
            backTrack(nums, used, track);
            //(2.4)取向选择/状态重置。后序遍历，删除该层数字
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }
}
