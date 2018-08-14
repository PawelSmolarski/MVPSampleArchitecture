package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base;

/**
 * Created by psmolarski on 14.03.2018.
 *
 */

interface IBasePresenter {
    /**
     * Method that should signal the appropriate view to show the appropriate error notification
     * with the provided message.
     * @param messageId message id.
     */
    void onError(int messageId);
    void onError(String message);

    /**
     * Method that should signal the appropriate view to show the appropriate success notification
     * with the provided message.
     * @param messageId message id.
     */
    void onSuccess(int messageId);

    /**
     * Method that should signal the appropriate view to show loading bar.
     */
    void onDataReceiving(int messageId);

    /**
     * Method that should signal the appropriate view to hide loading bar.
     */
    void onDataReceived();

    /**
     * Method that gives information if fragment is still on view.
     */
    boolean isViewAvailable();
}