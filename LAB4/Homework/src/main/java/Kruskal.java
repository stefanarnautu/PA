import java.util.*;
import java.lang.*;

/**
 * Algoritmul lui Kruskal pentru gasirea MST
 */

public class Kruskal {

    /**
     * Clasa pentru a creea un obiect de tip edge.
     */
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

    /**
     * Constructorul
     * @param vertices numarul de noduri ale grafului
     * @param edges numarul de muchii ale grafului
     */
    Kruskal(int vertices, int edges)
    {
        V = vertices;
        E = edges;
        edge = new Edge[E];
        for (int i = 0; i < edges; ++i)
            edge[i] = new Edge();
    }

    /**
     * @param subsets subsetul in care se face cutarea
     * @param varf nodul pentru care se face cautarea
     * @return
     */
    int find(subset subsets[], int varf)
    {
        if (subsets[varf].parent != varf)
            subsets[varf].parent = find(subsets, subsets[varf].parent);

        return subsets[varf].parent;
    }

    /**
     * Implementare union find
     * @param subsets subestul la momentul apelarii
     * @param varful1 varful 1 al muchiei alese
     * @param varful2 varful 2 al muchiei alese
     */
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

    /**
     * Implemetare Kruskal si afisare a solutiei
     */
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
