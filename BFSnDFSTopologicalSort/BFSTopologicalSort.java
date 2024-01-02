package com.company;

import java.util.*;
public class BFSTopologicalSort{
    static class Graph {

        private int V; // Number of vertices

        private ArrayList<ArrayList<Integer>> adj_list;
        private int char_input = 0;
        private static char initial_char;
        private static int initial_int = 0;

        Graph(int v) {
            V = v;
            adj_list = new ArrayList<ArrayList<Integer>>(v);
            for (int i = 0; i < v; ++i)
                adj_list.add(new ArrayList<Integer>());
        }

        // Function to add an edge into the graph when nodes are Integers
        void addEdge(int u, int v) {
            u = u - initial_int;
            v = v - initial_int;
            adj_list.get(u).add(v);
        }

        // Function to add an edge into the graph when nodes are characters
        void addEdgeChar(char u, char v) {
            char_input = 1;
            int au = (int) u - (int) initial_char;
            int av = (int) v - (int) initial_char;
            adj_list.get(au).add(av);
        }

        //function to do topological sort by BFS
        void topoSortBFS() {

            //array to store indegree of all vertices
            int indegree[] = new int[V];

            for (int i = 0; i < V; i++) {
                for (int node : adj_list.get(i)) {
                    indegree[node]++;
                }
            }

            // queue to add all vertices with indegree 0
            Queue<Integer> q  = new LinkedList<Integer>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0)
                    q.add(i);
            }

            // to keep count of visited vertices to check cycle
            int count = 0;

            // resultList to store values as per topological order
            ArrayList<Integer> resultList = new ArrayList<Integer>();
            while (!q.isEmpty()) {
                //dequeue and adding it to the resultList
                int n = q.poll();
                resultList.add(n);

                // Iterating through all the neighbouring nodes
                // of dequeued node n and decrease their in-degree by 1
                for (int node : adj_list.get(n)) {
                    indegree[node] = indegree[node] - 1;
                    // If in-degree becomes zero,adding it to queue
                    if (indegree[node] == 0)
                        q.add(node);
                }
                count++;
            }

            // Checking if there exists a cycle
            if (count != V) {
                System.out.println("\nThere exists a cycle in the given graph, so topological sort is not possible\n\n");
                return;
            }

            // Printing topological order
            if (char_input == 1) {
                for (int i : resultList) {
                    System.out.print((char) (i + (int) initial_char) + " ");
                }
                System.out.println("\n\n");
            }else{
                for (int i : resultList) {
                    System.out.print(i + initial_int + " ");
                }
                System.out.println("\n\n");
            }
        }
    }


// Main function
public static void main(String args[])
{

    BFSTopologicalSort.Graph g1 = new BFSTopologicalSort.Graph(8);
    //if vertices starts from non zero integer, please give the intial integer vertex to convert vertices to 0 to V
    BFSTopologicalSort.Graph.initial_int = 1;

    g1.addEdge(1, 2);
    g1.addEdge(1, 5);
    g1.addEdge(1, 6);
    g1.addEdge(2, 5);
    g1.addEdge(2, 3);
    g1.addEdge(2, 7);
    g1.addEdge(3, 4);
    g1.addEdge(4, 5);
    g1.addEdge(5, 7);
    g1.addEdge(5, 8);
    g1.addEdge(6, 5);
    g1.addEdge(6, 8);
    g1.addEdge(7, 4);
    g1.addEdge(7, 8);

    System.out.println("\nBFS Topological sort of the given graph in IMAGE 1  is as below: \n");
    g1.topoSortBFS();


    BFSTopologicalSort.Graph g2 = new BFSTopologicalSort.Graph(14);
    //if giving char type nodes, please give the intial char node to convert node to 0 to V
    BFSTopologicalSort.Graph.initial_char = 'm';

    g2.addEdgeChar('m', 'q');
    g2.addEdgeChar('m', 'r');
    g2.addEdgeChar('m', 'x');
    g2.addEdgeChar('n', 'o');
    g2.addEdgeChar('n', 'q');
    g2.addEdgeChar('n', 'u');
    g2.addEdgeChar('o', 'r');
    g2.addEdgeChar('o', 'v');
    g2.addEdgeChar('o', 's');
    g2.addEdgeChar('p', 'o');
    g2.addEdgeChar('p', 's');
    g2.addEdgeChar('p', 'z');
    g2.addEdgeChar('q', 't');
    g2.addEdgeChar('r', 'u');
    g2.addEdgeChar('r', 'y');
    g2.addEdgeChar('s', 'r');
    g2.addEdgeChar('u', 't');
    g2.addEdgeChar('v', 'w');
    g2.addEdgeChar('v', 'x');
    g2.addEdgeChar('w', 'z');
    g2.addEdgeChar('y', 'v');

    System.out.println("\nBFS Topological sort of the given graph in IMAGE 2  is as below: \n\n");
    g2.topoSortBFS();


}
}
