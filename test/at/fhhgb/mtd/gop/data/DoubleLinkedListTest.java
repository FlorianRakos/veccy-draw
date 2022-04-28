package at.fhhgb.mtd.gop.data;

import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Shape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    DoubleLinkedList testList = new DoubleLinkedList();
    Shape shape = new Circle(1,2, 3);


    @Test
    void get() {
        testList.append(shape);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testList.get(1));
    }

    @Test
    void removeFirst() {
        Assertions.assertThrows(NoSuchElementException.class, () -> testList.removeFirst());
    }

    @Test
    void peekFirst() {
        Assertions.assertThrows(NoSuchElementException.class, () -> testList.peakFirst());
    }

    @Test
    void removeLast() {
        Assertions.assertThrows(NoSuchElementException.class, () -> testList.removeFirst());
    }

    @Test
    void peakLast() {
        Assertions.assertThrows(NoSuchElementException.class, () -> testList.peakLast());
    }


}