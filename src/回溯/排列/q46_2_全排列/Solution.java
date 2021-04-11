package 回溯.排列.q46_2_全排列;

import java.util.*;

/**
 * 方法一：回溯
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        //用于判断是否为已使用过节点，与nums下标同步
        boolean[] used = new boolean[nums.length];
        //回溯
        backTrack(nums, new ArrayList<>(), used);
        return res;
    }

    private void backTrack(int[] nums, ArrayList<Integer> track, boolean[] used) {
        //(1)结束条件。一次完整的排列组合则保存
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        //(2)多叉树遍历。以每个数字作为起点，遍历每种可能
        for (int i = 0; i < nums.length; i++) {
            //(2.1)used[i]为true则说明该数字(路径)已经选过了
            if (used[i]) {
                continue;
            }
            //(2.2)做选择。前序遍历，添加该节点为已选择数字(路径)
            track.add(nums[i]);
            used[i] = true;
            //(2.3)进入下一层决策树。
            backTrack(nums, track, used);
            //(2.4)取向选择/状态重置。后序遍历，删除该层数字
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }
}
