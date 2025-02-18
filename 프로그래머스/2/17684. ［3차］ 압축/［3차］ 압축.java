import java.util.*;
class Solution {
    public List<Integer> solution(String msg) {
        List <Integer> list = new ArrayList<>();
        Map <String, Integer> map = new HashMap<>();
        int index = 1;
        for(char c = 'A'; c <= 'Z'; c++)
            map.put(String.valueOf(c), index++);
        
        int len = 0;
        for(int i = 0; i < msg.length(); i = len - 1) {
        	boolean check = false;
            for(int j = i + 1; j <= msg.length(); j++) {
            	len = j;
                if(!map.containsKey(msg.substring(i, j))) {
                	check = true;
                	break;
                }
            }
            if(!check)
            	list.add(map.get(msg.substring(i, len)));
            else
            	list.add(map.get(msg.substring(i, len - 1)));
            map.put(msg.substring(i, len), index++);
            
            if(len == msg.length() && !check)
            	break;
        }
        return list;
    }
}