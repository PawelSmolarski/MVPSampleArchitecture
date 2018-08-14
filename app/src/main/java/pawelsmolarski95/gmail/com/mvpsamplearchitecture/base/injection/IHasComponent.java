package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.injection;

/**
 * Created by psmolarski on 14.03.2018.
 *
 * Interface which represents contract with components
 */
public interface IHasComponent<C> {
    C getComponent();
}