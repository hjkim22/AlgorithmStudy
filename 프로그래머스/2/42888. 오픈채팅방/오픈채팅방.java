import java.util.*;
class Solution {
    public List<String> solution(String[] record) {
        List <String> list = new ArrayList<>();
        Map <String, String> map = new HashMap<>();
        for(String r : record) {
            String[] s = r.split(" ");
            list.add(s[1] + " "+ s[0]);
            if(s.length == 3)
                map.put(s[1], s[2]);
        }
        
        List<String> answer = new ArrayList<>();
        for(String l : list) {
            String[] s = l.split(" ");
            String status = " 나갔습니다.";
            if(s[1].equals("Enter"))
                status = " 들어왔습니다.";
            else if(s[1].equals("Change")) continue;
            
            answer.add(map.get(s[0]) + "님이" + status);
        }
        return answer;
    }
}