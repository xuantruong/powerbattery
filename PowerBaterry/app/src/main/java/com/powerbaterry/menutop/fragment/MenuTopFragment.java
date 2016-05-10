package com.powerbaterry.menutop.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.powerbaterry.base.BaseFragment;
import com.powerbaterry.base.BaseManager;
import com.powerbaterry.config.Rconfig;
import com.powerbaterry.menutop.block.MenuTopBlock;
import com.powerbaterry.menutop.controller.MenuTopController;
import com.powerbaterry.slidemenu.fragment.SlideMenuFragment;


public class MenuTopFragment extends BaseFragment {
	public View rootView;
	protected MenuTopBlock mBlock;
	protected MenuTopController mController;
	protected SlideMenuFragment mNavigationDrawerFragment;
	
	public static MenuTopFragment newInstance(SlideMenuFragment mNavigationDrawerFragment){
		MenuTopFragment fragment = new MenuTopFragment();
		fragment.mNavigationDrawerFragment = mNavigationDrawerFragment;
		return fragment;
	}
	
	public MenuTopFragment() {
		super();
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		rootView = inflater.inflate(Rconfig.getInstance().layout("core_menu_top"), container,false);
		rootView.setBackgroundColor(Color.parseColor("#282D31"));
		Context mContext = getActivity();
		mBlock = new MenuTopBlock(rootView, mContext);
		mBlock.initView();
		if (mController == null) {
			mController = new MenuTopController();
			mController.setSlideMenu(mNavigationDrawerFragment);
			mController.setMenuTopDelegate(mBlock);
			mController.init();
		} else {
			
		}
		mBlock.setOnTouchMenu(mController.getTouchMenu());
		BaseManager.getIntance().setmMenuTopController(mController);
		return rootView;
	}
}
