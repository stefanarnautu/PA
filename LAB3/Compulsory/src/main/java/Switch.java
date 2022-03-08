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
                ", adress='" + adress + '\'';
    }
}
