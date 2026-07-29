import java.util.Scanner;
class Merge{
    static void merge(int[] a,int na,int[] b,int nb,int[] c){
        //na,nb는 배열 a,b의 요솟수, c는 병합된 배열
        int pa=0; //a의 커서
        int pb=0; //b의 커서
        int pc=0; //c의 커서

        while(pa<na && pb<nb) //a와 b의 모든 요소를 병합이 완료될 때까지 반복
            c[pc++] = (a[pa]<=b[pb]) ? a[pa++] : b[pb++];
            //a[pa]와 b[pb] 중 작은 값을 c[pc]에 저장하고 커서를 증가시킴

        while(pa<na) //a에 남아 있는 요소를 c에 복사
        //첫 번째 while문 이후 b에 모든 요소가 c로 옮겨졌으나, 
        //a에 남아 있는 요소가 있는 경우
            c[pc++] = a[pa++];

        while(pb<nb) //b에 남아 있는 요소를 c에 복사
        //첫 번째 while문 이후 a에 모든 요소가 c로 옮겨졌으나,
        //b에 남아 있는 요소가 있는 경우
            c[pc++] = b[pb++];
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("배열을 병합합니다.");
        System.out.print("a의 요솟수: ");
        int na = stdIn.nextInt();
        int[] a = new int[na]; //요솟수가 na인 배열

        for(int i=0;i<na;i++){
            System.out.print("a["+i+"]: ");
            a[i] = stdIn.nextInt();
        }

        System.out.print("b의 요솟수: ");
        int nb = stdIn.nextInt();
        int[] b = new int[nb]; //요솟수가 nb인 배열

        for(int i=0;i<nb;i++){
            System.out.print("b["+i+"]: ");
            b[i] = stdIn.nextInt();
        }

        int[] c = new int[na+nb]; //병합된 배열
        merge(a,na,b,nb,c); //배열 a와 b를 병합하여 c에 저장

        System.out.println("배열 a와 b를 병합했습니다.");
        for(int i=0;i<na+nb;i++)
            System.out.println("c["+i+"]="+c[i]);
    }
}