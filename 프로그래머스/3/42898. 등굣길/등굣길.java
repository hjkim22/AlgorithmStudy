class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        int[][] map = new int[n+1][m+1];
        
        for(int[] p:puddles){
            int x = p[0];
            int y = p[1];
            map[y][x] = -1; //웅덩이
        }
        
        dp[1][1] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j]==-1){
                    continue;
                }
                if(i>1){
                    dp[i][j] += dp[i-1][j]%1000000007;
                }
                if(j>1){
                    dp[i][j] += dp[i][j-1]%1000000007;
                }
            }
        }
        
        answer = dp[n][m]%1000000007;
        
        return answer;
    }
}