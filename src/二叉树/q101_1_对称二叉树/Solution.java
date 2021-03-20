package 二叉树.q101_1_对称二叉树;

import org.w3c.dom.Node;
import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 前序遍历
 * 1. 判断左子树.val是否等于右子树.val
 * 2. 判断左子树与右子树的子节点是否对称
 */
class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.val == node2.val && check(node1.left, node2.right) && check(node1.right, node2.left);
    }
}