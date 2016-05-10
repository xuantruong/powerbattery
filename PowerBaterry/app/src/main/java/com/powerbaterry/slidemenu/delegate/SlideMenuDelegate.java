package com.powerbaterry.slidemenu.delegate;


import com.powerbaterry.slidemenu.entity.ItemNavigation;

import java.util.ArrayList;

public interface SlideMenuDelegate {
	public void onSelectedItem(int position);

	public void onRefresh();

	public void setAdapter(ArrayList<ItemNavigation> items);

	
}
