public class FragmentController {
    private final FragmentHostCallback<?> mHost;

    public static final FragmentController createController(FragmentHostCallback<?> callbacks) {
        return new FragmentController(callbacks);
    }

    private FragmentController(FragmentHostCallback<?> callbacks) {
        mHost = callbacks;
    }

    public FragmentManager getFragmentManager() {
        return mHost.getFragmentManagerImpl();
    }

    // All the information gets delegated to Fragment Manager as well
    public void dispatchCreate() {
        mHost.mFragmentManager.dispatchCreate();
    }

    public void dispatchActivityCreated() {
        mHost.mFragmentManager.dispatchActivityCreated();
    }

    public void dispatchStart() {
        mHost.mFragmentManager.dispatchStart();
    }

    public void dispatchResume() {
        mHost.mFragmentManager.dispatchResume();
    }

    public void dispatchPause() {
        mHost.mFragmentManager.dispatchPause();
    }

    public void dispatchStop() {
        mHost.mFragmentManager.dispatchStop();
    }

    public void dispatchDestroyView() {
        mHost.mFragmentManager.dispatchDestroyView();
    }

    public void dispatchDestroy() {
        mHost.mFragmentManager.dispatchDestroy();
    }
}
