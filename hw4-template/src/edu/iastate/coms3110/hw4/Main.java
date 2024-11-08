package edu.iastate.coms3110.hw4;

import java.util.HashMap;
import java.util.Map;

// import edu.iastate.coms3110.hw4.DirectedGraph;


public class Main {

    public static void main(String... args)
    {
        DirectedGraph<String> G = new DirectedGraph<>();

        String
            minnesota = "minnesota",
            iowa = "iowa",
            illinois = "illinois",
            kansas = "kansas",
            texas = "texas";

        G.addVertex(minnesota);
        G.addVertex(iowa);
        G.addVertex(illinois);
        G.addVertex(kansas);
        G.addVertex(texas);
        G.addEdge(minnesota, iowa);
        G.addEdge(iowa, kansas);
        G.addEdge(minnesota, illinois);
        G.addEdge(kansas, texas);
        G.addEdge(iowa, illinois);
        G.addEdge(illinois, texas);

        Map<Tuple<String, String>, Double> weights = new HashMap<>();
        weights.put(Tuple.create(minnesota, iowa), 1.);
        weights.put(Tuple.create(iowa, kansas), 3.);
        weights.put(Tuple.create(minnesota, illinois), 4.);
        weights.put(Tuple.create(kansas, texas), 4.);
        weights.put(Tuple.create(iowa, illinois), 2.);
        weights.put(Tuple.create(illinois, texas), 0.5);

        var results = G.dijkstras(minnesota, weights);

        for(String s : results.getFirst().keySet())
        {
            System.out.printf("%s -- %f\n", s, results.getFirst().get(s));
        }
    }

}
