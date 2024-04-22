import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private T[] elements; // Define the type of elements array
    private int lastIndex;

    public Stack() {
        elements = (T[]) new Object[1]; // Cast the Object array to T[]
        lastIndex = 0;
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public int length() {
        return lastIndex;
    }

    public void push(T item) throws FullStackException {
        if (lastIndex == elements.length) {
            // The stack is full
            throw new FullStackException("The stack is full");
        }
        elements[lastIndex] = item;
        lastIndex++;
    }

    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            // The stack is empty
            throw new EmptyStackException("The stack is empty");
        }

        T item = elements[--lastIndex];
        elements[lastIndex] = null;
        if (lastIndex > 0 && lastIndex == elements.length / 4) {
            resize(elements.length / 2);
        }
        return item;
    }

    private void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < lastIndex; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = lastIndex - 1; // Start from the top of the stack

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements in the stack");
                }
                return elements[index--];
            }
        };
    }
}
