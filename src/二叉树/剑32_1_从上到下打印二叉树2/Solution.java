package 二叉树.剑32_1_从上到下打印二叉树2;

import com.sun.source.tree.Tree;
import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 层序遍历
 */
class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            //开始入队除出队 queue.size()进行限制实现了分层
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
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