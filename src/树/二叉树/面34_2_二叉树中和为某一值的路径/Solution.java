package 树.二叉树.面34_2_二叉树中和为某一值的路径;

import 树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * target递减，最后为target为零且为叶节点，则条件满足
 * 注意：
 * 1. path使用linkedList，这样可以指定删除最后一个元素
 * 2. 保存path的时候需要深拷贝
 */
class PathSum {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        find(root, target);
        return res;
    }

    private void find(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        //target递减
        target -= root.val;
        //记录路径
        path.add(root.val);
        //如为叶节点且满足target，添加记录
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList(path));
        }

        find(root.left, target);
        find(root.right, target);

        //本层递归结束，删除本层路径
        path.removeLast();
    }
}