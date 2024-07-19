import java.util.HashSet;

public class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);
        char lastChar = words[0].charAt(words[0].length() - 1);

        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            int person = (i % n) + 1;
            int turn = (i / n) + 1;

            if (usedWords.contains(currentWord) || currentWord.charAt(0) != lastChar) {
                return new int[] {person, turn};
            }

            usedWords.add(currentWord);
            lastChar = currentWord.charAt(currentWord.length() - 1);
        }

        return new int[] {0, 0};
    }
}