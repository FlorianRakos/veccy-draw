package at.fhhgb.mtd.gop.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    DoubleLinkedList testList = new DoubleLinkedList();


    @Test
    void clear() {
    testList.append(20);
    testList.append(10);
    testList.clear();
    assertEquals(0,testList.size());

    //System.out.println(testList.peakFirst());

    }

    @Test
    void prepend() {
        testList.prepend(5);
        testList.prepend(10);
        assertEquals(10,testList.peakFirst());
    }

    @Test
    void append() {
        testList.append(5);
        testList.append(10);
        assertEquals(10, testList.peakLast());
    }

    @Test
    void get() {
        testList.append(5);
        testList.append(10);
        testList.prepend(-5);
        assertEquals(5, testList.get(1));
    }

    @Test
    void removeFirst() {
        testList.append(3);
        testList.append(4);
        testList.removeFirst();
        assertEquals(4,testList.peakFirst());
    }

    @Test
    void peekFirst() {
        testList.append(7);
        testList.prepend(2);
        assertEquals(2,testList.peakFirst());
    }

    @Test
    void removeLast() {
        testList.append(3);
        testList.append(4);
        testList.append(5);
        testList.removeLast();
        assertEquals(4,testList.peakLast());
    }

    @Test
    void peakLast() {
        testList.append(4);
        testList.append(5);
        assertEquals(5,testList.peakLast());
    }

    @Test
    void reverse() {
        testList.append(3);
        testList.append(4);
        testList.append(5);
        testList.reverse();

        assertEquals(5,testList.peakFirst());
        assertEquals(3,testList.peakLast());
    }

    @Test
    void size() {
        assertEquals(0,testList.size());
        testList.append(3);
        testList.append(10);
        assertEquals(2,testList.size());
    }
}