package com.powerbaterry.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.powerbaterry.base.BaseFragment;
import com.powerbaterry.config.Rconfig;

/**
 * Created by root on 10/05/2016.
 */
public class FragmentHome extends BaseFragment {


    private View rootView;

    public static FragmentHome newInstance() {
        FragmentHome home = new FragmentHome();
        return home;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(Rconfig.getInstance().layout("fragment_home_layout"), container, false);
        return rootView;
    }
}
