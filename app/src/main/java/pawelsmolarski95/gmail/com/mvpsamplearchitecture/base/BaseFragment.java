package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.AndroidApplication;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.components.IApplicationComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.navigator.Navigator;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.IHasComponent;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection.modules.FragmentModule;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Base clasc for fragments in project
 */
public abstract class BaseFragment extends Fragment implements IBaseView {
    private boolean isInjected = false;

    @Override
    @CallSuper
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        setRetainInstance(true);

        try {
            isInjected = onInjectView();
        } catch (IllegalStateException e) {
            Log.e(e.getClass().getSimpleName(), e.getMessage());
            isInjected = false;
        }
    }

    protected abstract void initializeInjector();

    protected IApplicationComponent getApplicationComponent() {

        if(getActivity() == null )
            throw new IllegalStateException("Activity is null");

        return ((AndroidApplication) getActivity().getApplication()).getApplicationComponent();
    }

    @Nullable
    @Override
    @CallSuper
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Navigator.INSTANCE.setCurrentFragment(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!isInjected) {
            isInjected = onInjectView();
        }
    }

    /**
     * gets DI component
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) throws IllegalStateException {
        if(getActivity() == null )
            throw new IllegalStateException("Activity is null");

        C component = componentType.cast(((IHasComponent<C>) getActivity()).getComponent());
        if (component == null) {
            throw new IllegalStateException(componentType.getSimpleName() + " has not been initialized yet.");
        }
        return component;
    }

    protected boolean onInjectView() throws IllegalStateException {
        return false;
    }


    /**
     * Get an Fragment module for dependency injection.
     */
    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void errorNotification(int messageId) {
        //todo error notification
    }

    @Override
    public void errorNotification(String message) {
        //todo error notification
    }

    @Override
    public void successNotification(int messageId) {
        //todo error success
    }

    @Override
    public void showLoadingBar(int messageId) {
        //todo loading bar
    }

    @Override
    public void hideLoadingBar() {
        //todo loading bar
    }

    @Override
    public boolean isAvailable() {
        return getActivity() != null && isAdded() && ((BaseActivity) getActivity()).isAvailable();
    }
}