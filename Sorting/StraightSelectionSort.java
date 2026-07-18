import java.util.Scanner;
class StraightSelectionSort{
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1]; //a[idx1]의 값을 t에 저장
        a[idx1] = a[idx2]; //a[idx2]의 값을 a[idx1]에 저장
        a[idx2] = t; //t의 값을 a[idx2]에 저장
    }

    static void selectionSort(int[] a,int n){
        for(int i=0;i<n-1;i++){ //n-1회 반복
            int min = i; //정렬할 부분에서 가장 작은 요소의 인덱스를 저장
            for(int j=i+1;j<n;j++){//정렬할 부분에서 가장 작은 요소를 찾는다.
                if(a[j]<a[min]){ //앞의 요소가 뒤의 요소보다 크면
                    min = j; //가장 작은 요소의 인덱스를 갱신
                }
            }
            swap(a,i,min); //찾은 가장 작은 요소와 정렬할 부분의 첫 번째 요소를 교환
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("단순선택정렬");
        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; //요솟수가 num인 배열

        for(int i=0;i<num;i++){
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x,num); //배열 x를 단순선택정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<num;i++){
            System.out.println("x["+i+"]="+x[i]);
        }
    }
}