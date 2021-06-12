package 剑指offer补充.剑65_1_不用加减乘除做加法;

/**
 * 方法一：模拟运算
 */
public class Solution {
    public int add(int a, int b) {
        while(b!=0){
            int c = (a&b)<<1;
            a^=b;
            b=c;
        }
        return a;
    }
}
