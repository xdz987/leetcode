package 位运算.异或运算.q461_1_汉明距离;

/**
 * 方法一：位运算——异或
 * Java：100% 90%
 * 复杂度：O(K) O(1) 其中K为x^y二进制中1的数量
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int z = x ^ y;
        while (z != 0) {
            //与运算技巧：删除最为1的比特
            z = z & (z - 1);
            count++;
        }
        return count;
    }
}
