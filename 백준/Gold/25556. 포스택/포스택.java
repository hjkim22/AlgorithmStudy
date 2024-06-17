import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }
        
        System.out.println(canCleanSequence(n, sequence));
    }

    public static String canCleanSequence(int n, int[] sequence) {
        Stack<Integer>[] stacks = new Stack[4];
        for (int i = 0; i < 4; i++) {
            stacks[i] = new Stack<>();
        }

        for (int num : sequence) {
            boolean placed = false;
            for (Stack<Integer> stack : stacks) {
                if (stack.isEmpty() || stack.peek() < num) {
                    stack.push(num);
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                return "NO";
            }
        }

        List<Integer> topElements = new ArrayList<>();
        for (Stack<Integer> stack : stacks) {
            while (!stack.isEmpty()) {
                topElements.add(stack.pop());
            }
        }

        Collections.sort(topElements);

        for (int i = 1; i < topElements.size(); i++) {
            if (topElements.get(i - 1) > topElements.get(i)) {
                return "NO";
            }
        }

        return "YES";
    }
}
