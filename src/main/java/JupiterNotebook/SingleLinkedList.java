package JupiterNotebook;

public class SingleLinkedList<T>{
    public Node<T> head = null;

    public class Node<T>{
        T data;
        Node<T> next = null;    //Pointer: 다음 위치로 이동할 메모리의 주소값 셋팅.

        public Node(T data){
            //생성자 생성.
            this.data = data;
        }
    }

    public void addNode(T data){
        if(head == null)
            head = new Node<T>(data);
        else{
            Node<T> node = this.head;
            while (node.next != null)/*다음으로 이동할 노드가 있다면 다음 노드의 주소값을 셋팅*/{
                node = node.next;
            }
            node.next = new Node<T>(data);  //더 이상 갈 노드가 없으면 새로 생성한 노드로 갈 수 있게 설정.
        }
    }//END addNode

    public static void main(String[] args){
        SingleLinkedList<Integer> test = new SingleLinkedList<Integer>();

        test.addNode(1);
        System.out.println(test.head.data); // 1

        test.addNode(2);
        System.out.println(test.head.next); // 추가된 2의 값을 가지고 있는 노드의 주소
                                            // ex) JupiterNotebook.SingleLinkedList$Node@15db9742
        System.out.println(test.head.next.data);    // 1의 값을 가지고 있는 노드의 다음 노드의 값. //2
        test.addNode(3);
        test.addNode(4);
        test.addNode(5);
        test.addNode(6);

        test.printAll();

    }//-END main();

    public void printAll(){
        if(head!=null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }
}
