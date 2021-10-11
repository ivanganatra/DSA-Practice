package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

public class Trees {
    static class Tree{
        int data=-1;
        Tree left=null;
        Tree right=null;
        Tree(){}
        Tree(int num){
            this.data=num;
        }
    }
    static Tree tree;
    static void insert(Tree tree, int num)
    {
        if(tree==null)
        {
            tree=new Tree(num);
            return;
        }
        if(num<=tree.data)
        {
           if(tree.left==null)
           {
               tree.left=new Tree(num);
           }
           else
           {
               insert(tree.left,num);
           }
        }
        else if(num>tree.data)
        {
            if(tree.right==null)
            {
                tree.right=new Tree(num);
            }
            else
            {
                insert(tree.right,num);
            }
        }
    }
    static boolean search(Tree tree, int num)
    {
        if(tree==null)
        {
            return false;
        }
        if(num==tree.data)
        {
            return true;
        }
        if(num<=tree.data)
        {
            if(tree.left==null)
            {
                tree.left=new Tree(num);
            }
            else
            {
                return search(tree.left,num);
            }
        }
        else if(num>tree.data)
        {
            if(tree.right==null)
            {
                tree.right=new Tree(num);
            }
            else
            {
                return search(tree.right,num);
            }
        }
        return false;
    }
//    static boolean delete(Tree tree, int num.int direction)
//    {
//        if(tree==null)
//        {
//            return false;
//        }
//        if(num==tree.data)
//        {
//            if(direction==0)
//            {
//
//            }
//            return true;
//        }
//        if(num<=tree.data)
//        {
//            if(tree.left==null)
//            {
//                tree.left=new Tree(num);
//            }
//            else
//            {
//                return search(tree.left,num);
//            }
//        }
//        else if(num>tree.data)
//        {
//            if(tree.right==null)
//            {
//                tree.right=new Tree(num);
//            }
//            else
//            {
//                return search(tree.right,num);
//            }
//        }
//        return false;
//    }
    public static void main(String args[])
    {
        int n;
        Scanner sc=new Scanner(System.in);
        int a[]={10,6,4,45,23,54,12};
        n=a.length;
        tree = new Tree();
        for(int i=0;i<n;i++)
        {
            insert(tree,a[i]);
        }
        int searchElements[] = new int[]{5,6,4,25,99,1,23};
        for(Integer x:searchElements)
        {
            System.out.printf("Is %d present in the tree ? %B\n",x, search(tree,x));
        }
        int deletElement[]=searchElements;
        for(Integer x:searchElements)
        {
//            delete(tree,x,null);
            System.out.println("The element "+x+ " isdeleted from the tree.");
            System.out.printf("Is %d present in the tree ? %B\n",x, search(tree,x));
        }
    }
}
