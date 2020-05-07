import java.util.ArrayList;

public abstract class FragmentManager {
    boolean mStateSaved;
    boolean mExecutingActions;
    int mCurState = Fragment.INITIALIZING;
    final ArrayList<Fragment> mAdded = new ArrayList<>();

    void moveToState(Fragment f, int newState, int transit, int transitionStyle,
                     boolean keepActive) {

    }

    void moveToState(Fragment f) {
        moveToState(f, mCurState, 0, 0, false);
    }

    // All fragments inside Fragment Manager state changes
    void moveToState(int newState, boolean always) {
        mCurState = newState;
        for (int i = 0; i < mAdded.size(); i++) {
            moveToState(mAdded.get(i));
        }
    }

    public boolean execPendingActions() {

    }

    private void dispatchMoveToState(int state) {
        try {
            mExecutingActions = true;
            moveToState(state, false);
        } finally {
            mExecutingActions = false;
        }
        execPendingActions();
    }

    public void dispatchCreate() {
        mStateSaved = false;
        dispatchMoveToState(Fragment.CREATED);
    }

    public void dispatchActivityCreated() {
        mStateSaved = false;
        dispatchMoveToState(Fragment.ACTIVITY_CREATED);
    }

    public void dispatchStart() {
        mStateSaved = false;
        dispatchMoveToState(Fragment.STARTED);
    }

    public void dispatchResume() {
        mStateSaved = false;
        dispatchMoveToState(Fragment.RESUMED);
    }

    public void dispatchPause() {
        dispatchMoveToState(Fragment.STARTED);
    }

    public void dispatchStop() {
        dispatchMoveToState(Fragment.STOPPED);
    }

    public void dispatchDestroyView() {
        dispatchMoveToState(Fragment.CREATED);
    }

    public void dispatchDestroy() {
        mDestroyed = true;
        execPendingActions();
        dispatchMoveToState(Fragment.INITIALIZING);
        mHost = null;
        mContainer = null;
        mParent = null;
    }

    public void addFragment(Fragment fragment, boolean moveToStateNow) {
        mAdded.add(fragment);
        if (moveToStateNow) {
            moveToState(fragment);
        }
    }
}

final class FragmentManagerImpl extends FragmentManager {

}
