import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

class PhysicalDataSort{
    static class PhysicalData{
        private String name; // 이름
        private int height; // 키
        private double vision; // 시력

        // 생성자
        public PhysicalData(String name,int height,double vision){
            this.name=name;
            this.height=height;
            this.vision=vision;
        }

        // 문자열 표현을 반환
        public String toString(){
            return name+" "+height+" "+vision;
        }

        //오름차순으로 정렬하는 comparator
        public static final Comparator<PhysicalData> HEIGHT_ORDER=new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhysicalData>{
            public int compare(PhysicalData d1,PhysicalData d2){
                return (d1.height>d2.height)?1:(d1.height<d2.height)?-1:0;
                //크면 1, 작으면 -1, 같으면 0을 반환
            }
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        PhysicalData[] x={
            new PhysicalData("홍길동",162,0.3),
            new PhysicalData("이순신",173,0.7),
            new PhysicalData("강감찬",175,2.0),
            new PhysicalData("유관순",171,1.5),
            new PhysicalData("윤봉길",168,0.4)
        };

        Arrays.sort(x,PhysicalData.HEIGHT_ORDER); //키의 오름차순으로 정렬

        
        System.out.println("--신체검사 결과--");
        for(int i=0;i<x.length;i++)
            System.out.println("x["+i+"]: "+x[i].name+" "+x[i].height+" "+x[i].vision);
    }
}