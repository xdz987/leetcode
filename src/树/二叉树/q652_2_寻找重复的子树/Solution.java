package 树.二叉树.q652_2_寻找重复的子树;

import 树.二叉树.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 序列化子树，然后使用HashMap存储子树，递归时判断是否重复(存在)
 */
class FindDuplicateSubtrees {

    //(1)初始化存储子树序列化的容器、结果res
    Map<String, Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        System.out.println(memo.keySet().toString());
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        //(2)后缀递归遍历
        String left = traverse(root.left);
        String right = traverse(root.right);

        //(3)序列化当前子树，查找是否存在重复，存在则加到res
        String subTree = left + "," + right + "," + root.val;
        int freq = memo.getOrDefault(subTree, 0);
        if (freq == 1) {
            res.add(root);
        }
        //添加进容器
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
