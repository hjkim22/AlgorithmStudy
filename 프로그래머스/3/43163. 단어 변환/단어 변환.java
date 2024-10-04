import java.util.*;
class Solution {
    boolean[] visited;
    int ans = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        visited = new boolean[words.length];
        if(!Arrays.asList(words).contains(target)){
            return 0;
        }
        else{
            dfs(begin, target, 0, words);
            answer = ans;
        }
        
        return answer;
    }
    
    public void dfs(String word, String target, int count, String[] words){
        if(word.equals(target)){
            ans = Math.min(count, ans);
        }
        
        for(int i=0; i<words.length; i++){
            if(visited[i]) continue;
            
            if(canChange(word, words[i])){
                visited[i] = true;
                dfs(words[i], target, count+1, words);
                
                visited[i] = false;
            }
        }
        return;
    }
    
    public boolean canChange(String word, String w){
        int cnt = 0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)!=w.charAt(i))
                cnt++;
            if(cnt>1){
                return false;
            }
        }
        return true;
    }

}