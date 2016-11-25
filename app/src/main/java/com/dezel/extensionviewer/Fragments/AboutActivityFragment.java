package com.dezel.extensionviewer.Fragments;

import android.app.Fragment;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dezel.extensionviewer.R;


public class AboutActivityFragment extends Fragment {

    private static final String TAG = "AboutActivityFragment";

    private static String mVersionName = null;

    private TextView mVersionText;

    public AboutActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        mVersionText = (TextView) rootView.findViewById(R.id.version);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (mVersionName == null) {
            mVersionName = getVersionName();
        }

        mVersionText.append(" ");
        mVersionText.append(mVersionName);
    }

    private String getVersionName() {
        PackageManager packageManager = getActivity().getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(getActivity().getPackageName(),
                    PackageManager.GET_META_DATA);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }

        return "";
    }
}
