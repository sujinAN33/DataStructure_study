import java.util.Scanner;
import java.util.Stack;
class QuickSortNonRecursive{
    static void swap(int[] a,int idx1,int idx2){
        int t=a[idx1]; //a[idx1]의 값을 t에 저장
        a[idx1]=a[idx2]; //a[idx2]의 값을 a[idx1]에 저장
        a[idx2]=t; //t의 값을 a[idx2]에 저장
    }
    static void quickSortNonRecursive(int[] a,int left,int right){
        Stack<Integer> lstack = new Stack<Integer>(); //왼쪽 커서를 저장하는 스택
        Stack<Integer> rstack = new Stack<Integer>(); //오른쪽 커서를 저장하는 스택
        //즉 1 2 3 4 5 | 6 | 7 8 9 10 11 일 경우 1~5, 7~11은 왼쪽 그룹과 오른쪽 그룹이므로 
        //1과 7을 lstack에 , 5와 11을 rstack에 저장

        lstack.push(left); //왼쪽 커서를 스택에 푸시
        rstack.push(right); //오른쪽 커서를 스택에 푸시

        while(lstack.isEmpty()!=true){ //스택이 비어있지 않으면 반복
            int pl=left=lstack.pop(); //왼쪽 커서를 스택에서 팝
            int pr=right=rstack.pop(); //오른쪽 커서를 스택에서 팝
            int x=a[(pl+pr)/2]; //피벗(가운데 요소)

            do{
                while(a[pl]<x) pl++;
                while(a[pr]>x) pr--;
                if(pl<=pr)
                    swap(a,pl++,pr--);
            }while(pl<=pr);

            if(pr>left){ //왼쪽 그룹에 요소가 있으면
                lstack.push(left);  //왼쪽 그룹의 왼쪽 커서를 스택에 푸시
                rstack.push(pr); //왼쪽 그룹의 오른쪽 커서를 스택에 푸시
            }
            if(pl<right){ //오른쪽 그룹에 요소가 있으면
                lstack.push(pl); 
                rstack.push(right); 
           }
        }
    }
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("퀵정렬(비재귀버전)");
        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; //요솟수가 num인 배열
        for(int i=0;i<num;i++){
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }
        quickSortNonRecursive(x,0,num-1); //배열 x를 비재귀 퀵정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<num;i++)
            System.out.println("x["+i+"]="+x[i]);
    }
}