import java.util.Scanner;
class QuickSortPrint{
    static void swap(int[] a,int idx1,int idx2){
        int t=a[idx1]; //a[idx1]의 값을 t에 저장
        a[idx1]=a[idx2]; //a[idx2]의 값을 a[idx1]에 저장
        a[idx2]=t; //t의 값을 a[idx2]에 저장
    }
    static void quickSortPrint(int[] a,int left,int right){
        int pl=left;
        int pr=right;
        int x=a[(pl+pr)/2]; //피벗(가운데 요소)

        //분할 수행 과정 출력
        //QuickSortPrint(a,left,right) 호출 시 마다 그룹a[left]~a[right]의 요소를 출력
        System.out.printf("a[%d]~a[%d]:{",left,right);
        for(int i=left;i<right;i++)
            System.out.printf("%d,",a[i]);
        System.out.printf("%d}\n",a[right]);

        do{
            while(a[pl]<x) pl++;
            while(a[pr]>x) pr--;
            if(pl<=pr)
                swap(a,pl++,pr--);
        }while(pl<=pr);

        if(left<pr) quickSortPrint(a,left,pr);
        if(pl<right) quickSortPrint(a,pl,right);
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

        quickSortPrint(x,0,num-1); //배열 x를 퀵정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<num;i++)
            System.out.println("x["+i+"]="+x[i]);
    }
}