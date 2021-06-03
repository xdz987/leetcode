package 数组.q667_2_数组相差值的个数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        ConstructArray constructArray = new ConstructArray();
        System.out.println(Arrays.toString(constructArray.constructArray(30, 10)));
    }
}

/**
 * 找规律 构建法
 */
class ConstructArray {
    public int[] constructArray(int n, int k) {
        //(1)初始化 结果数组
        int[] result = new int[n];

        //(2)前k个元素，构建所需k个非重复差值
        result[0] = 1;
        for (int i = 1, interval = k; i < k + 1; i++, interval--) {
            result[i] = i % 2 == 1 ? (result[i - 1] + interval) : result[i - 1] - interval;
        }

        //(3)k+1往后元素，直接填充
        for (int i = k + 1; i < n; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}