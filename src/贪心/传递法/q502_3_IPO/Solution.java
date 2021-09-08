package 贪心.传递法.q502_3_IPO;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] project = new int[n][2];
        for(int i=0;i<n;i++){
            project[i] = new int[]{capital[i],profits[i]};
        }
        Arrays.sort(project,(n1, n2)->{
            if(n1[0]==n2[0]){
                return n2[1]-n1[1];
            }else{
                return n1[0]-n2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->b-a);
        int j = 0;
        for(int i=0;i<k;i++){
            for(;j<n && project[j][0]<=w;j++){
                queue.add(project[j][1]);
            }
            if(queue.isEmpty())
                break;
            w+=queue.poll();
        }
        return w;
    }
}