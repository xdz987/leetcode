package 数组.q565_2_数组嵌套;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 0, 3, 1, 6, 2};
        ArrayNesting arrayNesting = new ArrayNesting();
        //暴力法
        long startTime = System.nanoTime();   //获取开始时间
        System.out.println(arrayNesting.arrayNesting1(nums));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

        //标记法 额外数组
        startTime = System.nanoTime();   //获取开始时间
        System.out.println(arrayNesting.arrayNesting2(nums));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

        //标记法 标记于原数组
        startTime = System.nanoTime();   //获取开始时间
        System.out.println(arrayNesting.arrayNesting3(nums));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

    }
}

/**
 * 元素值作为索引进行嵌套，直到回到起点构成环
 * 方法一：暴力法，O(n^2) O(1)，从0到n每个元素作为起点计数一遍，取最长。PS：存在大量重复计算
 * 方法二：标记法 额外数组，O(n) O(n)，增加一个等长数组标记已访问过的元素。PS：环中的每个数组元素的最长路径都是一样的
 * 方法三：标记法 标记自身，O(n) O(1)，已访问过的数组设为Integer.MAX_VALUE为已访问
 */
class ArrayNesting {
    // 暴力法
    public int arrayNesting1(int[] nums) {
        //(1)初始化
        int res = 0;

        //(2)循环查找每个元素的最长嵌套
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int count = 0;
            do {
                start = nums[start];
                count++;
                //nums[i]是不变的，相等说明走了一圈，回了起点
                //例：nums[0]=2，而start=nums[2]=0 => start=nums[0]=2
            } while (start != nums[i]);
            res = Math.max(count, res);
        }
        return res;
    }

    //标记法1 额外已访问数组
    public int arrayNesting2(int[] nums) {
        //(1)初始化 标记数组
        int res = 0;
        boolean[] visitedArr = new boolean[nums.length];

        //(2)循环查找每个元素的最长嵌套 跳过已访问
        for (int i = 0; i < nums.length; i++) {
            if (!visitedArr[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                } while (start != nums[i]);
                res = Math.max(count, res);
            }
        }
        return res;
    }

    //标记法2 已访问置于原数组
    public int arrayNesting3(int[] nums) {
        //(1)初始化 标记数组
        int res = 0;

        //(2)循环查找每个元素的最长嵌套 跳过已访问
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                do {
                    int tmp = start;
                    start = nums[start];
                    count++;
                    nums[tmp] = Integer.MAX_VALUE;
                }while (nums[start] !=Integer.MAX_VALUE);
                res = Math.max(count, res);
            }
        }
        return res;
    }
}