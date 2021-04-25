package 数学.质数.q204_1_计数质数;

/**
 * 方法一：埃氏法
 */
class Solution {
    public int countPrimes(int n) {
        //false是质数
        boolean[] isPrime = new boolean[n];
        //sqrt(n)
        //(1)排除非质数
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        //(2)统计剩余的质数
        int res = 0;
        for (int i = 2; i < n; i++) {
            res += !isPrime[i] ? 1 : 0;
        }
        return res;
    }
}