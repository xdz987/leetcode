package 数学.其他.q367_1_有效的完全平方数;

/**
 * 方法一：找规律
 * Java：100% 69%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        int base = 1;
        while(num>0){
            num-=base;
            base+=2;
        }
        return num==0;
    }
}