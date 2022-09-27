package com.tarasenko.collections.list;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;



public class ArrayListImpl<T> implements List<T> {
    private final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;
    private Object[] elements = new Object[capacity];
    private int size;


    private void increase() {
        int newCapacity = capacity + capacity / 2 + 1;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);

        capacity = newCapacity;
        elements = newElements;
    }

    private void checkIndexBounds(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is incorrect");
        }
    }


    @Override
    public boolean add(T t) {
        add(size, t);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean isRemoved = false;

        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                remove(i);
                isRemoved = true;
                break;
            }
        }

        return isRemoved;
    }

    @Override
    public void clear() {
        capacity = DEFAULT_CAPACITY;
        elements = new Object[capacity];
        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndexBounds(index);
        return (T)elements[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T set(int index, T element) {
        checkIndexBounds(index);

        T oldElement = (T)elements[index];
        elements[index] = element;

        return oldElement;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is incorrect");
        }
        if (index + 1 > capacity) {
            increase();
        }

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndexBounds(index);
        T elem = get(index);

        for (int i = index; i < size + 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;

        return elem;
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
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            return false;        }

        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) {
            return false;
        }

        boolean modified = false;
        for (T t : c)
            if (add(t))
                modified = true;
        return modified;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        if (a == null) {
            return (E[]) new Object[0];
        }
        if (a.length < size) {
            return (E[]) Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    /*
    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }
    */

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
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
    public String toString() {
        return "ArrayList= {" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListImpl<?> arrayList = (ArrayListImpl<?>) o;
        return size == arrayList.size && Arrays.equals(elements, arrayList.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }
}
