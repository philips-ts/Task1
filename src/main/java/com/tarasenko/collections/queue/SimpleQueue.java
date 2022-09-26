package com.tarasenko.collections.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;


public class SimpleQueue<T> implements Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private void addLast(T t) {
        final Node<T> oldLast = last;
        final Node<T> newNode = new Node<>(oldLast, t, null);
        last = newNode;
        if (oldLast == null) {
            first = newNode;
        } else {
            oldLast.next = newNode;
        }
        size++;
    }

    private void addFirst(T t) {
        final Node<T> oldFirst = first;
        final Node<T> newNode = new Node<>(null, t, first);
        first = newNode;
        if (oldFirst == null) {
            last = newNode;
        } else {
            oldFirst.prev = newNode;
        }
        size++;
    }

    private T removeFirst() {
        final T element = first.item;
        final Node<T> next = first.next;
        first.item = null;
        first.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;

        return element;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Node<T> element = first; element != null; element = element.next) {
                if (element.item == null) {
                    return true;
                }
            }
        } else {
            for (Node<T> element = first; element != null; element = element.next) {
                if (o.equals(element.item)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (first == null) {
            throw new NoSuchElementException();
        }
        removeFirst();
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            return false;
        }
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (Node<T> element = first; element != null; ) {
            Node<T> next = element.next;
            element.item = null;
            element.next = null;
            element.prev = null;
            element = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public boolean offer(T t) {
        addLast(t);
        return true;
    }

    @Override
    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return removeFirst();
    }

    @Override
    public T poll() {
        return (first == null) ? null : removeFirst();
    }

    @Override
    public T element() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    @Override
    public T peek() {
        return (first == null) ? null : first.item;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> element = first; element != null; element = element.next) {
            result[i++] = element.item;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("This version of Queue doesn't support this operation.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("This version of Queue doesn't support this operation.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This version of Queue doesn't support this operation.");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("This version of Queue doesn't support this operation.");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("This version of Queue doesn't support this operation.");
    }
}
