package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection;

import java.lang.annotation.Retention;
import javax.inject.Scope;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Custom scope for Activity life duration
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {}