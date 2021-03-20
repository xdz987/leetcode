package 二叉树.q617_1_合并二叉树;

import com.sun.source.tree.Tree;
import 二叉树.TreeNode;

import java.util.logging.Level;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 前序
 * 重新构建一颗树，而不是填充到root1或root2中
 */
class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        //(1)如root1或root2一方节点为空，直接返回该节点(拆出来)作为新树节点
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        //(2)否则创建新节点作为新树节点
        TreeNode root = new TreeNode(root1.val + root2.val);
        //(3)递归root的left与right子树
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }
}