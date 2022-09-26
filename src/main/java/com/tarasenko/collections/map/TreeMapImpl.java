package com.tarasenko.collections.map;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class TreeMapImpl<K, V> implements Map<K, V> {
    private Entry<K,V> root;
    private int size = 0;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private final Comparator<? super K> comparator;


    public TreeMapImpl() {
        comparator = null;
    }

    public TreeMapImpl(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }


    public static class Entry<K,V> implements Map.Entry<K,V> {
        private K key;
        private V value;

        private Entry<K,V> left;
        private Entry<K,V> right;
        private Entry<K,V> parent;

        private boolean color;

        public Entry() {
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }



    @SuppressWarnings("unchecked")
    private int compare(Object k1, Object k2) {
        return comparator==null ? ((Comparable<? super K>)k1).compareTo((K)k2)
                : comparator.compare((K)k1, (K)k2);
    }


    private boolean isBlack(Entry<K, V> node) {
        return node == null || node.color == BLACK;
    }

    private static class NilNode<K, V> extends Entry<K, V> {
        private final boolean color;
        private NilNode() {
            this.color = BLACK;
        }
    }


    private void insertNode(K key, V value) {
        Entry<K, V> entry = root;
        Entry<K, V> parent = null;

        while (entry != null) {
            parent = entry;
            int compareResult = compare(key, entry.key);
            if (compareResult < 0) {
                entry = entry.left;
            } else if (compareResult > 0) {
                entry = entry.right;
            } else {
                entry.value = value;
                return;
            }
        }

        Entry<K, V> newNode = new Entry<>(key, value);
        newNode.color = RED;
        if (parent == null) {
            root = newNode;
        } else {
            int compareResult = compare(key, parent.key);
            if (compareResult < 0) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
        newNode.parent = parent;

        fixRedBlackPropertiesAfterInsert(newNode);
        size++;
    }

    private void fixRedBlackPropertiesAfterInsert(Entry<K, V> node) {
        Entry<K, V> parent = node.parent;

        if (parent == null) {
            return;
        }
        if (parent.color == BLACK) {
            return;
        }

        Entry<K, V> grandparent = parent.parent;
        if (grandparent == null) {
            parent.color = BLACK;
            return;
        }

        Entry<K, V> uncle = getUncle(parent);
        if (uncle != null && uncle.color == RED) {
            parent.color = BLACK;
            grandparent.color = RED;
            uncle.color = BLACK;
            fixRedBlackPropertiesAfterInsert(grandparent);
        }

        else if (parent == grandparent.left) {
            if (node == parent.right) {
                rotateLeft(parent);
                parent = node;
            }
            rotateRight(grandparent);
            parent.color = BLACK;
            grandparent.color = RED;
        }
        else {
            if (node == parent.left) {
                rotateRight(parent);
                parent = node;
            }
            rotateLeft(grandparent);
            parent.color = BLACK;
            grandparent.color = RED;
        }
    }

    private Entry<K, V> getUncle(Entry<K, V> parent) {
        Entry<K, V> grandparent = parent.parent;
        if (grandparent.left == parent) {
            return grandparent.right;
        } else if (grandparent.right == parent) {
            return grandparent.left;
        } else {
            throw new IllegalStateException();
        }
    }

    private V deleteNode(K key) {
        Entry<K, V> node = root;
        V returnValue;

        while (node != null) {
            int compareResult = compare(node.key, key);
            if (compareResult == 0) {
                break;
            }
            if (compareResult < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (node == null) {
            return null;
        }
        returnValue = node.value;

        Entry<K, V> movedUpNode;
        boolean deletedNodeColor;
        if (node.left == null || node.right == null) {
            movedUpNode = deleteNodeWithZeroOrOneChild(node);
            deletedNodeColor = node.color;
        } else {
            Entry<K, V> inOrderSuccessor = findMinimum(node.right);
            node.key = inOrderSuccessor.key;
            node.value = inOrderSuccessor.value;
            movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
            deletedNodeColor = inOrderSuccessor.color;
        }

        if (deletedNodeColor == BLACK) {
            fixRedBlackPropertiesAfterDelete(movedUpNode);
            if (movedUpNode.getClass() == NilNode.class) {
                replaceParentsChild(movedUpNode.parent, movedUpNode, null);
            }
        }
        size--;

        return returnValue;
    }

    private Entry<K, V> deleteNodeWithZeroOrOneChild(Entry<K, V> node) {
        if (node.left != null) {
            replaceParentsChild(node.parent, node, node.left);
            return node.left;
        }  else if (node.right != null) {
            replaceParentsChild(node.parent, node, node.right);
            return node.right;
        } else {
            Entry<K, V> newChild = node.color == BLACK ? new NilNode<>() : null;
            replaceParentsChild(node.parent, node, newChild);
            return newChild;
        }
    }

    private Entry<K, V> findMinimum(Entry<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void fixRedBlackPropertiesAfterDelete(Entry<K, V> node) {
        if (node == root) {
            return;
        }

        Entry<K, V> sibling = getSibling(node);
        if (sibling.color == RED) {
            handleRedSibling(node, sibling);
            sibling = getSibling(node);
        }

        if (isBlack(sibling.left) && isBlack(sibling.right)) {
            sibling.color = RED;
            if (node.parent.color == RED) {
                node.parent.color = BLACK;
            } else {
                fixRedBlackPropertiesAfterDelete(node.parent);
            }
        }  else {
            handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
        }
    }

    private void handleRedSibling(Entry<K, V> node, Entry<K, V> sibling) {
        sibling.color = BLACK;
        node.parent.color = RED;

        if (node == node.parent.left) {
            rotateLeft(node.parent);
        } else {
            rotateRight(node.parent);
        }
    }

    private void handleBlackSiblingWithAtLeastOneRedChild(Entry<K, V> node, Entry<K, V> sibling) {
        boolean nodeIsLeftChild = node == node.parent.left;

        if (nodeIsLeftChild && isBlack(sibling.right)) {
            sibling.left.color = BLACK;
            sibling.color = RED;
            rotateRight(sibling);
            sibling = node.parent.right;
        } else if (!nodeIsLeftChild && isBlack(sibling.left)) {
            sibling.right.color = BLACK;
            sibling.color = RED;
            rotateLeft(sibling);
            sibling = node.parent.left;
        }

        sibling.color = node.parent.color;
        node.parent.color = BLACK;
        if (nodeIsLeftChild) {
            sibling.right.color = BLACK;
            rotateLeft(node.parent);
        } else {
            sibling.left.color = BLACK;
            rotateRight(node.parent);
        }
    }

    private Entry<K, V> getSibling(Entry<K, V> node) {
        Entry<K, V> parent = node.parent;
        if (node == parent.left) {
            return parent.right;
        } else if (node == parent.right) {
            return parent.left;
        } else {
            throw new IllegalStateException("Parent isn't a child of its grandparent");
        }
    }

    private void rotateRight(Entry<K, V> node) {
        Entry<K, V> parent = node.parent;
        Entry<K, V> leftChild = node.left;

        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        leftChild.right = node;
        node.parent = leftChild;

        replaceParentsChild(parent, node, leftChild);
    }

    private void rotateLeft(Entry<K, V> node) {
        Entry<K, V> parent = node.parent;
        Entry<K, V> rightChild = node.right;

        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }

        rightChild.left = node;
        node.parent = rightChild;

        replaceParentsChild(parent, node, rightChild);
    }

    private void replaceParentsChild(Entry<K, V> parent, Entry<K, V> oldChild, Entry<K, V> newChild) {
        if (parent == null) {
            root = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        } else {
            throw new IllegalStateException();
        }

        if (newChild != null) {
            newChild.parent = parent;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private void unlinkAllNodes(Entry<K, V> startNode) {
        if (startNode != null) {
            Entry<K, V> leftNode = startNode.left;
            Entry<K, V> rightNode = startNode.right;
            startNode.left = null;
            startNode.right = null;
            unlinkAllNodes(leftNode);
            unlinkAllNodes(rightNode);
        }
    }

    @Override
    public void clear() {
        unlinkAllNodes(root);
        root = null;
        size = 0;
    }

    private Entry<K, V> findNodeByValue(Entry<K, V> startNode, Object value) {
        Entry<K, V> foundNode = null;

        if (startNode != null) {
            if (startNode.value == null) {
                if (value == null) {
                    return startNode;
                }
            } else {
                if (value != null) {
                    if (startNode.value.equals(value)) {
                        return startNode;
                    }
                }
            }
            foundNode = findNodeByValue(startNode.left, value);
            if (foundNode == null) {
                foundNode = findNodeByValue(startNode.right, value);
            }
        }

        return foundNode;
    }

    private Entry<K, V> findNodeByKey(K key) {
        Entry<K, V> node = root;
        while (node != null) {
            int compareResult = compare(key, node.key);
            if (compareResult == 0) {
                return node;
            } else {
                if (compareResult < 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }

        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsKey(Object key) {
        if (key == null) {
            throw new RuntimeException("The key can not be null");
        }
        Entry<K, V> node = findNodeByKey((K)key);
        return node != null;
    }


    @Override
    public boolean containsValue(Object value) {
        Entry<K, V> foundNode = findNodeByValue(root, value);
        return foundNode != null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        if (key == null) {
            throw new RuntimeException("The key can not be null");
        }
        Entry<K, V> node = findNodeByKey((K)key);
        return node == null ? null : node.value;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new RuntimeException("The key can not be null");
        }
        insertNode(key, value);
        return value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        if (key == null) {
            throw new RuntimeException("The key can not be null");
        }

        return deleteNode((K)key);
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("This version of List doesn't support this operation.");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeMapImpl<?, ?> treeMap = (TreeMapImpl<?, ?>) o;
        return size == treeMap.size && Objects.equals(root, treeMap.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root, size);
    }
}
