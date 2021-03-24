package 树.二叉树.q112_1_路径总和;

import 树.二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }
}

/**
 * 前序
 */
class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        //说明达到叶节点
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        //CurrentSum会复制作为形参到每一节点进行运算
        //当targetSum从root.val减到叶节点后，如果等于叶节点的值，则说明该路径之和等于targetSum
        int currentSum = targetSum - root.val;
        return hasPathSum(root.left, currentSum) || hasPathSum(root.right, currentSum);
    }

    //****以下用于理解二叉树递归学习*****
    //用于学习：计算每条路径之和
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        boolean res = pathSum(root, 0, targetSum);
//        System.out.println(pathSumList.toString());
//        return res;
//    }
//
//    //每条路径之和容器
//    List<Integer> pathSumList = new ArrayList<>();
//
//    public boolean pathSum(TreeNode root, int currentSum, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//        //到此说明为叶节点
//        if (root.left == null && root.right == null) {
//            int pathSum = currentSum+root.val;
//            pathSumList.add(pathSum);
////            return pathSum == targetSum;
//        }
//
//        //累加每条路径的值，并进行作为形参赋值到Left和Right子树，进行分裂
//        currentSum += root.val;
//        return pathSum(root.left, currentSum, targetSum) || pathSum(root.right, currentSum, targetSum);
//    }
}