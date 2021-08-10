package com.company;

/**Circular Queue*/
public class Queue {
    private int capacity;
    private int size;
    private int a[];
    private int front;
    private int rear;
    Queue(int capacity)
    {
        this.capacity=capacity;
        a=new int[capacity];
        front=-1;
        rear=-1;
        size=capacity;
    }
    void isFull()
    {
        if((rear+1)%size==(front)%size)
        {
            capacity=2*capacity;
            int b[]=new int[capacity];
            int j=0;
            for(int i=(front);i!=rear;i=(i+1)%size,j++)
            {
                b[j]=a[i];
            }
            b[j]=a[rear];
            front=0;
            rear=size-1;
            size=2*size;
            a=b;
        }
    }
    void enQueue(int data)
    {
        isFull();
        if(rear==-1)
        {
            front=(front+1)%size;
        }
        rear=(rear+1)%size;
        a[rear]=data;
    }
    void deQueue()
    {
        if(isEmpty())
        {
            System.out.println("Cannot dequeue anything from a empty queue.");
        }
        else
        {
            if(front==rear)
            {
                front=-1;
                rear=-1;
            }
            else
            {
                front=(front+1)%size;
            }
        }
    }
    void printQueue()
    {
        /**Queue printed from front to end*/
        if(isEmpty())
        {
            System.out.println("Cannot print a empty queue.");
            return;
        }
        for(int i=front;i!=rear;i=(i+1)%size)
        {
            System.out.print(a[i]+" ");
        }
        System.out.print(a[rear]+" ");
        System.out.println("");
    }
    boolean isEmpty()
    {
        if(front==-1)
        {
            front=-1;
            rear=-1;
            return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Queue q = new Queue(3);

        // deQueue is not possible on empty queue
        q.deQueue();

        // enQueue 5 elements
        q.enQueue(1);
        q.printQueue();
        q.enQueue(2);
        q.printQueue();
        q.deQueue();
        q.printQueue();
        q.deQueue();
        q.printQueue();
        q.deQueue();
        q.printQueue();
        q.enQueue(3);
        q.printQueue();
        q.enQueue(4);
        q.printQueue();
        q.deQueue();
        q.printQueue();
        q.deQueue();
        q.printQueue();
        q.deQueue();
        q.printQueue();
        q.enQueue(5);
        q.printQueue();
        q.enQueue(6);
        q.printQueue();
        q.enQueue(7);
        q.printQueue();
        q.enQueue(8);
        q.printQueue();


    }
}
