package 二叉树.q572_1_另一个树的子树;

import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 方法一：序列化。同q652，序列化t子树，再序列化s子树查找是否相等（低性能，仅做学习）
 */
class IsSubtree {

    //方法一：序列化（仅做学习）
//    boolean res = false;
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        String tSerialize = serialize(t);
//        search(s, tSerialize);
//        return res;
//    }
//
//    //序列化一颗树
//    private String serialize(TreeNode root) {
//        if (root == null) {
//            return "#";
//        }
//
//        String left = serialize(root.left);
//        String right = serialize(root.right);
//
//        return left + "," + right + "," + root.val;
//    }
//
//    //查看是否存在target子树
//    private String search(TreeNode root, String target) {
//        if (root == null) {
//            return "#";
//        }
//
//        String left = search(root.left, target);
//        String right = search(root.right, target);
//        String subTree = left + "," + right + "," + root.val;
//        if (subTree.equals(target)) {
//            res = true;
//        }
//        return subTree;
//    }
    //双层递归
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == null && t == null;
        }
        //判断是否为同一结构的树
        if (isSameTree(s, t)) {
            return true;
        }

        //递归每颗子树(节点)，判断是否相等
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode ss, TreeNode t) {
        if (ss == null || t == null) {
            return ss == null && t == null;
        }
        //判断节点的值是否相等
        if (ss.val != t.val) {
            return false;
        }

        //递归判断左右所有节点的val是否相等
        return isSameTree(ss.left, t.left) && isSameTree(ss.right, t.right);
    }
}