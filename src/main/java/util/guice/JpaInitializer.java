
package util.guice;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.inject.persist.PersistService;

/**
 * idk
 */
@Singleton
public class JpaInitializer {

    @Inject
    public JpaInitializer (PersistService persistService) {
        persistService.start();
    }

}
