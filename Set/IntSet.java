public class IntSet {
    private int max; //집합의 최대 개수
    private int num; //집합의 요소 개수
    private int[] set; //집합 본체

    //생성자
    public IntSet(int capacity) {
        num = 0;
        max = capacity;
        try {
            set = new int[max]; //집합 배열 생성
        } catch (OutOfMemoryError e) { //배열 생성 실패
            max = 0;
        }
    }

    //집합의 최대 개수
    public int capacity() {
        return max; 
    }

    //집합의 요소 개수
    public int size() {
        return num;
    }

    //집합에서 n을 검색(인덱스 반환)
    public int indexOf(int n) {
        for (int i = 0; i < num; i++)
            if (set[i] == n) return i; //검색 성공
        return -1; //검색 실패
    }

    //집합에 n이 있는지 없는지 확인
    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    //집합에 n을 추가
    public boolean add(int n) {
        if (num >= max || contains(n) == true) //가득 찼거나 이미 존재하면
            return false;
        else {
            set[num++] = n; //가장 마지막 자리에 추가
            return true;
        }
    }

    //집합에서 n을 삭제
    public boolean remove(int n) {
        int idx; //n이 저장된 요소의 인덱스
        if (num <= 0 || (idx = indexOf(n)) == -1) //비어 있거나 n이 존재하지 않으면
            return false;
        else {
            set[idx] = set[--num]; //마지막 요소를 삭제한 곳으로 이동
            return true;
        }
    }

    //집합 s에 복사
    public void copyTo(IntSet s) {
        int n = (s.max < num) ? s.max : num; //복사할 요소 개수
        for (int i = 0; i < n; i++)
            s.set[i] = set[i];
        s.num = n;
    }

    //집합 s를 복사
    public void copyFrom(IntSet s) {
        int n = (max < s.num) ? max : s.num; //복사할 요소 개수
        for (int i = 0; i < n; i++)
            set[i] = s.set[i];
        num = n;
    }

    //집합 s와 같은지 확인
    public boolean equalTo(IntSet s) {
        if (num != s.num) //요소 개수가 같지 않으면
            return false; //집합이 같지 않음
        for (int i = 0; i < num; i++) {
            int j = 0;
            for (; j < s.num; j++)
                if (set[i] == s.set[j]) //set[i]와 같은 요소가 s에 존재하면
                    break;
            if (j == s.num) //set[i]와 같은 요소가 s에 존재하지 않으면
                return false; //집합이 같지 않음
        }
        return true; //집합이 같음
    }//순서가 중요하지 않은 집합의 비교이므로 원래 집합의 한 요소를 뽑아 
    //다른 집합에 존재하는 모든 요소와 비교하여 같은 요소가 존재하지 않아야 집합이 같지 않다고 판단한다.

    //집합 s1과 s2의 합집합을 복사
    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1); //집합 s1을 복사
        for (int i = 0; i < s2.num; i++) //집합 s2의 모든 요소를 추가
            add(s2.set[i]);
    }//합집합이므로 s1의 모든 요소를 복사하고 s2의 모든 요소를 추가한다.

    //문자열로 변환
    public String toString() {
        StringBuffer temp = new StringBuffer("{");
        for (int i = 0; i < num; i++) {
            temp.append(set[i]+" "); //temp에 set[i]를 추가
        }
        temp.append("}");
        return temp.toString(); //temp를 문자열로 변환하여 반환
    }

    public static void main(String[] args) {
        IntSet s1 = new IntSet(10);
        IntSet s2 = new IntSet(10);
        IntSet s3 = new IntSet(10);

        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);
        //s1={10,15,20,25}

        s1.copyTo(s2);
        s2.add(12);
        s2.remove(25);
        //s2={10,15,20,12}

        s3.copyFrom(s2);
        //s3={10,15,20,12}

        System.out.println("s1="+s1);
        System.out.println("s2="+s2);
        System.out.println("s3="+s3);

        System.out.println("집합 s1에 15는 "+(s1.contains(15)?"포함되어 있습니다.":"포함되어 있지 않습니다."));

        System.out.println("집합 s2에 25는 "+(s2.contains(25)?"포함되어 있습니다.":"포함되어 있지 않습니다."));

        System.out.println("집합 s1과 s2는 "+(s1.equalTo(s2)?"같습니다.":"같지 않습니다."));

        System.out.println("집합 s2와 s3는 "+(s2.equalTo(s3)?"같습니다.":"같지 않습니다."));

        s3.unionOf(s1, s2);//s3<- s1 U s2
        System.out.println("집합 s1과 s2의 합집합은 "+s3+"입니다.");
    }
}