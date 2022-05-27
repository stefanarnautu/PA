package entity;

public class MessageObject {
    private int id;
    private String name;
    private String message;

    public MessageObject() {
        this.id = 0;
        this.name = null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", write by " + name +
                ", message: " + message;
    }
}
