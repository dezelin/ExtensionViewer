package com.dezel.extensionviewer.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dezel.extensionviewer.Fragments.DatabaseFragment;
import com.dezel.extensionviewer.Fragments.DisplayModesFragment;
import com.dezel.extensionviewer.Fragments.ExtensionsFragment;
import com.dezel.extensionviewer.Fragments.RenderingFragment;
import com.dezel.extensionviewer.Fragments.ReportFragment;
import com.dezel.extensionviewer.Fragments.SummaryFragment;


public class MainActivityPagerAdapter extends FragmentStatePagerAdapter {

    private int mTabsCount;

    public MainActivityPagerAdapter(FragmentManager fragmentManager, int tabsCount) {
        super(fragmentManager);
        mTabsCount = tabsCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                return new SummaryFragment();
            }
            case 1: {
                return new ExtensionsFragment();
            }
            case 2: {
                return new DisplayModesFragment();
            }
            case 3: {
                return new RenderingFragment();
            }
            case 4: {
                return new DatabaseFragment();
            }
            case 5: {
                return new ReportFragment();
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabsCount;
    }
}
