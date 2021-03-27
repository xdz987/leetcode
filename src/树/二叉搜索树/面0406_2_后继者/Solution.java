package 树.二叉搜索树.面0406_2_后继者;

import 树.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode pre = null;
        boolean next = false;
        TreeNode res = null;
        while (cur != null) {
            if (cur.left == null) {
                if (next) {
                    res = cur;
                    break;
                }
                if (cur == p)
                    next = true;
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                if (next) {
                    res = cur;
                    break;
                }
                if (cur == p)
                    next = true;
                cur = cur.right;
            }
        }

        return res;
    }
}