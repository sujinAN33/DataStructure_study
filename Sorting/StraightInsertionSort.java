import java.util.Scanner;
class StraightInsertionSort{
    static void insertionSort(int[] a,int n){
        for(int i=1;i<n;i++){
            int j;
            int tmp = a[i]; //정렬할 요소를 tmp에 저장
            for(j=i;j>0 && a[j-1]>tmp;j--){ //정렬할 요소보다 큰 요소를 한 칸씩 뒤로 이동
                a[j] = a[j-1];
            }
            a[j] = tmp; //정렬할 요소를 삽입
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("단순삽입정렬");
        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; //요솟수가 num인 배열

        for(int i=0;i<num;i++){
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x,num); //배열 x를 단순삽입정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<num;i++){
            System.out.println("x["+i+"]="+x[i]);
        }
    }
}