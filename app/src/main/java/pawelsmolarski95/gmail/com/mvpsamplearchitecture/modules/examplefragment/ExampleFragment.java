package pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import javax.inject.Inject;
import butterknife.ButterKnife;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.R;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.BaseFragment;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment.injection.DaggerIExampleComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment.injection.ExampleModule;

/**
 * Created by psmolarski on 16.03.2018.
 *
 * Example fragment
 */

public class ExampleFragment extends BaseFragment implements IExampleContract.IView {
    @Inject
    IExampleContract.IPresenter presenter;

    @Override
    protected void initializeInjector() {
        DaggerIExampleComponent
                .builder()
                .iApplicationComponent(getApplicationComponent())
                .exampleModule(new ExampleModule(this))
                .fragmentModule(getFragmentModule())
                .build()
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View fragmentView = inflater.inflate(R.layout.fragment_example, container, false);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }
}