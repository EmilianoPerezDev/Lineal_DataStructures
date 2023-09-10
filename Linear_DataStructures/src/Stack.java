import java.util.Arrays;

public class Stack {

    private int[] items;
    private int count;

    public Stack(int capacity) {
        items = new int[capacity];
    }

    public void push(int item) {
        if (isFull())
            throw new StackOverflowError();

        items[count++] = item;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalArgumentException();

        return items[--count];
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalArgumentException();

        return items[count - 1];
    }

    public int min() {
        if (isEmpty())
            throw new IllegalArgumentException();

        if (count == 1)
            return items[0];

        int min = items[0];
        for (int i = 1; i < count; i++) {
            if (min < items[i])
                min = items[i];
        }

        return min;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}
