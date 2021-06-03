package 其他算法.双指针.q633_2_平方数之和;

public class Solution {
    public static void main(String[] args) {
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        System.out.println(judgeSquareSum.judgeSquareSum(1000000));
        System.out.println((int)(669252*669252));
        System.out.println((int)(743526*743526));
    }
}

/**
 * 左右指针
 * 边界为[1,c]，设变量sum=a方+b方，根据sum与c的比较，调整a和c的值
 * 需注意的是可以存在a=b=0
 */
class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        //(1)初始化边界
        int a = 0;
        //不能将右指针b直接设为b=c，会导致b方越界的问题
        //此步骤的意义是：设b=√c，使得b方<=c方，存在意义：(1)减少执行次数(2)阻止了b方超过int导致越界问题，只要c不越界，b就不会越界
        int b = (int)Math.sqrt(c);

        //(2)查找a,b
        while (a <= b) {
            int sum = a * a + b * b;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                a++;
            }
            else {
                b--;
            }
        }
        return false;
    }
}
