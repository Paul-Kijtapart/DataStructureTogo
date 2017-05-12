package com.company.DijkstraAlgorithm;

import com.company.Graph.Graph;
import com.company.Graph.Graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by aor on 2017-05-11.
 */
public class Dijkstra {

    private Dijkstra() {}

    public static <T> List<Node> getShortestPath(
            Graph<T> graph,
            Node startNode,
            Node endNode
    ) {

        if (startNode == null || endNode == null) {
            System.err.println("startNode or endNode is null.");
            return null;
        }

        if (!graph.contains(startNode) || !graph.contains(endNode)) {
            System.err.println("startNode or endNode doesn't exist in the graph");
            return null;
        }

        if (graph.isEmpty()) {
            System.err.println("Graph is empty");
            return null;
        }

        List<Node> res = new ArrayList<>();
        Map<Node, Integer> costMap = getInitCostMap(graph);
        Map<Node, Node> nodeParentMap = getInitialNodeParentMap(graph);

        // Look at startNode First

        return res;
    } // close getShortestPath

    private static <T> Map<Node, Node> getInitialNodeParentMap(Graph<T> graph) {
        Map<Node, Node> res =
                new HashMap<>();
        List<Node> nodeList = graph.getNodeList();
        for (Node node : nodeList) {
            res.put(node, null);
        }
        return res;
    } // close getInitialNodeParentMap

    private static <T> Map<Node, Integer> getInitCostMap(Graph<T> graph) {
        Map<Node, Integer> res =
                new HashMap<>();

        List<Node> nodeList = graph.getNodeList();
        for (Node node : nodeList) {
            res.put(node, Integer.MAX_VALUE);
        }
        return res;
    } // close getInitialCostMap




} // close class Dijkstra
