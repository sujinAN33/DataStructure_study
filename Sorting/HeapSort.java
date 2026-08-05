import java.util.Scanner;
class HeapSort{
    static void swap(int [] a,int idx1,int idx2){
        int t=a[idx1]; a[idx1]=a[idx2]; a[idx2]=t;
    }

    //a[left]~a[right]을 힙으로 만들기
    static void downHeap(int [] a,int left,int right){
        int temp=a[left]; //루트
        int child; //큰 값을 가진 노드
        int parent; //부모 노드
        for(parent=left;(parent*2+1)<=right;parent=child){
            int cl=parent*2+1; //왼쪽 자식
            int cr=cl+1; //오른쪽 자식
            child=(cr<=right && a[cr]>a[cl])?cr:cl; //큰 값을 가진 자식
            if(temp>=a[child]) break; //부모노드가 자식 노드보다 크면 종료
            a[parent]=a[child]; //한 단계 아래로 이동
        }
        a[parent]=temp; //temp를 재배치
    }
    
    //힙 정렬
    static void heapSort(int [] a,int n){
        for(int i=(n-1)/2;i>=0;i--) //a[i]를 힙으로 만들기
            downHeap(a,i,n-1);
        for(int i=n-1;i>0;i--){
            swap(a,0,i); //루트와 맨 끝 요소를 교환
            downHeap(a,0,i-1); //a[0]~a[i-1]을 힙으로 만들기
        } 
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("요솟수: ");
        int nx=sc.nextInt();
        int [] x=new int[nx];

        for(int i=0;i<nx;i++){
            System.out.print("x["+i+"]: ");
            x[i]=sc.nextInt();
        }

        heapSort(x,nx); //배열 x를 힙 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++)
            System.out.println("x["+i+"]: "+x[i]);
    }
}