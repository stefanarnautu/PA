import java.util.ArrayList;
import java.util.List;

abstract class Node{
    protected String name;
    protected String hardware;
    protected String adress;
    protected List<MapClass> mapElements = new ArrayList<>();
    public abstract void setName(String name);
    public abstract String getName();
    public abstract void setHardwareAddr(String hard);
    public abstract String getHardwareAddr();
    public abstract void setAdress(String adr);
    public abstract String getAdress();
    public abstract String toString();
    public abstract void addElements(String key,int valoare,float failure);
    public Node(String name, String hardware, String adress)
    {
        this.adress=adress;
        this.hardware=hardware;
        this.name=name;
    }
}
