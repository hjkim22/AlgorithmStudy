import java.util.Stack;

public class Solution {
    public int solution(String s) {
        int validCount = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (isValid(s)) {
                validCount++;
            }
            s = rotateString(s);
        }

        return validCount;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private String rotateString(String s) {
        return s.substring(1) + s.charAt(0);
    }
}