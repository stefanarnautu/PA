public class Switch extends Node{

    public Switch(String name, String hardware, String adress) {
        super(name, hardware, adress);
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
        return "S{" +
                "name='" + name + '\'' +
                ", hardware='" + hardware + '\'' +
                ", adress='" + adress + '\'' + '}';
    }
    public void addElements(String key,int valoare,float failure){
        MapClass muchie=new MapClass(key, valoare, failure);
        mapElements.add(muchie);
    }
}
