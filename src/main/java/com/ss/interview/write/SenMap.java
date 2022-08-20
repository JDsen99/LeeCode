package com.ss.interview.write;


/**
 * @author Senn
 * @create 2022/3/25 18:34
 */
public class SenMap<K, V> {

    static class Node<K, V> {
        final K key;
        final int hash;
        V value;
        Node<K, V> next;

        public Node(K key, int hash, V value, Node<K, V> next) {
            this.key = key;
            this.hash = hash;
            this.value = value;
            this.next = next;
        }
    }

    Node<K, V>[] table;

    private int size;

    private float loadFactor = 0.75F;

    private int threshold;

    private static final int MAX_CAPACITY = 1 << 30;

    private static final int DEFAULT_CAPACITY = 16;

    private static final Object EMPTY_TABLE = null;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public SenMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public SenMap(int capacity, float loadFactor) {
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(capacity);
    }

    private int tableSizeFor(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n < 0 ? 1 : (n > MAX_CAPACITY ? MAX_CAPACITY : n + 1);
    }

    public V get(K key) {
        Node<K, V> node;
        return (node = getNode(hash(key), key)) == null ? null : node.value;
    }

    public V put(K key, V value) {
        return putValue(hash(key), key, value, false);
    }

    private V putValue(int hash, K key, V value, boolean onlyIfAbsent) {
        Node<K, V>[] tab = this.table;
        int index = (tab.length - 1) & hash;
        Node<K, V> node;
        if ((node = tab[index]) == null) {
            tab[index] = new Node<>(key, hash, value, null);
        }else {
            while(node.next != null) {
                if (node.hash == hash && (node.key == key || node.key.equals(key))){
                    node.value = value;
                    break;
                }
                node = node.next;
            }
            node.next = new Node<>(key, hash, value, null);
        }
        ++size;
        if (size > threshold) {
            resize();
        }
        return null;
    }

    private Node<K, V>[] resize() {
        Node<K, V>[] oldTab = this.table;
        int oldThreshold = this.threshold;
        int oldCapacity = oldTab == null ? 0 : oldTab.length;
        int newCap, newThr;
        if (oldCapacity > 0) {
            if (oldCapacity > MAX_CAPACITY) {
                this.threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            if ((newCap = oldCapacity << 1) < MAX_CAPACITY && newCap > DEFAULT_CAPACITY) {
                newThr = oldThreshold << 1;
            }
        }else if(oldThreshold > 0) {
            newCap = oldThreshold;
        }else {
            newCap = DEFAULT_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_CAPACITY);
        }
        for (int i = 0; i < oldCapacity; i++) {
            Node<K, V> node = oldTab[i];
            if (node == null) {
                continue;
            }
            Node<K, V> nNode = null, oNode = null;
            if ((node.hash & oldCapacity) == 1) {
                nNode = node;
            }else {
                oNode = node;
            }
            node = node.next;
            while (node != null) {
                if ((node.hash & oldCapacity) == 1) {
                    while (nNode != null) nNode = nNode.next;
                    nNode.next = new Node<>(node.key, node.hash, node.value, null);
                }else {
                    while (oNode.next != null) oNode = oNode.next;
                    oNode.next = new Node<>(node.key, node.hash, node.value, null);
                }
                node = node.next;
             }
        }
        return null;
    }

    private Node<K, V> getNode(int hash, K key) {
        Node<K, V>[] tab = this.table;
        Node<K, V> node;
        if (tab == null) return null;
        int index = (tab.length - 1) & hash;
        if ( (node = tab[index]) == null) return null;
        //check first
        if (node.hash == hash && (node.key == key || node.key.equals(key))) {
            return node;
        }
        if (node.next != null) {
            do {
                if (node.hash == hash && (node.key == key || node.key.equals(key))) {
                    return node;
                }
            }while ( (node = node.next) != null);
        }
        return null;
    }

    private int hash(K key) {
        int h;
        return (h = key.hashCode()) ^ (h >>> 16);
    }

}
