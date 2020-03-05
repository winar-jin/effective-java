package chap2;

import java.util.Arrays;
import java.util.EmptyStackException;

public class OutOfMemory_7 {
    class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;


        Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        Object pop_memory_leak() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            return elements[--size]; // the reference to the useless item is still exist, the garbage collector will not destroy it
        }

        Object pop_right_way() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            final Object poppedObject = elements[--size];
            elements[size] = null; // !! Eliminate obsolete reference
            return poppedObject;
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }

    }
}
