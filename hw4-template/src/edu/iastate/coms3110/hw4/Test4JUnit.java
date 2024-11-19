package edu.iastate.coms3110.hw4;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

//Source: https://www.tutorialspoint.com/design_and_analysis_of_algorithms/design_and_analysis_of_algorithms_shortest_paths.htm

public class Test4JUnit {

    // @Test
    public static void testDijkstrasDisconnectedGraph() {
        Graph<String> g = new DirectedGraph<String>();
        String v1 = "1", v2 = "2", v3 = "3", v4 = "4", v5 = "5", v6 = "6", v7 = "7", v8 = "8", v9 = "9";

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);
        g.addVertex(v8);
        g.addVertex(v9);

        Map<Tuple<String, String>, Double> weights = new HashMap<>();

        g.addEdge(v1, v2);
        weights.put(Tuple.create(v1, v2), 5.0);
        g.addEdge(v1, v3);
        weights.put(Tuple.create(v1, v3), 2.0);
        g.addEdge(v2, v4);
        weights.put(Tuple.create(v2, v4), 3.0);
        g.addEdge(v2, v5);
        weights.put(Tuple.create(v2, v5), 7.0);
        g.addEdge(v3, v2);
        weights.put(Tuple.create(v3, v2), 2.0);
        g.addEdge(v3, v7);
        weights.put(Tuple.create(v3, v7), 9.0);
        g.addEdge(v4, v3);
        weights.put(Tuple.create(v4, v3), 3.0);
        g.addEdge(v4, v5);
        weights.put(Tuple.create(v4, v5), 2.0);
        g.addEdge(v4, v7);
        weights.put(Tuple.create(v4, v7), 6.0);
        g.addEdge(v5, v6);
        weights.put(Tuple.create(v5, v6), 8.0);
        g.addEdge(v5, v7);
        weights.put(Tuple.create(v5, v7), 5.0);
        g.addEdge(v5, v8);
        weights.put(Tuple.create(v5, v8), 7.0);
        g.addEdge(v6, v9);
        weights.put(Tuple.create(v6, v9), 4.0);
        g.addEdge(v7, v8);
        weights.put(Tuple.create(v7, v8), 2.0);
        g.addEdge(v8, v6);
        weights.put(Tuple.create(v8, v6), 3.0);


        var distsAndPreds = g.dijkstras(v1, weights);

        Map<String, Double> expectedDistances = new HashMap<>();
        expectedDistances.put("1", 0.0);
        expectedDistances.put("2", 4.0);
        expectedDistances.put("3", 2.0);
        expectedDistances.put("4", 7.0);
        expectedDistances.put("5", 9.0);
        expectedDistances.put("6", 16.0);
        expectedDistances.put("7", 11.0);
        expectedDistances.put("8", 13.0);
        expectedDistances.put("9", 20.0);

        Map<String, String> expectedPredecessors = new HashMap<>();
        expectedPredecessors.put("1", null);
        expectedPredecessors.put("2", "3");
        expectedPredecessors.put("3", "1");
        expectedPredecessors.put("4", "2");
        expectedPredecessors.put("5", "4");
        expectedPredecessors.put("6", "8");
        expectedPredecessors.put("7", "3");
        expectedPredecessors.put("8", "7");
        expectedPredecessors.put("9", "6");

        System.out.println("TEST 4");
        System.out.println("\tDistances correct?: " + expectedDistances.equals(distsAndPreds.getFirst()));
        System.out.println("\tExploration correct?: " + expectedPredecessors.equals(distsAndPreds.getSecond()));
    }
}
