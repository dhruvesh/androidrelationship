public abstract class FragmentHostCallback<E> extends FragmentContainer {
    final FragmentManagerImpl mFragmentManager = new FragmentManagerImpl();

    FragmentManagerImpl getFragmentManagerImpl() {
        return mFragmentManager;
    }
}
