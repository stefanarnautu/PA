public class Computer extends Node implements Identifiable,Storage{
    private String ip;
    private int capacity;
    public Computer(String name, String hardware, String adress,String ip,int capacity) {
        super(name, hardware, adress);
        this.ip=ip;
        this.capacity=capacity;
    }

    public void setStorageCapacity(int capacity){
        this.capacity=capacity;
    }
    public int getStorageCapacity(){
        return this.capacity;
    }

    public void setIp(String ip){
        this.ip=ip;
    }
    public String getIp() {
     return ip;
    }

    public void setName(String name) {
       this.name=name;
    }

    public String getName() {
        return this.name;
    }

    public void setHardwareType(String hard) {
        this.hardware=hard;
    }

    public String getHardwareType() {
        return hardware;
    }

    public void setAdress(String adr) {
       this.adress=adr;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                "ip='" + ip + '\'' +
                ", capacity=" + capacity +
                ", hardware='" + hardware + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
    public void addTimeCosts(String toWhere,int cost)
    {
      this.timeCosts.put(toWhere,cost);
    }
    public int getTimeCosts(String toWhere)
    {
     return this.timeCosts.get(toWhere);
    }
}
