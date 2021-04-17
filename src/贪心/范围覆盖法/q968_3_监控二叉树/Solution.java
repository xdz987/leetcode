package 贪心.范围覆盖法.q968_3_监控二叉树;

import 树.二叉树.TreeNode;

/**
 * 方法一：贪心
 * Java：100% 70%
 * 局部最优：摄像头尽可能的覆盖节点，即最少数量摄像头
 * 0:该节点无覆盖(摄像头)
 * 1:该节点即摄像头
 * 2:该节点有覆盖
 */
class Solution {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (traversal(root) == 0) {
            res++;
        }
        return res;
    }

    private int traversal(TreeNode root) {
        //base case：叶节点不安装摄像头才是最少数量摄像头。
        //所以子节点为空即父节点为叶节点或单枝节点，返回2表示父节点为有覆盖，那么爷爷节点必须按照个摄像头，刚好覆盖叶节点
        if (root == null) {
            return 2;
        }
        int left = traversal(root.left);
        int right = traversal(root.right);

        //(1)两个子节点存在无覆盖，那么给父节点按照个摄像头，1
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        //(2)两个节点都有覆盖，那么该父节点为无覆盖。再往上时父节点会给覆盖或按照摄像头的，0
        else if (left == 2 && right == 2) {
            return 0;
        }
        //(3)两个节点存在一个或两个摄像头，那份父节点就被覆盖到了，2
        else {
            return 2;
        }
    }
}