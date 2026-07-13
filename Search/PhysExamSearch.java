import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

class PhysExamSearch {
    static class PhyscData {
        private String name; // 이름
        private int height; // 키
        private double vision; // 시력

        // 생성자
        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }
    

    // 키를 기준으로 오름차순 정렬하기 위한 Comparator
    static class HeightOrderComparator implements Comparator<PhyscData> {
        public int compare(PhyscData d1, PhyscData d2) {
            return (d1.height> d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
        }
    }
    // HeightOrderComparator를 이용하여 정렬하기 위한 Comparator 객체 생성
    public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        PhyscData[] x = {
                new PhyscData("홍길동", 162, 0.3),
                new PhyscData("이순신", 175, 0.7),
                new PhyscData("강감찬", 168, 0.8),
                new PhyscData("김유신", 180, 1.0),
                new PhyscData("장보고", 172, 0.5)
        };

        System.out.print("검색할 키를 입력하세요: ");
        int height = stdIn.nextInt();

        // 키를 기준으로 이진 검색 수행
        int idx = Arrays.binarySearch(x, new PhyscData("", height, 0), PhyscData.HEIGHT_ORDER);

        if (idx < 0) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("검색 결과: " + x[idx]); //toString() 메서드가 자동으로 호출되어 결과 출력
        }
    }
}