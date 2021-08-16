package 回溯.排列.q526_2_优美的排列;

/**
 * 方法一：回溯
 */
class Solution {
    int res = 0;
    public int countArrangement(int n) {
        boolean[] used = new boolean[n+1];
        backTrack(used,n,1);
        return res;
    }

    private void backTrack(boolean[] used,int n,int track){
        if(track-1 == n){
            res++;
        }
        for(int i = 1;i<=n;i++){
            if(used[i])
                continue;
            if(i%track != 0 && track%i !=0){
                continue;
            }
            track++;
            used[i] = true;
            backTrack(used,n,track);
            track--;
            used[i] = false;
        }
    }
}