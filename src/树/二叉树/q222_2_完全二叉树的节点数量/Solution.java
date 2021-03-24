package 树.二叉树.q222_2_完全二叉树的节点数量;

import 树.二叉树.TreeNode;

class Solution {
    public int countNodes(TreeNode root) {
        TreeNode l = root;
        TreeNode r = root;

        //1. 计算左右高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        //2. 左右高度相等说明是满二叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }

        //3. 不是满二叉树按普通二叉树来计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}