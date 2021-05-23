package 树.二叉树.q671_1_二叉树中第二小的节点;

import 树.二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 题意：树为特殊的树，即可存在重复的节点值，子节点数只能为2或0
 * 重点：
 * 1. 只有左右字节点相等才需要递归，则进行剪枝
 * 2. 当左右子节点相等，而进行递归时：
 *    (1)所有节点相等，则当所有递归到达叶节点，返回-1
 *    (2)一边子树的所有节点相等或为叶节点，则直接返回另一节点
 *      a.另一节点叶为-1，即等同于(1)
 *      b.另一节点不为-1，则说明为倒数第二小子节点
 *    (3)两边子树都存在大于根节点的值，取最小值即为倒数第二小子节点。同时由于进行了剪枝，所以不会往下递归
 */
class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return find(root, root.val);
    }

    private int find(TreeNode root, int rootVal) {
        //(1)不等于root.val即为倒数第二小
        if (root.val != rootVal) {
            return root.val;
        }
        //(2)说明为叶节点
        if (root.left == null) {
            return -1;
        }
        //出现以上情况，直接不再深入递归，即剪枝

        //(3)以下说明left子节点等于right子节点，进行递归
        int left = find(root.left, root.val);
        int right = find(root.right, root.val);

        //(3.1)针对一边为叶子节点或全相等，另一边存在倒数第二小值
        if (left == -1) {   
            return right;
        }
        if (right == -1) {
            return left;
        }

        //(3.2)说明两边都存在一个大于root节点的值，取最小即可
        return Math.min(left, right);
    }
}
