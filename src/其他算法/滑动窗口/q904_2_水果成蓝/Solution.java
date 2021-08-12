package 其他算法.滑动窗口.q904_2_水果成蓝;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] tree = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        TotalFruit totalFruit = new TotalFruit();
        System.out.println(totalFruit.totalFruit(tree));
    }
}

/**
 * 题目：如[0,1,2,2]：第一个颗产生型号0水果，第二棵树产生型号2水果，第三第四颗树产生型号2的水果
 * 即求只包含两种元素的最长连续子序列
 */
class TotalFruit {
    //三刷：7ms
    public int totalFruit3(int[] fruits) {
        int n = fruits.length;
        int[] window = new int[n];
        int valid = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        while(right<n){
            window[fruits[right]]++;
            if(window[fruits[right]] == 1){
                valid++;
            }
            right++;
            while(valid>2){
                window[fruits[left]]--;
                if(window[fruits[left]]==0){
                    valid--;
                }
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }

    //HashMap版
    public int totalFruit(int[] tree) {
        //(1)初始化窗口指针Map、res
        HashMap<Integer, Integer> valid = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;

        //滑动窗口
        while (right < tree.length) {
            //(2)拓展窗口
            int rNum = tree[right];
            right++;
            valid.put(rNum, valid.getOrDefault(rNum, 0) + 1);

            //(3)当超过两种型号水果则缩小窗口
            while (valid.size() > 2) {
                int lNum = tree[left];
                left++;
                valid.put(lNum, valid.getOrDefault(lNum, 0) - 1);
                //删除元素
                if (valid.get(lNum) < 1) {
                    valid.remove(lNum);
                }
            }

            //(4)保存 水果总数
            res = Math.max(res, right - left);
        }
        return res;
    }

    //int[]版 (超时 忽略)
//    public int totalFruit(int[] tree) {
//        int[] valid = new int[tree.length];
//        int left = 0;
//        int right = 0;
//        int res = 0;
//
//        while (right < tree.length) {
//            int rNum = tree[right];
//            right++;
//            valid[rNum]++;
//
//            if(Arrays.stream(valid).filter(num->num>0).count()>2){
//                int lNum = tree[left];
//                left++;
//                valid[lNum]--;
//            }
//
//            res = Math.max(res, Arrays.stream(valid).sum());
//        }
//        return res;
//    }
}
