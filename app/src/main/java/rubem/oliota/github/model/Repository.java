package rubem.oliota.github.model;

import java.io.Serializable;

public class Repository implements Serializable {
    private String name;
    private String owner;
    private String avatar_url;
    private String description;

    public Repository() {

    }

    public Repository(String name, String owner, String avatar_url, String description) {
        this.name = name;
        this.owner = owner;
        this.avatar_url = avatar_url;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
