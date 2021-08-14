package 数组.q1583_2_统计不开心的朋友;


/**
 * 方法一：数组/模拟
 */
class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        //(1)整理preferences表：整理权重
        //记录i与其他朋友的关系亲密度权重表weights
        int[][] weights = new int[n][n];
        for(int i=0;i<n;i++){
            int weight = n-1;
            for(int fre:preferences[i]){
                weights[i][fre] = weight--;
            }
        }
        //(2)整理pairs表：根据paris队友记录对应权重值
        //将当前配对的朋友保存进teams表。i当前的队友为teams[i][0]，关系亲密度的权重为teams[i][1]
        int[][] teams = new int[n][2];
        for(int[] pair:pairs){
            teams[pair[0]][0] = pair[1];
            teams[pair[0]][1] = weights[pair[0]][pair[1]];
            teams[pair[1]][0] = pair[0];
            teams[pair[1]][1] = weights[pair[1]][pair[0]];
        }
        //(3)统计不开心的朋友：满足不等式即累加
        //将题目的不等式代入，成立时res++
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //当朋友是自己或朋友为队友时，不需要进行比较，continue
                if(i==j || j == teams[i][0]){
                    continue;
                }
                int x_y = teams[i][1];
                int x_u = weights[i][j];
                int u_v = teams[j][1];
                int u_x = weights[j][i];
                //剪枝：当paris中队友的亲密度为最高时，直接不需要比较
                if(x_y == n-1)
                    break;
                //当满足不等式时，i为不开心的朋友
                if(x_y < x_u && u_v < u_x){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}