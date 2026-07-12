import java.util.Scanner;
//보초법을 이용한 선형 검색
//매 요소를 검사할 때마다 현재 요소가 마지막 요소인지 검사하는 판단을 생략할 수 있음
class Sentinel_method{
    static int seqSearchSen(int[] a, int n, int key){
        a[n] = key; //배열의 마지막 요소에 검색할 값을 넣음
        
        while(true){
            if(a[n] == key){ //마지막 요소와 검색할 값이 같으면
                break; //반복 종료
            }
            n++; //n을 증가시켜 다음 요소를 검사
        }
        return n == a.length - 1 ? -1 : n; //검색 실패 시 -1을 반환, 검색 성공 시 해당 인덱스를 반환
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1]; //마지막 요소를 검색할 값으로 사용하기 위해 배열 크기를 1 증가시킴

        for(int i = 0; i < num; i++){
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();

        int idx = seqSearchSen(x, num, ky);

        if(idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        }else{
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
        }
    }
}