package JupiterNotebook;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args){
        DoubleLinkedList<Integer> test = new DoubleLinkedList<Integer>();

        test.addNode(1);
        test.addNode(2);
        test.addNode(3);
        test.addNode(4);
        test.addNode(5);
        test.addNode(6);

        System.out.println(test.searchFromHead(3));
        System.out.println(test.searchFromTail(3));

        System.out.println(test.insertToFront(3, 10));

        test.printAll();


    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T isData){
        if(this.head == null){
            return null;
        }else{
            Node<T> node = this.head;
            while(node != null){
                if(node.data == isData){
                    return node.data;
                }else{
                    node = node.next;
                }
            }
            return null;
        }
    }

    public T searchFromTail(T isData){
        if(this.head == null)/*찾으려는 데이터가 없음.*/{
            return null;
        }else{
            Node<T> node = this.tail;
            while(node!=null){
                if(node.data == isData){
                    return node.data;
                }else{
                    node = node.prev;
                }
            }
            //head까지 순회 했을 때 데이터 미존재. == 찾으려는 데이터가 없음.
            return null;
        }
    }

    public boolean insertToFront(T existedData, T addData){
        if(this.head == null){
            //추가하려고 할 때 Head가 존재하지 않으면. => 데이터 가 없으므로 넣어준다.
            this.head = new Node<T>(addData);
            this.tail = this.head;
            return  true;
        }else if(existedData == this.head.data)/*현재 추가하려는 데이티가 이미 존재 한다면.*/{
            Node<T> newHead = new Node<T>(addData);
            newHead.next = this.head;
            this.head = newHead;
            return true;
        }else{
            Node<T> node = this.head;
            while (node != null){
                if(node.data == existedData){
                    Node<T> nodePrev = node.prev;

                    nodePrev.next = new Node<T>(addData);
                    nodePrev.next.next = node;
                    return true;
                }else{
                    node = node.next;
                }
            }
            return false;
        }
    }

}