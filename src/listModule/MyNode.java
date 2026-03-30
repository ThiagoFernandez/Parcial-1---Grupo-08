package listModule;

public class MyNode <E>{
    E data;
    MyNode<E> next;
    MyNode<E> prev;

    public MyNode(E data) {
        this.data = data;
        this.next =null;
        this.prev = null;
    }
}
