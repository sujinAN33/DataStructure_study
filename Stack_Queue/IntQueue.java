import java.util.Scanner;
public class IntQueue{
    private int max; //큐의 용량
    private int front; //첫 번째 요소 커서
    private int rear; //마지막 요소 커서
    private int num; //현재 데이터 수
    private int[] que; //큐의 본체

    //실행 시 예외: 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException(){}
    }

    //실행 시 예외: 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException(){}
    }

    //생성자
    public IntQueue(int capacity){
        num=front=rear=0;
        max=capacity;
        try{
            que=new int[max]; //큐 본체용 배열을 생성
        }catch(OutOfMemoryError e){ //생성할 수 없음
            max=0;
        }
    }

    //큐에 데이터를 인큐
    public int enque(int x) throws OverflowIntQueueException{
        if(num>=max) throw new OverflowIntQueueException(); //큐가 가득 참
        que[rear++]=x;
        num++;
        if(rear==max) rear=0;
        return x;
    }
    //큐에서 데이터를 디큐
    public int deque() throws EmptyIntQueueException{
        if(num<=0) throw new EmptyIntQueueException(); //큐가 비어 있음
        int x=que[front++];
        num--;
        if(front==max) front=0;
        return x;
    }

    public int peek() throws EmptyIntQueueException{
        if(num<=0) throw new EmptyIntQueueException(); //큐가 비어 있음
        return que[front];
    }

    public int indexOf(int x){
        for(int i=0;i<num;i++){
            int idx=(i+front)%max; //i번째 요소는 que[(i+front)%max]에 있음
            if(que[idx]==x) return idx; //검색 성공 
        }
        return -1; //검색 실패
    }

    public void clear(){num=front=rear=0;}
    public int capacity(){return max;}
    public int size(){return num;}
    public boolean isEmpty(){return num<=0;}
    public boolean isFull(){return num>=max;}
    public void dump(){
        if(num<=0) System.out.println("큐가 비어 있습니다.");
        else{
            for(int i=0;i<num;i++)
                System.out.print(que[(i+front)%max]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner stdIn=new Scanner(System.in);
        IntQueue s=new IntQueue(64); //최대 64개를 인큐할 수 있는 큐

        while(true){
            System.out.println("현재 데이터 수: "+s.size()+"/"+s.capacity());
            System.out.print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (0)종료: ");

            int menu=stdIn.nextInt();
            if(menu==0) break;

            int x;
            switch(menu){
                case 1: //인큐
                    System.out.print("데이터: ");
                    x=stdIn.nextInt();
                    try{
                        s.enque(x);
                    }catch(IntQueue.OverflowIntQueueException e){
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2: //디큐
                    try{
                        x=s.deque();
                        System.out.println("디큐한 데이터는 "+x+"입니다.");
                    }catch(IntQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3: //피크
                    try{
                        x=s.peek();
                        System.out.println("피크한 데이터는 "+x+"입니다.");
                    }catch(IntQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4: //덤프
                    s.dump();
                    break;
            }
        }
    }
}