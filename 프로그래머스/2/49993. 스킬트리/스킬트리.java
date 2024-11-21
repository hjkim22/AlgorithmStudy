import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s : skill_trees) {
            Map <Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++)
                map.put(s.charAt(i), i + 1);

            Stack <Integer> stack = new Stack<>();
            for(int i = 0; i < skill.length(); i++) {
                if(map.containsKey(skill.charAt(i)))
                    stack.push(map.get(skill.charAt(i)));
                else
                    stack.push(0);
            }
            while(!stack.isEmpty() && stack.peek() == 0)
                stack.pop();
            int n = 0;
            if(!stack.isEmpty())
                n = stack.pop();

            while(!stack.isEmpty()) {
                if(n <= stack.peek() || stack.peek() == 0)
                    break;
                else
                    n = stack.pop();
            }
            if(stack.isEmpty())
                answer++;
        }
        return answer;
    }
}