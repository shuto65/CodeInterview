package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import Datastructure.TripleArrayStack;

public class TripleArrayStackTest {

    @Test
    public void test_stack0() {
        TripleArrayStack baseArray = new TripleArrayStack(3, 3, 3);
        baseArray.push(0, 1);
        baseArray.push(0, 2);
        
        int _actual;
        _actual = baseArray.pop(0);
        assertThat(_actual, is(2));
        
        _actual = baseArray.pop(0);
        assertThat(_actual, is(1));
    }

    @Test
    public void test_stack1() {
        TripleArrayStack baseArray = new TripleArrayStack(3, 3, 3);
        baseArray.push(1, 1);
        baseArray.push(1, 2);
        
        int _actual;
        _actual = baseArray.pop(1);
        assertThat(_actual, is(2));
        
        _actual = baseArray.pop(1);
        assertThat(_actual, is(1));
    }
    
    @Test
    public void test_stack2() {
        TripleArrayStack baseArray = new TripleArrayStack(3, 3, 3);
        baseArray.push(2, 1);
        baseArray.push(2, 2);
        
        int _actual;
        _actual = baseArray.pop(2);
        assertThat(_actual, is(2));
        
        _actual = baseArray.pop(2);
        assertThat(_actual, is(1));
    }

   
    @Test  (expected=ArrayIndexOutOfBoundsException.class)
    public void test_tripleArrayStack0_Exception() {
        TripleArrayStack baseArray = new TripleArrayStack(1, 1, 1);
        baseArray.push(0, 1);
        baseArray.push(0, 2);
        
    }

    @Test  (expected=ArrayIndexOutOfBoundsException.class)
    public void test_tripleArrayStack1_Exception() {
        TripleArrayStack baseArray = new TripleArrayStack(1, 1, 1);
        baseArray.push(1, 1);
        baseArray.push(1, 2);
        
    }

    @Test  (expected=IndexOutOfBoundsException.class)
    public void test_tripleArrayStack2_Exception() {
        TripleArrayStack baseArray = new TripleArrayStack(1, 1, 1);
        baseArray.push(2, 1);
        baseArray.push(2, 2);
        
    }

}
