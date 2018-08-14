package pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment.injection;

import dagger.Component;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.PerFragment;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.modules.FragmentModule;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.components.IApplicationComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.components.IFragmentComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment.ExampleFragment;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment.ExampleModel;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment.IExampleContract;

/**
 * Created by psmolarski on 18.03.2018.
 *
 * Example module componenet
 */
@PerFragment
@Component(dependencies = IApplicationComponent.class, modules = {FragmentModule.class, ExampleModule.class})
public interface IExampleComponent extends IFragmentComponent {
    void inject(ExampleFragment exampleFragment);

    IExampleContract.IPresenter providePresenter();

    ExampleModel provideModel();
}