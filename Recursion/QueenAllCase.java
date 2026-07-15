//8개의 퀸을 8*8 체스판에 배치하는 모든 경우의 수를 출력
class QueenAllCase{
    static int[] pos = new int[8]; //각 열에 배치된 퀸의 위치

    static void print(){
        for(int i=0;i<8;i++){
            System.out.printf("%2d",pos[i]);
        }
        System.out.println();
    }

    static void set(int i){
        for(int j=0;j<8;j++){
            pos[i] = j; //i열의 퀸을 j행에 배치
            if(i==7){ //모든 열에 퀸을 배치했으면
                print(); //배치 결과 출력
            }else{
                set(i+1); //다음 열에 퀸을 배치
            }
        }
    }
    public static void main(String[] args){
        set(0); //0열부터 퀸을 배치
    }
}
//이러면 64C8의 조합, 즉 16,777,216가지 경우의 수가 출력됨