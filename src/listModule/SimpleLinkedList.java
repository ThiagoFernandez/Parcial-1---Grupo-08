package listModule;

import java.util.Objects;

public class SimpleLinkedList <E> implements SimpleList<E>{
    private MyNode<E> root;
    private MyNode<E> tail;
    private int size;

    public SimpleLinkedList() {
        this.root = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean add(E element){
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
        return true;
    }

    @Override
    public void add(int index, E element){
        validateIndexForAdd(index);
        MyNode<E> newNode = new MyNode<>(element);

        if(index == 0){
            if (root == null){
                root = newNode;
                tail = newNode;
            } else{
                newNode.next = root;
                root.prev = newNode;
                root = newNode;
            }
        } else if (index == size) {
            add(element);
            return;
        } else {
            MyNode<E> current = recorrerHastaIndice(index);

            MyNode<E> previous = current.prev;

            previous.next = newNode;
            newNode.prev = previous;

            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index){
            validateIndex(index);
            MyNode<E> current = recorrerHastaIndice(index);
            E data = current.data;
            // caso 1: unico elemento
            if (size == 1) {
                root = null;
                tail = null;
            }
            // caso 2: primero
            else if (current == root) {
                root = root.next;
                root.prev = null;
            }
            // caso 3: ultimo
            else if (current == tail) {
                tail = tail.prev;
                tail.next = null;
            }
            // caso 4: medio
            else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
            return data;
        }

    @Override
    public boolean remove(Object elemento){
        MyNode<E> current = root;
        int idx = 0;
        while (current!=null){
            if(Objects.equals(current.data, elemento)){
                remove(idx);
                return true;
            }else{
                current = current.next;
                idx++;
            }
        }return  false;
    }

    @Override
    public void clear(){
        root = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains( Object elemento){
        MyNode<E> current = root;
        while (current!=null){
            if(Objects.equals(current.data, elemento)){
                return true;
            }
            current = current.next;
        }
        return  false;
    }

    @Override
    public E get(int index){
        validateIndex(index);
        MyNode<E> current = recorrerHastaIndice(index);
        return current.data;
    }

    @Override
    public E set(int index, E elemento){
        validateIndex(index);
        MyNode<E> current = recorrerHastaIndice(index);
        E oldValue = current.data;
        current.data = elemento;
        return oldValue;
    }

    @Override
    public int size(){
        return size;
    }

    private void validateIndex(int index){
        if(index<0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    private void validateIndexForAdd(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
    }

    private MyNode<E> recorrerHastaIndice(int index){
        MyNode<E> current = root;
        for (int i = 0; i<index; i++ ){
            current = current.next;
        }
        return current;
    }
}

