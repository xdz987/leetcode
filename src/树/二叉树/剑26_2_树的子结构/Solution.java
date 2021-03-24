package 树.二叉树.剑26_2_树的子结构;

import 树.二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 类似q572，但子树与子结构不同：
 * 1. 子树包含下面叶节点，子结构可以不包含叶节点
 * 2. []是任一树的子树，空树不是任意一个树的子结构
 */
class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return subStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean subStructure(TreeNode AA, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (AA == null || AA.val != B.val) {
            return false;
        }

        return subStructure(AA.left, B.left) && subStructure(AA.right, B.right);
    }
}