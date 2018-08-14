package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.modules;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.AndroidApplication;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Application Module
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Singleton
    @Provides
    Resources provideResources() {
        return application.getResources();
    }
}