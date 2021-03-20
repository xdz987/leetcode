package 二叉树.q104_1_二叉树的最大深度;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 后序 深度优先
 * 重点：比较每个节点的深度，取最大深度
 */
class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        //比较每一个节点的深度，保存最大深度。+1用于累计当前深度
        return Math.max(left, right) + 1;
    }
}