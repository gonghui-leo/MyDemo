package com.gonghui.mydemo;

import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

    public CharSequence getPageTitle() {
        return getClass().getSimpleName();
    }
}
