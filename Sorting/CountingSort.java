import java.util.Scanner;
//도수정렬 counting sort
//재귀호출,이중 for문 없이 사용 가능 , 도수분포표를 이용하기 때문에 데이터의 범위(최소~최대)를 알고있어야 함.
class CountingSort{
    static void countingSort(int [] a,int n,int k){
        int [] c=new int[k+1]; //카운트 배열
        int [] b=new int[n]; //작업용 배열

        for(int i=0;i<=k;i++) c[i]=0; //카운트 배열 초기화
        for(int i=0;i<n;i++) c[a[i]]++; //각 데이터에 대한 카운트
        for(int i=1;i<=k;i++) c[i]+=c[i-1]; //누적 카운트 계산
        for(int i=n-1;i>=0;i--) b[--c[a[i]]]=a[i]; //정렬된 결과를 작업용 배열에 저장 - 0~a[i]까지의 점수를 갖고 있는 학생 수가 f[a[i]]이므로
        //a[i]의 점수를 갖고 있는 학생은 f[a[i]]-1번째에 위치해야 한다.(5번째 값이므로 5번째 위치인 b[4]에 저장) 따라서 b[--c[a[i]]]에 a[i]를 저장한다.
        for(int i=0;i<n;i++) a[i]=b[i]; //작업용 배열의 내용을 원래 배열로 복사
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("요솟수: ");
        int nx=sc.nextInt();
        int [] x=new int[nx];

        for(int i=0;i<nx;i++){
            do{
                System.out.print("x["+i+"]: ");
                x[i]=sc.nextInt();
            } while(x[i]<0 || x[i]>20); //0보다 작거나 20보다 큰 점수는 입력하면 멈춤
        }//for문으로 돌아가 다시 x[i]를 입력받음

        countingSort(x,nx,20); //배열 x를 카운팅 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++)
            System.out.println("x["+i+"]: "+x[i]);
    }
}