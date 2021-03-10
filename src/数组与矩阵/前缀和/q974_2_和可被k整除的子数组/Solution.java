package 数组与矩阵.前缀和.q974_2_和可被k整除的子数组;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
//        int[] A = new int[]{-1, 2, 9};
        int[] A = new int[]{4, 5, 0, -2, -3, 1};
        int k = 5;
        SubarraysDivByK subarraysDivByK = new SubarraysDivByK();
        System.out.println(subarraysDivByK.subarraysDivByK(A, k));
    }
}

/**
 * 前缀和
 * (一)暴力前缀和(超时) (sums[i] - sums[j]) % K ==0 去括号==> sum[i]%k - sum[j]%k ==0
 * (二)优化前缀和 Hashmap + sum[i]%k==sum[j]%k
 * 注意点：(1)0必定可被K整除 (2)负数取模为负数(跟语音相关)
 */
class SubarraysDivByK {

    //暴力前缀和
//    public int subarraysDivByK(int[] A, int K) {
//        //(1)初始化前缀和容器、满足条件子数组数量
//        int[] sums = new int[A.length + 1];
//        sums[0] = 0;
//        int res = 0;
//
//        //(2)填充前缀和
//        int i = 1;
//        for (int num : A) {
//            sums[i] += sums[i - 1] + num;
//            i++;
//        }
//
////        System.out.println(Arrays.toString(sums));
//        //(3)暴力前缀和
//        for (i = sums.length - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if ((sums[i] - sums[j]) % K == 0) {
////                    System.out.println((j) + "-" + (i - 1));
//                    res++;
//                }
//            }
//        }
//
//        return res;
//    }

//    //优化前缀和 hashMap
//    public int subarraysDivByK(int[] A, int K) {
//        //(1)初始化前缀和容器 [sum%k,数量]、结果res、累计运算sum
//        HashMap<Integer, Integer> preSum = new HashMap();
//        //表示前缀和即可被K整除，即[0,i]区间
//        preSum.put(0, 1);
//        int res = 0;
//        int sum = 0;
//
//        //(2)优化前缀和
//        for (int i = 0; i < A.length; i++) {
//            sum += A[i];
//            //4,9,9,7,4,5
//            //4,4,4,2,4,0
//            //取绝对值 如k=5，2-7=-5 2%5=2 -7%5=-2 此时2≠-2，但其区间实为符合被K整除
//            int cal = (sum % K + K) % K;
//            if (preSum.containsKey(cal)) {
//                res += preSum.get(cal);
//            }
//
//            System.out.println(sum + "-" + sum % K);
//            preSum.put(cal, preSum.getOrDefault(cal, 0) + 1);
//        }
//        System.out.println(preSum.toString());
//        return res;
//    }

    //优化前缀和 int[]
    public int subarraysDivByK(int[] A, int K) {
        //(1)初始化前缀和容器 [sum%k,数量]、结果res、累计运算sum
        int[] preSum = new int[K];
        //表示前缀和即可被K整除，即[0,i]区间
        preSum[0] = 1;
        int res = 0;
        int sum = 0;

        //(2)优化前缀和
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            //4,9,9,7,4,5
            //4,4,4,2,4,0
            //取绝对值 如k=5，2-7=-5 2%5=2 -7%5=-2 此时2≠-2，但其区间实为符合被K整除
            int cal = (sum % K + K) % K;
            res += preSum[cal];
            preSum[cal]++;
        }
        return res;
    }
}
