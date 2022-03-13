import java.util.HashMap;
import java.util.Map;

abstract class Node{
    protected String name;
    protected String hardware;
    protected String adress;
    protected Map<String,Integer> timeCosts = new HashMap<>();
    public abstract void setName(String name);
    public abstract String getName();
    public abstract void setHardwareType(String hard);
    public abstract String getHardwareType();
    public abstract void setAdress(String adr);
    public abstract String getAdress();
    public abstract String toString();
    public abstract void addTimeCosts(String toWhere,int cost);
    public abstract int getTimeCosts(String toWhere);

    public Node(String name, String hardware, String adress)
    {
        this.adress=adress;
        this.hardware=hardware;
        this.name=name;
    }
}
