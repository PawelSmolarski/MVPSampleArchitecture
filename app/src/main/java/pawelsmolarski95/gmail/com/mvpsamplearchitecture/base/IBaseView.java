package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base;

/**
 * Created by psmolarski on 14.03.2018.
 *
 */

public interface IBaseView {
    void errorNotification(int messageId);

    void errorNotification(String message);

    void successNotification(int messageId);

    void showLoadingBar(int messageId);

    void hideLoadingBar();

    boolean isAvailable();
}