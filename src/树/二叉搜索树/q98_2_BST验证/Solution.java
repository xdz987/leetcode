package 树.二叉搜索树.q98_2_BST验证;

import 树.二叉搜索树.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    //BST需满足：max.val > root.val > min.val
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        //限定了左子树的最大值是root.val，不断递归不断更新max为root
        //右子树的最小值是root.val，不断递归不断更新min为root
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
