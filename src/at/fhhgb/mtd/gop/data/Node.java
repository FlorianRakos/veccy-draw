package at.fhhgb.mtd.gop.data;

import at.fhhgb.mtd.gop.veccy.shapes.Shape;

public class Node {
    public Node next;
    public Node prev;
    public Shape val;

    public Node (Node next, Node prev, Shape val) {
        this.next = next;
        this.prev = prev;
        this.val = val;
    }

    public Node () {

    }

}
