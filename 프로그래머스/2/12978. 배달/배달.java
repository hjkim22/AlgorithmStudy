import java.util.*;

class Solution {
    class Node implements Comparable<Node>{
        int end;
        int cost;
        
        Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
        
        public int compareTo(Node o){
            return cost - o.cost; 
        }
    }
    ArrayList<Node>[] graph;
    int[] best;
    int N;
    
    //50 road 0 start 1 end 2 소요시간
    public int solution(int N, int[][] road, int K) {
        this.N = N;
        graph = new ArrayList[N+1];
        best = new int[N+1];
        
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
            best[i] = Integer.MAX_VALUE;
        }
        
        for(int[] r : road){
            int start = r[0];
            int end = r[1];
            int cost = r[2];
            
            graph[start].add(new Node(end,cost));
            graph[end].add(new Node(start,cost));
        }
        
        dijkstra();
        
        int answer = 0;
        
        for(int i=1;i<=N;i++){
            if(best[i]<=K) answer++;
        }
        
        return answer;
    }
    
    public void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        best[1] = 0;
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            
            if(best[now.end] < now.cost) continue;
            
            for(Node next : graph[now.end]){
                
                if(best[next.end] > best[now.end]+next.cost){
                    best[next.end] = best[now.end]+next.cost;
                    pq.add(new Node(next.end,best[next.end]));
                }
            }
            
            
        }
        
    }
}