package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import Datastructure.ArrayStack;
import Datastructure.ListQueue;
import Datastructure.Stack;
import Datastructure.Stack.Node;

public class ListQueueTest{

	 @Test
     public void testListQueue() {
		 ListQueue queue = new ListQueue();
		 
		 queue.enqueue(1);
/*
		 int _actual;
         _actual = stack.pop();
         assertThat(_actual, is(2));
         _actual = stack.pop();
         assertThat(_actual, is(1));
         */
     }
 
}
