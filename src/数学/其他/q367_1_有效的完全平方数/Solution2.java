package 数学.其他.q367_1_有效的完全平方数;

/**
 * 方法二：二分查找
 * Java：100% 95%
 * 复杂度：O(logN) O(1)
 */
public class Solution2 {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left = 2;
        long right = num / 2;
        while (left <= right) {
            long mid = left + ((right - left) >>> 1);
            long guessSquared = mid * mid;
            if (num == guessSquared)
                return true;
            else if (num < guessSquared)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}
