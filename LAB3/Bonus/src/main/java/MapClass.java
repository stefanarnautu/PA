public class MapClass {
    protected String key;
    protected int valoare;
    protected float failure;

    public MapClass(String key,int valoare,float failure){
        this.key=key;
        this.valoare=valoare;
        this.failure=failure;
    }

    @Override
    public String toString() {
        return "MapClass{" +
                "key='" + key + '\'' +
                ", valoare=" + valoare +
                ", failure=" + failure +
                '}';
    }

    public String getKey() {
        return key;
    }

    public int getValoare() {
        return valoare;
    }

    public float getFailure() {
        return failure;
    }
}
