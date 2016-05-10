package com.powerbaterry.slidemenu.entity;


import android.graphics.drawable.Drawable;

public class ItemNavigation {

    protected String mName;
    protected Drawable mDrawble;

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }


    public void setDrawble(Drawable mDrawble) {
        this.mDrawble = mDrawble;
    }

    public Drawable getDrawble() {
        return mDrawble;
    }
}
