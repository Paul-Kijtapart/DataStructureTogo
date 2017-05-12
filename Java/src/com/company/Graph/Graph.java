package com.company.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aor on 2017-05-10.
 */
public class Graph<T> {

    // states
    List<Node> nodeList;
    Map<T, Node<T>> nodeMap;

    public Graph() {
        this.nodeMap = new HashMap<>();
        this.nodeList = new ArrayList<>();
    } // close constructor Graph

    public Node<T> createOrGetNode(T value) {
        if (this.nodeMap.containsKey(value)) {
            return this.nodeMap.get(value);
        }

        Node<T> res = new Node<>(value);
        this.nodeList.add(res);
        this.nodeMap.put(value, res);

        return res;
    }


    public static <T> Graph buildGraph(
            T[] values,
            T[][] edges,
            int[] costs
    ) {
        Graph<T> res = new Graph<>();

        res.addNodes(values);
        res.addEdges(edges, costs);

        return res;
    } // close buildGraph

    private void addNodes(T[] values) {
        for (T val : values) {
            createOrGetNode(val);
        }
    } // close addNodes


    /*
    * T[][] values input can be [ fromNode, toNode ]
    * cost[] values input can be [ 5, 0 ]
    * */
    private void addEdges(
            T[][] values,
            int[] costs
    ) {

        if (values.length != costs.length) {
            System.err.print("Some edges are missing specified cost.");
            return;
        }

        for (int i = 0; i < values.length; i++) {
            T[] currentInput = values[i];
            int currentCost = costs[i];

            Node<T> from = createOrGetNode(currentInput[0]);
            Node<T> to = createOrGetNode(currentInput[1]);
            from.addChild(to, currentCost);
        }

    } // close addEdges

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        for (Node n : nodeList) {
            sb.append(" " + n + "\n");
        }

        sb.append("\n}\n");

        return sb.toString();
    }

    class Node<T> {
        private T value;
        private Map<T, WeightedEdge<T>> childMap;
        private int dependencies;

        public Node(T value) {
            this.value = value;
            this.childMap = new HashMap<>();
        }

        public void incrementDependencies() {
            this.dependencies += 1;
        }

        public void decrementDependencies() {
            this.dependencies -= 1;
        }

        public void addChild(Node<T> to, int cost) {
            WeightedEdge<T> edge =
                    new WeightedEdge<>(cost, to);

            this.childMap.put(to.value, edge);
            to.incrementDependencies();
        }// close addChild

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", childMap=" + childMap +
                    '}';
        }
    } // close inner class Node


    class WeightedEdge<T> {
        int cost;
        Node<T> destinationNode;

        public WeightedEdge(int cost, Node<T> destinationNode) {
            this.cost = cost;
            this.destinationNode = destinationNode;
        }

        @Override
        public String toString() {
            return "{" +
                    "cost=" + cost +
                    '}';
        }
    } // close inner class WeightedEdge
} // close class Graph
