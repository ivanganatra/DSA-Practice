package com.company;

public class LinkedList {

    class Node{
        int data=-1;
        Node next=null;
        Node(){}
        Node(int data)
        {
            this.data=data;
        }
    };
    Node head;
    LinkedList()
    {
    }
    void insertAtEnd(int data)
    {
        if(head==null)
        {
            head=new Node(data);
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=new Node(data);
        }
    }
    void insertAtBeginning(int data)
    {
        if(head==null)
        {
            head=new Node(data);
        }
        else
        {
            Node temp=head;
            head=new Node(data);
            head.next=temp;
        }
    }
    void printList()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println(" ");
    }
    void insertAfter(Node node,int data)
    {
        if(node==null)
        {
            System.out.println("This node is null.");
            return;
        }
        if(node.next==null)
        {
            node.next=new Node(data);
        }
        else
        {
            Node temp=node.next;
            node.next=new Node(data);
            node.next.next=temp;
        }
    }
    void deleteAtBeginning()
    {
        if(head==null)
        {
            System.out.println("Cannot delete anything from a empty list.");
            return;
        }
        head=head.next;
    }
     void deleteAtEnd()
    {
        if(head==null)
        {
            System.out.println("Cannot delete anything from a empty list.");
            return;
        }
        if(head.next==null)
        {
            head=null;
            return;
        }
        Node temp=head;
        while(temp.next.next!=null)
        {
            temp=temp.next;
        }
        temp.next=null;
    }

    /**Removes the first node having this data*/
    void deleteDataNode(int data)
    {
        if(head==null)
        {
            System.out.println("Cannot find and delete anything from a empty list.");
            return;
        }
        if(head.data==data)
        {
            head=head.next;
            return;
        }
        Node temp=head;
        Node prev=null;
        while(temp!=null)
        {
            if(temp.data==data)
            {
                prev.next=temp.next;
                return;
            }
            prev=temp;
            temp=temp.next;
        }
        System.out.println("This element is not present in the list.");
    }
    boolean search(int data)
    {
        if(head==null)
        {
            return false;
        }
        Node temp=head;
        while(temp!=null)
        {
            if(temp.data ==data)
            {
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public  static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(3);
        list.insertAtEnd(4);
        list.insertAfter(list.head, 5);
        System.out.println("Linked list: ");
        list.printList();
        System.out.println("\nAfter deleting an element: ");
        list.deleteAtBeginning();
        list.printList();
        System.out.println();
        list.deleteDataNode(1);
        int item_to_find = 4;
        if (list.search(item_to_find))
            System.out.println(item_to_find + " is found");
        else
            System.out.println(item_to_find + " is not found");
        list.printList();
        list.deleteAtEnd();
        list.printList();

    }
}
