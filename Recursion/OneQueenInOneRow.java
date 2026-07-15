class OneQueenInOneRow{
    //8룩Rook 문제 해결-행과 열 방향으로 겹치지 않는 경우의 수를 출력
    //실제 퀸은 대각선으로도 공격 가능하므로, 8퀸 문제에서는 대각선 방향으로도 겹치지 않도록 해야 함
    //하지만 이 문제에서는 대각선 방향으로 겹치지 않도록 하는 조건은 고려하지 않음
    static boolean[] flag=new boolean[8];
    static int[] pos=new int[8];

    static void print(){
        for(int i=0;i<8;i++){
            System.out.printf("%2d",pos[i]);
        }
        System.out.println();
    }

    static void set(int i){
        for(int j=0;j<8;j++){
            if(flag[j]==false){ //j행에 퀸이 배치되지 않았으면
                pos[i]=j; //i열의 퀸을 j행에 배치
                
                if(i==7){ //모든 열에 퀸을 배치했으면
                    print(); //배치 결과 출력
                }else{
                    flag[j]=true; //j행에 퀸을 배치했음을 표시
                    set(i+1); //다음 열에 퀸을 배치
                    flag[j]=false; //j행의 퀸 배치를 해제
                    //백트래킹 - 이전 단계로 돌아가 다른 경우를 탐색하기 위해 j행의 퀸 배치를 해제
                }
            }
        }
    }

    public static void main(String[] args){
        set(0); //0열부터 퀸을 배치
    }
}