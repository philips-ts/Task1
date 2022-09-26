package com.tarasenko.collections.list;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class LinkedListImpl<T> implements List<T>, Deque<T> {

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

        @Override
        public String toString() {
            return "item=" + item;
        }
    }

    private T removeElement(Node<T> x) {
        final T element = x.item;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;

        return element;
    }
    
    private void insertElement(T e, Node<T> nodeToInsert) {
        final Node<T> pred = nodeToInsert.prev;
        final Node<T> newNode = new Node<>(pred, e, nodeToInsert);
        nodeToInsert.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    private Node<T> getNode(int index) {
        if (index < (size >> 1)) {
            Node<T> element = first;
            for (int i = 0; i < index; i++)
                element = element.next;
            return element;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public void addFirst(T t) {
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

    @Override
    public void addLast(T t) {
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

    @Override
    public boolean offerFirst(T t) {
        addFirst(t);
        return true;
    }

    @Override
    public boolean offerLast(T t) {
        addLast(t);
        return true;
    }

    @Override
    public T removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
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
    public T removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }

        final T element = last.item;
        final Node<T> prev = last.prev;
        last.item = null;
        last.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;

        return element;
    }

    @Override
    public T pollFirst() {
        return (first == null) ? null : removeFirst();
    }

    @Override
    public T pollLast() {
        return (last== null) ? null : removeLast();
    }

    @Override
    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    @Override
    public T getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    @Override
    public T peekFirst() {
        return (first == null) ? null : first.item;
    }

    @Override
    public T peekLast() {
        return (last == null) ? null : last.item;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Node<T> element = last; element != null; element = element.prev) {
                if (element.item == null) {
                    removeElement(element);
                    return true;
                }
            }
        } else {
            for (Node<T> element = last; element != null; element = element.prev) {
                if (o.equals(element.item)) {
                    removeElement(element);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean offer(T t) {
        return add(t);
    }

    @Override
    public T remove() {
        return removeFirst();
    }

    @Override
    public T poll() {
        return (first == null) ? null : removeFirst();
    }

    @Override
    public T element() {
        return getFirst();
    }

    @Override
    public T peek() {
        return (first == null) ? null : first.item;
    }

    @Override
    public void push(T t) {
        addFirst(t);
    }

    @Override
    public T pop() {
        return removeFirst();
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
        return indexOf(o) >= 0;
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
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<T> element = first; element != null; element = element.next) {
                if (element.item == null) {
                    removeElement(element);
                    return true;
                }
            }
        } else {
            for (Node<T> element = first; element != null; element = element.next) {
                if (o.equals(element.item)) {
                    removeElement(element);
                    return true;
                }
            }
        }

        return false;
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
    public T get(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).item;
    }

    @Override
    public T set(int index, T element) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        
        Node<T> node = getNode(index);
        T oldVal = node.item;
        node.item = element;
        
        return oldVal;
    }

    @Override
    public void add(int index, T element) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            addLast(element);
        } else {
            insertElement(element, getNode(index));
        }
    }

    @Override
    public T remove(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        return removeElement(getNode(index));
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<T> element = first; element != null; element = element.next) {
                if (element.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<T> element = first; element != null; element = element.next) {
                if (o.equals(element.item))
                    return index;
                index++;
            }
        }
        
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<T> element = last; element != null; element = element.prev) {
                index--;
                if (element.item == null)
                    return index;
            }
        } else {
            for (Node<T> element = last; element != null; element = element.prev) {
                index--;
                if (o.equals(element.item))
                    return index;
            }
        }
        
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public Iterator<T> descendingIterator() {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListImpl<?> that = (LinkedListImpl<?>) o;
        return size == that.size && Objects.equals(first, that.first) && Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, size);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Node<T> element = last; element != null; element = element.prev) {
            stringBuilder.append(element);
        }

        return "LinkedListImpl { = " +
                stringBuilder +
                '}';
    }
}
