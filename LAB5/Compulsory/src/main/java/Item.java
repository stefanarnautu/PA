import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Item.class),
})

public class Item implements Serializable {
    private String id;
    private String title;
    private String location;
    private int year;
    private String author;
    private String type;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @JsonCreator
    public Item(@JsonProperty("id")String id, @JsonProperty("title")String title, @JsonProperty("location")String location, @JsonProperty("year")int year,@JsonProperty("author")String author,@JsonProperty("type")String type) {
        this.id= id;
        this.title=title;
        this.location=location;
        this.year= year;
        this.author=author;
        this.type=type;
    }

}
