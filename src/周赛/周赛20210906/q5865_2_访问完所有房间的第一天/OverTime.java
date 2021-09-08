package 周赛.周赛20210906.q5865_2_访问完所有房间的第一天;

class OverTime {
    private static final int MOD = 1000000007;
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int visited = 0;
        boolean[] flag = new boolean[n];
        int[] times = new int[n];
        int i=nextVisit[0];
        while(visited<n){
            if(!flag[i]){
                visited++;
                flag[i]=true;
            }
            times[i]++;
            if((times[i]&1)==1){
                i=nextVisit[i];
            }else{
                i=(i+1)%n;
            }
        }
        int days=0;
        for(int day:times)
            days = (days+day)%MOD;
        return days-1;
    }
}