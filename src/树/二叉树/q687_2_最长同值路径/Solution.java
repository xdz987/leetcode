package 树.二叉树.q687_2_最长同值路径;

import 树.二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 后序
 */
class LongestUnivaluePath {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return max;
    }

    private int arrowLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //(1)后序递归每颗子树
        int left = arrowLength(root.left);
        int right = arrowLength(root.right);

        //(2)累加同值路径
        int leftCount = 0;
        int rightCount = 0;
        if (root.left != null && root.left.val == root.val) {
            leftCount += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightCount += right + 1;
        }

        //(3)动态保存当前树的最长同值路径 left+right为最大同值路径。作为当前子树的视角
        max = Math.max(max, rightCount + leftCount);

        //(4)返回left和right子节点中最大同值路径。
        //以便递归返回继续向上链接节点，达到最大同值路径。
        //作为父节点的子树的视角，当达到最顶层根节点时，此返回无意义，因为没有再上的根，而上面max已经保存
        return Math.max(leftCount, rightCount);
    }
}