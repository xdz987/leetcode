package 树.二叉树.q257_1_二叉树的所有路径;

import 树.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：回溯
 * Java：100% 75%
 */
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        backTrack(root, new ArrayList<>());
        return res;
    }

    private void backTrack(TreeNode root, ArrayList<Integer> track) {
        if (root == null) {
            return;
        }
        track.add(root.val);
        if (root.left==null&&root.right==null){
            StringBuilder sb = new StringBuilder();
            for (int num:track){
                sb.append(num);
                sb.append("->");
            }
            res.add(sb.substring(0,sb.length()-2));
        }
        backTrack(root.left, track);
        backTrack(root.right, track);
        track.remove(track.size() - 1);
    }
}