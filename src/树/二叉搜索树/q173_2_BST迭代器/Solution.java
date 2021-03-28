package 树.二叉搜索树.q173_2_BST迭代器;

import 树.二叉搜索树.TreeNode;

import java.util.*;

public class Solution {

}

/**
 * 方法一：提前保存好所有数值
 * 方法二：使用中序遍历+栈控制
 */
//class BSTIterator {
//    List<Integer> valList = new ArrayList<>();
//    int index = 0;
//
//    public BSTIterator(TreeNode root) {
//        if (root == null)
//            return;
//        inorderTraversal(root);
//    }
//
//    private void inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        inorderTraversal(root.left);
//        valList.add(root.val);
//        inorderTraversal(root.right);
//    }
//
//    public int next() {
//        return valList.get(index++);
//    }
//
//    public boolean hasNext() {
//        return index < valList.size();
//    }
//}

//方法二：中序遍历+栈
class BSTIterator {

    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
