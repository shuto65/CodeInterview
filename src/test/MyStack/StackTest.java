package test.MyStack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import Datastructure.MyStack.ArrayStack;

public class StackTest {


        @Test
        public void testStack() {
            ArrayStack stack = new ArrayStack(5);
            
            stack.push(1);
            stack.push(2);
            
            int _actual;
            _actual = stack.pop();
            assertThat(_actual, is(2));
            _actual = stack.pop();
            assertThat(_actual, is(1));
        }
    
        @Test (expected=IndexOutOfBoundsException.class)
        public void testException() {
            
            ArrayStack stack = new ArrayStack(1);
            
            stack.pop();
            stack.pop();

            //assertThat(node.d, is(0));
        }

}
