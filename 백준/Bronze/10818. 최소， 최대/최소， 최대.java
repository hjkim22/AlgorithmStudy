import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < N; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println(min + " " + max);

        scanner.close();
    }
}
