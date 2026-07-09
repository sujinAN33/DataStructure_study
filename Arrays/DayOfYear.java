package Arrays;
import java.util.Scanner;

class DayOfYear{
    static int[][] mdays = {
        {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
        {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}  //윤년
    };

    static int isLeap(int year) { //윤년이면 1, 아니면 0을 반환
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0; //4로 나누어 떨어지고 100으로 나누어 떨어지지 않거나 400으로 나누어 떨어지는 해는 윤년
    }

    static int dayOfYear(int y, int m, int d) { //y년 m월 d일의 그 해 경과 일 수를 구함
        for(int i=0; i<m-1; i++) { //1월부터 m-1월까지의 일 수를 더함
            d += mdays[isLeap(y)][i]; //해당 월까지의 일 수를 더함 
            //예를 들어 2020년 3월 10일이면 2020년은 윤년이므로 mdays[1(윤년)][0(1월)] + mdays[1(윤년)][1(2월)] = 31 + 29 = 60일을 더함
            //d=10 + 60 = 70일이 됨. 따라서 2020년 3월 10일은 70일째임.
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("그 해 경과 일 수를 구합니다.");
        System.out.print("년: "); int year = stdIn.nextInt();
        System.out.print("월: "); int month = stdIn.nextInt();
        System.out.print("일: "); int day = stdIn.nextInt();

        System.out.printf("%d년 %d월 %d일은 %d일째입니다.\n", year, month, day, dayOfYear(year, month, day));
    }
}gi