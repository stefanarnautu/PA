import java.util.ArrayList;
import java.util.List;

public class Network {
    protected List<Object> nodes = new ArrayList<Object>();

    public void addNodes(Object node)
    {
        this.nodes.add(node);
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

 /* public void compareByName()
  {
      for (:) {

      }
  }*/

}
