package com.fundamentals.fundamentals.simpleCodingPractice;

import java.util.LinkedList;

public class MiscClass {
    
    
    private LinkedList<String> listArray[];
    
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.testPrintGraph();
        
    }
    
    private static class Graph {
        int size;
        LinkedList<Integer> adjList[];
        
        public Graph(int size) {
            this.size = size;
            adjList = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                adjList[i] = new LinkedList<Integer>();
            }
            
        }
        
        public void testPrintGraph() {
            Graph graph = new Graph(10);
            graph.addEdge(graph, 1, 2);
            graph.addEdge(graph, 2, 3);
            graph.addEdge(graph, 2, 4);
            graph.addEdge(graph, 2, 5);
            graph.addEdge(graph, 0, 4);
            graph.addEdge(graph, 0, 3);
            graph.addEdge(graph, 0, 8);
            graph.addEdge(graph, 0, 9);
            graph.addEdge(graph, 0, 7);
            graph.addEdge(graph, 0, 6);
            graph.addEdge(graph, 4, 1);
           // graph.addEdge(graph, 3, 0);
            printGraph(graph);
            
        }
        
        public void addEdge(Graph g, Integer src, int dest) {
            if (g != null) {
                g.adjList[src].add(dest);
                g.adjList[dest].add(src);
            }
            
        }
        
        private void printGraph(Graph graph) {
            
            if (graph != null) {
                for (int v = 0; v < graph.size; v++) {
                    System.out.print("The vertex " + v);
                    for (Integer x : graph.adjList[v]) {
                        System.out.print("-->" + x);
                    }
                    System.out.println("\n");
                }
            }
            
        }
    }
    
}
