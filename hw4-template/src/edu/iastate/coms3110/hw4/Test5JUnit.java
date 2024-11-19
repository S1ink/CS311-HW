package edu.iastate.coms3110.hw4;

// import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

// import static org.junit.jupiter.api.Assertions.assertEquals;

//Source: https://www.youtube.com/watch?v=pVfj6mxhdMw

public class Test5JUnit {

    // @Test
    public static void testDijkstrasDisconnectedGraph() {
        Graph<String> g = new DirectedGraph<String>();
        String v1 = "a", v2 = "b", v3 = "c",v4 = "d", v5 = "e";

        Map<Tuple<String, String>, Double> weights = new HashMap<>();
        addUndirectedEdge(g, v1, v2, 6.0, weights);
        addUndirectedEdge(g, v1, v4, 1.0, weights);
        addUndirectedEdge(g, v2, v3, 5.0, weights);
        addUndirectedEdge(g, v2, v4, 2.0, weights);
        addUndirectedEdge(g, v2, v5, 2.0, weights);
        addUndirectedEdge(g, v3, v5, 5.0, weights);
        addUndirectedEdge(g, v4, v5, 1.0, weights);

        var distsAndPreds = g.dijkstras(v1, weights);

        Map<String, Double> expectedDistances = new HashMap<>();
        expectedDistances.put("a", 0.0);
        expectedDistances.put("b", 3.0);
        expectedDistances.put("c", 7.0);
        expectedDistances.put("d", 1.0);
        expectedDistances.put("e", 2.0);

        Map<String, String> expectedPredecessors = new HashMap<>();
        expectedPredecessors.put("a", null);
        expectedPredecessors.put("b", "d");
        expectedPredecessors.put("c", "e");
        expectedPredecessors.put("d", "a");
        expectedPredecessors.put("e", "d");


        System.out.println("TEST 5");
        System.out.println("\tDistances correct?: " + expectedDistances.equals(distsAndPreds.getFirst()));
        System.out.println("\tExploration correct?: " + expectedPredecessors.equals(distsAndPreds.getSecond()));
    }

    public static void addUndirectedEdge(Graph<String> g, String v1, String v2, Double edgeWeight, Map<Tuple<String, String>, Double> weights) {
        g.addVertex(v1);
        g.addVertex(v2);
        g.addEdge(v1, v2); // Add edge v1 -> v2
        g.addEdge(v2, v1); // Add edge v2 -> v1
        weights.put(Tuple.create(v1, v2), edgeWeight);
        weights.put(Tuple.create(v2, v1), edgeWeight);
    }
}