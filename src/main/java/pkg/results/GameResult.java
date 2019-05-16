package pkg.results;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class GameResult {

    @Id
    @GeneratedValue
    private String id;

    /**
     * Name of the player.
     */
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String name2;

    /**
     * Number of how many times won the player.
     */
   // private int numberOfwons1, numberOfwons2;
    /**
     * The timestamp when the game was ended.
     */
    @Column(nullable = false)
    private ZonedDateTime created;

    @PrePersist
    protected void onPersist() {
        created = ZonedDateTime.now();
    }

    public String getName() {
        return name;
    }

}