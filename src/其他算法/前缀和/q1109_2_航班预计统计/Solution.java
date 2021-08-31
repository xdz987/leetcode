package 其他算法.前缀和.q1109_2_航班预计统计;

/**
 * 方法一：差分
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for(int i=0;i<bookings.length;i++){
            res[bookings[i][0]-1]+=bookings[i][2];
            if(bookings[i][1]<n){
                res[bookings[i][1]]-=bookings[i][2];
            }
        }
        for(int i=0;i<res.length-1;i++){
            res[i+1] +=res[i];
        }
        return res;
    }
}