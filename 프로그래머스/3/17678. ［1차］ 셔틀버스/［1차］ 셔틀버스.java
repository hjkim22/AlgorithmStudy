import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time:timetable){
            pq.add(convertToTime(time));
        }
        
        int departureTime = 9*60;
        List<List<Integer>> bus = new ArrayList<>();
        for(int i=0; i<n; i++)
            bus.add(new ArrayList<>());
        
        int ans = 0;
        for(int i=0; i<n; i++){
            while(!pq.isEmpty()){
                int crew = pq.poll();
                if(bus.get(i).size() < m && crew<=departureTime){
                    bus.get(i).add(crew);
                    ans = crew - 1;
                }
                else{
                    pq.add(crew);
                    break;
                }   
            }
            departureTime += t;
        }
        
        if(bus.get(n-1).size() < m){
            ans = departureTime - t;
        }
        
        answer += converToString(ans);
        
        return answer;
    }
    
    static int convertToTime(String s){
        String[] arr = s.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        return hour*60+min;
    }
    
    static String converToString(int time){
        String hour = String.format("%02d", time/60);
        String min = String.format("%02d", time%60);
        return hour+":"+min;
    } 
}