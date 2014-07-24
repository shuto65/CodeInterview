package test.MyQueue;

import Datastructure.MyQueue.myQueue;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class myQueueTest {


    @Test
    public void testStack() {

        myQueue myqueue = new myQueue();

        myqueue.enqueue(19);
        myqueue.enqueue(10);
        myqueue.enqueue(5);

        Object _actual;
        _actual = myqueue.dequeue();
        assertEquals(_actual, 19);
        _actual = myqueue.dequeue();
        assertEquals(_actual, 10);
        _actual = myqueue.dequeue();
        assertEquals(_actual, 5);

    }

    @Test// (expected=IndexOutOfBoundsException.class)
    public void testEnqueueAndDequeueAlternative() {

        myQueue myqueue = new myQueue();

        myqueue.enqueue(19);
        myqueue.enqueue(10);
        myqueue.enqueue(5);

        Object _actual;
        _actual = myqueue.dequeue();
        assertEquals(_actual, 19);
        _actual = myqueue.dequeue();
        assertEquals(_actual, 10);

        myqueue.enqueue(3);
        myqueue.enqueue(2);

        _actual = myqueue.dequeue();
        assertEquals(_actual, 5);
        _actual = myqueue.dequeue();
        assertEquals(_actual, 3);
    }

    @Test(expected = EmptyStackException.class)
    public void testException() {

        myQueue myqueue = new myQueue();

        myqueue.enqueue(19);
        myqueue.enqueue(10);
        myqueue.enqueue(5);

        myqueue.dequeue();
        myqueue.dequeue();
        myqueue.dequeue();
        myqueue.dequeue();

    }

}
