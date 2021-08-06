package JupiterNotebook;

public class MyNode<T> {
    T data;
    MyNode<T> next = null;

    public MyNode(T data){
        this.data = data;
    }

    public static void main(String[] args){
        MyNode<Integer> node1 = new MyNode<Integer>(1);
        MyNode<Integer> node2 = new MyNode<Integer>(2);

        node1.next = node2;
        MyNode head = node1;
    }

}
