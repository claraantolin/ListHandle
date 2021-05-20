package list.handle.api.game.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "games")
public class GameInfoDTO {

    @Id
    private String id;
    private String name;
    private String platform;
    private String pegi;

    public GameInfoDTO(String id, String name, String platform, String pegi) {
        this.id = id;
        this.name = name;
        this.platform = platform;
        this.pegi = pegi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPegi() {
        return pegi;
    }

    public void setPegi(String pegi) {
        this.pegi = pegi;
    }
}
