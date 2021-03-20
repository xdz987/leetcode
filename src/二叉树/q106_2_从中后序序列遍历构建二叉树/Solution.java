package 二叉树.q106_2_从中后序序列遍历构建二叉树;

import com.sun.source.tree.Tree;
import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 同105
 */
class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (postLeft > postRight) {
            return null;
        }

        int rootValue = postorder[postRight];
        int inIndex = -1;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootValue) {
                inIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);
        int inLeftSize = inIndex - inLeft;

        root.left = build(inorder, inLeft, inIndex - 1, postorder, postLeft, postLeft + inLeftSize - 1);
        root.right = build(inorder, inIndex + 1, inRight, postorder, postLeft + inLeftSize, postRight - 1);

        return root;
    }
}