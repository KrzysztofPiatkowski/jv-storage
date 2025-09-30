package core.basesyntax;

import java.util.Objects;

public final class StorageImpl<K, V> implements Storage {
    private static final int CAPACITY = 10;

    private final Object[] keys = new Object[CAPACITY];
    private final Object[] values = new Object[CAPACITY];
    private int size = 0;

    @Override
    public void put(Object key, Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (size >= CAPACITY) {
            throw new IllegalStateException("Storage is full: " + CAPACITY);
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                V val = (V) values[i];
                return val;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
