public class Activity {

    final FragmentController mFragments = FragmentController.createController(new HostCallbacks());

    protected void onCreate() {
        mFragments.dispatchCreate();
    }

    final void performStop() {
        mFragments.dispatchStop();
    }

    final void performStart(String reason) {
        mFragments.dispatchStart();
    }

    final void performResume(boolean followedByPause, String reason) {
        mFragments.dispatchResume();
    }
}

class HostCallbacks extends FragmentHostCallback<Activity> {

}

