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
        return true;
    }

    @Override
    public void add(E element){
        MyNode
    }

}

