package at.fhhgb.mtd.gop.data;

public class DoubleLinkedList {


    private Node head, tail;

    public DoubleLinkedList () {
        head = null;
        tail = null;
    }

    public void clear () {
        head = null;
        tail = null;
    }

    public void prepend(int val) {
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

    public void append(int val) {
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

    public int get(int index) {
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        if (curNode == null) return Integer.MIN_VALUE;
        return curNode.val;
    }

    public int removeFirst () {
        int result = head.val;
        head = head.next;
        head.prev = null;

        return result;

    }

    public int peakFirst () {
        return head.val;
    }

    public int removeLast () {
        int result = tail.val;
        tail = tail.prev;
        tail.next = null;

        return result;
    }

    public int peakLast () {
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




//    public void prepend(int val) {
//        Node newNode = new Node();
//        newNode.value = val;
//
//        if (this.head == null) {
//            this.head = newNode;
//            this.tail = newNode;
//            return;
//        }
//
//        this.head.prev = newNode;
//        newNode.next = this.head;
//        this.head
//    }
//
//    // müsste passen
//    public void append(int val) {
//        Node newNode = new Node();
//        newNode.value = val;
//
//        // Liste ist leer
//        if(this.tail == null) {
//            this.head = newNode;
//            this.tail = newNode;
//            return;
//        }
//
//        //Liste nicht leer, also tail != null
//        this.tail.next = newNode;
//        newNode.prev = this.tail;
//        if(this.head == this.tail) {
//            this.head = this.tail;
//        }
//        this.tail = newNode;
//
//
//
//    }
//    //Wie viele Elemente in Liste liegen
//    public int size() {
//        Node node = this.head;
//        int x = 0;
//        while(node != null) {
//            x += 1;
//            node = node.next;
//        }
//        return x;
//    }
}
