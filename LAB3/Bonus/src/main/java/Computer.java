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

    public void setHardwareAddr(String hard) {
        this.hardware=hard;
    }

    public String getHardwareAddr() {
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
        return "C{" +
                "name='" + name + '\'' +
                ", hardware='" + hardware + '\'' +
                ", adress='" + adress + '\'' +
                ", ip='" + ip + '\'' +
                ", capacity=" + capacity +
                '}';
    }
    public void addElements(String key,int valoare,float failure){
        MapClass muchie=new MapClass(key, valoare, failure);
        mapElements.add(muchie);
    }
}
