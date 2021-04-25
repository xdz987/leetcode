package 数学.其他.q326_1_3的幂;

/**
 * 方法二：迭代循环
 * Java：99% 63%
 * 复杂度：O(logbN) O(1)
 */
public class Solution2 {
    public boolean isPowerOfThree(int n) {
        //任何数的0次幂=1
        if (n < 1)
            return false;
        //3^x由3*3*3*...组成
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
