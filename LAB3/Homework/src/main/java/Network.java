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
    public void sorteaza()
    {
        Collections.sort(nodes, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                return n1.getName().compareTo(n2.getName());
            }
        });
    }

    public void addCosts(String nameFrom,String nameTo, int cost)
    {
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

    public void sortareIdentifiable(){
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

        int contor=0;
        Integer[] vLocNou = new Integer[nodesWithIdent.size()];
        int j=0;
        for(Node n:nodes){
            if(n instanceof Switch){
                contor++;
            }
            else{
           vLocNou[j]=contor;
           j++;
           contor++;}
        }
        contor=0;
        for(int i=0;i<vLocNou.length;i++){
            nodes.add(vLocNou[i],nodesWithIdent.get(contor));
            nodes.remove(vLocNou[i]+1);
           contor++;
        }
    }

    public void afisareIdentifiable(){
        for(Node n : nodes){
        if (n instanceof Computer || n instanceof Router )
            System.out.println(n.getHardwareAddr());
        }
    }
    public int minDistance(Integer[] shortPath, boolean[] visited)
    {
        Integer min =Integer.MAX_VALUE;
        int min_index=0;

        for (int v = 0; v < this.nodes.size(); v++)
            if (!visited[v] && shortPath[v] <= min) {
                min = shortPath[v];
                min_index = v;
            }
        return min_index;
    }

    void printSolution(Integer[] shortPath)
    {
        System.out.println("Cel mai scurt drum este:");
        for (int i = 0; i < this.nodes.size(); i++)
            System.out.println(i+1+" "+shortPath[i]);
    }

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

      /*
      for(int kk=0;kk< graph.length;kk++) {
         for (int kkk = 0; kkk < graph.length; kkk++) {
                System.out.print(graph[kk][kkk]+" ");
            }
            System.out.println("");
        }
        */
    }


}
