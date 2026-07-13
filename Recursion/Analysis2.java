import java.util.Scanner;

class Analysis2 {
    static void recur(int n) {

        IntStack stack = new IntStack(n); //스택 생성

        while (true) {
            if (n > 0) {
                stack.push(n); //n을 푸시
                n = n - 1; //n을 감소시켜 재귀 호출
                continue;
            }
            if (!stack.isEmpty()) { 
                n = stack.pop(); //스택에서 n을 팝
                System.out.println(n);
                n = n - 2; //n을 감소시켜 재귀 호출
                continue;
            }
            break;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int num = scanner.nextInt();
        recur(num); 
    }
}
//n=4 일 경우 recur(4) 호출 시, 스택에 4 3 2 1이 푸시되고 [4321]
//n=0이 되면 첫 번째 if문은 패스, 두 번째 if문이 실행되어
// 스택에서 1을 팝하고 1 출력 후 n= -1이 되어 사라짐[432]
// while문으로 돌아가 스택에서 2를 팝하고 2 출력 후 n=0이 되어 사라짐[43]
// 다시 while문으로 돌아가 스택에서 3을 팝하고 3 출력 후 n=1이 되어 1푸시됨[41]
//n=0이 되어 첫 번째 if문은 패스, 두 번째 if문이 실행되어 스택에서 1을 팝하고 1 출력 후 n=-1이 되어 사라짐[4]
// while문으로 돌아가 스택에서 4를 팝하고 4 출력 후 n=2가 되어 사라짐[]
// 다시 while문으로 돌아가 첫 번째 if문이 실행되어 2가 푸시됨[2]
//n=1이 되어 첫 번째 if문이 실행되어 1이 푸시됨[21]
//n=0이 되어 첫 번째 if문은 패스, 두 번째 if문이 실행되어 스택에서 1을 팝하고 1 출력 후 n=-1이 되어 사라짐[2]
// while문으로 돌아가 스택에 2가 남아있어 두 번째 if문이 실행되어 스택에서 2를 팝하고[]
// 2 출력 후 n=0이 두 if문을 다 패스하고 break만나 종료

//출력결과: 1 2 3 1 4 1 2