package com.company;
import java.util.Random;
import java.util.Scanner;

    public class LinkedList {

        Node head;

        static class Node {

            int data;
            Node next;

            Node(int d)
            {
                data = d;
                next = null;
            }
        }

        public static LinkedList insert(LinkedList list, int data)
        {
            Node new_node = new Node(data);
            new_node.next = null;

            if (list.head == null) {
                list.head = new_node;
            }
            else {
                Node last = list.head;
                while (last.next != null) {
                    last = last.next;
                }

                last.next = new_node;
            }

            return list;
        }

    static void printList(LinkedList.Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    static LinkedList.Node selectionSort(LinkedList.Node head)
    {
        LinkedList.Node node1, node2, node3, node4, tmp;

        node1 = node2 = head;

        // While node2 is not the last node
        while (node2.next != null) {

            node3 = node4 = node2.next;

            // While node4 is pointing to a valid node
            while (node4 != null) {

                if (node2.data > node4.data) {

                    // If node4 appears immediately after node2
                    if (node2.next == node4) {

                        // Case 1: node2 is the head of the linked list
                        if (node2 == head) {

                            // Moving node4 before node2
                            node2.next = node4.next;
                            node4.next = node2;

                            // Swapping node2 and node4 pointers
                            tmp = node2;
                            node2 = node4;
                            node4 = tmp;

                            node3 = node4;

                            // Updating the head
                            head = node2;

                            // Skipping to the next element
                            // as it is already in order
                            node4 = node4.next;
                        }

                        // Case 2: node2 is not the head of the linked list
                        else {

                            // Moving node4 before node2
                            node2.next = node4.next;
                            node4.next = node2;
                            node1.next = node4;

                            // Swapping node2 and node4 pointers
                            tmp = node2;
                            node2 = node4;
                            node4 = tmp;

                            node3 = node4;

                            // Skipping to the next element
                            // as it is already in order
                            node4 = node4.next;
                        }
                    }

                    // If node2 and node4 have some nodes in between them
                    else {

                        // Case 3: node2 is the head of the linked list
                        if (node2 == head) {

                            // Swapping node2.next and node4.next
                            tmp = node2.next;
                            node2.next = node4.next;
                            node4.next = tmp;
                            node3.next = node2;

                            // Swapping node2 and node4 pointers
                            tmp = node2;
                            node2 = node4;
                            node4 = tmp;

                            node3 = node4;

                            // Skipping to the next element
                            // as it is already in order
                            node4 = node4.next;

                            // Update the head
                            head = node2;
                        }

                        // Case 4: node2 is not the head of the linked list
                        else {

                            // Swapping node2.next and node4.next
                            tmp = node2.next;
                            node2.next = node4.next;
                            node4.next = tmp;
                            node3.next = node2;
                            node1.next = node4;

                            // Swapping node2 and node4 pointers
                            tmp = node2;
                            node2 = node4;
                            node4 = tmp;

                            node3 = node4;

                            // Skip to the next element
                            // as it is already in order
                            node4 = node4.next;
                        }
                    }
                }
                else {

                    // Updating node3 and skip to the next element
                    // as it is already in order
                    node3 = node4;
                    node4 = node4.next;
                }
            }

            node1 = node2;
            node2 = node2.next;
        }

        return head;
    }

        // Driver code
        public static void main(String[] args)
        {
            LinkedList list = new LinkedList();
            Scanner sc = new Scanner(System.in);
            Random rand = new Random();
            System.out.print("Enter the required number of nodes in the list: ");
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++){
                int val = rand.nextInt(100);
            list = insert(list,val);
        }
            Node new_head;
            System.out.print("list before sort: \n");
            printList(list.head);
            new_head = selectionSort(list.head);
            System.out.print("\nlist after sort: \n");
            printList(new_head);

        }
    }
