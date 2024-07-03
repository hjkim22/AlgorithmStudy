import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstNum = Integer.parseInt(sc.nextLine());
        int result = firstNum;
        String operator = sc.nextLine();

        while (!operator.equals("=")) {
            int nextNum = Integer.parseInt(sc.nextLine());
            switch (operator) {
                case "+":
                    result += nextNum;
                    break;
                case "-":
                    result -= nextNum;
                    break;
                case "*":
                    result *= nextNum;
                    break;
                case "/":
                    result /= nextNum;
                    break;
                default:
                    System.out.println("유효하지 않은 입력값.");
                    break;
            }
            operator = sc.nextLine();
        }
        System.out.println(result);
    }
}