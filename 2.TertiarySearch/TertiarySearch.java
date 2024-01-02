package com.company;

import java.util.Scanner;

public class TertiarySearch {
    static int tertiarySearch(int left, int right, int val, int ar[])
    {
        if (right >= left) {

            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (ar[mid1] == val) {
                return mid1;
            }
            if (ar[mid2] == val) {
                return mid2;
            }

            if (val < ar[mid1]) {

                return tertiarySearch(left, mid1 - 1, val, ar);
            }
            else if (val > ar[mid2]) {

                return tertiarySearch(mid2 + 1, right, val, ar);
            }
            else {

                return tertiarySearch(mid1 + 1, mid2 - 1, val, ar);
            }
        }

        return -1;
    }

    public static void main(String args[])
    {
        int l, r, p, val;

        int ar[] = { 11,12,13,14,15,16,17,18,19,20};
        l = 0;
        r = ar.length-1;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value you want to search: ");
        val = sc.nextInt();

        p = tertiarySearch(l, r, val, ar);

        System.out.println("Index of " + val + " is " + p);
    }

}
