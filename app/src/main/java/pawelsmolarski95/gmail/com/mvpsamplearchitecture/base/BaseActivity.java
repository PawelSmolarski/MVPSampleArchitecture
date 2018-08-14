package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import pawelsmolarski95.gmail.com.mvpsamplearchitecture.AndroidApplication;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.components.IApplicationComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.modules.ActivityModule;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Base activity for activities in project
 */

public abstract class BaseActivity extends AppCompatActivity {
    private boolean isAvailable;

    @Override
    @CallSuper
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectActivity();
    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        isAvailable = true;
    }

    @Override
    @CallSuper
    protected void onPause() {
        super.onPause();
        isAvailable = false;
    }

    private void injectActivity() {
        this.getApplicationComponent().inject(this);
    }

    protected IApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    /**
     *
     * @return flag is activity avaible
     */
    public boolean isAvailable() {
        return isAvailable;
    }
}