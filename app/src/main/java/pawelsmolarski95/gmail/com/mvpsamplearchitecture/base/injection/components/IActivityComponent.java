package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.components;

import android.app.Activity;
import dagger.Component;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.PerActivity;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.modules.ActivityModule;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Activity base component
 *
 */

@PerActivity
@Component(dependencies = IApplicationComponent.class, modules = ActivityModule.class)
public interface IActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
