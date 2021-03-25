package 树.二叉树.q94_2_二叉树的中序遍历;

import com.sun.source.tree.Tree;
import 树.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：非递归中序遍历。使用栈，出栈要求：左<-中<-右
 * 方法二：递归中序遍历
 * 方法三：Morris中序遍历
 * 比较：方法三 > 方法二 > 方法一
 */
public class Solution {
    //方法一：非递归
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) return res;
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        while (cur != null || !stack.isEmpty()) {
//            while (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//            TreeNode node = stack.pop();
//            res.add(node.val);
//            cur = node.right;
//        }
//        return res;
//    }

//    //方法二：DFS
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) return res;
//        collect(root);
//        return res;
//    }
//
//    private void collect(TreeNode root) {
//        if (root==null)return;
//        collect(root.left);
//        res.add(root.val);
//        collect(root.right);
//    }

    //方法三：Morris中序
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
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
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
