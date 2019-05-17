package util.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.google.inject.persist.Transactional;

public abstract class GenericJpaDao<T> {

   protected Class<T> entityClass;
    protected EntityManager entityManager;

    public GenericJpaDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Inject
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void persist(T entity) {
        entityManager.persist(entity);
    }


}
