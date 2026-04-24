package stackModule;

public class SimpleArrayStack<E> implements SimpleStack<E>{
    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements =  (E[]) new Object[DEFAULT_CAPACITY];
    private int size;

    public SimpleArrayStack(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // metodos de la interfaz
    @Override
    public void push(E element){
        validateSize(size+1);
        elements[size] = element;
        size++;
    }
    @Override
    public E pop(){
        E aux = elements[size-1];
        elements[size-1] = null;
        size--;
        return aux;

    }
    @Override
    public E peek(){
        return elements[size-1];
    }
    @Override
    public void clear(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean isEmpty() { //
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
