import java.util.Comparator;

public class LinkedList<E> {
    // 노드
    class Node<E> {
        private E data; // 데이터
        private Node<E> next; // 뒤쪽 포인터(다음 노드 참조)

        // 생성자
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        // 데이터를 반환
        E getData() {
            return data;
        }

        // 문자열을 반환
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> head; // 머리 노드
    private Node<E> crnt; // 선택 노드

    // 생성자
    public LinkedList() {
        head = crnt = null;
    }

    // 노드를 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head; // 현재 스캔 중인 노드
        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) { // 검색 성공
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        
        return null; // 검색 실패
    }

    //머리에 노드를 삽입
    public void addFirst(E obj) {
        Node<E> ptr = head; // 삽입 전의 머리 노드
        head = crnt = new Node<E>(obj, ptr);    
    }

    // 꼬리에 노드를 삽입
    public void addLast(E obj) {
        if (head == null) // 리스트가 비어있으면
            addFirst(obj); // 머리에 삽입
        else {
            Node<E> ptr = head;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    //머리 노드를 삭제
    public void removeFirst() {
        if (head != null)
            head = crnt = head.next;
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        if (head != null) {
            if (head.next == null) // 노드가 하나만 있으면
                removeFirst(); // 머리 노드를 삭제
            else {
                Node<E> ptr = head; // 스캔 중인 노드
                Node<E> pre = head; // 스캔 중인 노드의 앞쪽
                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                //while문이 끝나면 ptr은 꼬리 노드를 가리키고, pre는 꼬리 노드의 바로 앞 노드를 가리킴
                pre.next = null; //꼬리노드 삭제
                crnt = pre;
            }
        }
    }
}