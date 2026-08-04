import java.util.Arrays; // Arrays 클래스의 sort() 메서드를 사용하기
import java.util.Scanner;
class ArraysSortTester{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("요솟수: ");
        int nx=sc.nextInt();
        int[] x=new int[nx];

        for(int i=0;i<nx;i++){
            System.out.print("x["+i+"]: ");
            x[i]=sc.nextInt();
        }
        Arrays.sort(x); // 배열 x를 오름차순으로 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0;i<nx;i++)
            System.out.println("x["+i+"]: "+x[i]);
    }
}