import java.util.HashMap;

public class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> yearningMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }

        int[] result = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String person : photo[i]) {
                if (yearningMap.containsKey(person)) {
                    score += yearningMap.get(person);
                }
            }
            result[i] = score;
        }

        return result;
    }
}
