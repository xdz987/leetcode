package 树.二叉搜索树.q653_1_BST两数之和;

import 树.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序+双指针
 * 1. 中序将BST转换为List
 * 2. 双指针查找sum等于k
 */
public class Solution {
    List<Integer> res = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        //双指针
        collect(root);
        int l = 0;
        int r = res.size() - 1;
        while (l < r) {
            int sum = res.get(l) + res.get(r);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    //将BST收集为ArrayList
    private void collect(TreeNode root) {
        if (root == null) {
            return;
        }
        collect(root.left);
        res.add(root.val);
        collect(root.right);
    }
}
