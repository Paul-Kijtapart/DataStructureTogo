package com.company;

import com.company.Graph.Graph;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] values = {"start", "a", "b", "fin"};
        String[][] edges = {
                {"start", "a"},
                {"start", "b"},
                {"b", "a"},
                {"b", "fin"},
                {"a", "fin"}
        };
        int[] costs = {6, 2, 3, 5, 1};
        Graph<String> graph = Graph.buildGraph(values, edges, costs);
        System.out.println(graph);
    }
}
