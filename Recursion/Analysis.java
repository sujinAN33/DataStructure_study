import java.util.Scanner;

class Analysis {
    static void recur(int n) {
        if (n > 0) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int num = scanner.nextInt();
        recur(num); 
    }
}
//하향식 분석(Top-down analysis) - 재귀 호출을 통해 문제를 작은 문제로 나누어 해결하는 방식
//n=4 일 경우 recure(4) 호출 시, recur(3) 호출 후 4 출력, recur(2) 호출 
//recur(3) 호출 시, recur(2) 호출 후 3 출력, recur(1) 호출
//recur(2) 호출 시, recur(1) 호출 후 2 출력, recur(0) 호출
//recur(1) 호출 시, recur(0) 호출 후 1 출력, recur(-1) 호출
//recur(0) 호출 시, 아무것도 출력하지 않고 종료

//상향식 분석(Bottom-up analysis) - 작은 문제부터 해결하여 큰 문제를 해결하는 방식
//n=1 호출 시, recur(0) 호출 후 1 출력, recur(-1) 호출 -> 1출력
//n=2 호출 시, recur(1) 호출 후 2 출력, recur(0) 호출 -> 1 2출력
//n=3 호출 시, recur(2) 호출 후 3 출력, recur(1) 호출 -> 1 2 3 1출력
//n=4 호출 시, recur(3) 호출 후 4 출력, recur(2) 호출 -> 1 2 3 1 4 1 2출력