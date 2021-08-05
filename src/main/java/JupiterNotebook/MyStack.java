package JupiterNotebook;

import java.util.ArrayList;

public class MyStack<T>{
    private ArrayList<T> stack = new ArrayList<T>();

    public void push(T data){
        stack.add(data);
    }

    public T pop(){
        if(stack.isEmpty()){
            return null;
        }

        return stack.remove(stack.size() -1);
    }

    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<Integer>();

        stack.push(0);
        stack.push(1);
        stack.push(2);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}