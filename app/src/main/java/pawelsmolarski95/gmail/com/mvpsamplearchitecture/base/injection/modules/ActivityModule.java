package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.PerActivity;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Activity module
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}