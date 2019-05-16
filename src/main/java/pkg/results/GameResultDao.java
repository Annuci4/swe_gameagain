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

    public List<GameResult> findBest(int n) {
        return entityManager.createQuery("SELECT r FROM GameResult r  ORDER BY r.name ASC", GameResult.class)
                .setMaxResults(n)
                .getResultList();
    }
}
