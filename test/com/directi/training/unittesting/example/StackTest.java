package com.directi.training.unittesting.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackTest
{
    private Stack<Integer> stack;

    @Before
    public void setUp()
    {
        stack = new Stack<Integer>(5);
    }

    @Test
    public void createEmptyStack()
    {
        assertEquals("Stack should be empty", stack.size(), 0);
    }

    @Test
    public void shouldAllowToPushAnElementOfSpecificType()
    {
        int oldSize = stack.size();
        stack.push(1);
        assertEquals("Stack size should increase by 1", oldSize + 1, stack.size());
    }

    @Test
    public void shouldAllowToPushMultipleElements()
    {
        int oldSize = stack.size();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("Stack size should increase by the number of elements pushed", oldSize + 3,
            stack.size());
    }

    @Test
    public void shouldAllowToPopAnElement()
    {
        Integer pushedElement = 1;
        stack.push(pushedElement);
        Integer poppedElement = stack.pop();
        assertEquals("Popped and pushed element should be same", pushedElement, poppedElement);
    }

    @Test
    public void shouldReturnElementsInLIFOWhenPoppedMultipleElements()
    {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("Should return top element from the stack", new Integer(3), stack.pop());
        assertEquals("Should return top element from the stack", new Integer(2), stack.pop());
        assertEquals("Should return top element from the stack", new Integer(1), stack.pop());
    }

    @Test(expected = StackUnderFlowException.class)
    public void shouldNotAllowToPopInAnEmptyStack()
    {
        stack.pop();
    }

    @Test(expected = StackOverFlowException.class)
    public void shouldNotAllowToPushIfStackHasReachedMaxLimit()
    {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
    }

    @Test
    public void peekElementShouldReturnTopElementOfStack()
    {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("Peek element should return top element", new Integer(3), stack.peek());
    }

    @Test
    public void peekShouldNotRemoveElement()
    {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int oldSize = stack.size();
        stack.peek();
        int newSize = stack.size();
        assertEquals("Peek element should not remove element from stack", oldSize, newSize);
    }

    @Test
    public void testExistenceOfAnItem()
    {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertTrue("Element should exist", stack.exist(3));
        assertFalse("Element should NOT exist", stack.exist(10));
    }
}
