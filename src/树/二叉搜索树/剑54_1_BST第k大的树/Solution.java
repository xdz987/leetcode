package 树.二叉搜索树.剑54_1_BST第k大的树;

import 树.二叉搜索树.TreeNode;

/**
 * 方法一：Morris方向中序 100% 87%
 * 方法二：反向中序遍历 100% 44%
 */
public class Solution {
//    public int kthLargest(TreeNode root, int k) {
//        TreeNode cur = root;
//        TreeNode pre = null;
//        int pos = 0;
//        while (cur != null) {
//            if (cur.right == null) {
//                pos++;
//                if (pos==k)
//                    break;
//                cur = cur.left;
//                continue;
//            }
//            pre = cur.right;
//            while (pre.left!=null && pre.left!=cur){
//                pre = pre.left;
//            }
//            if (pre.left==null){
//                pre.left = cur;
//                cur = cur.right;
//            }else{
//                pre.left = null;
//                pos++;
//                if (pos==k)
//                    break;
//                cur= cur.left;
//            }
//        }
//        return cur.val;
//    }

    int pos = 0;
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int left = kthLargest(root.right, k);
        pos++;
        if (pos == k)
            return root.val;
        int right = kthLargest(root.left, k);
        return Math.max(left, right);
    }
}
