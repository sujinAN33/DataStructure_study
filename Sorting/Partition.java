import java.util.Scanner;

class Partition{
    static void swap(int[] a,int idx1,int idx2){
        int t=a[idx1]; //a[idx1]의 값을 t에 저장
        a[idx1]=a[idx2]; //a[idx2]의 값을 a[idx1]에 저장
        a[idx2]=t; //t의 값을 a[idx2]에 저장
    }

    static void partition(int[] a,int n){
        int pl=0; //왼쪽 커서
        int pr=n-1; //오른쪽 커서
        int x=a[n/2]; //피벗(가운데 요소)

        do{
            while(a[pl]<x) pl++; //피벗보다 큰 값을 만날 때까지 왼쪽 커서를 이동
            while(a[pr]>x) pr--; //피벗보다 작은 값을 만날 때까지 오른쪽 커서를 이동
            if(pl<=pr) swap(a,pl++,pr--); //커서가 가리키는 요소를 교환하고 커서를 이동
        }while(pl<=pr); //커서가 엇갈릴 때까지 반복

        System.out.println("피벗의 값은 "+x+"입니다.");

        System.out.println("피벗 이하의 그룹");
        for(int i=0;i<=pl-1;i++) //왼쪽 그룹 출력
            System.out.print(a[i]+" ");
        System.out.println();

        if(pl>pr+1){ //왼쪽 그룹과 오른쪽 그룹이 엇갈린 경우
            System.out.println("피벗과 일치하는 그룹");
            for(int i=pr+1;i<=pl-1;i++) //피벗과 일치하는 그룹 출력
                System.out.print(a[i]+" ");
            System.out.println();
        }

        System.out.println("피벗 이상의 그룹");
        for(int i=pr+1;i<n;i++) //오른쪽 그룹 출력
            System.out.print(a[i]+" ");
        System.out.println();
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("배열을 나눕니다.");
        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; //요솟수가 num인 배열

        for(int i=0;i<num;i++){
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        partition(x,num); //배열 x를 나눔
    }
}