package 数学.其他.q326_1_3的幂;

/**
 * 方法一：整数限制
 * Java：99% 92%
 * 复杂度：O(1) O(1)
 */
class Solution {
    //1162261467是int类型最大的3的幂
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}