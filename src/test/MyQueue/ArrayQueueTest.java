package test.MyQueue;

import Datastructure.MyQueue.ArrayQueue;
import Datastructure.MyQueue.EmptyQueueException;
import Datastructure.MyQueue.FullQueueException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArrayQueueTest {
    ArrayQueue<Integer> queue;

    @Before
    public void setup(){
        queue = new ArrayQueue(5);
    }
/*
    @Test
    public void testEnqueue() {
        queue.enqueue(5);

        int _actual = queue.get(0);

        assertThat(_actual, is(5));
    }
*/
    @Test
    public void testSimpleDequeue() {
        queue.enqueue(10);

        int _actual = queue.dequeue();

        assertThat(_actual, is(10));
    }

    @Test(expected=EmptyQueueException.class)
    public void testDequeueException() {

        queue.enqueue(10);

        queue.dequeue();
        queue.dequeue();

    }

    @Test(expected=FullQueueException.class)
    public void testEnqueueException() {

        for(int i=0; i <= 5; i++){
            queue.enqueue(10);
        }
    }

    @Test
    public void testSize() {

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertThat(queue.size(), is(5));
    }

    @Test
    public void testSizeWhenTailSmallerThanHead() {

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);


        queue.dequeue();

        queue.enqueue(6);
        assertThat(queue.size(), is(5));

    }

}
