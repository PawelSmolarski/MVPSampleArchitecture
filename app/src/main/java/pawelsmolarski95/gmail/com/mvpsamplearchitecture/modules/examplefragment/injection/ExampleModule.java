package pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment.injection;

import dagger.Module;
import dagger.Provides;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.PerFragment;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment.ExampleModel;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment.ExamplePresenter;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment.IExampleContract;

/**
 * Created by psmolarski on 18.03.2018.
 *
 */
@Module
public class ExampleModule {
    private final IExampleContract.IView view;

    public ExampleModule(IExampleContract.IView view){
        this.view = view;
    }

    @Provides
    @PerFragment
    IExampleContract.IPresenter providePresenter(ExampleModel model) {
        return new ExamplePresenter(view, model);
    }

    @Provides
    @PerFragment
    ExampleModel provideModel() {
        return new ExampleModel();
    }
}