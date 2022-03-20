import java.util.*;
import java.lang.*;

public class Kruskal {

    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;
        public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    };

    class subset
    {
        int parent, rank;
    };

    int V, E;
    Edge edge[];

    Kruskal(int vertices, int edges)
    {
        V = vertices;
        E = edges;
        edge = new Edge[E];
        for (int i = 0; i < edges; ++i)
            edge[i] = new Edge();
    }

    int find(subset subsets[], int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset subsets[], int varful1, int varful2)
    {
        int xroot = find(subsets, varful1);
        int yroot = find(subsets, varful2);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
            else if (subsets[xroot].rank > subsets[yroot].rank)
                subsets[yroot].parent = xroot;
                else {
                    subsets[yroot].parent = xroot;
                    subsets[xroot].rank++;
                }
    }

    void KruskalMST()
    {
        Edge result[] = new Edge[V];

        int muchii = 0;

        for (int i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        subset subsets[] = new subset[V];
        for (int i = 0; i < V; ++i)
            subsets[i] = new subset();

        for (int varf = 0; varf < V; ++varf)
        {
            subsets[varf].parent = varf;
            subsets[varf].rank = 0;
        }

        int contor = 0;
        while (muchii < V - 2)
        {
            Edge next_edge = edge[contor++];
            int varful1 = find(subsets, next_edge.src);
            int varful2 = find(subsets, next_edge.dest);

            if (varful1 != varful2) {
                result[muchii] = next_edge;
                muchii++;
                Union(subsets, varful1, varful2);
            }
        }

        System.out.println("MST");
        int minimumCost = 0;
        for (int i = 0; i < muchii; ++i)
        {
            System.out.println(result[i].src + " -- "
                    + result[i].dest
                    + " Cost " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost "
                + minimumCost);
    }

}
