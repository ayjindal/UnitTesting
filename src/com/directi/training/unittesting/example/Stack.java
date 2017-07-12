package com.directi.training.unittesting.example;

public class Stack<T>
{
    private Object[] list;
    private int top = -1;
    private int maxSize;

    public Stack(int maxSize)
    {
        list = new Object[maxSize];
        this.maxSize = maxSize;
    }

    public int size()
    {
        return top + 1;
    }

    public void push(T element)
    {
        checkOverFlow();
        list[++top] = element;
    }

    @SuppressWarnings("unchecked")
    public T pop()
    {
        checkUnderFlow();
        T element = (T) list[top];
        list[top] = null;
        top--;
        return element;
    }

    @SuppressWarnings("unchecked")
    public T peek()
    {
        checkUnderFlow();
        return (T) list[top];
    }

    public boolean exist(T element)
    {
        if (element == null) {
            return false;
        } else {
            for (Object item : list) {
                if (element.equals(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkOverFlow()
    {
        if (size() == maxSize) {
            throw new StackOverFlowException();
        }
    }

    private void checkUnderFlow()
    {
        if (size() == 0) {
            throw new StackUnderFlowException();
        }
    }
}
