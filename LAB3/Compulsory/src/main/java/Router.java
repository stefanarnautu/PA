public class Router extends Node implements Identifiable{

    private String ip;

    public Router(String name, String hardware, String adress,String ip) {
        super(name, hardware, adress);
        this.ip=ip;
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
        return "Router{" +
                "name='" + name + '\'' +
                ", hardware='" + hardware + '\'' +
                ", adress='" + adress + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
