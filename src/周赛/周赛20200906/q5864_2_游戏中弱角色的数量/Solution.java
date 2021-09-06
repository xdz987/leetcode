package 周赛.周赛20200906.q5864_2_游戏中弱角色的数量;

import java.util.Arrays;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        int res = 0;
        Arrays.sort(properties,(a, b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return b[0]-a[0];
            }
        });
        int[] max = properties[0];
        for(int i=0;i<n-1;i++){
            if(max[0] > properties[i+1][0] && max[1]>properties[i+1][1]){
                res++;
            }else{
                max = properties[i+1];
            }
        }
        return res;
    }
}