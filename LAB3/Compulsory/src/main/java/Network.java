import java.util.*;

public class Network{
    protected List<Node> nodes = new ArrayList<>();

    private static int compare(Node p1, Node p2) {
        int i = p1.getName().compareTo("aa");
        return i;
    }

    public void addNodes(Object node)
    {
        this.nodes.add((Node) node);
    }
    public Object getNode(int index)
    {
        return nodes.get(index);
    }

  public void afiseazaObiectele()
  {
     for(Object n:nodes)
    {
        System.out.println(n.toString());
    }
  }
  public void sorteaza()
    {
        Collections.sort(nodes, new Comparator<Node>(){
            @Override
            public int compare(Node v1, Node v2){
                return v1.getName().compareTo(v2.getName());
            }
        });
    }

}
