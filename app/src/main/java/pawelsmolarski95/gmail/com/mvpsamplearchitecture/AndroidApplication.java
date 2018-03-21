package pawelsmolarski95.gmail.com.mvpsamplearchitecture;

import android.app.Application;

import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.components.DaggerIApplicationComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.components.IApplicationComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.modules.ApplicationModule;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Android main Application
 */

public class AndroidApplication extends Application {

    private IApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerIApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public IApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}