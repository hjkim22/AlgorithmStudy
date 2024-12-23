class Solution {
    int ans;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(0, numbers, 0, target);
        
        answer = ans;
        
        return answer;
    }
    
    public void dfs(int depth, int[] numbers, int now, int target){
        if(depth==numbers.length){
            if(now==target) ans++;
            return;
        }
        
        dfs(depth+1, numbers, now+numbers[depth], target);
        dfs(depth+1, numbers, now-numbers[depth], target);
        
        return;
    }
}