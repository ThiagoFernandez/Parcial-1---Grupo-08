package listModule;

public class MyNode <E>{
    // los puse public para no tener que hacer una clase igual para los linked de otros packages
    public E data;
    public MyNode<E> next;
    public MyNode<E> prev;

    public MyNode(E data) {
        this.data = data;
        this.next =null;
        this.prev = null;
    }
}
