package pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.home;

import javax.inject.Inject;

import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.BasePresenter;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Home presenter
 */

public class HomePresenter extends BasePresenter implements IHomeContract.IPresenter {

    private final static String TAG = "HomePresenter";
    private final IHomeContract.IView view;


    @Inject
    public HomePresenter(IHomeContract.IView view) {
        super(view);
        this.view = view;
    }


    @Override
    public String getPresenterTag() {
        return TAG;
    }

}
