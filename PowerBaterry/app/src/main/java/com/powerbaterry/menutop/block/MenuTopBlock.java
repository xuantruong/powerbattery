package com.powerbaterry.menutop.block;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.powerbaterry.config.Rconfig;
import com.powerbaterry.menutop.delegate.MenuTopDelegate;


public class MenuTopBlock  implements MenuTopDelegate {
	protected View mView;
	protected Context context;
	protected ImageView imv_menu;
	protected Button btn_cartnavigation;
	protected RelativeLayout layout_cart;
	
	public static MenuTopBlock newInstance(View v,Context context){
		MenuTopBlock menuBlock = new MenuTopBlock(v, context);
		return menuBlock;
	}
	
	public MenuTopBlock(View v, Context mcontext) {
		this.mView = v;
		this.context = mcontext;
	}
	
	public MenuTopBlock() {
		super();
	}

	public void initView() {
		initButtonMenu();
	}
	
	private void initButtonMenu() {
		imv_menu = (ImageView) mView.findViewById(Rconfig.getInstance().id(
				"img_menu"));
		imv_menu.setColorFilter(Color.parseColor("#0048BA"));
		layout_cart = (RelativeLayout)mView.findViewById(Rconfig.getInstance().id("layout_cart"));
	}
	public void setOnTouchMenu(OnTouchListener touchMenu) {
		imv_menu.setOnTouchListener(touchMenu);
	}

	@Override
	public void controllCartLayout() {
		// TODO Auto-generated method stub
		if (layout_cart.getVisibility() == View.VISIBLE) {
			layout_cart.setVisibility(View.GONE);
		} else {
			layout_cart.setVisibility(View.VISIBLE);
		}
	}
}
