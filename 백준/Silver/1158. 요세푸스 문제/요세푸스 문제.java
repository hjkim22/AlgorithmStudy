import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        if (N <= 0 || K <= 0) {
            System.out.println("N과 K는 양의 정수여야 합니다.");
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(1, N + 1).forEach(queue::add);

        ArrayList<Integer> result = new ArrayList<>();
        int counter = 0;
        while (!queue.isEmpty()) {
            int data = queue.remove();
            counter++;

            if (counter % K == 0) {
                result.add(data);
            } else {
                queue.add(data);
            }
        }

        StringJoiner joiner = new StringJoiner(", ", "<", ">");
        for (int number : result) {
            joiner.add(Integer.toString(number));
        }
        System.out.println(joiner.toString());
    }
}
