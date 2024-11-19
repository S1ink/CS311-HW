package edu.iastate.coms3110.hw4;

import java.util.HashMap;
import java.util.Map;
// import java.util.Random;
// import java.util.Arrays;

// import edu.iastate.coms3110.hw4.DirectedGraph;


public class Main {

    // public static class RandomGraphTest<T> extends DirectedGraph<T>
    // {
    //     public int VERTEX_CONNECTIONS = 10;
    //     public boolean CONNECT_ALL_VERTICES = false;
    //     public double WEIGHT_MAX = 10.;

    //     final Random rand = new Random();
    //     private T[] vertices;
    //     private Map<Tuple<T, T>, Double> weights;

    //     public RandomGraphTest() {}
    //     public RandomGraphTest(int vertex_connections, boolean connect_all)
    //     {
    //         this.VERTEX_CONNECTIONS = vertex_connections;
    //         this.CONNECT_ALL_VERTICES = connect_all;
    //     }

    //     public void addVertices(T... vertices)
    //     {
    //         final int prev_len = this.vertices.length;
    //         this.vertices = Arrays.copyOf(this.vertices, prev_len + vertices.length);
    //         for(int i = prev_len; i < this.vertices.length; i++)
    //         {
    //             final T x = vertices[i - prev_len];
    //             this.vertices[i] = x;
    //             super.addVertex(x);
    //         }
    //     }
    //     public void setVertices(T... vertices)
    //     {
    //         this.vertices = Arrays.copyOf(vertices, vertices.length);
    //         super.adjList.clear();
    //         for(final T x : this.getVertices())
    //         {
    //             super.addVertex(x);
    //         }
    //     }

    //     public void generateEdges()
    //     {

    //     }

    //     // public void test(T... vertices)
    //     // {
    //     //     final int MAX_NODE_CONNECTIONS = 10;

    //     //     final int n_vertices = vertices.length;
    //     //     final T[] verts = Arrays.copyOf(vertices, n_vertices);
    //     //     final int n_edges = Math.min(
    //     //         (1 + r.nextInt(MAX_NODE_CONNECTIONS - 1) * n_vertices),
    //     //         (int)Math.pow(2., n_vertices) );

    //     //     for(int i = 0; i < )
    //     // }


    //     private void generateEdgesFC()
    //     {
    //         final int n_verts = this.vertices.length;
    //         for(int i = 0; i < n_verts; i++)
    //         {
    //             int z = 1 + this.rand.nextInt(n_verts - i - 1);
    //             T a = this.vertices[0];
    //             T b = this.vertices[z];
    //             this.addEdge(a, b);
    //             this.weights.put(Tuple.create(a, b), this.WEIGHT_MAX);
    //         }

    //     }
    //     private void generateEdgesRC()
    //     {

    //     }

    //     private void swap(int x, int y)
    //     {
    //         if(x >= this.vertices.length || y >= this.vertices.length) return;
    //         final T v = this.vertices[x];
    //         this.vertices[x] = this.vertices[y];
    //         this.vertices[y] = v;
    //     }

    // }

    public static void main(String... args)
    {
        DirectedGraph<String> G = new DirectedGraph<>();

        String
            minnesota = "minnesota",
            iowa = "iowa",
            illinois = "illinois",
            kansas = "kansas",
            texas = "texas",
            ohio = "ohio",
            florida = "florida",
            montana = "montana",
            nevada = "nevada",
            california = "california";

        G.addVertex(minnesota);
        G.addVertex(iowa);
        G.addVertex(illinois);
        G.addVertex(kansas);
        G.addVertex(texas);
        G.addVertex(ohio);
        G.addVertex(florida);
        G.addVertex(montana);
        G.addVertex(nevada);
        G.addVertex(california);

        G.addEdge(minnesota, iowa);
        G.addEdge(iowa, kansas);
        G.addEdge(minnesota, illinois);
        G.addEdge(kansas, texas);
        G.addEdge(iowa, illinois);
        G.addEdge(illinois, texas);
        G.addEdge(nevada, california);
        G.addEdge(california, minnesota);
        G.addEdge(texas, nevada);
        G.addEdge(texas, iowa);
        G.addEdge(iowa, minnesota);
        G.addEdge(kansas, montana);
        G.addEdge(nevada, montana);
        G.addEdge(montana, illinois);
        G.addEdge(montana, texas);
        G.addEdge(california, florida);
        G.addEdge(florida, texas);

        Map<Tuple<String, String>, Double> weights = new HashMap<>();
        weights.put(Tuple.create(minnesota, iowa), 1.);
        weights.put(Tuple.create(iowa, kansas), 3.);
        weights.put(Tuple.create(minnesota, illinois), 4.);
        weights.put(Tuple.create(kansas, texas), 4.);
        weights.put(Tuple.create(iowa, illinois), 2.);
        weights.put(Tuple.create(illinois, texas), 0.5);
        weights.put(Tuple.create(nevada, california), 2.5);
        weights.put(Tuple.create(california, minnesota), 7.);
        weights.put(Tuple.create(texas, nevada), 7.5);
        weights.put(Tuple.create(texas, iowa), 5.5);
        weights.put(Tuple.create(iowa, minnesota), 15.);
        weights.put(Tuple.create(kansas, montana), 8.);
        weights.put(Tuple.create(nevada, montana), 4.);
        weights.put(Tuple.create(montana, illinois), 0.5);
        weights.put(Tuple.create(montana, texas), 0.5);
        weights.put(Tuple.create(california, florida), 1.);
        weights.put(Tuple.create(florida, texas), 2.);

        var results = G.dijkstras(california, weights);

        for(String s : results.getFirst().keySet())
        {
            System.out.printf("%s -- %f\t", s, results.getFirst().get(s));
            String x = results.getSecond().get(s);
            if(x != null)
            {
                System.out.print(s);
                while(x != null)
                {
                    System.out.printf(" <-- %s", x);
                    x = results.getSecond().get(x);
                }
            }
            System.out.println();
        }

        System.out.println("\n----------------------------------------------\n");
        Test1JUnit.testDijkstras();
        Test2JUnit.testDijkstrasDisconnectedGraph();
        Test3JUnit.testDijkstrasDisconnectedGraph();
        Test4JUnit.testDijkstrasDisconnectedGraph();
        Test5JUnit.testDijkstrasDisconnectedGraph();
    }

}
