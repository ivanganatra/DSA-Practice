package com.company;

import java.util.Scanner;

/**Circular Queue*/
public class Searching {
    Searching()
    {

    }
    static String linearSearch(int a[], int n, int find[], int m)
    {

        String ans="";
        for(int i=0;i<m;i++)
        {
            int num=find[i];

            //Linear search
            int flag=0;
            for(int j=0;j<m;j++)
            {
                if(a[j]==num)
                {
                    ans+="Y ";
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                ans+="N ";
            }
        }
        return ans;
    }
    public static boolean binarySearch(int a[],int n,int k,int left,int right)
    {
        int mid=(left+right)/2;
        if(left>right)
        {
            return false;
        }
        boolean isAvailable=false;
        if(a[mid]==k)
        {
            isAvailable=true;
        }
        else if(a[mid]<k)
        {
            isAvailable|=binarySearch(a,n,k,mid+1,right);
        }
        else if(a[mid]>k)
        {
            isAvailable|=binarySearch(a,n,k,left,mid-1);
        }
        return  isAvailable;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int a[]= {1,3,5,7,8};
        int n=a.length;
        for(Integer x:a)
        {
            System.out.print(x+" ");
        }
        System.out.println("");
        System.out.println("Enter the number of elements you want to search:");
        int m=sc.nextInt();
        int find[]=new int[m];
        for(int i=0;i<m;i++)
        {
            find[i]=sc.nextInt();
        }
        System.out.println(linearSearch(a,n,find,m));
        String s="";
        for(int i=0;i<n;i++)
        {
            if(binarySearch(a,n,find[i],0,n-1))
            {
                s+="Y ";
            }
            else
            {
                s+="N ";
            }
        }
        System.out.println(s);
    }
}
