package pawelsmolarski95.gmail.com.mvpsamplearchitecture.base.navigator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import java.util.Stack;
import pawelsmolarski95.gmail.com.mvpsamplearchitecture.R;

/**
 * Created by psmolarski on 16.03.2018.
 *
 * Singleton object to provide functionality for navigating between fragments.
 */

public enum Navigator {
    INSTANCE;

    private Fragment homeFragment;
    private Stack<Fragment> fragmentBackStack = new Stack<>();
    private Fragment currentFragment;
    private int frameLayoutId;

    /**
     * Method to set field with currentFragment. Need to restore application.
     *
     * @param currentFragment to be restored
     */
    public void setCurrentFragment(Fragment currentFragment) {
        this.currentFragment = currentFragment;
    }

    /**
     *  Initializes fragment as home one. Should be called in onCreate method in main activity.
     *
     * @param homeFragment to be set as home
     * @param frameLayout for keeping fragment
     * @param activity to be filled out
     */
    public void initializeHomeFragment(Fragment homeFragment, FrameLayout frameLayout, AppCompatActivity activity) {

        if (this.homeFragment == null) {
                initializeView(homeFragment, frameLayout, activity);

        } else {
            if(this.homeFragment.isAdded() || fragmentBackStack.contains(this.homeFragment) && this.homeFragment != this.currentFragment)
                return;

            restoreView(activity, frameLayout);
        }

    }

    private void initializeView(Fragment homeFragment, FrameLayout frameLayout, AppCompatActivity activity){
        final FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        frameLayout.removeAllViews();
        fragmentTransaction.add(frameLayout.getId(), homeFragment, "homeFragment");
        fragmentTransaction.commit();

        this.homeFragment = homeFragment;
        this.frameLayoutId = frameLayout.getId();
        this.currentFragment = homeFragment;
        fragmentBackStack.push(homeFragment);
    }

    private void restoreView(AppCompatActivity activity, FrameLayout frameLayout){
        final FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(frameLayout.getId(), this.homeFragment, "homeFragment");
        fragmentTransaction.commit();
    }

    /**
     * Sets given fragment as home one. Should be called in onCreateView method.
     *
     * @param fragment to be setted as home
     */
    public void setHomeFragment(Fragment fragment) {
        this.homeFragment = fragment;
        resetFragmentBackStack(true);
    }

    /**
     * Method which navigates to specific fragment. It sets this fragment at the top of stack of fragments
     *
     * The logic behind combinations of {@param saveBackStack} and {@param resetBackStack}
     *  false - false => parent fragment would not be kept and previous stack would not be reset
     *  true - false => parent fragment would be kept and previous stack would not be reset
     *  false - true => parent fragment would not be kept and stack would be reset to home fragment
     *  true - true => parent fragment would be kept and stack would be reset to home
     *
     * @param childFragment to be set as current one
     * @param bundle to be set to next fragment with usage of {@link android.support.v4.app.Fragment#setArguments(Bundle)}
     * @param saveBackStack flag which indicates if current fragment has to be saved in back-stack
     * @param resetBackStack flag which indicates if back-stack has to be reset, what means that after clicking back the home activity would be restored
     *
     */
    public void navigateView(Fragment childFragment, Bundle bundle, boolean saveBackStack, boolean resetBackStack) {
        this.resetFragmentBackStack(resetBackStack);
        this.saveCurrentFragmentToBackStack(saveBackStack);

        if (bundle != null) {
            childFragment.setArguments(bundle);
        }


        FragmentManager fragmentManager = currentFragment.getFragmentManager();

        if(fragmentManager == null)
            throw new IllegalStateException("Fragment manager of current fragment is null");

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayoutId, childFragment);

        currentFragment = childFragment;

        fragmentTransaction.commit();


    }

    private void saveCurrentFragmentToBackStack(boolean saveBackstack) {
        if (saveBackstack || (currentFragment.getClass() == homeFragment.getClass() && !fragmentBackStack.contains(homeFragment))) {
            fragmentBackStack.push(currentFragment);
        }
    }

    private void resetFragmentBackStack(boolean resetBackstack) {
        if (resetBackstack) {
            fragmentBackStack.removeAllElements();
            fragmentBackStack.push(homeFragment);
        }
    }

    /**
     * Method to be called in onBackPressed method in main activity to decide what to do with current
     * fragment of backtrace.
     *
     * @return false if current fragment is last one
     */
    public boolean onBackPressed() {

        if (fragmentBackStack.size() == 0) {
            return false;
        }

        if (fragmentBackStack.size() == 1 && (fragmentBackStack.lastElement() == homeFragment && currentFragment == homeFragment))
            return false;

        Fragment lastFragment = fragmentBackStack.pop();

        if (lastFragment != null) {
            Bundle bundle = currentFragment.getArguments();
            navigateView(lastFragment, bundle, false, false);
            return true;
        }
        return false;

    }

}