package 哈希表.q202_1_快乐数;

/**
 * 方法二：快慢指针
 * Java：99% 99%
 * 复杂度：O(n) O(1)
 */
class Solution2 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSplitSum(n);
        while (slow != 1 && slow != fast) {
            slow = getSplitSum(slow);
            fast = getSplitSum(getSplitSum(fast));
        }
        return slow == 1;
    }

    private int getSplitSum(int num) {
        int sum = 0;
        while (num != 0) {
            int tmp = num % 10;
            sum += tmp * tmp;
            num = num / 10;
        }
        return sum;
    }
}
