package Arrays;
import java.util.Scanner;

class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0; //나눗셈을 수행한 횟수
        int numOfPrimes = 0; //찾은 소수의 개수
        int [] primes = new int[500]; //100개의 소수를 저장하기 위한 배열
        int ptr = 0; //배열에 저장된 소수의 개수 (다음에 저장할 위치)
        primes[ptr++] = 2; //2는 소수이므로 배열에 저장 primes[0] = 2, ptr = 1

        for(int n=3; n <= 1000; n+=2) { //3부터 1000까지의 홀수만 검사
            boolean isPrime = true; //소수 여부를 나타내는 플래그
            for(int i=1; i<ptr; i++) { //이미 찾은 소수들로 나눗셈 수행
                count++; //나눗셈 횟수 증가
                if(n % primes[i] == 0) { //나누어 떨어지면 소수가 아님
                    isPrime = false;
                    break; //더 이상 검사할 필요 없음
                }
            }
            if(isPrime) { //소수이면 배열에 저장
                primes[ptr++] = n;
                numOfPrimes++; //찾은 소수 개수 증가
            }
        }
        
        for(int i=0; i<ptr; i++){
            System.out.print(primes[i]+ " "); //찾은 소수 출력
        }
        System.out.println();
        System.out.println("찾은 소수의 개수: " + numOfPrimes);
        System.out.println("나눗셈을 수행한 횟수: " + count);
    }
}