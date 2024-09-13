import java.util.LinkedList;
import java.util.Queue;
 
class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 1;
    int weight_sum = 0;
    Queue<Integer> truck = new LinkedList<>();
    Queue<Integer> time = new LinkedList<>();
 
    for(int i = 0 ;  ; ++answer) {
        
      if(!time.isEmpty() &&
        answer - time.peek() >= bridge_length) {
        weight_sum -= truck.remove();
        time.remove();
      }
        
      if(i < truck_weights.length &&
        weight_sum + truck_weights[i] <= weight) {
        weight_sum += truck_weights[i];
        truck.add(truck_weights[i]);
        time.add(answer);
        i++;
      }
 
      if(truck.isEmpty()) break;
    }
    return answer;
  }
}