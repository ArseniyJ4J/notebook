package pay.travel.testtask.objects;

import java.util.Date;

public class Note {

    private String description;

    private String creationDate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Note() {
    }

    public Note(String description) {
        this.description = description;
    }

    public Note(String description, String creationDate) {
        this.description = description;
        this.creationDate = creationDate;
    }
}
