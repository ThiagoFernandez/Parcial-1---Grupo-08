package setModule;

import listModule.MyNode;

import javax.lang.model.element.Element;

public class SimpleLinkedSet<E> implements SimpleSet<E>{
    private MyNode<E> root;
    private MyNode<E> tail;
    private int size;

    public SimpleLinkedSet(){
        root = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(E element){
        if (!contains(element)){
            MyNode<E> newNode = new MyNode<>(element);
            if (root == null){
                root = newNode;
                tail = newNode;
            } else{
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
            return  true;
        }
        return false;
    }

    @Override
    public boolean remove(E element){
        MyNode<E> current = root;
        for (int i = 0; i<size; i++){
            if (current.data.equals(element)){
                if (size == 1){
                    root = null;
                    tail = null;
                } else if (current == root) {
                    root = root.next;
                    root.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else{
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E element){
        MyNode<E> current = root;
        for (int i = 0; i<size; i++){
            if (current.data.equals(element)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
