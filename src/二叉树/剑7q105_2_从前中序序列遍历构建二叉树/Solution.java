package 二叉树.剑7q105_2_从前中序序列遍历构建二叉树;

import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 重点：同q654，只是max变preorder[preLeft]，需要同时维护preorder与inorder
 */
class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        //base case pre或in的范围选一个即可
        if (preLeft > preRight) {
            return null;
        }

        //(1)找到pre中root节点位置
        int rootVal = preorder[preLeft];

        //(2)找到in中root节点位置
        int inIndex = -1;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal) {
                inIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        //(3)确定pre的左右子树范围
        int inLeftSize = inIndex - inLeft;

        //(4)递归生成树
        root.left = build(preorder, preLeft + 1, preLeft + inLeftSize, inorder, inLeft, inIndex - 1);
        root.right = build(preorder, preLeft + inLeftSize + 1, preRight, inorder, inIndex + 1, inRight);

        return root;
    }
}