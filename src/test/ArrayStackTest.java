package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import Datastructure.Stack;
import Datastructure.Stack.Node;

public class ArrayStackTest {


        @Test
        public void testStack() {
            Stack stack = new Stack();
            
            stack.push(1);
            stack.push(2);
            Node node = stack.pop();
            assertThat(node.d, is(2));
            node = stack.pop();
            assertThat(node.d, is(1));
            
        }
    
        @Test //(expected=IndexOutOfBoundsException.class)
        public void testException() {
            
            Stack stack = new Stack();
            
            Node node = stack.pop();
            assertThat(node.d, is(0));
        }

}
