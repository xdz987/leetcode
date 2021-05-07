package 剑指offer补充.剑64_2_限制条件求阶乘;

/**
 * 方法一：递归
 * Java：100% 70%
 * 复杂度：O(1) O(1)
 */
class Solution {
    public int sumNums(int n) {
        boolean x = n > 1 && ((n+=sumNums(n-1))>0);
        return n;
    }
}