import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int[][] node;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        node = new int[n][n];
        visited = new boolean[n];
        
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1) node[i][j] = node[j][i] = 1;
            }
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                //dfs(n, i);
                bfs(n, i);
                answer ++;
            }
        }
        return answer;
    }
    
    static void dfs(int n, int index){
        visited[index] = true;
        
        for(int i=0; i<n; i++){
            if(node[index][i] == 1 && !visited[i]) dfs(n, i);
        }
    }
    
    static void bfs(int n, int index){
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(index);
        visited[index] = true;
        
        while(!que.isEmpty()){
            int temp = que.poll();
            
            for(int i=0; i<n; i++){
                if(node[temp][i] == 1 && !visited[i]){
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}