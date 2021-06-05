package 其他算法.二分查找.q69_1_x的平方根;

public class Solution {
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(8));
        System.out.println(mySqrt.mySqrt(4));
    }
}

/**
 * 基本二分查找
 * 平方根舍小数，则取得左段最大值
 */
class MySqrt {
    //2ms
    public int mySqrt(int x) {
        //(1)初始化边界等
        int left = 1;
        int right = (x / 2) + 1;
        int mid = 0;
        int result = 0;

        //(2)基本二分查找
        while (left <= right) {
            mid = left + ((right - left) >>> 1);
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    //二刷：1ms
    public int mySqrt2(int x) {
        if (x == 1) return 1;
        int left = 1;
        int right = x >> 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            long cal = (long) mid * mid;
            if (cal == x) {
                return mid;
            } else if (cal < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}