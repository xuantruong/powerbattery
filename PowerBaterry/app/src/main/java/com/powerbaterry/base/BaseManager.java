package com.powerbaterry.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.powerbaterry.config.Rconfig;
import com.powerbaterry.menutop.controller.MenuTopController;

/**
 * Created by root on 09/05/2016.
 */
public class BaseManager {


    private static BaseManager instance;
    private Activity mCurrentActivity;
    private Context mCurrentContext;
    protected MenuTopController mMenuTopController;
    private FragmentManager mManager;

    public static BaseManager getIntance() {
        if (null == instance) {
            instance = new BaseManager();
        }
        return instance;
    }

    public void setCurrentActivity(Activity mCurrentActivity) {
        this.mCurrentActivity = mCurrentActivity;
    }

    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public void setCurrentContext(Context mCurrentContext) {
        this.mCurrentContext = mCurrentContext;
    }

    public FragmentManager getManager() {
        return mManager;
    }

    public void setManager(FragmentManager mManager) {
        this.mManager = mManager;
    }
    public void setmMenuTopController(MenuTopController mMenuTopController) {
        this.mMenuTopController = mMenuTopController;
    }


    public Context getCurrentContext() {
        return mCurrentContext;
    }

    public void addFragment(BaseFragment fragment) {
        if (null != mManager) {
            String nameFragment = fragment.getClass().getName();
            FragmentTransaction ft = mManager.beginTransaction();
            ft.replace(Rconfig.getInstance().id("container"), fragment);
            ft.addToBackStack(nameFragment);
            ft.commit();
            mManager.executePendingTransactions();
        }
    }

    public void replaceFragment(BaseFragment fragment) {
        System.out.println(mManager);
        if (mManager != null) {
            String nameFragment = fragment.getClass().getName();
            boolean isHome = false;
            mManager.popBackStack(nameFragment,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = mManager
                    .beginTransaction();
            fragmentTransaction.replace(Rconfig.getInstance().id("container"),
                    fragment);
            fragmentTransaction.addToBackStack(nameFragment);
            fragmentTransaction.commit();
        }

    }
}
