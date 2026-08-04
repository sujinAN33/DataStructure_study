import java.util.Scanner;
class MergeSort{
    //병합 정렬
    //앞부분 병합정렬로 정렬
    //뒤부분 병합정렬로 정렬
    //병합
    static int[] buff; //작업용 배열

    //a[left]~a[right]를 병합정렬
    static void __mergeSort(int[] a,int left,int right){
        if(left<right){
            int i;
            int center=(left+right)/2; //중앙 요소
            int p=0;
            int j=0;
            int k=left;

            __mergeSort(a,left,center); //앞부분 병합정렬
            __mergeSort(a,center+1,right); //뒷부분 병합정렬
            
            for(i=left;i<=center;i++) buff[p++]=a[i]; 
            //앞부분을 작업용 배열 buff에 복사

            while(i<=right && j<p) //앞부분, 뒷부분을 병합
                a[k++]=(buff[j]<=a[i])?buff[j++]:a[i++];
            
            while(j<p) //앞부분에 남아 있는 요소를 복사
                a[k++]=buff[j++];
        }
    }

    //병합정렬
    static void mergeSort(int[] a,int n){
        buff=new int[n]; //작업용 배열을 생성
        __mergeSort(a,0,n-1); //배열 전체를 병합정렬
        buff=null; //작업용 배열을 해제
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("요솟수: ");
        int nx=sc.nextInt();
        int[] x=new int[nx];

        for(int i=0;i<nx;i++){
            System.out.print("x["+i+"]: ");
            x[i]=sc.nextInt();
        }

        mergeSort(x,nx); //배열 x를 병합정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++)
            System.out.println("x["+i+"]: "+x[i]);
    }


}