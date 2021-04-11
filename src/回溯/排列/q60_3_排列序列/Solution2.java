package 回溯.排列.q60_3_排列序列;

/**
 * 方法一：回溯-递归版
 * 复杂度：O(n^2) O(n)
 * Java：100% 82%
 */
public class Solution2 {
    //阶乘：对应决策树的叶节点数量
    final int[] factorials = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    int k;
    int n;
    boolean[] used;

    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        this.k = k;
        this.n = n;
        used = new boolean[n + 1];
        backTrack(0, res);
        return res.toString();
    }

    //只会到目标叶节点一次就return
    private void backTrack(int level, StringBuilder res) {
        if (n == res.length()) {
            return;
        }

        //(1)初始化该层叶子节点数量
        int branchLeafNodeCount = factorials[n - 1 - level];
        for (int i = 1; i <= n; i++) {
            //已经使用过的数字
            if (used[i])
                continue;

            //剪枝
            //(2)查找位于哪个分支：小于k，说明在下一个分支，即执行k-=childBranchCount
            if (branchLeafNodeCount < k) {
                k -= branchLeafNodeCount;
                continue;
            }
            //(3)cnt>=k，说明位于该分支
            res.append(i);
            used[i] = true;
            //(4)进入下一层，level+1
            backTrack(level + 1, res);
            return;
        }
    }
}
