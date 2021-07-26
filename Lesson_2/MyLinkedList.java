package Interview.Lesson_2;

import java.util.Iterator;

public class MyLinkedList<E> {

    protected int size;
    protected Node<E> firstElement; //001[005]

    public void insertFirst(E value) {
        Node<E> newNode = new Node<>(value, firstElement); // 002[007] | 002[..next->005]
        firstElement = newNode; //001[007]
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedElement = firstElement;
        E data = removedElement.item;

        firstElement = firstElement.next;
        removedElement.next = null;
        removedElement.item = null;

        size--;
        return data;
    }

    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        }
        else {
            previous.next = current.next;
        }

        current.next = null;
        current.item = null;

        size--;
        return true;
    }

    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void display() {
        System.out.println("-----------");
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("-----------");
    }

    public E getFirst() {
        return firstElement.item;
    }

    public Node<E> getFirstElement() {
        return firstElement;
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator<>(this);
    }

    private static class LinkedListIterator<E> implements Iterator<E> {

        private final MyLinkedList<E> list;

        private Node<E> current;
        private Node<E> previous;

        public LinkedListIterator(MyLinkedList<E> list) {
            this.list = list;
            reset();
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E nextValue = current.item;
            previous = current;
            current = current.next;
            return nextValue;
        }

        public void remove() {
            if (previous == null){
                list.firstElement = current.next;
                reset();
            } else {
                previous.next = current.next;
                if ( !hasNext() ) {
                    reset();
                } else {
                    current = current.next;
                }
            }
        }

        public void reset() {
            current = list.firstElement;
            previous = null;
        }

        public void insertBefore(E value) {
            Node<E> newItem = new Node<>(value, null);
            if(previous == null) {
                newItem.next = list.firstElement;
                list.firstElement = newItem;
                reset();
            }
            else {
                newItem.next = previous.next;
                previous.next = newItem;
                current = newItem;
            }

        }

        public void insertAfter(E value) {
            Node<E> newItem = new Node<>(value, null);
            if (list.isEmpty()){
                list.firstElement = newItem;
                current = newItem;
            } else {
                newItem.next = current.next;
                current.next = newItem;
                next();
            }
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
