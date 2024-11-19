package edu.iastate.coms3110.hw4;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

//No connections from a, this purely tests for null parent and inf. distances
public class Test2JUnit {

    // @Test
    public static void testDijkstrasDisconnectedGraph() {
        Graph<String> g = new DirectedGraph<>();
        String v1 = "a", v2 = "b", v3 = "c", v4 = "d";

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);



        Map<Tuple<String, String>, Double> weights = new HashMap<>();

        g.addEdge(v2, v1);
        weights.put(Tuple.create(v2, v1), 5.0);

        var distsAndPreds = g.dijkstras(v1, weights);

        Map<String, Double> expectedDistances = new HashMap<>();
        expectedDistances.put("a", 0.0);
        expectedDistances.put("b", Double.POSITIVE_INFINITY);
        expectedDistances.put("c", Double.POSITIVE_INFINITY);
        expectedDistances.put("d", Double.POSITIVE_INFINITY);

        Map<String, String> expectedPredecessors = new HashMap<>();
        expectedPredecessors.put("a", null);
        expectedPredecessors.put("b", null);
        expectedPredecessors.put("c", null);
        expectedPredecessors.put("d", null);

        System.out.println("TEST 2");
        System.out.println("\tDistances correct?: " + expectedDistances.equals(distsAndPreds.getFirst()));
        System.out.println("\tExploration correct?: " + expectedPredecessors.equals(distsAndPreds.getSecond()));
    }
}
