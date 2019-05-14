package pkg.results;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import java.util.List;
import util.jpa.GenericJpaDao;

import javax.persistence.EntityManager;

public class GameResultDao extends GenericJpaDao<GameResult> {

    public GameResultDao() {
        super(GameResult.class);
    }

    @Transactional
    public GameResult createPlayer(String name, int numberOfWons){
        GameResult plyr = new GameResult();
        plyr.setPlayername(name);
        plyr.setNumberOfVictories(numberOfWons);
        return plyr;
    }
    @Transactional
    public List<GameResult> findTop5(int n) {
        return entityManager.createQuery("SELECT r FROM GameResult r ORDER BY r.numberOfVictories ASC", GameResult.class).getResultList();
    }

}