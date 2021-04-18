package 位运算.位移.剑15q191_1_二进制中1的个数;

/**
 * 方法二：巧用n&(n-1)
 * Java：97% 97%
 * 复杂度：O(M) O(1) 其中M为1的个数
 */
public class Solution2 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
