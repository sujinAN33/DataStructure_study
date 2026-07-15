import java.util.Scanner;
class BubbleSort1{
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1]; //a[idx1]의 값을 t에 저장
        a[idx1] = a[idx2]; //a[idx2]의 값을 a[idx1]에 저장
        a[idx2] = t; //t의 값을 a[idx2]에 저장
    }

    static void bubbleSort(int[] a,int n){
        for(int i=0;i<n-1;i++){ //n-1회 반복
            for(int j=n-1;j>i;j--){//뒤쪽 요소부터 앞쪽 요소까지 반복
                if(a[j-1]>a[j]){ //앞의 요소가 뒤의 요소보다 크면
                    swap(a,j-1,j); //두 요소를 교환
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("버블정렬(버전1)");
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