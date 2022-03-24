package at.fhhgb.mtd.gop.data;

public class DoubleLinkedList {



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
