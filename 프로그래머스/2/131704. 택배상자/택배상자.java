import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int len = order.length;
        Queue<Integer> main = new LinkedList<>();
        for(int i = 1; i <= len; i++){
            main.offer(i);
        }
        
        Stack<Integer> sub = new Stack<>();
       
        int now = 0;
        for(int o : order){
            while(true){
                if(o < now){
                    if(sub.peek() == o){
                        now = sub.pop();
                        answer++;
                        break;
                    }
                    else{
                        return answer;
                    }
                }
                else if(!main.isEmpty()){
                    if(main.peek() == o){
                        now = main.poll();
                        answer++;
                        break;
                    }
                    else{
                        sub.push(main.poll());
                    }
                }
            }
        }
        
        return answer;
    }
}