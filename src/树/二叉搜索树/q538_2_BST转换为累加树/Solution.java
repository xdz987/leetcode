package 树.二叉搜索树.q538_2_BST转换为累加树;

import 树.二叉搜索树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 解题：利用BST的特性
 * 累加树：节点值为>=本节点的值之和
 * 可采用中序遍历(right交换顺序)累加节点的值，并进行赋值即可
 */
class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    int sum = 0;
    private void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convert(root.right);
        sum += root.val;
        root.val = sum;

        convert(root.left);
    }
}