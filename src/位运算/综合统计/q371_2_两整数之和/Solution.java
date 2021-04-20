package 位运算.综合统计.q371_2_两整数之和;

/**
 * 方法一：位运算
 * 前置知识：a^b为没有考虑进位情况的两数之和，(a&b)<<1就是进位
 * Java：
 * 复杂度：O(w) O(w)  w是max(a比特位,b的比特位)
 */
class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}