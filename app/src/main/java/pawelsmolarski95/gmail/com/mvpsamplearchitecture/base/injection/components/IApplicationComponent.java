package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.components;

import android.content.Context;
import android.content.res.Resources;
import javax.inject.Singleton;
import dagger.Component;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.BaseActivity;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.modules.ApplicationModule;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Application life duration component
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface IApplicationComponent {

    void inject(BaseActivity baseActivity);

    Context context();

    Resources resources();
}

