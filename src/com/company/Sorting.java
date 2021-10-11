package com.company;

import java.util.Collections;

public class Sorting {
    static void bubbleSort(int a[],int n)
    {
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<n-i;j++)
            {
                if(a[j-1]>a[j])
                {
                    swap(a,j,j-1);
                }
            }
        }
        printSortedArray(a,n);
    }
    static void insertionSort(int a[],int n)
    {
        for(int i=1;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(a[j]>a[j+1])
                {
                    swap(a,j,j+1);
                }
            }
        }
        printSortedArray(a,n);
    }
    static void selectionSort(int a[],int n)
    {
        for(int i=0;i<n;i++)
        {
            int min_index=i;
            for(int j=i+1;j<n;j++)
            {
                if(a[j]<a[min_index])
                {
                    min_index=j;
                }
            }
            swap(a,min_index,i);
        }
        printSortedArray(a,n);
    }
    static void shellSort(int a[],int n)
    {
        for(int gap=n/2;gap>0;gap/=2)
        {
            for(int j=gap;j<n;j++)
            {
                for(int i=j-gap;i>=0;i-=gap)
                {
                    if(a[i+gap]>a[i])
                    {
                        break;
                    }
                    else
                    {
                        swap(a,i+gap,i);
                    }
                }
            }
        }
        printSortedArray(a,n);
    }
    static void merge(int a[],int left,int right)
    {
        int b[]=new int[right-left+1];
        int mid=(left+right)/2 +1;
        int i = 0;
        int l=left,r=mid;
        while(r<=right || l<mid)
        {
            if(r>right ||((l<mid) && a[l]<a[r]))
            {
                b[i]=a[l];
                l++;
            }
            else if(l>=mid || ((r<=right) && a[l]>=a[r]))
            {
                b[i]=a[r];
                r++;
            }
            i++;
        }
        for(int j=0;j<b.length;j++)
        {
            a[j+left]=b[j];
        }
    }
    static void mergeSort(int a[],int left,int right)
    {
         if(left>=right) {
             return;
         }
         int mid=(left+right)/2;
         mergeSort(a,left,mid);
         mergeSort(a,mid+1,right);
         merge(a,left,right);
    }
    static void quickSort(int a[],int left,int right)
    {
        if(left>=right) {
            return;
        }
        int x=left+(int)((right-left+1)*Math.random());
        int pivot= a[x];
        int s=left,e=right;
        while(s<e)
        {
            while(a[s]<=pivot)
            {
                s++;
            }
            while(a[e]>pivot) {
                e--;
            }
            if(s<e)
            swap(a,s,e);
        }
        if(a[e]==pivot)
        {
            quickSort(a,left,e-1);
        }
        else
        {
            quickSort(a,left,e);
        }
        quickSort(a,e+1,right);
    }
    static void radixSort(int a[],int n)
    {
        int count[]=new int[10];
        int b[]=new int[n];
        int dpow=1;
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<10;j++)
            {
                count[j]=0;
            }
            for(int j=0;j<n;j++)
            {
                count[(a[j]/dpow)%10]++;
            }
            if(count[0]==n)
            {
                break;
            }
            for(int j=1;j<10;j++)
            {
                count[j]+=count[j-1];
            }
            for(int j=n-1;j>=0;j--)
            {
                int y=(a[j]/dpow)%10;
                b[--count[y]]=a[j];
            }
            for(int j=0;j<n;j++)
            {
                a[j]=b[j];
            }
            dpow*=10;

        }
        printSortedArray(a,n);
    }
    static void printSortedArray(int a[],int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
    static void swap(int a[],int i,int j)
    {
        int temp=a[j];
        a[j]=a[i];
        a[i]=temp;
    }
    static void copy(int a[],int b[])
    {
        for(int i=0;i<b.length;i++)
        {
            a[i]=b[i];
        }
    }
    public static void main(String[]args)
    {
        int b[]={5,6,1,2,6,4,3,5,6,7};
        int a[]=new int[b.length];
        int n=a.length;
        copy(a,b);
        bubbleSort(a,n);
        copy(a,b);
        insertionSort(a,n);
        copy(a,b);
        selectionSort(a,n);
        copy(a,b);
        shellSort(a,n);
        copy(a,b);
        a=new int[]{432,8,530,90,88,231,11,45,677,199};
        radixSort(a,a.length);
        copy(a,b);
        mergeSort(a,0,a.length-1);
        copy(a,b);
        a=new int[]{432,8,530,90,88,231,11,45,677,199};
        quickSort(a,0,a.length-1);
        printSortedArray(a,a.length);
    }
}

