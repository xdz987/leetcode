package 其他算法.滑动窗口.q978_2_最长湍流子数组;

public class Solution {
    public static void main(String[] args) {
        int[] A = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
//        int[] A = new int[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 0};
//        int[] A = new int[]{4, 8, 12, 16};
        MaxTurbulenceSize maxTurbulenceSize = new MaxTurbulenceSize();
        System.out.println(maxTurbulenceSize.maxTurbulenceSize(A));
    }
}

/**
 * 满足条件最大窗口
 */
class MaxTurbulenceSize {
    //7ms
    public int maxTurbulenceSize(int[] arr) {
        //(1)初始化窗口指针、满足条件窗口长度
        int left = 0;
        int right = 0;
        int res = 0;

        //(2)处理前两个元素
        if (arr.length == 1) {
            res = 1;
        }
        if (arr.length >= 2) {
            if (arr[0] == arr[1])
                res = 1;
            else
                res = 2;
        }

        //滑动窗口
        while (right < arr.length - 2) {
            right++;

            //(4)不符合湍流子则重新累计
            boolean judge = (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) ||
                    (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]);
            if (!judge) {
                left = right;
            } else {
                //(5)子数组的第以个驼峰或山谷由3个元素组成，所以补2
                res = Math.max(res, right - left + 2);
            }
        }
        return res;
    }

    //二刷：5ms
    public int maxTurbulenceSize2(int[] arr) {
        int n = arr.length;
        int res = 0;
        if (n == 1) {
            res = 1;
        }
        if (n >= 2) {
            res = arr[0] != arr[1] ? 2 : 1;
        }
        int left = 0;
        int right = 0;
        while (right < n - 2) {
            right++;
            if ((arr[right] < arr[right - 1] && arr[right] < arr[right + 1])
                    || arr[right] > arr[right - 1] && arr[right] > arr[right + 1]) {
                res = Math.max(res, right - left + 2);
            } else {
                left = right;
            }
        }
        return res;
    }
}
