package com.company;

public class HeapSort {
        public void sort(int arr[])
        {
            int n = arr.length;
            System.out.println("\n array before Heapify is\n");
            printArray(arr);

            // Building min heap
            for (int i = n / 2 - 1; i >= 0; i--) {

                heapify(arr, n, i);

            }
            System.out.println("\n array after Heapify  is\n");
            printArray(arr);

            // sorting the modified array by swapping the first and the last of latest array
            for (int i = n - 1; i > 0; i--) {

                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // calling heapify on the reduced heap
                heapify(arr, i, 0);
            }
        }


        void heapify(int arr[], int n, int i)
        {
            int smallest = i; // Initialize smallest as root
            int l = 2 * i + 1; // left = 2*i + 1
            int r = 2 * i + 2; // right = 2*i + 2

            // If left child is smaller than root
            if (l < n && arr[l] < arr[smallest])
                smallest = l;

            // If right child is smaller than smallest
            if (r < n && arr[r] < arr[smallest])
                smallest = r;

            // If smallest is not root, swap
            if (smallest != i) {
                int swap = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = swap;

                // Recursively heapify the affected sub-tree
                heapify(arr, n, smallest);
            }
        }

        /* function to print array  */
        static void printArray(int arr[])
        {
            int n = arr.length;
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }

        // Driver code
        public static void main(String args[])
        {
            int arr[] = { 12, 11, 13, 7, 15, 19, 21, 42, 53, 29, 28, 25, 36, 18, 17 };
            int n = arr.length;

            System.out.println("\n array before Heap sort is\n");
            printArray(arr);

            HeapSort a = new HeapSort();
            a.sort(arr);

            System.out.println("\n array after Heap sort is\n");
            printArray(arr);
        }
    }
