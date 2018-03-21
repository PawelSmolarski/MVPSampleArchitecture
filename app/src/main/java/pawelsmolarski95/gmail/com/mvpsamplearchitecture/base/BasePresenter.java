package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base;

import android.util.Log;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Base presenter
 */

public abstract class BasePresenter implements IBasePresenter{

    private final IBaseView view;

    protected BasePresenter(IBaseView view) {
        this.view = view;
    }

    @Override
    public void onError(int messageId) {
        view.errorNotification(messageId);
    }

    @Override
    public void onError(String message) {
        Log.d(this.getPresenterTag(), message);
        view.errorNotification(message);
    }

    @Override
    public void onSuccess(int messageId) {
        view.successNotification(messageId);
    }

    @Override
    public void onDataReceiving(int messageId) {
        view.showLoadingBar(messageId);
    }

    @Override
    public void onDataReceived() {
        view.hideLoadingBar();
    }

    protected abstract String getPresenterTag();

    @Override
    public boolean isViewAvailable(){
        return view.isAvailable();
    }
}