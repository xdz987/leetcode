package 树.二叉搜索树.q230_2_BST第k小的树;

import 树.二叉搜索树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * BST中序遍历
 */
class KthSmallest {
    int res = -1;
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return res;
    }

    private void find(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        find(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }

        find(root.right, k);
    }
}