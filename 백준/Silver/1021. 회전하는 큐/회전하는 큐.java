import java.util.LinkedList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] positions = new int[M];
        for (int i = 0; i < M; i++) {
            positions[i] = sc.nextInt();
        }

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int totalMoves = 0;

        for (int pos : positions) {
            int currentIndex = deque.indexOf(pos);
            int leftMoves = currentIndex;
            int rightMoves = deque.size() - currentIndex;

            if (leftMoves <= rightMoves) {
                totalMoves += leftMoves;
                for (int i = 0; i < leftMoves; i++) {
                    deque.addLast(deque.removeFirst());
                }
            } else {
                totalMoves += rightMoves;
                for (int i = 0; i < rightMoves; i++) {
                    deque.addFirst(deque.removeLast());
                }
            }
            deque.removeFirst();
        }
        System.out.println(totalMoves);
    }
}
