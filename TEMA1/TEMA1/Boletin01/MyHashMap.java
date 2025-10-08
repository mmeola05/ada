package TEMA1.Boletin01;

class MyHashMap {
    private String[] keys;
    private int[] values;
    private int size;

    /**
     *
     * @param capacity
     */
    public MyHashMap(int capacity) {
        keys = new String[capacity];
        values = new int[capacity];
        size = 0;
    }

    /**
     *
     * @param key
     * @param value
     */
    public void put(String key, int value) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    /**
     *
     * @param key
     * @return
     */
    public Integer get(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    /**
     *
     * @param key
     */
    public void remove(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                // mover el último elemento a la posición eliminada
                keys[i] = keys[size - 1];
                values[i] = values[size - 1];
                size--;
                return;
            }
        }
    }
}

