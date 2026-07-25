//증분값 h를 4,2,1로 한 버전 1에서는 h 값이 서로 소수 관계에 있지 않아 효율이 떨어짐
//h=121,40,13,4,1 로 하면 3의 배수에 1을 더한 수열이므로 서로 소수 관계에 있어 정렬이 제대로 됨
//h 초깃값이 너무 크면 효과가 없기 때문에 배열크기 n을 9로 나눈 값보다 작은 값으로 설정하는 것이 좋음
import java.util.Scanner;
class ShellSort2{
    static void shellSort(int[] a,int n){
        int h;
        //h의 초깃값 구하기
        for(h=1;h<n/9;h=h*3+1); //h를 1,4,13,40,121,... 에서 n/9보다 작은 것 중 가장 큰 값으로 설정
        for(;h>0;h/=3){ //h를 1/3씩 줄여가며 반복
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
