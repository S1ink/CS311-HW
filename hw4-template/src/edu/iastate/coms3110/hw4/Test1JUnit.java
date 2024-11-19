package edu.iastate.coms3110.hw4;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class Test1JUnit {

    // @Test
    public static void testDijkstras() {
        Graph<String> g = new DirectedGraph<>();
        String v1 = "a", v2 = "b", v3 = "c", v4 = "d", v5 = "e", v6 = "f";

        Map<Tuple<String, String>, Double> weights = new HashMap<>();
        addUndirectedEdge(g, v1, v2, 1.0, weights);
        addUndirectedEdge(g, v1, v4, 4.0, weights);
        addUndirectedEdge(g, v1, v5, 3.0, weights);
        addUndirectedEdge(g, v2, v4, 4.0, weights);
        addUndirectedEdge(g, v2, v5, 2.0, weights);
        addUndirectedEdge(g, v3, v5, 4.0, weights);
        addUndirectedEdge(g, v3, v6, 5.0, weights);
        addUndirectedEdge(g, v4, v5, 4.0, weights);
        addUndirectedEdge(g, v5, v6, 7.0, weights);

        var distsAndPreds = g.dijkstras(v1, weights);

        Map<String, Double> expectedDistances = new HashMap<>();
        expectedDistances.put("a", 0.0);
        expectedDistances.put("b", 1.0);
        expectedDistances.put("c", 7.0);
        expectedDistances.put("d", 4.0);
        expectedDistances.put("e", 3.0);
        expectedDistances.put("f", 10.0);

        Map<String, String> expectedPredecessors = new HashMap<>();
        expectedPredecessors.put("a", null);
        expectedPredecessors.put("b", "a");
        expectedPredecessors.put("c", "e");
        expectedPredecessors.put("d", "a");
        expectedPredecessors.put("e", "a");
        expectedPredecessors.put("f", "e");

        System.out.println("TEST 1");
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
