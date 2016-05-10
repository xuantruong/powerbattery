package com.powerbaterry.slidemenu.controller;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.powerbaterry.base.BaseFragment;
import com.powerbaterry.base.BaseManager;
import com.powerbaterry.config.Constance;
import com.powerbaterry.config.Rconfig;
import com.powerbaterry.fragment.FragmentHome;
import com.powerbaterry.slidemenu.delegate.CloseSlideMenuDelegate;
import com.powerbaterry.slidemenu.delegate.SlideMenuDelegate;
import com.powerbaterry.slidemenu.entity.ItemNavigation;


public class PhoneSlideMenuController {

    protected CloseSlideMenuDelegate mCloseDelegate;
    protected Context mContext;
    protected SlideMenuDelegate mDelegate;
    protected OnItemClickListener mListener;
    protected ArrayList<ItemNavigation> mItems = new ArrayList<ItemNavigation>();
    protected int DEFAULT_POSITION = 0;

    public PhoneSlideMenuController(SlideMenuDelegate delegate, Context context) {
        mDelegate = delegate;
        mContext = context;
        mItems = new ArrayList<ItemNavigation>();
    }

    public void setCloseDelegate(CloseSlideMenuDelegate delegate) {
        mCloseDelegate = delegate;
    }

    public OnItemClickListener getListener() {
        return mListener;
    }

    public void closeSlideMenutab() {
        mCloseDelegate.closeSlideMenu();
    }

    public void setListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }


    public void create() {

        mListener = new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                onNaviagte(position);
                // mMenuTopDelegate.controllCartLayout();
            }

        };

        initial();
    }

    private void initial() {
        initDataAdapter();
        mDelegate.setAdapter(mItems);
        FragmentHome home = FragmentHome.newInstance();
        BaseManager.getIntance().replaceFragment(home);
    }

    public void initDataAdapter() {
        addSetting();
        addBatteryCenter();
        addTodayUsages();
        addAbout();
    }

    private void addSetting() {
        int index = checkElement(Constance.ITEM_SETTING);
        if (index == -1) {
            ItemNavigation item = new ItemNavigation();
            item.setName(Constance.ITEM_SETTING);
            int id_icon = Rconfig.getInstance().drawable("ic_settings");
            Drawable icon = mContext.getResources().getDrawable(id_icon);
            icon.setColorFilter(Color.parseColor("#ffffff"),
                    PorterDuff.Mode.SRC_ATOP);
            item.setDrawble(icon);
            mItems.add(item);
        }

    }

    private void addBatteryCenter() {
        int index = checkElement(Constance.ITEM_BATTERY_CENTER);
        if (index == -1) {
            ItemNavigation item = new ItemNavigation();
            item.setName(Constance.ITEM_BATTERY_CENTER);
            int id_icon = Rconfig.getInstance().drawable("ic_battery_center");
            Drawable icon = mContext.getResources().getDrawable(id_icon);
            icon.setColorFilter(Color.parseColor("#ffffff"),
                    PorterDuff.Mode.SRC_ATOP);
            item.setDrawble(icon);
            mItems.add(item);
        }
    }

    private void addTodayUsages() {
        int index = checkElement(Constance.ITEM_TODAY_USAGE);
        if (index == -1) {
            ItemNavigation item = new ItemNavigation();
            item.setName(Constance.ITEM_TODAY_USAGE);
            int id_icon = Rconfig.getInstance().drawable("ic_today_usage");
            Drawable icon = mContext.getResources().getDrawable(id_icon);
            icon.setColorFilter(Color.parseColor("#ffffff"),
                    PorterDuff.Mode.SRC_ATOP);
            item.setDrawble(icon);
            mItems.add(item);
        }
    }

    private void addAbout() {
        int index = checkElement(Constance.ITEM_ABOUT);
        if (index == -1) {
            ItemNavigation item = new ItemNavigation();
            item.setName(Constance.ITEM_ABOUT);
            int id_icon = Rconfig.getInstance().drawable("ic_about");
            Drawable icon = mContext.getResources().getDrawable(id_icon);
            icon.setColorFilter(Color.parseColor("#ffffff"),
                    PorterDuff.Mode.SRC_ATOP);
            item.setDrawble(icon);
            mItems.add(item);
        }
    }


    public void onNaviagte(int position) {
        ItemNavigation item = mItems.get(position);
        if (null != item) {
            BaseFragment fragment = null;
            fragment = navigateNormal(item);
            if (fragment != null) {
                BaseManager.getIntance().replaceFragment(fragment);
            }
        }
        mDelegate.onSelectedItem(position);
        if (mCloseDelegate != null) {
            mCloseDelegate.closeSlideMenu();
        }
    }

    public void closeSlideMenu() {
        if (mCloseDelegate != null) {
            mCloseDelegate.closeSlideMenu();
        }
    }

    public BaseFragment navigateNormal(ItemNavigation item) {
        BaseFragment fragment = null;
        String name = item.getName();
        switch (name) {
//            case Constant.ITEM_HOME:
//                fragment = FragmentHome.newInstance();
//                break;
            default:
                break;
        }
        return fragment;
    }

    protected int checkElement(String name) {
        if (null != mItems || mItems.size() > 0) {
            for (int i = 0; i < mItems.size(); i++) {
                ItemNavigation item = mItems.get(i);
                if (item.getName().equals(name)) {
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

}
