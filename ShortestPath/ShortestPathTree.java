package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

public class ShortestPathTree {

        static int V;
        int minDistance(int d[], Boolean spt[])
        {
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < V; v++)
                if (spt[v] == false && d[v] <= min) {
                    min = d[v];
                    min_index = v;
                }

            return min_index;
        }

        void printMinDist(int src, int d[],int parent[])
        {
            System.out.println("\n\nAFTER IMPLEMENTING DIJKSTRA's ALGORITHM\n\n");
            System.out.println("source \t Vertex \t\t Minimum Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(src+" \t\t  "+ i + " \t\t\t\t\t " + d[i]);
        }
        void printEdges(int parent[])
        {
            System.out.println("\nEdges that make up the tree");
            for (int i = 0; i < V; i++)
                if (parent[i] != -1) {
                    System.out.println("(" + parent[i] + "," + i + ")");
                }
        }
        void printGraph(int graph[][])
        {
            System.out.println("Vertices in the actual graph");
            for (int i = 0; i < V; i++){
                System.out.print(" "+i+" ");
            }
            System.out.println("\nEdges in the actual graph");
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (graph[i][j] > 0){
                        System.out.println(" ("+i+","+j+") ");
                    }
        }

        // Function to implement Dijkstra's algorithm
        void dijkstra(int graph[][], int src)
        {
            V = graph.length;
            printGraph(graph);
            int d[] = new int[V]; // the shortest distance from src to i
            int parent[] = new int[V]; // parent list to track the parent

            // spt[i] will be true if vertex i is processed
            Boolean spt[] = new Boolean[V];

            // Initializing all distances as INFINITE and spt[] as false
            for (int i = 0; i < V; i++) {
                d[i] = Integer.MAX_VALUE;
                spt[i] = false;
            }

            // Distance of source vertex from itself is always 0
            d[src] = 0;
            parent[src] = -1;

            // Finding shortest path for all vertices
            for (int c = 0; c < V - 1; c++) {

                int u = minDistance(d, spt);

                // Marking the picked vertex as processed
                spt[u] = true;

                // Updating distance value of the adjacent vertices of the picked vertex.
                int v;
                for (v = 0; v < V; v++)

                    if (!spt[v] && graph[u][v] != 0 && d[u] != Integer.MAX_VALUE && d[u] + graph[u][v] < d[v]) {
                        d[v] = d[u] + graph[u][v];
                        parent[v] = u;
                    }
            }

            printMinDist(src,d,parent);
            printEdges(parent);
        }


        public static void main(String[] args)
        {
            int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0,3 },
                    { 4, 0, 8, 0, 0, 0, 0, 11, 0, 0 },
                    { 0, 8, 0, 7, 0, 4, 0, 0, 2, 0  },
                    { 0, 0, 7, 0, 9, 14, 0, 0, 0, 0  },
                    { 0, 0, 0, 9, 0, 10, 0, 0, 0, 0  },
                    { 0, 0, 4, 14, 10, 0, 2, 0, 0, 0  },
                    { 0, 0, 0, 0, 0, 2, 0, 1, 6, 0  },
                    { 8, 11, 0, 0, 0, 0, 1, 0, 7, 0  },
                    { 0, 0, 2, 0, 0, 0, 6, 7, 0, 0  },
                    { 3, 0, 0, 0, 0, 0, 0, 0, 0, 0  }};
            ShortestPathTree S = new ShortestPathTree();
            S.dijkstra(graph, 0);
        }
}
