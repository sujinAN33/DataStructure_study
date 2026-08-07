//KMP 문자열 검색 - 찾으려는 문자열 안에서 중복되는 부분을 찾아 효율적으로 검색하는 알고리즘
public class KMPmatch {
    static int kmpMatch(String txt, String pat) {
        int pt = 1; // txt 커서
        int pp = 0; // pat 커서
        int[] skip = new int[pat.length() + 1]; // 건너뛰기 표 skip[6] 까지 있음

        // 건너뛰기 표 만들기
        // pat의 각 문자에 대해, 그 문자까지의 접두사와 접미사가 일치하는 최대 길이를 skip 배열에 저장
        // 예를 들어, pat = "ABABAC"이면 skip 배열은 [0, 0, 1, 2, 3, 0]이 됨
        //ABABAC 
        // ABABAC
        //00 (B와 A가 다르므로 0)

        //한 칸 이동
        //ABABAC
        //  ABABAC
        //00123 (ABA가 같으므로 123)

        //마지막글자로 이동
        //ABABAC (이게 pt)
        //     ABABAC (이게 pp)
        //001230 (C와 A가 다르므로 0)

        
        skip[pt] = 0; // pt=1, pp=0이므로 skip[1] = 0으로 초기화
        while (pt != pat.length()) { 
            if (pat.charAt(pt) == pat.charAt(pp)) { //pt=1,pp=0으로 시작하므로 B != A 따라서 else if문으로 넘어감
            //다시 pt=2, pp=0으로 시작하므로 A == A 따라서 skip[3] = 1, pt=3, pp=1로 이동
            //다시 pt=3, pp=1으로 시작하므로 B == B 따라서 skip[4] = 2, pt=4, pp=2로 이동
            //다시 pt=4, pp=2으로 시작하므로 A == A 따라서 skip[5] = 3, pt=5, pp=3로 이동
            //다시 pt=5, pp=3으로 시작하므로 C != B 따라서 else문으로 넘어감
                skip[++pt] = ++pp;
            } else if (pp == 0) { //pp=0이므로 skip[2] = 0, pt=2, pp=0으로 이동
                skip[++pt] = pp;
            } else {
                pp = skip[pp];  //pt=5,pp=3이므로 pp=skip[3]=1 이 되어 pp=1로 이동, 다시 while문으로 돌아가
                                // pt=5, pp=1으로 시작하므로 C != B 따라서 else문으로 넘어감
                                //다시 pp=skip[1]=0이 되어 pp=0로 이동, 다시 while문으로 돌아가
                                //else if문으로 넘어가 skip[6] = 0, pt=6, pp=0으로 변경, while문으로 돌아가 pt=6이므로 while문 종료
            }
        }
        //결론적으로 skip 배열은 [0, 0, 0, 1, 2, 3, 0]이 됨

        // 문자열 검색
        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0) {
                pt++;
            } else {
                pp = skip[pp];
            }
        }
        return (pp == pat.length()) ? pt - pp : -1; // 검색 성공 시 검색한 위치, 실패 시 -1 반환
    }
}