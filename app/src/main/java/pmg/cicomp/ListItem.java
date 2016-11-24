package pmg.cicomp;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by pedro on 20/10/16.
 */

public class ListItem implements Serializable {

    private int id;
    private String name;
    private String description;
    private String instructor;
    private String organization;
    private String type;
    private String from;
    private String to;

    public ListItem(int id, String name, String description, String instructor, String organization, String type, String from, String to) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.organization = organization;
        this.type = type;
        this.from = from;
        this.to = to;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
