package 二叉树.q114_2_二叉树展开为链表;

import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 将链表变成右斜树
 * 后缀：垂直，链接头尾链表
 */
class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        //展开链表
        flatten(root.left);
        flatten(root.right);

        //备份root的左右子树单链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        //修改root的节点，将left单链表链接到root.right
        root.left = null;
        root.right = left;

        //将链接到root的left右斜树指向尾结点，以便链接right右斜树
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
