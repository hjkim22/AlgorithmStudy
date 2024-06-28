import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap<String, Integer> nameToScore = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameToScore.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            int totalScore = 0;
            for (String person : photo[i]) {
                if (nameToScore.containsKey(person)) {
                    totalScore += nameToScore.get(person);
                }
            }
            answer[i] = totalScore;
        }
        
        return answer;
    }
}
