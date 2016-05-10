package com.powerbaterry.slidemenu.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.powerbaterry.base.BaseFragment;
import com.powerbaterry.config.Rconfig;
import com.powerbaterry.slidemenu.block.PhoneSlideMenuBlock;
import com.powerbaterry.slidemenu.controller.PhoneSlideMenuController;
import com.powerbaterry.slidemenu.delegate.CloseSlideMenuDelegate;


public class PhoneSlideMenuFragment extends BaseFragment {
	protected CloseSlideMenuDelegate mCLoseDelegate;
	protected PhoneSlideMenuController mController;
	protected PhoneSlideMenuBlock mBlock;
	public void setCloseDelegate(CloseSlideMenuDelegate mCLoseDelegate) {
		this.mCLoseDelegate = mCLoseDelegate;
	}
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(
				Rconfig.getInstance().layout("core_phone_slide_menu"), null,
				false);
		view.setBackgroundColor(Color.parseColor("#171A1F"));
		Context context = getActivity();
		mBlock = new PhoneSlideMenuBlock(view, context);
		mBlock.initView();
		
		mController = new PhoneSlideMenuController(mBlock, context);
		mController.setCloseDelegate(mCLoseDelegate);
		mController.create();
		
		mBlock.setListener(mController.getListener());
		return view;
	}
}
