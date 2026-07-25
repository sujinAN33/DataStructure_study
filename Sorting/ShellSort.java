import java.util.Scanner;
class ShellSort{
    static void shellSort(int[] a,int n){
        for(int h=n/2;h>0;h/=2){ //h를 1/2씩 줄여가며 반복 4,2,1
            for(int i=h;i<n;i++){ //i번째 요소를 h만큼 떨어진 앞쪽 요소들과 비교
                int j;
                int tmp = a[i]; //정렬할 요소를 tmp에 저장
                for(j=i-h;j>=0 && a[j]>tmp;j-=h){ //정렬할 요소보다 큰 요소를 h만큼 뒤로 이동
                    a[j+h] = a[j];
                }
                a[j+h] = tmp; //정렬할 요소를 삽입
            }
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("셸정렬");
        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; //요솟수가 num인 배열

        for(int i=0;i<num;i++){
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        shellSort(x,num); //배열 x를 셸정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<num;i++){
            System.out.println("x["+i+"]="+x[i]);
        }
    }
}