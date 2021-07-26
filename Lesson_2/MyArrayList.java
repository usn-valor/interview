package Interview.Lesson_2;

import java.util.Arrays;

public class MyArrayList<E extends Comparable<? super E>> {

    protected E[] data;
    protected int size;

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
    }

    public void insert(E value, int index) {
        doInsert(value, index);
    }

    protected void doInsert(E value, int index) {
        checkAndGrow();
        if (index == size) {
            add(value);
        }
        else {
            checkIndex(index);
//            for (int i = size - 1; i >= index; i--) {
//                data[i + 1] = data[i];
//            }
            if (size - index >= 0)  {
                System.arraycopy(data, index, data, index + 1, size - index);
            }
            data[index] = value;
            size++;
        }
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public boolean remove(E value) {
        int index = indexOf(value);
        return index != -1 && (remove(index) != null);
    }

    public E remove(int index) {
        checkIndex(index);

        E removedValue = data[index];
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }

        data[size - 1] = null;
        size--;
        return removedValue;
    }

    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void display() {
        System.out.println(toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size > 0) {
            sb.append(data[size - 1]);
        }
        sb.append("]");
        return sb.toString();
    }

    private void swap(int indexA, int indexB) {
        E temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("SWW");
        }
    }

    protected void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, calculateNewLength());
        }
    }

    private int calculateNewLength() {
        return size > 0 ? size * 2 : 1;
    }
}
