package docsrepo.soap.entities;

import java.io.Serializable;

public class Document implements Serializable {

    private int id;
    private String name;
    private String contentDescription;
    private byte[] file;

    public Document() {
    }

    public Document(int id, String name, String contentDescription, byte[] file) {
        this.id = id;
        this.name = name;
        this.contentDescription = contentDescription;
        this.file = file;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentDescription() {
        return this.contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public byte[] getFile() {
        return this.file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

}
