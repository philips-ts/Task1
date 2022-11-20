package com.tarasenko.collections.set;

import com.tarasenko.collections.map.TreeMapImpl;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class TreeSetImpl<T> implements Set<T> {
    private final TreeMapImpl<T, Integer> treeMap;

    public TreeSetImpl() {
        treeMap = new TreeMapImpl<>();
    }

    public TreeSetImpl(Comparator<? super T> comparator) {
        treeMap = new TreeMapImpl<>(comparator);
    }

    @Override
    public int size() {
        return treeMap.size();
    }

    @Override
    public boolean isEmpty() {
        return treeMap.isEmpty();
    }

    @Override
    public void clear() {
        treeMap.clear();
    }

    @Override
    public boolean contains(Object o) {
        return treeMap.containsKey(o);
    }

    @Override
    public boolean add(T t) {
        Integer result = treeMap.put(t, 0);
        return result == null;
    }

    @Override
    public boolean remove(Object o) {
        return treeMap.remove(o, 0);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean isAllContained = true;
        for (Object o : c) {
            if (!treeMap.containsKey(o)) {
                isAllContained = false;
                break;
            }
        }

        return isAllContained;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("This version of Set doesn't support this operation.");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("This version of Set doesn't support this operation.");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("This version of Set doesn't support this operation.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This version of Set doesn't support this operation.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("This version of Set doesn't support this operation.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("This version of Set doesn't support this operation.");
    }
}
