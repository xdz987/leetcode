package 树.二叉搜索树.q95_2_不同的BST2;

import 树.二叉搜索树.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 同95，把每个组合都合成BST
 * 方法一：递归枚举
 * 方法二：动态规划(待学习补充)
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int l, int r) {
        List<TreeNode> res = new LinkedList<>();
        if (l > r) {
            //单边树的情况
            res.add(null);
            return res;
        }

        //1. 穷举root节点的所有可能
        for (int i = l; i <= r; i++) {
            //2. 递归构造出以i为root的合法左右子树BST 与q96比不同点
            List<TreeNode> leftTree = build(l, i - 1);
            List<TreeNode> rightTree = build(i + 1, r);

            //3. 给以i为root节点穷举所有左右子树的组合 与q96比新增点
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}