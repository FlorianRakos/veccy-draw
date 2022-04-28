package at.fhhgb.mtd.gop.data;

import at.fhhgb.mtd.gop.veccy.shapes.Shape;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoubleLinkedList implements Iterable<Shape> {


    private Node head, tail;

    public DoubleLinkedList () {
        head = null;
        tail = null;
    }

    public void clear () {
        head = null;
        tail = null;
    }

    public void prepend(Shape val) {
        Node newNode = new Node();
        newNode.val = val;

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;

            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }

    }

    public void append(Shape val) {
        Node newNode = new Node();
        newNode.val = val;

        if (tail != null) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
    }

    public Shape get(int index) throws IndexOutOfBoundsException{
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        if (curNode == null) {
            throw new IndexOutOfBoundsException();
        }
        return curNode.val;
    }

    public Shape removeFirst () throws NoSuchElementException {
        if (head == null) throw new NoSuchElementException();
        Shape result = head.val;
        head = head.next;
        head.prev = null;
        return result;
    }

    public Shape peakFirst () throws NoSuchElementException {
        if (head == null) throw new NoSuchElementException();
        return head.val;
    }

    public Shape removeLast () throws NoSuchElementException {
        if (tail == null) throw new NoSuchElementException();
        Shape result = tail.val;
        tail = tail.prev;
        tail.next = null;

        return result;
    }

    public void remove (int index) throws IndexOutOfBoundsException {
        Node curNode;

        // select negative indices
        if (index < 0) {
            curNode = tail;
            for (int i = 0; i < -1 * index; i++) {
                curNode = curNode.prev;
            }
        // select positive indices
        } else {
            System.out.println("Index: " + index);
            curNode = head;
            for (int i = 0; i < index; i++) {
                curNode = curNode.next;
            }
        }

        if (curNode == null) {
            throw new IndexOutOfBoundsException();
        }

        // Reference to curNode is lost -> Garbage Collector
        Node next = curNode.next;
        Node prev = curNode.prev;
        if (next != null) next.prev = prev;
        if (prev != null) prev.next = next;


    }

    public Shape peakLast () throws NoSuchElementException {
        if (tail == null) throw new NoSuchElementException();
        return tail.val;
    }

    public void reverse () {
        Node curNode = head;
        head = tail;
        tail = curNode;

        while (curNode != null) {
            Node nextNode = curNode.next;
            curNode.next = curNode.prev;
            curNode.prev = nextNode;

            curNode = nextNode;
        }
    }

    public int size() {
        Node node = head;
        int x = 0;
        while(node != null) {
            x += 1;
            node = node.next;
        }
        return x;
    }

    @Override
    public Iterator<Shape> iterator() {
        return new DoubleLinkedListIterator(this.head);
    }

//    public void sort (func()) {
//
//    }

}

