package 回溯.排列.q60_3_排列序列;

/**
 * 方法三：回溯-迭代颁
 */
public class Solution3 {
    public String getPermutation(int n, int k) {
        //(1)初始化阶乘数组、used数组、结果res
        int[] factorials = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        boolean[] used = new boolean[n];
        StringBuilder res = new StringBuilder();
        //(2)遍历决策树每一层
        for (int i = n - 1; i >= 0; i--) {
            int branchLeafNodeCount = factorials[i];
            //(3)遍历每个元素
            for (int j = 1; j <= n; j++) {
                //(3.1)已经使用够的元素
                if (used[j - 1])
                    continue;
                //(3.2)不在此分支，跳到下一个分支
                if (branchLeafNodeCount < k) {
                    k -= branchLeafNodeCount;
                    continue;
                }
                //(3.3)在此分支，添加到res，并直接break执行下一层
                res.append(j);
                used[j - 1] = true;
                break;
            }
        }
        return res.toString();
    }
}
