package pkg.results;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class GameResult {

    /**
     * Name of the player.
     */
    @Column(nullable = false)
    private String playername;

    public void setPlayername(String player) {
        this.playername = player;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public String getPlayername() {
        return playername;
    }

    /**
     * Number of how many times won the player.
     */
    private int numberOfVictories;

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}