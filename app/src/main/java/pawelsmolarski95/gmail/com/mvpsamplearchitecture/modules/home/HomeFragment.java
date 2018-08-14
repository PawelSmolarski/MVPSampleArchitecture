package pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import javax.inject.Inject;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.R;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.BaseFragment;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment.ExampleFragment;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home.injection.IHomeComponent;

import static pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.navigator.Navigator.INSTANCE;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Home fragment
 */

public class HomeFragment extends BaseFragment implements IHomeContract.IView {
    @Override
    protected boolean onInjectView() throws IllegalStateException {
        getComponent(IHomeComponent.class).inject(this);
        return true;
    }

    protected void initializeInjector() {
        // does nothing
    }

    @Inject
    IHomeContract.IPresenter presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View fragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }

    @OnClick(R.id.btnGoSecond)
    void onClickSecond(){
        Fragment fragment = new ExampleFragment();
        INSTANCE.navigateView(fragment, null ,true, false);
    }
}