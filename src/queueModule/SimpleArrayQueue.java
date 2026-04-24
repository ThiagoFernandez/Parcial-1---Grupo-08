package queueModule;

public class SimpleArrayQueue<E> implements SimpleQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements =  (E[]) new Object[DEFAULT_CAPACITY];
    private int size;

    public SimpleArrayQueue(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size=0;
    }
    @Override
    public void enqueue(E element) {
        validateSize(size+1);
        elements[size] = element;
        size++;
    }
    @Override
    public E dequeue(){
        E removed = elements[0];
        for(int i = 0; i<size; i++){
            elements[i] = elements[i+1];
        }
        size--;
        return removed;
    }
    @Override
    public E peek(){
        return elements[0];
    }
    @Override
    public void clear(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size=0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    // metodos auxiliares
    @SuppressWarnings("unchecked")
    private void resize(){
        int newCapacity = elements.length * 2;
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i=0; i< size; i++){
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    private void validateSize(int newSize){
        if(newSize> elements.length){
            resize();
        }
    }
}

