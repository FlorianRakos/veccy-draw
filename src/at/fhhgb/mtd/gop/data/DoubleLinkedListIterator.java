package at.fhhgb.mtd.gop.data;

import at.fhhgb.mtd.gop.veccy.shapes.Shape;

import java.util.Iterator;

public class DoubleLinkedListIterator implements Iterator<Shape> {
    private Node head;
    private Node currentNode;

    public DoubleLinkedListIterator(Node head) {
        this.head = head;
        this.currentNode = head;
    }

    @Override
    public boolean hasNext() {
        return currentNode.next != null;
    }

    @Override
    public Shape next() {
        currentNode = currentNode.next;
        return currentNode.val;
    }
}
