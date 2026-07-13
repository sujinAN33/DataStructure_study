import java.util.Scanner;
class EuclidGCD {
    //유클리드 호제법을 이용한 최대공약수 계산
    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y); //직접재귀 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("두 정수를 입력하세요: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result = gcd(a, b);
        System.out.println(a + "와 " + b + "의 최대공약수는 " + result + "입니다.");
    }
}