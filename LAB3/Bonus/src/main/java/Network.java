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
    public void addCosts(String nameFrom,String nameTo, int cost,float failure) {
        for(Node n:nodes)
        {
            if(n.getName().equals(nameFrom))
            {
                n.addElements(nameTo,cost,failure);
            }
        }
        for(Node n:nodes)
        {
            if(n.getName().equals(nameTo))
            {
                n.addElements(nameTo,cost,failure);
            }
        }
    }

    public void afiseazaCosturi(){
        for(Node n:nodes){
            System.out.print(n.getName()+" : ");
            for(MapClass m : n.mapElements)
            System.out.println(m.toString());
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
    public int minDistance(float[] shortPath, boolean[] visited) {
        float min =2;
        int min_index=0;

        for (int v = 0; v < this.nodes.size(); v++)
            if (!visited[v] && shortPath[v] <= min) {
                min = shortPath[v];
                min_index = v;
            }
        return min_index;
    }

    //Afisare solutie Dijkstra
    void printSolution(float[] safest,Integer[] timeTo) {
        System.out.println("Cel mai sigur si timpul catre el drum este:");
        for (int i = 0; i < this.nodes.size(); i++)
            System.out.println(i+1+". Fail probability: "+safest[i]*100+"%, Time: "+ timeTo[i]);
    }
//String.format("%f", safest[i]*100)
    //Implementare Dijkstra
    public void dijkstra(Node nodStart){
        int n=this.nodes.size(), i,j=0;
        float[] safest= new float[n];
        Integer[] shortPath= new Integer[n];
        boolean[] visited= new boolean[n];
        float[][] graph= new float[n][n];
        Integer[][] graphForTime= new Integer[n][n];
        for(int linie=0;linie<n;linie++)
            for(int coloana=0;coloana<n;coloana++) {
                graph[linie][coloana]=2;
            }

        for(Node node :nodes){
             for(MapClass m:node.mapElements){
                String key = m.getKey();
                int pathTime = m.getValoare();
                float failProb = m.getFailure();
                i = nodes.indexOf(node);
                for(Node node1:nodes){
                    if(node1.getName().compareTo(key)==0) {
                        j = nodes.indexOf(node1);
                        continue;
                    }
                }
                graph[i][j]=graph[j][i]=failProb;
                graphForTime[i][j]=graphForTime[j][i]=pathTime;
            }
        }

        for(int iter=0;iter<nodes.size();iter++)
        {
            safest[iter]=2;
            visited[iter]=false;
            shortPath[iter]=0;
        }

        safest[this.nodes.indexOf(nodStart)]=0;

        for (int count = 0; count < this.nodes.size() - 1; count++) {

            int u = minDistance(safest, visited);

            visited[u] = true;

            for (int v = 0; v < this.nodes.size(); v++) {
               if(!visited[v]) {
                   if (graph[u][v]!=2 && (safest[u] != Integer.MAX_VALUE) && ((safest[u] + graph[u][v]) < safest[v])) {
                       safest[v] = safest[u] + graph[u][v];
                       shortPath[v]=shortPath[u] + graphForTime[u][v];
                }
               }

            }
        }
        printSolution(safest,shortPath);
    }


}
