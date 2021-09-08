package 笔试.完美世界20210907.可回退的按值跳楼梯;


public class ac66 {
    public static void main(String[] args) {
        System.out.println(minJump(new int[]{1,1,1,1,1,1,1}));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param jump int整型一维数组 
     * @return int整型
     */
    public static int minJump (int[] jump) {
        int n = jump.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = jump[0];
        if(dp[1]>=n) return 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+jump[dp[i-1]];
            if(dp[i]>=n){
                return i;
            }
            for(int j=1;j<dp[i-1];j++){
                dp[i] = Math.max(dp[i],j+jump[j]);
                if (dp[i]>=n){
                    return i+1;
                }
            }
        }
        return n;
    }
}