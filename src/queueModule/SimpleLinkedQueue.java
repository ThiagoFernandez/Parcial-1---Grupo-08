package queueModule;

import listModule.MyNode;
import java.util.NoSuchElementException;

public class SimpleLinkedQueue<E> implements SimpleQueue<E> {
    private MyNode<E> root;
    private MyNode<E> tail;
    private int size;

    public SimpleLinkedQueue() {
        root = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        MyNode<E> newNode = new MyNode<>(element);
        if (root == null) {
            root = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        MyNode<E> removed = root;
        root = root.next;
        if (root != null) {
            root.prev = null;
        } else {
            tail = null;
        }
        size--;
        return removed.data;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return root.data;
    }

    @Override
    public void clear() {
        root = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;  // fix: era root != null && tail != null
    }
}