//배열 5->1로 비교를 해나갈 때 3,2,1이 이미 정렬이 되어있다면 다음 번 정렬에서는 3,2,1을 비교할 필요가 없으므로 정렬 범위를 줄여서 효율성을 높인다.
import java.util.Scanner;
class BubbleSort3{
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1]; //a[idx1]의 값을 t에 저장
        a[idx1] = a[idx2]; //a[idx2]의 값을 a[idx1]에 저장
        a[idx2] = t; //t의 값을 a[idx2]에 저장
    }
    
    static void bubbleSort(int[] a,int n){
        int k=0; //a[k]보다 앞쪽은 정렬이 완료되었음을 나타내는 변수
        while(k<n-1){  //k까지 정렬이 완료되었는데, n-1이 마지막 요소이므로 k=n-1이면 정렬이 완료된 것이므로 반복문 종료, 
        //k<n-1이면 정렬이 완료되지 않은 것,정렬할 부분이 남아있으므로 반복문 계속
            int last = n-1; //마지막으로 교환한 위치를 저장
            for(int j=n-1;j>k;j--){//뒤쪽 요소부터 앞쪽 요소까지 반복
                if(a[j-1]>a[j]){ //앞의 요소가 뒤의 요소보다 크면
                    swap(a,j-1,j); //두 요소를 교환
                    last = j; //마지막으로 교환한 위치를 저장
                }
            }
            k=last; //다음 패스의 정렬 범위를 마지막으로 교환한 위치까지로 설정
            //즉 앞의 요소가 뒤의 요소보다 크지 않은, 정렬이 완료된 부분은 k까지이다.
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("버블정렬(버전3)");
        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; //요솟수가 num인 배열

        for(int i=0;i<num;i++){
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x,num); //배열 x를 버블정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<num;i++){
            System.out.println("x["+i+"]="+x[i]);
        }
    }
}