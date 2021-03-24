package 树.二叉搜索树.q96_2_不同的BST;

/**
 * 根据BST的特性，左子树只能用1~i-1构建设x，右子树只能用i+1~n构建设y
 * 最终结果 = x * y，即卡特兰公式：G(n) = G(0)*G(n-1) + G(1)*G(n-2) +...+G(n-1)*G(0)
 * 方法一：递归枚举、递归枚举-备忘录优化
 * 方法二：动态规划(待学习)
 */
public class Solution {
    //备忘录
    int[] record;

    public int numTrees(int n) {
        record = new int[n + 1];
        record[0] = 1;
        return count(n);
    }

    private int count(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (record[n] > 0) {
            return record[n];
        }

        //卡特兰公式
        for (int i = 1; i <= n; i++) {
            record[n] += count(i - 1) * count(n - i);
        }

        return record[n];
    }
}
