//Boyer-Moore법으로 문자열 검색
class BMmatch {
    static int bmMatch(String txt, String pat) {
        int pt; // txt 커서
        int pp; // pat 커서
        int txtLen = txt.length();
        int patLen = pat.length();
        int[] skip = new int[Character.MAX_VALUE + 1]; // 건너뛰기 표
        

        // 건너뛰기 표 만들기
        for (pt = 0; pt <= Character.MAX_VALUE; pt++)
            skip[pt] = patLen; //우선 전부 다 patLen(패턴 길이)로 초기화
        for (pt = 0; pt < patLen - 1; pt++)
            skip[pat.charAt(pt)] = patLen - pt - 1; //패턴에 포함된 문자에 대해서만 건너뛰기 값 설정

        // 검색
        while (pt < txtLen) { // txt의 길이만큼 반복
            pp = patLen - 1; // pat의 마지막 문자부터 검사
            while (txt.charAt(pt) == pat.charAt(pp)) { //일치하면
                if (pp == 0) // pat의 첫 문자까지 일치하면
                    return pt; // 검색 성공
                pp--;
                pt--;
            }
            //중간에 일치하지 않는 문자가 나오면 내부 while문을 빠져나와, 건너뛰기 표를 참고하여 pt를 이동시킴
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }
        return -1; // 검색 실패
    }
}