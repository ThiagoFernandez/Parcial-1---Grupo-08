package listModule;

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
        validateIndex(index);
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
            MyNode<E> current = root;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

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
            MyNode<E> current = root;
            // recorrer hasta el índice
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            E data = current.data;
            // caso 1: único elemento
            if (size == 1) {
                root = null;
                tail = null;
            }
            // caso 2: primero
            else if (current == root) {
                root = root.next;
                root.prev = null;
            }
            // caso 3: último
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

    private void validateIndex(int index){
        if(index<0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}

