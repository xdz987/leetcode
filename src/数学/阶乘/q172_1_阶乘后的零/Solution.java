package 数学.阶乘.q172_1_阶乘后的零;

/**
 * 方法一：因子计数
 * Java：94% 84%
 * 复杂度：O(logN) O(1)
 */
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}