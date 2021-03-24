package 树.二叉树.q437_2_路径总和3;

import 树.二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 前缀和+前序+后序
 * 前缀和：从顶至下，从根节点到某子节点路径之和
 * 前序：查找是否存在符合路径的节点前缀和
 * 后序：删除本子树下的节点前缀和，以防止影响到其他子树
 */
class PathSum {

    //前缀和，次数
    Map<Integer, Integer> container = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        //存在某个节点直接等于sum，此时需要前缀和为0作补充
        container.put(0, 1);

        //currentSum前缀和初始值
        return preSum(root, sum, 0);
    }

    private int preSum(TreeNode root, int target, int currentSum) {
        if (root == null) {
            return 0;
        }
        //符合target的数量res
        int res = 0;

        //前缀和累计计算
        currentSum += root.val;
        //查找是否存在满足target
        //"前缀和"精髓，后一前缀和-前一前缀和=中间路径之和(目标)，即查找存在 前一前缀和=后一前缀和(currentSum)-目标路径之和(target)
        res += container.getOrDefault(currentSum - target, 0);

        //插入前缀和容器
        container.put(currentSum, container.getOrDefault(currentSum, 0) + 1);

        //递归查找路径
        res += preSum(root.left, target, currentSum);
        res += preSum(root.right, target, currentSum);

        //清除前缀和容器，避免影响其他子树
        container.put(currentSum, container.getOrDefault(currentSum, 0) - 1);

        return res;
    }
}