package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.modules;


import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.PerFragment;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Fragment Module
 */
@Module
public class FragmentModule {
    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    Fragment fragment() {
        return this.fragment;
    }
}