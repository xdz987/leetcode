package 树.二叉树.q145_2_二叉树的后序遍历;

import 树.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 方法一：非递归遍历。使用栈，出栈要求：左<-右<-中
 * 方法二：递归遍历
 * 方法三：Morris遍历
 * 比较：方法二 > 方法三 > 方法一
 */
public class Solution {

//    //方法一：非递归遍历
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) return res;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        //(1)按照前序的方式，不过改为left先入栈再入right
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node == null) continue;
//            res.add(node.val);
//            stack.push(node.left);
//            stack.push(node.right);
//        }
//        //(2)结果反转以下即为后序
//        Collections.reverse(res);
//        return res;
//    }

//    //方法二：dfs递归
//    List<Integer> res = new ArrayList<>();
//
//    public List<Integer> postorderTraversal(TreeNode root) {
//        if (root == null) return res;
//        collect(root);
//        return res;
//    }
//
//    private void collect(TreeNode root) {
//        if (root == null) return;
//        collect(root.left);
//        collect(root.right);
//        res.add(root.val);
//    }

    //方法三：Morris后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        //虚拟头节点
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        TreeNode cur = dummy;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
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

                //倒序输出：当前节点左子节点到当前节点前驱节点路径上的所有节点
                TreeNode node = cur.left;
                List<Integer> reOrder = new ArrayList<>();
                while (node != null) {
                    //头插法
                    reOrder.add(0, node.val);
                    node = node.right;
                }
                res.addAll(reOrder);
                cur = cur.right;
            }
        }
        return res;
    }
}
