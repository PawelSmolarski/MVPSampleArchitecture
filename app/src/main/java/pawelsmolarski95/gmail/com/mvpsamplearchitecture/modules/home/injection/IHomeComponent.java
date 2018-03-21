package pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.injection;

import dagger.Component;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.PerActivity;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.modules.ActivityModule;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.components.IActivityComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.components.IApplicationComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.HomeFragment;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.IHomeContract;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Home component
 */

@PerActivity
@Component(dependencies = IApplicationComponent.class, modules = {ActivityModule.class, HomeModule.class})
public interface IHomeComponent extends IActivityComponent {

    void inject(HomeFragment homeFragment);

    IHomeContract.IPresenter presenter();


}