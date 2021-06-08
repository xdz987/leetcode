package 其他算法.双指针.q633_2_平方数之和;

public class Solution {
    public static void main(String[] args) {
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        System.out.println(judgeSquareSum.judgeSquareSum(1000000));
        System.out.println((int) (669252 * 669252));
        System.out.println((int) (743526 * 743526));
    }
}

/**
 * 左右指针
 * 边界为[1,c]，设变量sum=a方+b方，根据sum与c的比较，调整a和c的值
 * 需注意的是可以存在a=b=0
 */
class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int cal = left * left + right * right;
            if (c == cal) {
                return true;
            } else if (c > cal) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
