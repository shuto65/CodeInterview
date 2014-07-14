package test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import sun.plugin.dom.exception.InvalidStateException;

import org.junit.Test;

import Datastructure.ListQueue;

public class ListQueueTest{

	 @Test
     public void testListQueue() {
		 ListQueue queue = new ListQueue();
		 
		 queue.enqueue(19);
         queue.enqueue(10);
         queue.enqueue(5);

         int _actual;
         _actual = queue.dequeue();
         assertThat(_actual, is(19));
         _actual = queue.dequeue();
         assertThat(_actual, is(10));
         _actual = queue.dequeue();
         assertThat(_actual, is(5));

     }

    @Test(expected=InvalidStateException.class)
    public void testQueueException() {
        ListQueue queue = new ListQueue();

        queue.enqueue(19);
        queue.enqueue(10);
        queue.enqueue(5);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();



    }


    @Test
    public void testEnqueueWhileSomeDequeued() {
        ListQueue queue = new ListQueue();

        queue.enqueue(19);
        queue.enqueue(10);
        queue.enqueue(5);

        int _actual;
        _actual = queue.dequeue();
        assertThat(_actual, is(19));
        _actual = queue.dequeue();
        assertThat(_actual, is(10));

        queue.enqueue(10);
        queue.enqueue(5);

        _actual = queue.dequeue();
        assertThat(_actual, is(5));
        _actual = queue.dequeue();
        assertThat(_actual, is(10));
    }
}
