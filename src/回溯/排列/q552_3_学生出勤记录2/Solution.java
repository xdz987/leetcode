package 回溯.排列.q552_3_学生出勤记录2;

class Solution {
    final int MOD = (int)1e9+7;
    int[][][] memo;
    public int checkRecord(int n) {
        memo = new int[2][3][n];
        return dfs(n,0,0,0);
    }

    private int dfs(int n,int days,int A,int L){
        //叶子节点：达到第n天，说明从root到叶子节点的情况行得通
        if(days==n){
            return 1;
        }
        //备忘录存在直接返回值
        if(memo[A][L][days]!=0)
            return memo[A][L][days];

        int ans = 0;
        //Present：没有限制，直接dfs所有可能
        ans = (ans+dfs(n,days+1,A,0))%MOD;
        //Absent：限制少于2天，dfs累计小于2的情况
        if(A<1){
            ans = (ans + dfs(n,days+1,A+1,0))%MOD;
        }
        //Absent：限制少于3天，dfs累计小于3的情况
        if(L<2){
            ans = (ans + dfs(n,days+1,A,L+1))%MOD;
        }

        //保存备忘录
        memo[A][L][days] = ans;
        return ans;
    }
}
