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

        test.addNodeInside(10, 3);   //10이라는 Node를 3 데이터를 가진 Node에 입력
        test.addNodeInside(20, 20);  //20이라는 Node를 20 데이터를 가진 Node에 입력, 없으면 맨 뒤 Node에 생성.

        test.printAll();    //전체 리스트 출력.

        // Node삭제 TEST
        test.delNode(10);
        test.printAll();    //전체 리스트 출력.

        // HEAD를 삭제 했을 때
        test.delNode(1);
        test.printAll();    //전체 리스트 출력.

        // 마지막 노드 삭제
        test.delNode(20);
        test.printAll();    //전체 리스트 출력.

        // 없는 노드 삭제시
        System.out.println(test.delNode(30));

    }//-END main();

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

    public Node<T> search(T data){
        if(this.head == null){
            return null;
        }else{
            Node<T> node = this.head;
            while(node != null){
                if(node.data == data){
                    return node;
                }else{
                    node = node.next;
                }
            }
        }
        return null;
    }

    public void addNodeInside(T data, T isData){
        Node<T> searchNode = this.search(isData);

        if(searchNode == null){
            this.addNode(data);
        }else{
            Node<T> nextNode = searchNode.next;
            searchNode.next = new Node<T>(data);
            searchNode.next.next = nextNode;
        }
    }


    public boolean delNode(T isData){
        if(this.head == null){
            //데이터 미존재.
            return false;
        } else {
            Node<T> node = this.head;
            if(node.data == isData)/*입력한 값이 노드에 존재를 하면 */{
                // 첫번째 Node가 head 일 때
                this.head = this.head.next;
                return true;
            } else /*head가 아니면*/{
                while(node.next != null)/*다음 노드값을 가리키고 있으면.*/{
                    if(node.next.data == isData){
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }
}
