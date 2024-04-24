package ee.wtmn.guessgame.repository;

import ee.wtmn.guessgame.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuessGameRepo extends JpaRepository<Game, Long> { }
