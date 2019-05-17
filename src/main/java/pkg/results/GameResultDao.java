package pkg.results;

import com.google.inject.persist.Transactional;
import java.util.List;
import util.jpa.GenericJpaDao;

public class GameResultDao extends GenericJpaDao<GameResult> {

    public GameResultDao() {
        super(GameResult.class);
    }
    @Transactional
    public List<GameResult> findBest() {
        return entityManager.createQuery("SELECT r FROM GameResult r", GameResult.class)
                .setMaxResults(5)
                .getResultList();

    }

}
