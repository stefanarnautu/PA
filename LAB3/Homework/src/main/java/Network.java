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
                    return n1.getAdress().compareTo(n2.getAdress());
            }
        });

        Integer contor=0;
        Integer[] vectorCareTinePozitiileUndeTrebuiePus = new Integer[nodesWithIdent.size()];
        Integer j=0;
        for(Node n:nodes){
            if(n instanceof Switch){
                contor++;
            }
            else{
           vectorCareTinePozitiileUndeTrebuiePus[j]=contor;
           j++;
           contor++;}
        }
        contor=0;
        for(int i=0;i<vectorCareTinePozitiileUndeTrebuiePus.length;i++){
            nodes.add(vectorCareTinePozitiileUndeTrebuiePus[i],nodesWithIdent.get(contor));
            nodes.remove(vectorCareTinePozitiileUndeTrebuiePus[i]+1);
           contor++;
        }
    }

    public void afisareIdentifiable(){
        for(Node n : nodes){
        if (n instanceof Computer || n instanceof Router )
            System.out.println(n.getAdress());
        }
    }

}
