package 贪心.q406_2_根据身高重建队列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 方法一：贪心
 * Java：43% 60%
 * 局部最优：优先按身⾼⾼的people的k来插⼊。插⼊操作过后的people满⾜队列属性
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //(1)排序，第一序按照身高高的排序、第二序按照k值小的排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        //(2)根据容器长度与k值进行排序。当size>k时，插入到k位，当size<k时，直接加到尾部
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            //因为是链表，所以p[1]大于链表长度会直接追加尾部
            list.add(p[1], p);
        }
        return list.toArray(new int[0][2]);
    }
}