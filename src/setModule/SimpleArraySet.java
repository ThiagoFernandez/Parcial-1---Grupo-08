package setModule;

public class SimpleArraySet<E> implements SimpleSet<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements = (E[]) new Object[DEFAULT_CAPACITY];
    private int size;

    public SimpleArraySet() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(E element) {
        if (contains(element)) {
            return false;
        }
        validateSize(size + 1);  // fix: era validateSize(size++) con doble size++
        elements[size] = element;
        size++;
        return true;
    }

    @Override
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                elements[i] = elements[size - 1];  // reemplaza con el último
                elements[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    @Override
    public SimpleSet<E> unionWith(SimpleSet<E> other) {
        SimpleSet<E> result = new SimpleArraySet<>();

        for (int i = 0; i < size; i++) {
            result.add(elements[i]);
        }

        E[] otherArray = other.toArray();
        for (E element : otherArray) {
            result.add(element);
        }
        return result;
    }

    @Override
    public SimpleSet<E> intersectionWith(SimpleSet<E> other) {
        SimpleSet<E> result = new SimpleArraySet<>();

        for (int i = 0; i < size; i++) {
            if (other.contains(elements[i])) {
                result.add(elements[i]);
            }
        }
        return result;
    }

    @Override
    public SimpleSet<E> differenceWith(SimpleSet<E> other) {
        SimpleSet<E> result = new SimpleArraySet<>();

        for (int i = 0; i < size; i++) {
            if (!other.contains(elements[i])) {
                result.add(elements[i]);
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = elements.length * 2;
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    private void validateSize(int newSize) {
        if (newSize > elements.length) {
            resize();
        }
    }
}