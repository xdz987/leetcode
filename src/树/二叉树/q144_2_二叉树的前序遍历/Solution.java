package 树.二叉树.q144_2_二叉树的前序遍历;

import 树.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法1：非递归前序遍历。使用栈，出栈要求：中<-左<-右
 * 方法2：普通递归前序遍历
 * 方法3：Morris前序遍历
 * 方法3 > 方法2 > 方法1
 */
public class Solution {

//    //方法一 普通非递归
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            if (node==null) continue;
//            res.add(node.val);
//            stack.push(node.right);
//            stack.push(node.left);
//        }
//        return res;
//    }

//    //方法二：普通递归
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) return res;
//        collect(root);
//        return res;
//    }
//
//    private void collect(TreeNode root) {
//        if (root == null) return;
//        res.add(root.val);
//        collect(root.left);
//        collect(root.right);
//    }

    //方法三：Morris前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                res.add(cur.val);
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                cur = cur.right;
            }
        }
        return res;
    }
}
