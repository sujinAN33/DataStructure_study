import java.util.Scanner;
class Hanoi{
    static void move(int no,int x, int y){
        if(no>1){
            move(no-1,x,6-x-y); //6-x-y는 x,y기둥이 아닌 나머지 기둥
        }
        System.out.println("원반["+no+"]을 "+x+"기둥에서 "+y+"기둥으로 이동");
        if(no>1){
            move(no-1,6-x-y,y);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("원반의 개수를 입력하세요: ");
        int n = scanner.nextInt();
        move(n,1,3); //1기둥에 쌓인 원반 n개를 3기둥으로 이동
    }
}