import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(check[i]) continue;
            DFS(n, computers, check, i);
            answer++;
        }
        return answer;
    }
    
    private void DFS(int n, int[][] computers, boolean[] check, int index) {
        check[index] = true;
        for(int i = 0; i < n; i++) {
            if(!check[i] && computers[index][i] == 1) {
                DFS(n, computers, check, i);
            }
        }
    }
}