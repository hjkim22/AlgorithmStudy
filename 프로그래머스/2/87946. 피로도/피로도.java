class Solution {
    static int answer = 0;
    static boolean[] check;
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        DFS(k, dungeons, 0);
        return answer;
    }
    
    public void DFS(int k, int[][]d, int deep) {
        answer = Math.max(answer, deep);
        for(int i = 0; i < d.length; i++) {
            if(!check[i] && k >= d[i][0]) {
                check[i] = true;
                DFS(k - d[i][1], d, deep + 1);
                check[i] = false;
            }
        }
    }
}