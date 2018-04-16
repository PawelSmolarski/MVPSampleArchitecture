package pawelsmolarski95.gmail.com.mvpsamplearchitecture;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.BaseActivity;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.IHasComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.navigator.Navigator;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.HomeFragment;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.IHomeContract;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.injection.DaggerIHomeComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.injection.HomeModule;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.injection.IHomeComponent;

/**
 * Main activity
 */
public class MainActivity extends BaseActivity implements IHasComponent<IHomeComponent>, IHomeContract.IPresenter.ExampleListener {

    private IHomeComponent homeComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final IHomeContract.IView homeFragment = new HomeFragment();
        Navigator.INSTANCE.initializeHomeFragment((Fragment) homeFragment , (FrameLayout) this.findViewById(R.id.main_fragment_container), this);
        this.initializeInjector(homeFragment);
    }

    private void initializeInjector(IHomeContract.IView homeFragment) {
        this.homeComponent = DaggerIHomeComponent
                .builder()
                .iApplicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .homeModule(new HomeModule(homeFragment))
                .build();
    }

    @Override
    public IHomeComponent getComponent() {
        return homeComponent;
    }

    @Override
    public void onBackPressed() {
        if (!Navigator.INSTANCE.onBackPressed()) {
            super.onBackPressed();
        }
    }

}