package ee.wtmn.guessgame.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;

    private Integer secretNumber;
    private Integer count = 0;
    private boolean isGuessed = false;

}