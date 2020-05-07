public class Fragment {
    static final int INVALID_STATE = -1;   // Invalid state used as a null value.
    static final int INITIALIZING = 0;     // Not yet created.
    static final int CREATED = 1;          // Created.
    static final int ACTIVITY_CREATED = 2; // The activity has finished its creation.
    static final int STOPPED = 3;          // Fully created, not started.
    static final int STARTED = 4;          // Created and started, not resumed.
    static final int RESUMED = 5;          // Created started and resumed.

    FragmentManagerImpl mFragmentManager;
    FragmentHostCallback mHost;
    FragmentManagerImpl mChildFragmentManager;
    Fragment mParentFragment;
    int mFragmentId;
    int mContainerId;

    final public FragmentManager getFragmentManager() {
        return mFragmentManager;
    }

    final public FragmentManager getChildFragmentManager() {
        if (mChildFragmentManager == null) {
            instantiateChildFragmentManager();
            if (mState >= RESUMED) {
                mChildFragmentManager.dispatchResume();
            } else if (mState >= STARTED) {
                mChildFragmentManager.dispatchStart();
            } else if (mState >= ACTIVITY_CREATED) {
                mChildFragmentManager.dispatchActivityCreated();
            } else if (mState >= CREATED) {
                mChildFragmentManager.dispatchCreate();
            }
        }
        return mChildFragmentManager;
    }

    final public Fragment getParentFragment() {
        return mParentFragment;
    }
}
