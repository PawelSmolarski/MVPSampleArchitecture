package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.components;

import android.support.v4.app.Fragment;
import dagger.Component;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.PerFragment;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.modules.FragmentModule;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Fragment base component
 */

@PerFragment
@Component(dependencies = IApplicationComponent.class, modules = FragmentModule.class)
public interface IFragmentComponent {

    Fragment fragment();
}