package eu.thiscounts.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter class for managing the contents of the {@link android.support.v4.view.ViewPager}.
 * Here is where the actual tabs containing fragments are created.
 */
public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public FragmentPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragmentWithTitle(String title, Fragment fragment) {
        mFragmentTitleList.add(title);
        mFragmentList.add(fragment);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
