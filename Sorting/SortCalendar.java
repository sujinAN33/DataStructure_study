import java.util.Scanner;
import java.util.Arrays;
import java.util.GregorianCalendar; //Comparable인터페이스의 compareTo() 메서드가 구현되어 있어 정렬 가능
import static java.util.GregorianCalendar.*;

class SortCalendar{
    public static void main(String[] args){
        GregorianCalendar[] x={
            new GregorianCalendar(2020, JANUARY, 1),
            new GregorianCalendar(2019, DECEMBER, 31),
            new GregorianCalendar(2020, FEBRUARY, 29),
            new GregorianCalendar(2020, MARCH, 1),
            new GregorianCalendar(2020, JANUARY, 2)
        };

        Arrays.sort(x); // GregorianCalendar 배열 x를 오름차순으로 정렬

        for(int i=0;i<x.length;i++)
            System.out.println("x["+i+"]: "+x[i].get(GregorianCalendar.YEAR)+"년 "
                +(x[i].get(GregorianCalendar.MONTH)+1)+"월 "
                +x[i].get(GregorianCalendar.DATE)+"일");
        
    }
}