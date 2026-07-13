import java.util.Scanner;

class Factorial {
    static int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1); //직접재귀
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int num = scanner.nextInt();
        int result = factorial(num);
        System.out.println(num + "의 팩토리얼은 " + result + "입니다.");
    }
}