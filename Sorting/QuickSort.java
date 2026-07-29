import java.util.Scanner;
class QuickSort{
    static void swap(int[] a,int idx1,int idx2){
        int t=a[idx1]; //a[idx1]의 값을 t에 저장
        a[idx1]=a[idx2]; //a[idx2]의 값을 a[idx1]에 저장
        a[idx2]=t; //t의 값을 a[idx2]에 저장
    }

    static void quickSort(int[] a,int left,int right){
        int pl=left;
        int pr=right;
        int x=a[(pl+pr)/2]; //피벗(가운데 요소)

        //partition과 동일한 코드
        do{
            while(a[pl]<x)pl++;
            while(a[pr]>x)pr--;

            if(pl<=pr)
                swap(a,pl++,pr--);
        }while(pl<=pr); //커서가 엇갈릴 때까지 반복

        //첫 번째로 분할한 그룹의 왼쪽 부분과 오른쪽 부분은 완전히 정렬되어 있지 않으므로
        if(left<pr) quickSort(a,left,pr); //왼쪽 부분을 재귀호출로 정렬
        if(pl<right) quickSort(a,pl,right); //오른쪽 부분을 재귀호출로 정렬
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("퀵정렬");
        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; //요솟수가 num인 배열

        for(int i=0;i<num;i++){
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        quickSort(x,0,num-1); //배열 x를 퀵정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<num;i++)
            System.out.println("x["+i+"]="+x[i]);
    }
}