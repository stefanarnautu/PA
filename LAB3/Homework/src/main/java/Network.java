import java.util.*;

public class Network{
    protected List<Node> nodes = new ArrayList<>();

    public void addNodes(Object node)
    {
        this.nodes.add((Node) node);
    }

    public Object getNode(int index)
    {
        return nodes.get(index);
    }

    public void afiseazaObiectele() {
        for (Object n : nodes) {
            System.out.println(n.toString());
        }

    }

    //Sortarea obiectelor cu ajutorul Collections
    public void sorteaza() {
        Collections.sort(nodes, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                return n1.getName().compareTo(n2.getName());
            }
        });
    }

    //Adaugarea costurilor pe muchii in mapa fiecarui nod care este incident cu muchia
    public void addCosts(String nameFrom,String nameTo, int cost) {
        for(Node n:nodes)
        {
            if(n.getName().equals(nameFrom))
            {
              n.timeCosts.put(nameTo,cost);
            }
        }
        for(Node n:nodes)
        {
            if(n.getName().equals(nameTo))
            {
                n.timeCosts.put(nameTo,cost);
            }
        }
    }

    public void afiseazaCosturi(){
        for(Node n:nodes){
            System.out.print(n.getName()+" : ");
            System.out.println(n.timeCosts);
        }
    }

    //Soartare obiectelor care au o adresa hardware, si afisarea lor
    // (nu modific lista de obiecte dar am o portiune de cod care poate sa faca si asta; este pus in comentariu)
    public void afisareSortareIdentifiable(){
        List<Node> nodesWithIdent = new ArrayList<>();
        for(Node n:nodes){
            if(n instanceof Computer || n instanceof Router){
                nodesWithIdent.add(n);
            }
        }
        Collections.sort(nodesWithIdent, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                    return n1.getHardwareAddr().compareTo(n2.getHardwareAddr());
            }
        });

        for(Node n : nodesWithIdent) System.out.println(n);
    }

    //Functie pentru Dijkstra
    public int minDistance(Integer[] shortPath, boolean[] visited) {
        Integer min =Integer.MAX_VALUE;
        int min_index=0;

        for (int v = 0; v < this.nodes.size(); v++)
            if (!visited[v] && shortPath[v] <= min) {
                min = shortPath[v];
                min_index = v;
            }
        return min_index;
    }

    //Afisare solutie Dijkstra
    void printSolution(Integer[] shortPath) {
        System.out.println("Cel mai scurt drum este:");
        for (int i = 0; i < this.nodes.size(); i++)
            System.out.println(i+1+" "+shortPath[i]);
    }

    //Implementare Dijkstra
    public void dijkstra(Node nodStart){
        int n=this.nodes.size(), i,j=0;
        Integer[] shortPath= new Integer[n];
        boolean[] visited= new boolean[n];
        Integer[][] graph= new Integer[n][n];

        for(Node node :nodes){
            for (Map.Entry<String, Integer> entry : node.timeCosts.entrySet()) {
                String key = entry.getKey();
                Integer path = entry.getValue();
                i = nodes.indexOf(node);
                for(Node node1:nodes){
                    if(node1.getName().compareTo(key)==0) {
                        j = nodes.indexOf(node1);
                        continue;
                    }
                }
                graph[i][j]=graph[j][i]=path;
            }
        }

        for(int iter=0;iter<nodes.size();iter++)
        {
           shortPath[iter]=Integer.MAX_VALUE;
           visited[iter]=false;
        }

        shortPath[this.nodes.indexOf(nodStart)]=0;

        for (int count = 0; count < this.nodes.size() - 1; count++) {

            int u = minDistance(shortPath, visited);

            visited[u] = true;

            for (int v = 0; v < this.nodes.size(); v++) {
               if(!visited[v]) {
                   if (graph[u][v]!=null && (shortPath[u] != Integer.MAX_VALUE) && ((shortPath[u] + graph[u][v]) < shortPath[v])) {
                    shortPath[v] = shortPath[u] + graph[u][v];
                }
               }

            }
        }
        printSolution(shortPath);
    }


}
