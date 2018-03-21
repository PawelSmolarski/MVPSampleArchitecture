package pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.injection;

import dagger.Module;
import dagger.Provides;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.PerActivity;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.HomePresenter;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.IHomeContract;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Home Module
 */

@Module
public class HomeModule {

    private final IHomeContract.IView view;

    public HomeModule(IHomeContract.IView view){
        this.view = view;
    }

    @Provides
    @PerActivity
    IHomeContract.IPresenter presenter() {
        return new HomePresenter(view);
    }

}
