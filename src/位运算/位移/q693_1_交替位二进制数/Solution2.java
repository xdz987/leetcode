package 位运算.位移.q693_1_交替位二进制数;

/**
 * 方法二：位运算——与运算
 * Java：100% 100%
 * 复杂度：O(1) O(1)
 */
public class Solution2 {
    public boolean hasAlternatingBits(int n) {
        //(1)如果n为交替二进制，则m全为1
        int m = n ^ (n >>> 1);
        //(2)m全为1 与运算 m+1 必定为0。如111+1=1000 ==> 111&1000==0
        return (m & (m + 1)) == 0;
    }
}
