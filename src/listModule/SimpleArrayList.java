package listModule;

public class SimpleArrayList<E> implements SimpleList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] elementos = (E[]) new Object[DEFAULT_CAPACITY];
    private int size;

    public SimpleArrayList() {
        elementos = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(E element) {
        validateSize(size + 1);
        elementos[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        validateSizeForAdd(index);  // ahora si permite index == size
        validateSize(size + 1);
        for (int i = size; i > index; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        E aux = elementos[index];
        for (int i = index; i < size - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[size - 1] = null;
        size--;
        return aux;
    }

    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < size; i++) {
            if (elementos[i].equals(object)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        elementos = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(Object object) {
        for (int i = 0; i < size; i++) {
            if (elementos[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return elementos[index];
    }

    @Override
    public E set(int index, E element) {
        validateIndex(index);
        E aux = elementos[index];
        elementos[index] = element;
        return aux;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = elementos.length * 2;
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = elementos[i];
        }
        elementos = newArray;
    }

    private void validateSize(int newSize) {
        if (newSize > elementos.length) {
            resize();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void validateSizeForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}