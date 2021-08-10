package com.company;

public class Stack {
    private int capacity;
    private int size;
    private int a[];
    private int top;
    Stack(int capacity)
    {
        this.capacity=capacity;
        a=new int[capacity];
        top=-1;
        size=0;
    }
    void isFull()
    {
        if(size==capacity)
        {
            capacity=2*capacity;
            int b[]=new int[capacity];
            for(int i=0;i<size;i++)
            {
                b[i]=a[i];
            }
            a=b;
        }
    }
    void push(int data)
    {
        isFull();
        top+=1;
        a[top]=data;
        size++;
    }
    void pop()
    {
        if(isEmpty())
        {
            System.out.println("Cannot pop anything from a empty stack.");
        }
        else
        {
            top-=1;
            size--;
        }
    }
    void printStack()
    {
        /**Stack printed from bottom to top*/
        if(isEmpty())
        {
            System.out.println("Cannot print a empty stack.");
            return;
        }
        for(int i=0;i<=top;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
    boolean isEmpty()
    {
        if(top==-1)
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Stack stack = new Stack(3);

        stack.push(1);
        stack.printStack();
        stack.push(2);
        stack.printStack();
        stack.push(3);
        stack.printStack();
        stack.push(4);
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();

    }
}
