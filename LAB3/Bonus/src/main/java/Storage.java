public interface Storage {
    void setStorageCapacity(int capacity);
    int getStorageCapacity();
    default void printDifferent(){
       int capacity = this.getStorageCapacity();
        System.out.println(capacity + " gigabytes");
        System.out.println(capacity*1024 + " megabytes");
        System.out.println(capacity*1024*1024 + " kilobytes");
        System.out.println((long) capacity*1024*1024*1024 + " bytes");
    }
}
