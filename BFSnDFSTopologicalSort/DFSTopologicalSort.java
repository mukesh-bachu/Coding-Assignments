package com.company;

import java.util.*;
public class DFSTopologicalSort {

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

     //recursive function for topologicalSortDFS
     void topoSortDFSRecur(int v, boolean visited[], Stack<Integer> stack) {
         // Marking the current node as visited.
         visited[v] = true;
         Integer i;

         // Recurring for all the vertices adjacent to this vertex
         Iterator<Integer> iter = adj_list.get(v).iterator();
         while (iter.hasNext()) {
             i = iter.next();
             if (!visited[i])
                 topoSortDFSRecur(i, visited, stack);
         }

         // pushing current vertex to result storing stack
         stack.push(v);
     }

     //function to do Topological Sort by DFS
     void topoSortDFS() {
         Stack<Integer> stack = new Stack<Integer>();
         ArrayList<Integer> arrli = new ArrayList<Integer>(V);

         // initially marking all the vertices as not visited
         boolean visited[] = new boolean[V];
         int cycle = 0;

         for (int i = 0; i < V; i++)
             visited[i] = false;

         // Calling the recursive function to sort
         for (int i = 0; i < V; i++)
             if (visited[i] == false)
                 topoSortDFSRecur(i, visited, stack);

         //adding the result to an arrayList to check for cycle
         while (stack.empty() == false) {
             arrli.add(stack.pop());
         }

         for (int i = 0; i < V; i++) {
             for (Integer iter : adj_list.get(i)) {
                 // If starting vertex of an edge does not come first
                 if (arrli.indexOf(i) > arrli.indexOf(iter)) {
                     cycle = 1;
                 }
             }
         }

         if (cycle == 1) {
             System.out.println("\nThere exists a cycle in the given graph, so topological sort is not possible\n\n");
         } else {
             if ( char_input == 1) {
                 for (int j = 0; j < arrli.size(); j++)
                     System.out.print((char) (arrli.get(j) + (int) initial_char) + " ");
                 System.out.println("\n\n");
             }else{
                 for (int j = 0; j < arrli.size(); j++)
                     System.out.print(arrli.get(j) + initial_int + " ");
                 System.out.println("\n\n");
             }
         }

     }
 }


// Main function
public static void main(String args[])
{
    DFSTopologicalSort.Graph g1 = new DFSTopologicalSort.Graph(8);
    //if vertices starts from non zero integer, please give the intial integer vertex to convert vertices to 0 to V
    DFSTopologicalSort.Graph.initial_int = 1;

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

    System.out.println("\nDFS Topological sort of the given graph in IMAGE 1  is as below: \n");
    g1.topoSortDFS();


    DFSTopologicalSort.Graph g2 = new DFSTopologicalSort.Graph(14);
    DFSTopologicalSort.Graph.initial_char = 'm';

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

    System.out.println("\nDFS Topological sort of the given graph in IMAGE 2  is as below: \n\n");
    g2.topoSortDFS();

}
}