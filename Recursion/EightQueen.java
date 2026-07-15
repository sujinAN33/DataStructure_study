class EightQueen{
    //퀸은 같은 행,열,대각선의 말을 공격할 수 있으므로 같은 행,열,대각선에 퀸이 배치되지 않도록 해야 한다.

    static boolean[] flag_a=new boolean[8]; //각 행에 퀸이 배치되었는지 체크
    static boolean[] flag_b=new boolean[15]; //  /방향 대각선으로 퀸이 배치되었는지 체크
    static boolean[] flag_c=new boolean[15]; //  \방향 대각선으로 퀸이 배치되었는지 체크
    static int[] pos=new int[8]; //각 열에 배치된 퀸의 위치

    static void print(){
        for(int i=0;i<8;i++){
            System.out.printf("%2d",pos[i]);
        }
        System.out.println();
    }

    static void set(int i){
        for(int j=0;j<8;j++){
            if(flag_a[j]==false && flag_b[i+j]==false && flag_c[i-j+7]==false){ //j행, /대각선, \대각선에 퀸이 배치되지 않았으면
                pos[i]=j; //i열의 퀸을 j행에 배치
                if(i==7){ //모든 열에 퀸을 배치했으면
                    print(); //배치 결과 출력
                }else{
                    flag_a[j]=flag_b[i+j]=flag_c[i-j+7]=true; //j행, /대각선, \대각선에 퀸을 배치했음을 표시
                    set(i+1); //다음 열에 퀸을 배치
                    flag_a[j]=flag_b[i+j]=flag_c[i-j+7]=false; //j행, /대각선, \대각선의 퀸 배치를 해제
                    //백트래킹 - 이전 단계로 돌아가 다른 경우를 탐색하기 위해 j행, /대각선, \대각선의 퀸 배치를 해제
                }
            }
        }
    }

    public static void main(String[] args){
        set(0); //0열부터 퀸을 배치
    }
    //92가지 경우의 수가 출력됨
}