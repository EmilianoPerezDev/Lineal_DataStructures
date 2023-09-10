import java.util.LinkedList;

public class HashTable {
    private class Entry {

        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries;

    public HashTable(int capacity) {
        entries = new LinkedList[capacity];
    }

    public void put(int key, String value) {
        var index = hash(key);

        if (entries[index] == null) entries[index] = new LinkedList<>();

        var bucket = getBucket(key);
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        bucket.addLast(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(getEntry(key));
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }
    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null)
            for (var entry : bucket)
                if (entry.key == key)
                    return entry;

        return null;
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
