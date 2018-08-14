package pawelsmolarski95.gmail.com.mvpsamplearchitecture.modules.examplefragment;

import javax.inject.Inject;

import pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.BasePresenter;

/**
 * Created by psmolarski on 18.03.2018.
 *
 * Example presenter
 */

public class ExamplePresenter extends BasePresenter implements IExampleContract.IPresenter {
    private final static String TAG = "ExamplePresenter";

    private final IExampleContract.IView view;
    private final ExampleModel model;

    @Inject
    public ExamplePresenter(IExampleContract.IView view, ExampleModel model) {
        super(view);
        this.view = view;
        this.model = model;
    }

    @Override
    protected String getPresenterTag() {
        return TAG;
    }
}