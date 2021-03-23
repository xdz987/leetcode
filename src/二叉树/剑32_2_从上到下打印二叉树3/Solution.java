package 二叉树.剑32_2_从上到下打印二叉树3;

import com.sun.source.tree.IfTree;
import 二叉树.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 在剑32_1中的基础上，把保存节点值的数组变双端队列，通过res.size()判断奇偶层
 */
class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) {
                    level.addLast(node.val);
                }else {
                    level.addFirst(node.val);
                }
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(level);
        }
        return res;
    }
}