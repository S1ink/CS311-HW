package edu.iastate.coms3110.hw4;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

//0.1 + 0.2 =
public class Test3JUnit {

    // @Test
    public static void testDijkstrasDisconnectedGraph() {
        Graph<String> g = new DirectedGraph<String>();
        String v1 = "a", v2 = "b", v3 = "c";

        Map<Tuple<String, String>, Double> weights = new HashMap<>();
        addUndirectedEdge(g, v1, v2, 0.1, weights);
        addUndirectedEdge(g, v1, v3, 0.3, weights);
        addUndirectedEdge(g, v2, v3, 0.2, weights);

        var distsAndPreds = g.dijkstras(v1, weights);

        Map<String, Double> expectedDistances = new HashMap<>();
        expectedDistances.put("a", 0.0);
        expectedDistances.put("b", 0.1);
        expectedDistances.put("c", 0.3);

        Map<String, String> expectedPredecessors = new HashMap<>();
        expectedPredecessors.put("a", null);
        expectedPredecessors.put("b", "a");
        expectedPredecessors.put("c", "a");


        System.out.println("TEST 4");
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
