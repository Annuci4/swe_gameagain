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
    private Long id;

    /**
     * Name of player1.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Name of player2.
     */
    @Column(nullable = false)
    private String name2;

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

    public ZonedDateTime getCreated() {
        return created;
    }


}