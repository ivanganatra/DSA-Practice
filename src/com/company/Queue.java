package com.company;

/**Circular Queue*/
public class Queue {
    private int size;
    private int a[];
    private int front;
    private int back;
    Queue(int size)
    {
        this.size=size;
        a=new int[size];
        front=-1;
        back=-1;
    }
    void isFull()
    {
        //if back+1==front
        if((back+1)%size==(front)%size)
        {
            //create another array
            int b[]=new int[2*size];
            int j=0;

            //Copy the array
            for(int i=(front);i!=back;i=(i+1)%size,j++)
            {
                b[j]=a[i];
            }
            b[j]=a[back];
            front=0;
            back=size-1;
            size=2*size;
            a=b;
        }
    }
    void enQueue(int data)
    {
        //If full then double the size of array
        isFull();

        //If array is empty
        if(front==-1 && back==-1)
        {
            front=(front+1)%size;
            back=(back+1)%size;
        }
        else
        {
            back=(back+1)%size;
        }
        a[back]=data;
    }
    void deQueue()
    {
        if(isEmpty())
        {
            System.out.println("Cannot dequeue anything from a empty queue.");
        }
        else
        {
            //get to the starting position of the array
            if(front==back)
            {
                front=-1;
                back=-1;
            }
            else
            {
                front=(front+1)%size;
            }
        }
    }
    void printQueue()
    {
        //Queue printed from front to end
        if(isEmpty())
        {
            System.out.println("Cannot print a empty queue.");
            return;
        }
        for(int i=front;i!=back;i=(i+1)%size)
        {
            System.out.print(a[i]+" ");
        }
        System.out.print(a[back]+" ");
        System.out.println("");
    }
    boolean isEmpty()
    {
        if(front==-1)
        {
            front=-1;
            back=-1;
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
