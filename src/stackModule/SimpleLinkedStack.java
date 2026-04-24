package stackModule;

import listModule.MyNode;

public class SimpleLinkedStack <E> implements SimpleStack<E> {
    private MyNode<E> root;
    private MyNode<E> tail;
    private int size;

    public SimpleLinkedStack(){
        root = null;
        tail = null;
        size = 0;
    }

    @Override
    public void push(E element){ // chequear si esto se rompe porque aca no asigno un prev y el pop uso prev
        MyNode<E> newNode = new MyNode<>(element);
        if (root == null){
            root = newNode;
            tail = newNode;
        } else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size ++;
    }
    @Override
    public E pop() {
        MyNode<E> removed = tail;
        E data = removed.data;
        tail = tail.prev;
        if(tail!=null){
            tail.next = null;
        }else{
            root = null;
        }
        size--;
        return data;
    }
    @Override
    public E peek(){
        return tail.data;
    }
    @Override
    public void clear(){
        root = null;
        tail = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
}

